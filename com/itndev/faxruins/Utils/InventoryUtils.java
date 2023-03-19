/*     */ package com.itndev.faxruins.Utils;
/*     */ 
/*     */ import com.itndev.faxruins.DataFixer.BukkitSerialization;
/*     */ import com.itndev.faxruins.MySQL.wtfDatabase;
/*     */ import com.itndev.faxruins.Storage.InventoryStorage;
/*     */ import com.itndev.faxruins.Var.Values;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import net.kyori.adventure.text.TextComponent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryUtils
/*     */ {
/*     */   public static ItemStack createItem(Material m, String name, List<String> lore) {
/*  43 */     ItemStack item = new ItemStack(m);
/*  44 */     ItemMeta meta = item.getItemMeta();
/*  45 */     meta.displayName((Component)Component.text(colorize(name)));
/*  46 */     List<Component> finallore = new ArrayList<>();
/*  47 */     lore.forEach(string -> finallore.add(Component.text(colorize(string))));
/*  48 */     meta.lore(finallore);
/*  49 */     item.setItemMeta(meta);
/*  50 */     return item;
/*     */   }
/*     */   
/*     */   public static String colorize(String string) {
/*  54 */     return ChatColor.translateAlternateColorCodes('&', string);
/*     */   }
/*     */   
/*     */   public static ItemStack createItem(Material m, String name) {
/*  58 */     ItemStack item = new ItemStack(m);
/*  59 */     ItemMeta meta = item.getItemMeta();
/*  60 */     meta.displayName((Component)Component.text(colorize(name)));
/*  61 */     item.setItemMeta(meta);
/*  62 */     return item;
/*     */   }
/*     */   
/*     */   public static Inventory getInventory(Player p, String ID) {
/*  66 */     String InventoryID = p.getUniqueId() + Values.Splitter + ID;
/*  67 */     if (InventoryStorage.INVENTORYID_TRYINGTOLOAD.containsKey(InventoryID)) {
/*  68 */       return (Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(InventoryID);
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CompletableFuture<Inventory> AsyncGetInventory(Player p, String ID, String InventoryTitle, int size) {
/*  75 */     return LoadAndLock(p, ID, InventoryTitle, size);
/*     */   }
/*     */   
/*     */   public static CompletableFuture<Inventory> LoadAndLock(Player p, String InventoryID, String Title, int size) {
/*  79 */     CompletableFuture<Inventory> finalinventory = new CompletableFuture<>();
/*  80 */     (new Thread(() -> {
/*     */           String P_InventoryID = p.getUniqueId() + Values.Splitter + InventoryID;
/*     */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(P_InventoryID)) {
/*     */             int count = 0;
/*     */             String UUID = p.getUniqueId().toString();
/*     */             while (true) {
/*     */               try {
/*     */                 String InventoryRESPONCE = wtfDatabase.GetInventory(UUID, InventoryID).get();
/*     */                 if (!InventoryRESPONCE.equalsIgnoreCase("ISLOCKED")) {
/*     */                   ArrayList<String> list;
/*     */                   Inventory inv = BukkitSerialization.fromBase64(InventoryRESPONCE);
/*     */                   TextComponent textComponent = Component.text(ChatColor.translateAlternateColorCodes('&', Title));
/*     */                   Inventory finalinv = Bukkit.createInventory(null, size, (Component)textComponent);
/*     */                   if (inv != null && !inv.isEmpty()) {
/*     */                     finalinv.setContents(inv.getContents());
/*     */                   }
/*     */                   InventoryStorage.INVENTORYID_INVENTORYDATA.put(UUID + Values.Splitter + InventoryID, finalinv);
/*     */                   InventoryStorage.INVENTORYID_TRYINGTOLOAD.put(UUID + Values.Splitter + InventoryID, Boolean.valueOf(true));
/*     */                   if (InventoryStorage.PLAYER_OWNED_INVENTORYLIST.containsKey(UUID)) {
/*     */                     list = (ArrayList<String>)InventoryStorage.PLAYER_OWNED_INVENTORYLIST.get(UUID);
/*     */                   } else {
/*     */                     list = new ArrayList<>();
/*     */                   } 
/*     */                   if (!list.contains(InventoryID)) {
/*     */                     list.add(InventoryID);
/*     */                   }
/*     */                   InventoryStorage.PLAYER_OWNED_INVENTORYLIST.put(UUID, list);
/*     */                   finalinventory.complete(finalinv);
/*     */                   break;
/*     */                 } 
/* 110 */               } catch (IOException|InterruptedException|java.util.concurrent.ExecutionException e) {
/*     */                 throw new RuntimeException(e);
/*     */               } 
/*     */               
/*     */               if (++count > 3) {
/*     */                 TextComponent textComponent = Component.text("[ERROR] PLEASE RECONNECT.. Failed While Loading Data");
/*     */                 p.sendMessage((Component)textComponent);
/*     */                 if (!InventoryStorage.INVENTORYID_TRYINGTOLOAD.containsKey(InventoryID)) {
/*     */                   finalinventory.complete(null);
/*     */                   break;
/*     */                 } 
/*     */                 finalinventory.complete((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(P_InventoryID));
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } else {
/*     */             finalinventory.complete((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(P_InventoryID));
/*     */           } 
/* 128 */         })).start();
/* 129 */     return finalinventory;
/*     */   }
/*     */   
/*     */   public static void SaveAndUnLock(Player p, String InventoryID) {
/* 133 */     (new Thread(() -> {
/*     */           String UUID = p.getUniqueId().toString();
/*     */           String InventoryData = BukkitSerialization.toBase64(StorageUtils.getInventory(UUID, InventoryID));
/*     */           StorageUtils.removeInventory(UUID, InventoryID);
/*     */           int count = 0;
/*     */           while (true) {
/*     */             try {
/*     */               String InventoryRESPONCE = wtfDatabase.SetInventory(UUID, InventoryID, InventoryData).get();
/*     */               if (InventoryRESPONCE.equalsIgnoreCase("SUCCESS")) {
/*     */                 break;
/*     */               }
/* 144 */             } catch (InterruptedException|java.util.concurrent.ExecutionException e) {
/*     */               throw new RuntimeException(e);
/*     */             } 
/*     */             
/*     */             if (++count > 3) {
/*     */               System.out.println("[ERROR] UNABLE TO SAVE DATA TO MYSQL DATABASE... DROPPING INFO IN CONSOLE");
/*     */               System.out.println("[ERROR] UUID=" + UUID);
/*     */               System.out.println("[ERROR] InventoryID=" + InventoryID);
/*     */               System.out.println("[ERROR] InventoryData=" + InventoryData);
/*     */               System.out.println("[INFO^] ERROR SEARCH SYNTAX = INVENTORYSAVEERROR");
/*     */               break;
/*     */             } 
/*     */           } 
/* 157 */         })).start();
/*     */   }
/*     */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Utils\InventoryUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
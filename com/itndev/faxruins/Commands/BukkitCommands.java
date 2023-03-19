/*     */ package com.itndev.faxruins.Commands;
/*     */ 
/*     */ import com.itndev.faxruins.Utils.InventoryGUIHolder;
/*     */ import com.itndev.faxruins.Utils.InventoryUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ public class BukkitCommands
/*     */   implements CommandExecutor
/*     */ {
/*  19 */   Inventory inv1 = null;
/*  20 */   Inventory inv2 = null;
/*  21 */   Inventory inv3 = null;
/*  22 */   Inventory inv4 = null;
/*  23 */   Inventory inv5 = null;
/*  24 */   Inventory inv = null;
/*     */ 
/*     */   
/*     */   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
/*  28 */     if (sender instanceof Player) {
/*  29 */       Player p = (Player)sender;
/*  30 */       checkinventories();
/*  31 */       if (p.hasPermission("faxcore.admin")) {
/*  32 */         p.openInventory(this.inv5);
/*  33 */       } else if (p.hasPermission("faxcore.special")) {
/*  34 */         p.openInventory(this.inv3);
/*  35 */       } else if (p.hasPermission("faxcore.healerrank")) {
/*  36 */         p.openInventory(this.inv2);
/*  37 */       } else if (p.hasPermission("faxcore.chestrank")) {
/*  38 */         p.openInventory(this.inv1);
/*     */       } else {
/*  40 */         p.openInventory(this.inv);
/*     */       } 
/*     */     } 
/*  43 */     return false;
/*     */   }
/*     */   
/*     */   private void checkinventories() {
/*  47 */     if (this.inv == null) {
/*  48 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  49 */       Inventory inv = Holder.getInventory();
/*  50 */       inv.setItem(2, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(1)", lorebuilder("&2&lCHEST")));
/*  51 */       inv.setItem(3, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(2)", lorebuilder("&5&lHEALER")));
/*  52 */       inv.setItem(4, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(3)", lorebuilder("&e&lSPECIAL")));
/*  53 */       inv.setItem(5, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(4)", lorebuilder("&c&lADMIN")));
/*  54 */       inv.setItem(6, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(5)", lorebuilder("&c&lADMIN")));
/*  55 */       this.inv = inv;
/*     */     } 
/*  57 */     if (this.inv1 == null) {
/*  58 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  59 */       Inventory inv = Holder.getInventory();
/*  60 */       inv.setItem(2, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(1)"));
/*  61 */       inv.setItem(3, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(2)", lorebuilder("&5&lHEALER")));
/*  62 */       inv.setItem(4, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(3)", lorebuilder("&e&lSPECIAL")));
/*  63 */       inv.setItem(5, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(4)", lorebuilder("&c&lADMIN")));
/*  64 */       inv.setItem(6, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(5)", lorebuilder("&c&lADMIN")));
/*  65 */       this.inv1 = inv;
/*     */     } 
/*  67 */     if (this.inv2 == null) {
/*  68 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  69 */       Inventory inv = Holder.getInventory();
/*  70 */       inv.setItem(2, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(1)"));
/*  71 */       inv.setItem(3, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(2)"));
/*  72 */       inv.setItem(4, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(3)", lorebuilder("&e&lSPECIAL")));
/*  73 */       inv.setItem(5, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(4)", lorebuilder("&c&lADMIN")));
/*  74 */       inv.setItem(6, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(5)", lorebuilder("&c&lADMIN")));
/*  75 */       this.inv2 = inv;
/*     */     } 
/*  77 */     if (this.inv3 == null) {
/*  78 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  79 */       Inventory inv = Holder.getInventory();
/*  80 */       inv.setItem(2, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(1)"));
/*  81 */       inv.setItem(3, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(2)"));
/*  82 */       inv.setItem(4, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(3)"));
/*  83 */       inv.setItem(5, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(4)", lorebuilder("&c&lADMIN")));
/*  84 */       inv.setItem(6, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(5)", lorebuilder("&c&lADMIN")));
/*  85 */       this.inv3 = inv;
/*     */     } 
/*  87 */     if (this.inv4 == null) {
/*  88 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  89 */       Inventory inv = Holder.getInventory();
/*  90 */       inv.setItem(2, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(1)"));
/*  91 */       inv.setItem(3, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(2)"));
/*  92 */       inv.setItem(4, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(3)"));
/*  93 */       inv.setItem(5, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(4)"));
/*  94 */       inv.setItem(6, InventoryUtils.createItem(Material.BARRIER, "&8&l(&r&7사용불가&8&l) &7&l창고 &r&7&l(5)", lorebuilder("&c&lADMIN")));
/*  95 */       this.inv4 = inv;
/*     */     } 
/*  97 */     if (this.inv5 == null) {
/*  98 */       InventoryGUIHolder Holder = new InventoryGUIHolder("", "", 9, "&3&l[ &f&lFAX &3&l] &r&e창고목록");
/*  99 */       Inventory inv = Holder.getInventory();
/* 100 */       inv.setItem(2, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(1)"));
/* 101 */       inv.setItem(3, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(2)"));
/* 102 */       inv.setItem(4, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(3)"));
/* 103 */       inv.setItem(5, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(4)"));
/* 104 */       inv.setItem(6, InventoryUtils.createItem(Material.CHEST, "&e&l창고 &r&7&l(5)"));
/* 105 */       this.inv5 = inv;
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<String> lorebuilder(String rankname) {
/* 110 */     List<String> lore = new ArrayList<>();
/* 111 */     lore.add("&r &r " + rankname + " &r&e랭크 이상부터 사용가능합니다");
/* 112 */     lore.add("&r &r &r &a/진급&7으로 진급 가능합니다");
/* 113 */     return lore;
/*     */   }
/*     */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Commands\BukkitCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
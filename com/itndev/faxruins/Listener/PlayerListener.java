/*     */ package com.itndev.faxruins.Listener;
/*     */ 
/*     */ import com.itndev.faxruins.Main;
/*     */ import com.itndev.faxruins.Storage.InventoryStorage;
/*     */ import com.itndev.faxruins.Utils.InventoryUtils;
/*     */ import com.itndev.faxruins.Var.Values;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryCloseEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onConnect(PlayerJoinEvent e) {}
/*     */   
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onLeave(PlayerQuitEvent e) {
/*  33 */     if (InventoryStorage.PLAYER_OWNED_INVENTORYLIST.containsKey(e.getPlayer().getUniqueId().toString())) {
/*  34 */       for (String key : InventoryStorage.PLAYER_OWNED_INVENTORYLIST.get(e.getPlayer().getUniqueId().toString())) {
/*  35 */         InventoryUtils.SaveAndUnLock(e.getPlayer(), key);
/*     */       }
/*  37 */       InventoryStorage.PLAYER_OWNED_INVENTORYLIST.remove(e.getPlayer().getUniqueId().toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onClick(InventoryClickEvent e) {
/*  43 */     if (e.getInventory().getHolder() instanceof com.itndev.faxruins.Utils.InventoryGUIHolder) {
/*  44 */       e.setCancelled(true);
/*  45 */       final Player p = (Player)e.getWhoClicked();
/*  46 */       if (e.getRawSlot() == 2) {
/*  47 */         if (p.hasPermission("faxcore.chestrank")) {
/*  48 */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(p.getUniqueId().toString() + Values.Splitter + "1")) {
/*  49 */             (new Thread(() -> {
/*     */                   try {
/*     */                     final Inventory inv = InventoryUtils.AsyncGetInventory(p, "1", "&6&l창고 &r&7&l(1)", 54).get(200L, TimeUnit.MILLISECONDS);
/*     */                     if (inv != null) {
/*     */                       (new BukkitRunnable()
/*     */                         {
/*     */                           public void run() {
/*  56 */                             if (p.isOnline()) {
/*  57 */                               p.openInventory(inv);
/*     */                             }
/*     */                           }
/*     */                         }).runTask((Plugin)Main.getInstance());
/*     */                     }
/*  62 */                   } catch (InterruptedException|java.util.concurrent.ExecutionException|java.util.concurrent.TimeoutException ex) {
/*     */                     p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r오류로 인해 창고 1 로딩에 실패했습니다. 다시 시도 바랍니다")));
/*     */                     throw new RuntimeException(ex);
/*     */                   } 
/*  66 */                 })).start();
/*     */           } else {
/*  68 */             p.openInventory((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(p.getUniqueId().toString() + Values.Splitter + "1"));
/*     */           } 
/*     */         } else {
/*  71 */           p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r&2&lCHEST &r&f랭크 이상부터 사용 가능합니다")));
/*     */         } 
/*  73 */       } else if (e.getRawSlot() == 3) {
/*  74 */         if (p.hasPermission("faxcore.healerrank")) {
/*  75 */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(p.getUniqueId().toString() + Values.Splitter + "2")) {
/*  76 */             (new Thread(() -> {
/*     */                   try {
/*     */                     final Inventory inv = InventoryUtils.AsyncGetInventory(p, "2", "&6&l창고 &r&7&l(2)", 54).get(200L, TimeUnit.MILLISECONDS);
/*     */                     if (inv != null) {
/*     */                       (new BukkitRunnable()
/*     */                         {
/*     */                           public void run() {
/*  83 */                             if (p.isOnline()) {
/*  84 */                               p.openInventory(inv);
/*     */                             }
/*     */                           }
/*     */                         }).runTask((Plugin)Main.getInstance());
/*     */                     }
/*  89 */                   } catch (InterruptedException|java.util.concurrent.ExecutionException|java.util.concurrent.TimeoutException ex) {
/*     */                     p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r오류로 인해 창고 2 로딩에 실패했습니다. 다시 시도 바랍니다")));
/*     */                     throw new RuntimeException(ex);
/*     */                   } 
/*  93 */                 })).start();
/*     */           } else {
/*  95 */             p.openInventory((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(p.getUniqueId().toString() + Values.Splitter + "2"));
/*     */           } 
/*     */         } else {
/*  98 */           p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r&5&lHEALER &r&f랭크 이상부터 사용 가능합니다")));
/*     */         } 
/* 100 */       } else if (e.getRawSlot() == 4) {
/* 101 */         if (p.hasPermission("faxcore.special")) {
/* 102 */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(p.getUniqueId().toString() + Values.Splitter + "3")) {
/* 103 */             (new Thread(() -> {
/*     */                   try {
/*     */                     final Inventory inv = InventoryUtils.AsyncGetInventory(p, "3", "&6&l창고 &r&7&l(3)", 54).get(200L, TimeUnit.MILLISECONDS);
/*     */                     if (inv != null) {
/*     */                       (new BukkitRunnable()
/*     */                         {
/*     */                           public void run() {
/* 110 */                             if (p.isOnline()) {
/* 111 */                               p.openInventory(inv);
/*     */                             }
/*     */                           }
/*     */                         }).runTask((Plugin)Main.getInstance());
/*     */                     }
/* 116 */                   } catch (InterruptedException|java.util.concurrent.ExecutionException|java.util.concurrent.TimeoutException ex) {
/*     */                     p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r오류로 인해 창고 3 로딩에 실패했습니다. 다시 시도 바랍니다")));
/*     */                     throw new RuntimeException(ex);
/*     */                   } 
/* 120 */                 })).start();
/*     */           } else {
/* 122 */             p.openInventory((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(p.getUniqueId().toString() + Values.Splitter + "3"));
/*     */           } 
/*     */         } else {
/* 125 */           p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r&e&lSPECIAL &r&f랭크 이상부터 사용 가능합니다")));
/*     */         } 
/* 127 */       } else if (e.getRawSlot() == 5) {
/* 128 */         if (p.hasPermission("faxcore.admin")) {
/* 129 */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(p.getUniqueId().toString() + Values.Splitter + "4")) {
/* 130 */             (new Thread(() -> {
/*     */                   try {
/*     */                     final Inventory inv = InventoryUtils.AsyncGetInventory(p, "4", "&6&l창고 &r&7&l(4)", 54).get(40L, TimeUnit.MILLISECONDS);
/*     */                     if (inv != null) {
/*     */                       (new BukkitRunnable()
/*     */                         {
/*     */                           public void run() {
/* 137 */                             if (p.isOnline()) {
/* 138 */                               p.openInventory(inv);
/*     */                             }
/*     */                           }
/*     */                         }).runTask((Plugin)Main.getInstance());
/*     */                     }
/* 143 */                   } catch (InterruptedException|java.util.concurrent.ExecutionException|java.util.concurrent.TimeoutException ex) {
/*     */                     p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r오류로 인해 창고 4 로딩에 실패했습니다. 다시 시도 바랍니다")));
/*     */                     throw new RuntimeException(ex);
/*     */                   } 
/* 147 */                 })).start();
/*     */           } else {
/* 149 */             p.openInventory((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(p.getUniqueId().toString() + Values.Splitter + "4"));
/*     */           } 
/*     */         } else {
/* 152 */           p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r&f권한이 없습니다")));
/*     */         } 
/* 154 */       } else if (e.getRawSlot() == 6) {
/* 155 */         if (p.hasPermission("faxcore.admin")) {
/* 156 */           if (!InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(p.getUniqueId().toString() + Values.Splitter + "5")) {
/* 157 */             (new Thread(() -> {
/*     */                   try {
/*     */                     final Inventory inv = InventoryUtils.AsyncGetInventory(p, "5", "&6&l창고 &r&7&l(5)", 54).get(40L, TimeUnit.MILLISECONDS);
/*     */                     if (inv != null) {
/*     */                       (new BukkitRunnable()
/*     */                         {
/*     */                           public void run() {
/* 164 */                             if (p.isOnline()) {
/* 165 */                               p.openInventory(inv);
/*     */                             }
/*     */                           }
/*     */                         }).runTask((Plugin)Main.getInstance());
/*     */                     }
/* 170 */                   } catch (InterruptedException|java.util.concurrent.ExecutionException|java.util.concurrent.TimeoutException ex) {
/*     */                     p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r오류로 인해 창고 5 로딩에 실패했습니다. 다시 시도 바랍니다")));
/*     */                     throw new RuntimeException(ex);
/*     */                   } 
/* 174 */                 })).start();
/*     */           } else {
/* 176 */             p.openInventory((Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(p.getUniqueId().toString() + Values.Splitter + "5"));
/*     */           } 
/*     */         } else {
/* 179 */           p.sendMessage((Component)Component.text(InventoryUtils.colorize("&3&l[ &f&lFAX &3&l] &r&f권한이 없습니다")));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onInventoryClose(InventoryCloseEvent e) {
/* 187 */     if (e.getView().getTopInventory().getSize() != 9 || e.getPlayer() instanceof Player);
/*     */   }
/*     */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Listener\PlayerListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
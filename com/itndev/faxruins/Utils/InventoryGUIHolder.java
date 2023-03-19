/*    */ package com.itndev.faxruins.Utils;
/*    */ 
/*    */ import net.kyori.adventure.text.Component;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.InventoryHolder;
/*    */ 
/*    */ public class InventoryGUIHolder
/*    */   implements InventoryHolder {
/*    */   private Inventory inventory;
/*    */   private String name;
/*    */   private String type;
/*    */   
/*    */   public InventoryGUIHolder(String name, String type, int size, String title) {
/* 15 */     this.inventory = Bukkit.createInventory(this, size, (Component)Component.text(InventoryUtils.colorize(title)));
/* 16 */     this.name = name;
/* 17 */     this.type = type;
/*    */   }
/*    */ 
/*    */   
/*    */   public Inventory getInventory() {
/* 22 */     return this.inventory;
/*    */   }
/*    */   
/*    */   public String getMenuName() {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getMenuType() {
/* 30 */     return this.type;
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Utils\InventoryGUIHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
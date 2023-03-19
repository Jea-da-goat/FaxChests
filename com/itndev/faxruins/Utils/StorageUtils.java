/*    */ package com.itndev.faxruins.Utils;
/*    */ 
/*    */ import com.itndev.faxruins.Storage.InventoryStorage;
/*    */ import com.itndev.faxruins.Var.Values;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ 
/*    */ public class StorageUtils
/*    */ {
/*    */   public static Inventory getInventory(String PlayerUUID, String InventoryID) {
/* 12 */     if (InventoryStorage.INVENTORYID_INVENTORYDATA.containsKey(PlayerUUID + Values.Splitter + InventoryID)) {
/* 13 */       return (Inventory)InventoryStorage.INVENTORYID_INVENTORYDATA.get(PlayerUUID + Values.Splitter + InventoryID);
/*    */     }
/* 15 */     return Bukkit.createInventory(null, 9);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void removeInventory(String PlayerUUID, String InventoryID) {
/* 20 */     String key = PlayerUUID + Values.Splitter + InventoryID;
/* 21 */     InventoryStorage.INVENTORYID_TRYINGTOLOAD.remove(key);
/* 22 */     InventoryStorage.INVENTORYID_INVENTORYDATA.remove(key);
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Utils\StorageUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
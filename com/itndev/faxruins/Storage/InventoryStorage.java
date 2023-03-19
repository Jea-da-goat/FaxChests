/*    */ package com.itndev.faxruins.Storage;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Hashtable;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ 
/*    */ public class InventoryStorage
/*    */ {
/* 11 */   public static HashMap<String, ArrayList<String>> PLAYER_OWNED_INVENTORYLIST = new HashMap<>();
/* 12 */   public static HashMap<String, Inventory> INVENTORYID_INVENTORYDATA = new HashMap<>();
/* 13 */   public static Hashtable<String, Boolean> INVENTORYID_TRYINGTOLOAD = new Hashtable<>();
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Storage\InventoryStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
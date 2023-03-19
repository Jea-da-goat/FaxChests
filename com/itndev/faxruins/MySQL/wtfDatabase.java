/*    */ package com.itndev.faxruins.MySQL;
/*    */ 
/*    */ import com.itndev.faxruins.DataFixer.BukkitSerialization;
/*    */ import com.itndev.faxruins.Var.Values;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class wtfDatabase
/*    */ {
/*    */   public static CompletableFuture<String> GetInventory(String PlayerUUID, String InventoryID) {
/* 16 */     CompletableFuture<String> InventoryData = new CompletableFuture<>();
/* 17 */     (new Thread(() -> {
/*    */           try {
/*    */             PreparedStatement ps = HikariCP.getHikariConnection().prepareStatement("Call TRYGETINVENTORY(?, ?, ?, ?, ?)");
/*    */             ps.setString(1, PlayerUUID + Values.Splitter + InventoryID);
/*    */             ps.setString(2, Values.ServerName);
/*    */             ps.setString(3, Values.Unlocked);
/*    */             ps.setString(4, "NOTHING");
/*    */             ps.setString(5, BukkitSerialization.toBase64(Bukkit.createInventory(null, 9)));
/*    */             ResultSet rs = ps.executeQuery();
/*    */             if (rs.next()) {
/*    */               InventoryData.complete(rs.getString("VAL_FINALINVENTORY"));
/*    */             }
/*    */             HikariCP.closeConnections(null, ps, rs);
/* 30 */           } catch (SQLException e) {
/*    */             e.printStackTrace();
/*    */           } 
/* 33 */         })).start();
/* 34 */     return InventoryData;
/*    */   }
/*    */   
/*    */   public static CompletableFuture<String> SetInventory(String PlayerUUID, String InventoryID, String InventoryData) {
/* 38 */     CompletableFuture<String> RESPONCE = new CompletableFuture<>();
/* 39 */     (new Thread(() -> {
/*    */           try {
/*    */             PreparedStatement ps = HikariCP.getHikariConnection().prepareStatement("Call TRYSAVEINVENTORY(?, ?, ?, ?, ?)");
/*    */             ps.setString(1, PlayerUUID + Values.Splitter + InventoryID);
/*    */             ps.setString(2, Values.ServerName);
/*    */             ps.setString(3, "NOTHING");
/*    */             ps.setString(4, Values.Unlocked);
/*    */             ps.setString(5, InventoryData);
/*    */             ResultSet rs = ps.executeQuery();
/*    */             if (rs.next()) {
/*    */               RESPONCE.complete(rs.getString("VAL_FINALINVENTORY"));
/*    */             }
/*    */             HikariCP.closeConnections(null, ps, rs);
/* 52 */           } catch (SQLException e) {
/*    */             e.printStackTrace();
/*    */           } 
/* 55 */         })).start();
/* 56 */     return RESPONCE;
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\MySQL\wtfDatabase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
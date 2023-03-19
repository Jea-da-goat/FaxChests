/*     */ package com.itndev.faxruins.MySQL;
/*     */ 
/*     */ import com.itndev.faxruins.Main;
/*     */ import com.zaxxer.hikari.HikariDataSource;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ public class HikariCP {
/*     */   public static HikariDataSource dataSource;
/*     */   private static Connection connection;
/*     */   private static String host;
/*     */   private static String port;
/*     */   private static String database;
/*     */   private static String username;
/*     */   private static String password;
/*     */   private static Boolean useSSL;
/*     */   
/*     */   public static void setupHikariInfo() {
/*  23 */     host = "db.itndev.com";
/*  24 */     port = "5567";
/*  25 */     database = "factioninfo";
/*  26 */     username = "Skadi";
/*  27 */     password = "l80oKGTFA#@fCRH75v5w6fefw";
/*  28 */     useSSL = Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ConnectHikari() {
/*  33 */     dataSource = new HikariDataSource();
/*  34 */     dataSource.setMaximumPoolSize(10);
/*  35 */     dataSource.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
/*  36 */     dataSource.addDataSourceProperty("serverName", host);
/*  37 */     dataSource.addDataSourceProperty("port", port);
/*  38 */     dataSource.addDataSourceProperty("databaseName", database);
/*  39 */     dataSource.addDataSourceProperty("user", username);
/*  40 */     dataSource.addDataSourceProperty("password", password);
/*  41 */     PingDatabase();
/*     */   }
/*     */   
/*     */   public static void PingDatabase() {
/*  45 */     (new BukkitRunnable()
/*     */       {
/*     */         public void run() {
/*     */           try {
/*  49 */             HikariCP.getHikariConnection().prepareStatement("SELECT 1").executeQuery();
/*  50 */           } catch (SQLException throwables) {
/*  51 */             throwables.printStackTrace();
/*     */           } 
/*     */         }
/*  54 */       }).runTaskTimerAsynchronously((Plugin)Main.getInstance(), 10L, 12000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Connection getHikariConnection() throws SQLException {
/*     */     try {
/*  60 */       if (connection != null && !connection.isClosed()) {
/*  61 */         return connection;
/*     */       }
/*     */       try {
/*  64 */         ConnectHikari();
/*  65 */         connection = dataSource.getConnection();
/*  66 */         return connection;
/*  67 */       } catch (SQLException e) {
/*  68 */         e.printStackTrace();
/*  69 */         return connection;
/*     */       }
/*     */     
/*  72 */     } catch (SQLException e) {
/*  73 */       ConnectHikari();
/*     */       try {
/*  75 */         connection = dataSource.getConnection();
/*  76 */         return connection;
/*  77 */       } catch (SQLException ex) {
/*  78 */         ex.printStackTrace();
/*     */         
/*  80 */         return null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public static void createHikariTable() {
/*  85 */     CreateInventoryDataTable();
/*     */   }
/*     */   
/*     */   public static void CreateInventoryDataTable() {
/*     */     try {
/*  90 */       PreparedStatement ps = getHikariConnection().prepareStatement("CREATE TABLE IF NOT EXISTS InventoryData (InventoryID VARCHAR(100),WhoLocked VARCHAR(100),InventoryData VARCHAR(10000),PRIMARY KEY (InventoryID))");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  95 */       ps.executeUpdate();
/*     */     }
/*  97 */     catch (SQLException e) {
/*  98 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void closeConnections(Connection connection, PreparedStatement ps, ResultSet rs) {
/*     */     try {
/* 104 */       if (connection != null && !connection.isClosed()) {
/* 105 */         if (ps != null && !ps.isClosed()) {
/* 106 */           ps.close();
/*     */         }
/* 108 */         if (rs != null && !rs.isClosed()) {
/* 109 */           rs.close();
/*     */         }
/* 111 */         connection.close();
/* 112 */       } else if (connection == null) {
/* 113 */         if (ps != null && !ps.isClosed()) {
/* 114 */           ps.close();
/*     */         }
/* 116 */         if (rs != null && !rs.isClosed()) {
/* 117 */           rs.close();
/*     */         }
/*     */       } 
/* 120 */     } catch (Exception e) {
/* 121 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\MySQL\HikariCP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
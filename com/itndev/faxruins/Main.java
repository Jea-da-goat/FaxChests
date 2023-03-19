/*    */ package com.itndev.faxruins;
/*    */ 
/*    */ import com.itndev.faxruins.Commands.BukkitCommands;
/*    */ import com.itndev.faxruins.Listener.PlayerListener;
/*    */ import com.itndev.faxruins.MySQL.HikariCP;
/*    */ import com.itndev.faxruins.Var.Values;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ public final class Main
/*    */   extends JavaPlugin
/*    */ {
/*    */   private static Main instance;
/*    */   
/*    */   public static Main getInstance() {
/* 22 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 27 */     instance = this;
/* 28 */     Values.ServerName = "client1";
/*    */     
/* 30 */     HikariCP.setupHikariInfo();
/* 31 */     HikariCP.ConnectHikari();
/* 32 */     HikariCP.createHikariTable();
/*    */     
/* 34 */     Bukkit.getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)getInstance());
/* 35 */     ((PluginCommand)Objects.<PluginCommand>requireNonNull(getInstance().getCommand("창고"))).setExecutor((CommandExecutor)new BukkitCommands());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 41 */     instance = null;
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
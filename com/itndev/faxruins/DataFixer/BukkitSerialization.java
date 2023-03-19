/*    */ package com.itndev.faxruins.DataFixer;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.util.io.BukkitObjectInputStream;
/*    */ import org.bukkit.util.io.BukkitObjectOutputStream;
/*    */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
/*    */ 
/*    */ 
/*    */ public class BukkitSerialization
/*    */ {
/*    */   public static String[] playerInventoryToBase64(PlayerInventory playerInventory) throws IllegalStateException {
/* 18 */     String content = toBase64((Inventory)playerInventory);
/* 19 */     String armor = itemStackArrayToBase64(playerInventory.getArmorContents());
/*    */     
/* 21 */     return new String[] { content, armor };
/*    */   }
/*    */   
/*    */   public static String itemStackArrayToBase64(ItemStack[] items) throws IllegalStateException {
/*    */     try {
/* 26 */       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 27 */       BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
/*    */ 
/*    */       
/* 30 */       dataOutput.writeInt(items.length);
/*    */ 
/*    */       
/* 33 */       for (int i = 0; i < items.length; i++) {
/* 34 */         dataOutput.writeObject(items[i]);
/*    */       }
/*    */ 
/*    */       
/* 38 */       dataOutput.close();
/* 39 */       return Base64Coder.encodeLines(outputStream.toByteArray());
/* 40 */     } catch (Exception e) {
/* 41 */       throw new IllegalStateException("Unable to save item stacks.", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String toBase64(Inventory inventory) throws IllegalStateException {
/*    */     try {
/* 47 */       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 48 */       BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
/*    */ 
/*    */       
/* 51 */       dataOutput.writeInt(inventory.getSize());
/*    */ 
/*    */       
/* 54 */       for (int i = 0; i < inventory.getSize(); i++) {
/* 55 */         dataOutput.writeObject(inventory.getItem(i));
/*    */       }
/*    */ 
/*    */       
/* 59 */       dataOutput.close();
/* 60 */       return Base64Coder.encodeLines(outputStream.toByteArray());
/* 61 */     } catch (Exception e) {
/* 62 */       throw new IllegalStateException("Unable to save item stacks.", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Inventory fromBase64(String data) throws IOException {
/*    */     try {
/* 68 */       ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
/* 69 */       BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
/* 70 */       Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());
/*    */ 
/*    */       
/* 73 */       for (int i = 0; i < inventory.getSize(); i++) {
/* 74 */         inventory.setItem(i, (ItemStack)dataInput.readObject());
/*    */       }
/*    */       
/* 77 */       dataInput.close();
/* 78 */       return inventory;
/* 79 */     } catch (ClassNotFoundException e) {
/* 80 */       throw new IOException("Unable to decode class type.", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ItemStack[] itemStackArrayFromBase64(String data) throws IOException {
/*    */     try {
/* 86 */       ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
/* 87 */       BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
/* 88 */       ItemStack[] items = new ItemStack[dataInput.readInt()];
/*    */ 
/*    */       
/* 91 */       for (int i = 0; i < items.length; i++) {
/* 92 */         items[i] = (ItemStack)dataInput.readObject();
/*    */       }
/*    */       
/* 95 */       dataInput.close();
/* 96 */       return items;
/* 97 */     } catch (ClassNotFoundException e) {
/* 98 */       throw new IOException("Unable to decode class type.", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\itndev\faxruins\DataFixer\BukkitSerialization.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package org.slf4j;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoggerFactoryFriend
/*    */ {
/*    */   public static void reset() {
/* 20 */     LoggerFactory.reset();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setDetectLoggerNameMismatch(boolean enabled) {
/* 29 */     LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = enabled;
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\org\slf4j\LoggerFactoryFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
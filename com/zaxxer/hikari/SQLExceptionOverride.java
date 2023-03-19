/*    */ package com.zaxxer.hikari;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface SQLExceptionOverride
/*    */ {
/*    */   public enum Override
/*    */   {
/* 15 */     CONTINUE_EVICT,
/* 16 */     DO_NOT_EVICT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default Override adjudicate(SQLException sqlException) {
/* 28 */     return Override.CONTINUE_EVICT;
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\zaxxer\hikari\SQLExceptionOverride.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
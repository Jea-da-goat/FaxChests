/*    */ package com.zaxxer.hikari.pool;
/*    */ 
/*    */ import java.sql.CallableStatement;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ProxyCallableStatement
/*    */   extends ProxyPreparedStatement
/*    */   implements CallableStatement
/*    */ {
/*    */   protected ProxyCallableStatement(ProxyConnection connection, CallableStatement statement) {
/* 30 */     super(connection, statement);
/*    */   }
/*    */ }


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\com\zaxxer\hikari\pool\ProxyCallableStatement.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
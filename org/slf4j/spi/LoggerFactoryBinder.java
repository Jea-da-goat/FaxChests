package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

public interface LoggerFactoryBinder {
  ILoggerFactory getLoggerFactory();
  
  String getLoggerFactoryClassStr();
}


/* Location:              G:\FAXONLINE\bin\plugins\FaxChests-1.0-SNAPSHOT.jar!\org\slf4j\spi\LoggerFactoryBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
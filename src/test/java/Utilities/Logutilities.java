package Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import TestBase.BaseClass;


public class Logutilities{

	
	
	String LogFilepath = ".\\src\\test\\resources\\Log4j.properties";
	Logger logger = Logger.getLogger(Logutilities.class);

	public void info(String value) {

		PropertyConfigurator.configure(LogFilepath);
		logger.info(value);
		
	}

	public void warn(String value) {

		PropertyConfigurator.configure(LogFilepath);
		logger.warn(value);
	}

	public void error(String value) {

		PropertyConfigurator.configure(LogFilepath);
		logger.error(value);
	}

	public void fatal(String value) {

		PropertyConfigurator.configure(LogFilepath);
		logger.fatal(value);
	}

	public void debug(String value) {

		PropertyConfigurator.configure(LogFilepath);
		logger.debug(value);
	}
	
	
}

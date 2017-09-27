package br.jus.tjse.util.log;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public  class Log {
	private static Logger logger;

	static {
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("jersey-log.txt");
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("%d [%t] %5p %c:%L %m%n");
		fileAppender.setLayout(layout);
		fileAppender.activateOptions();

		Logger rootLogger = Logger.getRootLogger();
		rootLogger.addAppender(fileAppender);
	}

	public Log() {
		
	}
	
	public static Logger createLog(){
		logger = Logger.getLogger(Log.class);
		return logger;
	}
}

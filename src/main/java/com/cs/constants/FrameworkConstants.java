package com.cs.constants;

public class FrameworkConstants {
	
	private FrameworkConstants() {};
	
	
	private static String REPORT_PATH = System.getProperty("user.dir")+"/src/test/resources/report/index_"
			+ System.currentTimeMillis()+".html";
	
	public static String getReportPath() {
		return REPORT_PATH;
	}
	}

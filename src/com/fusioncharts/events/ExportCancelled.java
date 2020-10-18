package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ExportCancelled extends EventsTestBase {
	
	public static EventsBO exportcancelled;
	private static String eventName = "exportcancelled";
	
	@Test()
	public static void exportcancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		exportcancelled = new EventsBO();
		
        exportcancelled.setEventID((long) js.executeScript("return events.exportcancelled.eObj.eventId"));
        exportcancelled.setEventType((String) js.executeScript("return events.exportcancelled.eObj.eventType"));
        exportcancelled.setCancelled((boolean) js.executeScript("return events.exportcancelled.eObj.cancelled"));
        exportcancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.exportcancelled.eObj.stopPropagation"));
        exportcancelled.setDefaultPrevented((boolean) js.executeScript("return events.exportcancelled.eObj.defaultPrevented"));
        exportcancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.exportcancelled.eObj.preventDefault"));
        exportcancelled.setDetached((boolean) js.executeScript("return events.exportcancelled.eObj.detached"));
        exportcancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.exportcancelled.eObj.detachHandler"));
        exportcancelled.setChartType((String) js.executeScript("return events.exportcancelled.eObj.sender.chartType()"));
        
        String exportfilename = (String) js.executeScript("return events.exportcancelled.eObj.data.exportfilename");
        
        Assert.assertTrue(exportcancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(exportcancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(exportcancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(exportcancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(exportcancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(exportcancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(exportcancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(exportcancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(exportfilename.equals("FusionCharts"), "FusionCharts is the Export File Name");
        
        ExportCancelled.exportcancelledCount();
	}
	
	public static void exportcancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
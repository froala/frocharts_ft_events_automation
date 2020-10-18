package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class PrintCancelled extends EventsTestBase {

	
	public static EventsBO printcancelled;
	private static String eventName = "printcancelled";
	
	@Test()
	public static void printcancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		printcancelled = new EventsBO();
		
        printcancelled.setEventID((long) js.executeScript("return events.printcancelled.eObj.eventId"));
        printcancelled.setEventType((String) js.executeScript("return events.printcancelled.eObj.eventType"));
        printcancelled.setCancelled((boolean) js.executeScript("return events.printcancelled.eObj.cancelled"));
        printcancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.printcancelled.eObj.stopPropagation"));
        printcancelled.setDefaultPrevented((boolean) js.executeScript("return events.printcancelled.eObj.defaultPrevented"));
        printcancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.printcancelled.eObj.preventDefault"));
        printcancelled.setDetached((boolean) js.executeScript("return events.printcancelled.eObj.detached"));
        printcancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.printcancelled.eObj.detachHandler"));
        printcancelled.setChartType((String) js.executeScript("return events.printcancelled.eObj.sender.chartType()"));
        
        
        Assert.assertTrue(printcancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(printcancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(printcancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(printcancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(printcancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(printcancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(printcancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(printcancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        PrintCancelled.printcancelledCount();
	}
	
	public static void printcancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
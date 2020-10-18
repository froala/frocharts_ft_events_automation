package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class PrintComplete extends EventsTestBase {

	public static EventsBO printcomplete;
	private static String eventName = "printcomplete";
	
	@Test()
	public static void printcomplete()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		printcomplete = new EventsBO();
		
        printcomplete.setEventID((long) js.executeScript("return events.printcomplete.eObj.eventId"));
        printcomplete.setEventType((String) js.executeScript("return events.printcomplete.eObj.eventType"));
        printcomplete.setCancelled((boolean) js.executeScript("return events.printcomplete.eObj.cancelled"));
        printcomplete.setStopPropagation((Map<String, Object>) js.executeScript("return events.printcomplete.eObj.stopPropagation"));
        printcomplete.setDefaultPrevented((boolean) js.executeScript("return events.printcomplete.eObj.defaultPrevented"));
        printcomplete.setPreventDefault((Map<String, Object>) js.executeScript("return events.printcomplete.eObj.preventDefault"));
        printcomplete.setDetached((boolean) js.executeScript("return events.printcomplete.eObj.detached"));
        printcomplete.setDetachHandler((Map<String, Object>) js.executeScript("return events.printcomplete.eObj.detachHandler"));
        printcomplete.setChartType((String) js.executeScript("return events.printcomplete.eObj.sender.chartType()"));
        
        Assert.assertTrue(printcomplete.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(printcomplete.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(printcomplete.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(printcomplete.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(printcomplete.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(printcomplete.getDetached()==false, "detached is false");
        Assert.assertTrue(printcomplete.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(printcomplete.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        PrintComplete.printcompleteCount();
	}
	
	public static void printcompleteCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
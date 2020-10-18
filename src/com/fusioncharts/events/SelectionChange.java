package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class SelectionChange extends EventsTestBase{
	public static EventsBO selectionchange;
	private static String eventName = "selectionchange";
	
	@Test()
	public static void selectionchange()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		selectionchange = new EventsBO();
		
        selectionchange.setEventID((long) js.executeScript("return events.selectionchange.eObj.eventId"));
        selectionchange.setEventType((String) js.executeScript("return events.selectionchange.eObj.eventType"));
        selectionchange.setCancelled((boolean) js.executeScript("return events.selectionchange.eObj.cancelled"));
        selectionchange.setStopPropagation((Map<String, Object>) js.executeScript("return events.selectionchange.eObj.stopPropagation"));
        selectionchange.setDefaultPrevented((boolean) js.executeScript("return events.selectionchange.eObj.defaultPrevented"));
        selectionchange.setPreventDefault((Map<String, Object>) js.executeScript("return events.selectionchange.eObj.preventDefault"));
        selectionchange.setDetached((boolean) js.executeScript("return events.selectionchange.eObj.detached"));
        selectionchange.setDetachHandler((Map<String, Object>) js.executeScript("return events.selectionchange.eObj.detachHandler"));
        selectionchange.setChartType((String) js.executeScript("return events.selectionchange.eObj.sender.chartType()"));
        
        long binMuliplier = (long) js.executeScript("return events.selectionchange.eObj.data.binMuliplier");
        String binUnit = (String) js.executeScript("return events.selectionchange.eObj.data.binUnit");
        long end = (long) js.executeScript("return events.selectionchange.eObj.data.end");
        long start = (long) js.executeScript("return events.selectionchange.eObj.data.start");
        
        
        
        
        Assert.assertTrue(selectionchange.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(selectionchange.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(selectionchange.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(selectionchange.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(selectionchange.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(selectionchange.getDetached()==false, "detached is false");
        Assert.assertTrue(selectionchange.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(selectionchange.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(binMuliplier==1, "binMuliplier is 1");
        Assert.assertTrue(binUnit.equals("day"), "binUnit is day");
        Assert.assertTrue(end>start, "end is more than start");
        
        SelectionChange.selectionchangeCount();
	}
	
	public static void selectionchangeCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
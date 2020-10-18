package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;


public class Ready extends EventsTestBase {
	public static EventsBO ready;
	private static String eventName = "ready";
	
	@Test()
	public static void ready()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		ready = new EventsBO();
		
        ready.setEventID((long) js.executeScript("return events.ready.eObj.eventId"));
        ready.setEventType((String) js.executeScript("return events.ready.eObj.eventType"));
        ready.setCancelled((boolean) js.executeScript("return events.ready.eObj.cancelled"));
        ready.setStopPropagation((Map<String, Object>) js.executeScript("return events.ready.eObj.stopPropagation"));
        ready.setDefaultPrevented((boolean) js.executeScript("return events.ready.eObj.defaultPrevented"));
        ready.setPreventDefault((Map<String, Object>) js.executeScript("return events.ready.eObj.preventDefault"));
        ready.setDetached((boolean) js.executeScript("return events.ready.eObj.detached"));
        ready.setDetachHandler((Map<String, Object>) js.executeScript("return events.ready.eObj.detachHandler"));
        //ready.setChartType((String) js.executeScript("return events.ready.eObj.sender.chartType()"));
        
        boolean now = (boolean) js.executeScript("return events.ready.eObj.data.now");
        
        Assert.assertTrue(ready.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(ready.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(ready.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(ready.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(ready.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(ready.getDetached()==false, "detached is false");
        Assert.assertTrue(ready.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        //Assert.assertTrue(ready.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(now, "Now is true");
        
        Ready.readyCount();
	}
	
	public static void readyCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforeDraw extends EventsTestBase {
	public static EventsBO beforedraw;
	private static String eventName = "beforedraw";
	
	@Test()
	public static void beforedraw()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforedraw = new EventsBO();
		
        beforedraw.setEventID((long) js.executeScript("return events.beforedraw.eObj.eventId"));
        beforedraw.setEventType((String) js.executeScript("return events.beforedraw.eObj.eventType"));
        beforedraw.setCancelled((boolean) js.executeScript("return events.beforedraw.eObj.cancelled"));
        beforedraw.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforedraw.eObj.stopPropagation"));
        beforedraw.setDefaultPrevented((boolean) js.executeScript("return events.beforedraw.eObj.defaultPrevented"));
        beforedraw.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforedraw.eObj.preventDefault"));
        beforedraw.setDetached((boolean) js.executeScript("return events.beforedraw.eObj.detached"));
        beforedraw.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforedraw.eObj.detachHandler"));
        beforedraw.setChartType((String) js.executeScript("return events.beforedraw.eObj.sender.chartType()"));
        
        Assert.assertTrue(beforedraw.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforedraw.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforedraw.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforedraw.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforedraw.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforedraw.getDetached()==false, "detached is false");
        Assert.assertTrue(beforedraw.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforedraw.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        BeforeDraw.beforedrawCount();
	}
	
	public static void beforedrawCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}



}

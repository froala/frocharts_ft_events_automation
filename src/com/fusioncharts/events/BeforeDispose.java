package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforeDispose extends EventsTestBase {
	
	public static EventsBO beforedispose;
	private static String eventName = "beforedispose";
	
	@Test()
	public static void beforedispose()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforedispose = new EventsBO();
		
        beforedispose.setEventID((long) js.executeScript("return events.beforedispose.eObj.eventId"));
        beforedispose.setEventType((String) js.executeScript("return events.beforedispose.eObj.eventType"));
        beforedispose.setCancelled((boolean) js.executeScript("return events.beforedispose.eObj.cancelled"));
        beforedispose.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforedispose.eObj.stopPropagation"));
        beforedispose.setDefaultPrevented((boolean) js.executeScript("return events.beforedispose.eObj.defaultPrevented"));
        beforedispose.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforedispose.eObj.preventDefault"));
        beforedispose.setDetached((boolean) js.executeScript("return events.beforedispose.eObj.detached"));
        beforedispose.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforedispose.eObj.detachHandler"));
        
        
        Assert.assertTrue(beforedispose.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforedispose.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforedispose.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforedispose.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforedispose.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforedispose.getDetached()==false, "detached is false");
        Assert.assertTrue(beforedispose.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        
        BeforeDispose.beforedisposeCount();
	}
	
	public static void beforedisposeCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}



}

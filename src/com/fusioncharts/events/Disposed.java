package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class Disposed extends EventsTestBase {
	
	public static EventsBO disposed;
	private static String eventName = "disposed";
	
	@Test()
	public static void disposed()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		disposed = new EventsBO();
		
        disposed.setEventID((long) js.executeScript("return events.disposed.eObj.eventId"));
        disposed.setEventType((String) js.executeScript("return events.disposed.eObj.eventType"));
        disposed.setCancelled((boolean) js.executeScript("return events.disposed.eObj.cancelled"));
        disposed.setStopPropagation((Map<String, Object>) js.executeScript("return events.disposed.eObj.stopPropagation"));
        disposed.setDefaultPrevented((boolean) js.executeScript("return events.disposed.eObj.defaultPrevented"));
        disposed.setPreventDefault((Map<String, Object>) js.executeScript("return events.disposed.eObj.preventDefault"));
        disposed.setDetached((boolean) js.executeScript("return events.disposed.eObj.detached"));
        disposed.setDetachHandler((Map<String, Object>) js.executeScript("return events.disposed.eObj.detachHandler"));
        
        
        Assert.assertTrue(disposed.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(disposed.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(disposed.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(disposed.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(disposed.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(disposed.getDetached()==false, "detached is false");
        Assert.assertTrue(disposed.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        
        Disposed.disposedCount();
	}
	
	public static void disposedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
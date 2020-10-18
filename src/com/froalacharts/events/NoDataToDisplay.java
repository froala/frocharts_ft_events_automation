package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;


public class NoDataToDisplay extends EventsTestBase {

	public static EventsBO nodatatodisplay;
	private static String eventName = "nodatatodisplay";
	
	@Test()
	public static void nodatatodisplay()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		nodatatodisplay = new EventsBO();
		
        nodatatodisplay.setEventID((long) js.executeScript("return events.nodatatodisplay.eObj.eventId"));
        nodatatodisplay.setEventType((String) js.executeScript("return events.nodatatodisplay.eObj.eventType"));
        nodatatodisplay.setCancelled((boolean) js.executeScript("return events.nodatatodisplay.eObj.cancelled"));
        nodatatodisplay.setStopPropagation((Map<String, Object>) js.executeScript("return events.nodatatodisplay.eObj.stopPropagation"));
        nodatatodisplay.setDefaultPrevented((boolean) js.executeScript("return events.nodatatodisplay.eObj.defaultPrevented"));
        nodatatodisplay.setPreventDefault((Map<String, Object>) js.executeScript("return events.nodatatodisplay.eObj.preventDefault"));
        nodatatodisplay.setDetached((boolean) js.executeScript("return events.nodatatodisplay.eObj.detached"));
        nodatatodisplay.setDetachHandler((Map<String, Object>) js.executeScript("return events.nodatatodisplay.eObj.detachHandler"));
        nodatatodisplay.setChartType((String) js.executeScript("return events.nodatatodisplay.eObj.sender.chartType()"));
        
        Assert.assertTrue(nodatatodisplay.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(nodatatodisplay.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(nodatatodisplay.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(nodatatodisplay.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(nodatatodisplay.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(nodatatodisplay.getDetached()==false, "detached is false");
        Assert.assertTrue(nodatatodisplay.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(nodatatodisplay.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        NoDataToDisplay.nodatatodisplayCount();
	}
	
	public static void nodatatodisplayCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
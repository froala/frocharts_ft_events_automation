package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class RenderCancelled extends EventsTestBase{
	public static EventsBO rendercancelled;
	private static String eventName = "rendercancelled";
	
	@Test()
	public static void rendercancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		rendercancelled = new EventsBO();
		
        rendercancelled.setEventID((long) js.executeScript("return events.rendercancelled.eObj.eventId"));
        rendercancelled.setEventType((String) js.executeScript("return events.rendercancelled.eObj.eventType"));
        rendercancelled.setCancelled((boolean) js.executeScript("return events.rendercancelled.eObj.cancelled"));
        rendercancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.rendercancelled.eObj.stopPropagation"));
        rendercancelled.setDefaultPrevented((boolean) js.executeScript("return events.rendercancelled.eObj.defaultPrevented"));
        rendercancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.rendercancelled.eObj.preventDefault"));
        rendercancelled.setDetached((boolean) js.executeScript("return events.rendercancelled.eObj.detached"));
        rendercancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.rendercancelled.eObj.detachHandler"));
        rendercancelled.setChartType((String) js.executeScript("return events.rendercancelled.eObj.sender.chartType()"));
        
        String tagName = (String) js.executeScript("return events.rendercancelled.eObj.data.container.tagName");
        long height = (long) js.executeScript("return events.rendercancelled.eObj.data.height");
        long width = (long) js.executeScript("return events.rendercancelled.eObj.data.width");
        
        Assert.assertTrue(rendercancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(rendercancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(rendercancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(rendercancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(rendercancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(rendercancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(rendercancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(rendercancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(tagName.equals("DIV"), "tagName is DIV");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        RenderCancelled.rendercancelledCount();
	}
	
	public static void rendercancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
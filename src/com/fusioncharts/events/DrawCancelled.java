package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DrawCancelled extends EventsTestBase {
	
	public static EventsBO drawcancelled;
	private static String eventName = "drawcancelled";
	
	@Test()
	public static void drawcancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		drawcancelled = new EventsBO();
		
        drawcancelled.setEventID((long) js.executeScript("return events.drawcancelled.eObj.eventId"));
        drawcancelled.setEventType((String) js.executeScript("return events.drawcancelled.eObj.eventType"));
        drawcancelled.setCancelled((boolean) js.executeScript("return events.drawcancelled.eObj.cancelled"));
        drawcancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.drawcancelled.eObj.stopPropagation"));
        drawcancelled.setDefaultPrevented((boolean) js.executeScript("return events.drawcancelled.eObj.defaultPrevented"));
        drawcancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.drawcancelled.eObj.preventDefault"));
        drawcancelled.setDetached((boolean) js.executeScript("return events.drawcancelled.eObj.detached"));
        drawcancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.drawcancelled.eObj.detachHandler"));
        drawcancelled.setChartType((String) js.executeScript("return events.drawcancelled.eObj.sender.chartType()"));
        
        Assert.assertTrue(drawcancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(drawcancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(drawcancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(drawcancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(drawcancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(drawcancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(drawcancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(drawcancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        DrawCancelled.drawcancelledCount();
	}
	
	public static void drawcancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
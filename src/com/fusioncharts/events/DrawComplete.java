package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DrawComplete extends EventsTestBase {
	public static EventsBO drawcomplete;
	private static String eventName = "drawcomplete";
	
	@Test()
	public static void drawcomplete()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		drawcomplete = new EventsBO();
		
        drawcomplete.setEventID((long) js.executeScript("return events.drawcomplete.eObj.eventId"));
        drawcomplete.setEventType((String) js.executeScript("return events.drawcomplete.eObj.eventType"));
        drawcomplete.setCancelled((boolean) js.executeScript("return events.drawcomplete.eObj.cancelled"));
        drawcomplete.setStopPropagation((Map<String, Object>) js.executeScript("return events.drawcomplete.eObj.stopPropagation"));
        drawcomplete.setDefaultPrevented((boolean) js.executeScript("return events.drawcomplete.eObj.defaultPrevented"));
        drawcomplete.setPreventDefault((Map<String, Object>) js.executeScript("return events.drawcomplete.eObj.preventDefault"));
        drawcomplete.setDetached((boolean) js.executeScript("return events.drawcomplete.eObj.detached"));
        drawcomplete.setDetachHandler((Map<String, Object>) js.executeScript("return events.drawcomplete.eObj.detachHandler"));
        drawcomplete.setChartType((String) js.executeScript("return events.drawcomplete.eObj.sender.chartType()"));
        
        String renderer = (String) js.executeScript("return events.drawcomplete.eObj.data.renderer");
        long drawCount = (long) js.executeScript("return events.drawcomplete.eObj.data.drawCount");
        long height = (long) js.executeScript("return events.drawcomplete.eObj.data.height");
        long width = (long) js.executeScript("return events.drawcomplete.eObj.data.width");
        boolean displayingMessage = (boolean) js.executeScript("return events.drawcomplete.eObj.data.displayingMessage");
        
        Assert.assertTrue(drawcomplete.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(drawcomplete.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(drawcomplete.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(drawcomplete.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(drawcomplete.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(drawcomplete.getDetached()==false, "detached is false");
        Assert.assertTrue(drawcomplete.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(drawcomplete.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderer.equals("javascript"), "renderer is javascript");
        Assert.assertTrue(drawCount==1, "drawCount is 1");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        Assert.assertTrue(!displayingMessage, "displayingMessage is false");
        
        DrawComplete.drawcompleteCount();
	}
	
	public static void drawcompleteCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
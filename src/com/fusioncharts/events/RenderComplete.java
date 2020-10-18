package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class RenderComplete extends EventsTestBase {
	public static EventsBO rendercomplete;
	private static String eventName = "rendercomplete";
	
	@Test()
	public static void rendercomplete()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		rendercomplete = new EventsBO();
		
        rendercomplete.setEventID((long) js.executeScript("return events.rendercomplete.eObj.eventId"));
        rendercomplete.setEventType((String) js.executeScript("return events.rendercomplete.eObj.eventType"));
        rendercomplete.setCancelled((boolean) js.executeScript("return events.rendercomplete.eObj.cancelled"));
        rendercomplete.setStopPropagation((Map<String, Object>) js.executeScript("return events.rendercomplete.eObj.stopPropagation"));
        rendercomplete.setDefaultPrevented((boolean) js.executeScript("return events.rendercomplete.eObj.defaultPrevented"));
        rendercomplete.setPreventDefault((Map<String, Object>) js.executeScript("return events.rendercomplete.eObj.preventDefault"));
        rendercomplete.setDetached((boolean) js.executeScript("return events.rendercomplete.eObj.detached"));
        rendercomplete.setDetachHandler((Map<String, Object>) js.executeScript("return events.rendercomplete.eObj.detachHandler"));
        rendercomplete.setChartType((String) js.executeScript("return events.rendercomplete.eObj.sender.chartType()"));
        
        String renderer = (String) js.executeScript("return events.rendercomplete.eObj.data.renderer");
        long drawCount = (long) js.executeScript("return events.rendercomplete.eObj.data.drawCount");
        long height = (long) js.executeScript("return events.rendercomplete.eObj.data.height");
        long width = (long) js.executeScript("return events.rendercomplete.eObj.data.width");
        
        
        
        
        Assert.assertTrue(rendercomplete.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(rendercomplete.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(rendercomplete.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(rendercomplete.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(rendercomplete.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(rendercomplete.getDetached()==false, "detached is false");
        Assert.assertTrue(rendercomplete.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(rendercomplete.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderer.equals("javascript"), "renderer is javascript");
        Assert.assertTrue(drawCount==1, "drawCount is 1");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        RenderComplete.rendercompleteCount();
	}
	
	public static void rendercompleteCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
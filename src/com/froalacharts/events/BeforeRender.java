package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class BeforeRender extends EventsTestBase  {
	public static EventsBO beforerender;
	private static String eventName = "beforerender";
	
	@Test()
	public static void beforerender()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforerender = new EventsBO();
		
        beforerender.setEventID((long) js.executeScript("return events.beforerender.eObj.eventId"));
        beforerender.setEventType((String) js.executeScript("return events.beforerender.eObj.eventType"));
        beforerender.setCancelled((boolean) js.executeScript("return events.beforerender.eObj.cancelled"));
        beforerender.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforerender.eObj.stopPropagation"));
        beforerender.setDefaultPrevented((boolean) js.executeScript("return events.beforerender.eObj.defaultPrevented"));
        beforerender.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforerender.eObj.preventDefault"));
        beforerender.setDetached((boolean) js.executeScript("return events.beforerender.eObj.detached"));
        beforerender.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforerender.eObj.detachHandler"));
        beforerender.setChartType((String) js.executeScript("return events.beforerender.eObj.sender.chartType()"));
        
        String renderer = (String) js.executeScript("return events.beforerender.eObj.data.renderer");
        String tagName = (String) js.executeScript("return events.beforerender.eObj.data.container.tagName");
        long height = (long) js.executeScript("return events.beforerender.eObj.data.height");
        long width = (long) js.executeScript("return events.beforerender.eObj.data.width");
        
        
        
        
        Assert.assertTrue(beforerender.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforerender.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforerender.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforerender.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforerender.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforerender.getDetached()==false, "detached is false");
        Assert.assertTrue(beforerender.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforerender.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderer.equals("javascript"), "renderer is javascript");
        Assert.assertTrue(tagName.equals("DIV"), "data - container - tagName is DIV");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        BeforeRender.beforerenderCount();
	}
	
	public static void beforerenderCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}

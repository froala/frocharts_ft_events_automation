package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class Rendered extends EventsTestBase {
	public static EventsBO rendered;
	private static String eventName = "rendered";
	
	@Test()
	public static void rendered()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		rendered = new EventsBO();
		
        rendered.setEventID((long) js.executeScript("return events.rendered.eObj.eventId"));
        rendered.setEventType((String) js.executeScript("return events.rendered.eObj.eventType"));
        rendered.setCancelled((boolean) js.executeScript("return events.rendered.eObj.cancelled"));
        rendered.setStopPropagation((Map<String, Object>) js.executeScript("return events.rendered.eObj.stopPropagation"));
        rendered.setDefaultPrevented((boolean) js.executeScript("return events.rendered.eObj.defaultPrevented"));
        rendered.setPreventDefault((Map<String, Object>) js.executeScript("return events.rendered.eObj.preventDefault"));
        rendered.setDetached((boolean) js.executeScript("return events.rendered.eObj.detached"));
        rendered.setDetachHandler((Map<String, Object>) js.executeScript("return events.rendered.eObj.detachHandler"));
        rendered.setChartType((String) js.executeScript("return events.rendered.eObj.sender.chartType()"));
        
        String renderer = (String) js.executeScript("return events.rendered.eObj.data.renderer");
        
        
        
        
        Assert.assertTrue(rendered.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(rendered.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(rendered.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(rendered.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(rendered.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(rendered.getDetached()==false, "detached is false");
        Assert.assertTrue(rendered.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(rendered.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderer.equals("javascript"), "renderer is javascript");
        
        Rendered.renderedCount();
	}
	
	public static void renderedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
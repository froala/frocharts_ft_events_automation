package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforeInitialize extends EventsTestBase  {
	public static EventsBO beforeinitialize;
	private static String eventName = "beforeinitialize";
	
	@Test()
	public static void beforeinitialize()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforeinitialize = new EventsBO();
		
        beforeinitialize.setEventID((long) js.executeScript("return events.beforeinitialize.eObj.eventId"));
        beforeinitialize.setEventType((String) js.executeScript("return events.beforeinitialize.eObj.eventType"));
        beforeinitialize.setCancelled((boolean) js.executeScript("return events.beforeinitialize.eObj.cancelled"));
        beforeinitialize.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforeinitialize.eObj.stopPropagation"));
        beforeinitialize.setDefaultPrevented((boolean) js.executeScript("return events.beforeinitialize.eObj.defaultPrevented"));
        beforeinitialize.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforeinitialize.eObj.preventDefault"));
        beforeinitialize.setDetached((boolean) js.executeScript("return events.beforeinitialize.eObj.detached"));
        beforeinitialize.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforeinitialize.eObj.detachHandler"));
        beforeinitialize.setChartType((String) js.executeScript("return events.beforeinitialize.eObj.sender.chartType()"));
        
        String renderAt = (String) js.executeScript("return events.beforeinitialize.eObj.data.renderAt");
        String type = (String) js.executeScript("return events.beforeinitialize.eObj.data.type");
        String dataFormat = (String) js.executeScript("return events.beforeinitialize.eObj.data.dataFormat");
        String caption = (String) js.executeScript("return events.beforeinitialize.eObj.data.dataSource.caption.text");
        long height = (long) js.executeScript("return events.beforeinitialize.eObj.data.height");
        long width = (long) js.executeScript("return events.beforeinitialize.eObj.data.width");
        
        
        
        Assert.assertTrue(beforeinitialize.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforeinitialize.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforeinitialize.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforeinitialize.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforeinitialize.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforeinitialize.getDetached()==false, "detached is false");
        Assert.assertTrue(beforeinitialize.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforeinitialize.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderAt.equals("ft-container"), "renderAt is ft-container");
        Assert.assertTrue(type.equals("timeseries"), "type is timeseries");
        Assert.assertTrue(dataFormat.equals("JSON"), "dataFormat is JSON");
        Assert.assertTrue(caption.equals("I am a caption"), "caption is correct");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        BeforeInitialize.beforeinitializeCount();
	}
	
	public static void beforeinitializeCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforeResize extends EventsTestBase {

	public static EventsBO beforeresize;
	private static String eventName = "beforeresize";
	
	@Test()
	public static void beforeresize()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforeresize = new EventsBO();
		
        beforeresize.setEventID((long) js.executeScript("return events.beforeresize.eObj.eventId"));
        beforeresize.setEventType((String) js.executeScript("return events.beforeresize.eObj.eventType"));
        beforeresize.setCancelled((boolean) js.executeScript("return events.beforeresize.eObj.cancelled"));
        beforeresize.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforeresize.eObj.stopPropagation"));
        beforeresize.setDefaultPrevented((boolean) js.executeScript("return events.beforeresize.eObj.defaultPrevented"));
        beforeresize.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforeresize.eObj.preventDefault"));
        beforeresize.setDetached((boolean) js.executeScript("return events.beforeresize.eObj.detached"));
        beforeresize.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforeresize.eObj.detachHandler"));
        beforeresize.setChartType((String) js.executeScript("return events.beforeresize.eObj.sender.chartType()"));
        
        String newHeight = (String) js.executeScript("return events.beforeresize.eObj.data.newHeight");
        String newWidth = (String) js.executeScript("return events.beforeresize.eObj.data.newWidth");
        long currentHeight = (long) js.executeScript("return events.beforeresize.eObj.data.currentHeight");
        long currentWidth = (long) js.executeScript("return events.beforeresize.eObj.data.currentWidth");
        
        
        Assert.assertTrue(beforeresize.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforeresize.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforeresize.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforeresize.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforeresize.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforeresize.getDetached()==false, "detached is false");
        Assert.assertTrue(beforeresize.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforeresize.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(newHeight.equals("800"), "newHeight is 800");
        Assert.assertTrue(newWidth.equals("1300"), "newWidth is 1300");
        Assert.assertTrue(currentHeight==2000, "currentHeight is 2000");
        Assert.assertTrue(currentWidth==1200, "currentWidth is 1200");
        
        BeforeResize.beforeresizeCount();
	}
	
	public static void beforeresizeCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class Initialized extends EventsTestBase {
	public static EventsBO initialized;
	private static String eventName = "initialized";
	
	@Test()
	public static void initialized()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		initialized = new EventsBO();
		
        initialized.setEventID((long) js.executeScript("return events.initialized.eObj.eventId"));
        initialized.setEventType((String) js.executeScript("return events.initialized.eObj.eventType"));
        initialized.setCancelled((boolean) js.executeScript("return events.initialized.eObj.cancelled"));
        initialized.setStopPropagation((Map<String, Object>) js.executeScript("return events.initialized.eObj.stopPropagation"));
        initialized.setDefaultPrevented((boolean) js.executeScript("return events.initialized.eObj.defaultPrevented"));
        initialized.setPreventDefault((Map<String, Object>) js.executeScript("return events.initialized.eObj.preventDefault"));
        initialized.setDetached((boolean) js.executeScript("return events.initialized.eObj.detached"));
        initialized.setDetachHandler((Map<String, Object>) js.executeScript("return events.initialized.eObj.detachHandler"));
        initialized.setChartType((String) js.executeScript("return events.initialized.eObj.sender.chartType()"));
        
        String renderAt = (String) js.executeScript("return events.initialized.eObj.data.renderAt");
        String type = (String) js.executeScript("return events.initialized.eObj.data.type");
        String dataFormat = (String) js.executeScript("return events.initialized.eObj.data.dataFormat");
        String caption = (String) js.executeScript("return events.initialized.eObj.data.dataSource.caption.text");
        long height = (long) js.executeScript("return events.initialized.eObj.data.height");
        long width = (long) js.executeScript("return events.initialized.eObj.data.width");
        
        
        
        
        Assert.assertTrue(initialized.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(initialized.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(initialized.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(initialized.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(initialized.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(initialized.getDetached()==false, "detached is false");
        Assert.assertTrue(initialized.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(initialized.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderAt.equals("ft-container"), "renderAt is ft-container");
        Assert.assertTrue(type.equals("timeseries"), "type is timeseries");
        Assert.assertTrue(dataFormat.equals("JSON"), "dataFormat is JSON");
        Assert.assertTrue(caption.equals("I am a caption"), "caption is correct");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        Initialized.initializedCount();
	}
	
	public static void initializedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
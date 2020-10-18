package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class Resized extends EventsTestBase {

	public static EventsBO resized;
	private static String eventName = "resized";
	
	@Test()
	public static void resized()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		resized = new EventsBO();
		
        resized.setEventID((long) js.executeScript("return events.resized.eObj.eventId"));
        resized.setEventType((String) js.executeScript("return events.resized.eObj.eventType"));
        resized.setCancelled((boolean) js.executeScript("return events.resized.eObj.cancelled"));
        resized.setStopPropagation((Map<String, Object>) js.executeScript("return events.resized.eObj.stopPropagation"));
        resized.setDefaultPrevented((boolean) js.executeScript("return events.resized.eObj.defaultPrevented"));
        resized.setPreventDefault((Map<String, Object>) js.executeScript("return events.resized.eObj.preventDefault"));
        resized.setDetached((boolean) js.executeScript("return events.resized.eObj.detached"));
        resized.setDetachHandler((Map<String, Object>) js.executeScript("return events.resized.eObj.detachHandler"));
        resized.setChartType((String) js.executeScript("return events.resized.eObj.sender.chartType()"));
        
        String id = (String) js.executeScript("return events.resized.eObj.data.id");
        String height = (String) js.executeScript("return events.resized.eObj.data.height");
        String width = (String) js.executeScript("return events.resized.eObj.data.width");
        long originalHeight = (long) js.executeScript("return events.resized.eObj.data.originalHeight");
        long originalWidth = (long) js.executeScript("return events.resized.eObj.data.originalWidth");
        long pixelHeight = (long) js.executeScript("return events.resized.eObj.data.pixelHeight");
        long pixelWidth = (long) js.executeScript("return events.resized.eObj.data.pixelWidth");
        long prevHeight = (long) js.executeScript("return events.resized.eObj.data.prevHeight");
        long prevWidth = (long) js.executeScript("return events.resized.eObj.data.prevWidth");
        
        
        Assert.assertTrue(resized.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(resized.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(resized.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(resized.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(resized.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(resized.getDetached()==false, "detached is false");
        Assert.assertTrue(resized.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(resized.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(id.equals("fusiontimeid"), "id is fusiontimeid");
        Assert.assertTrue(height.equals("800"), "height is 800");
        Assert.assertTrue(width.equals("1300"), "width is 1300");
        Assert.assertTrue(originalHeight==2000, "originalHeight is 2000");
        Assert.assertTrue(originalWidth==1200, "originalWidth is 1200");
        Assert.assertTrue(pixelHeight==800, "pixelHeight is 800");
        Assert.assertTrue(pixelWidth==1300, "pixelWidth is 1300");
        Assert.assertTrue(prevHeight==2000, "prevHeight is 2000");
        Assert.assertTrue(prevWidth==1200, "prevWidth is 1200");
        
        Resized.resizedCount();
	}
	
	public static void resizedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
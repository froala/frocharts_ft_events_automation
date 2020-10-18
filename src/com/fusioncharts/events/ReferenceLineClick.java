package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceLineClick extends EventsTestBase{
	public static EventsBO referencelineclick;
	private static String eventName = "referencelineclick";
	
	@Test()
	public static void referencelineclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencelineclick = new EventsBO();
		
        referencelineclick.setEventID((long) js.executeScript("return events.referencelineclick.eObj.eventId"));
        referencelineclick.setEventType((String) js.executeScript("return events.referencelineclick.eObj.eventType"));
        referencelineclick.setCancelled((boolean) js.executeScript("return events.referencelineclick.eObj.cancelled"));
        referencelineclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencelineclick.eObj.stopPropagation"));
        referencelineclick.setDefaultPrevented((boolean) js.executeScript("return events.referencelineclick.eObj.defaultPrevented"));
        referencelineclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencelineclick.eObj.preventDefault"));
        referencelineclick.setDetached((boolean) js.executeScript("return events.referencelineclick.eObj.detached"));
        referencelineclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencelineclick.eObj.detachHandler"));
        referencelineclick.setChartType((String) js.executeScript("return events.referencelineclick.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencelineclick.eObj.data.label");
        double value = (double) js.executeScript("return events.referencelineclick.eObj.data.value");
        String valueFormatted = (String) js.executeScript("return events.referencelineclick.eObj.data.valueFormatted");
        
        
        
        
        Assert.assertTrue(referencelineclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencelineclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencelineclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencelineclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencelineclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencelineclick.getDetached()==false, "detached is false");
        Assert.assertTrue(referencelineclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencelineclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Line"), "label is Ref Line");
        Assert.assertTrue(value==0.5, "value is 0.5");
        Assert.assertTrue(valueFormatted.equals("0.5°C"), "valueFormatted is 0.5°C");
        
        ReferenceLineClick.referencelineclickCount();
	}
	
	public static void referencelineclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceLineRollOver extends EventsTestBase{
	public static EventsBO referencelinerollover;
	private static String eventName = "referencelinerollover";
	
	@Test()
	public static void referencelinerollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencelinerollover = new EventsBO();
		
        referencelinerollover.setEventID((long) js.executeScript("return events.referencelinerollover.eObj.eventId"));
        referencelinerollover.setEventType((String) js.executeScript("return events.referencelinerollover.eObj.eventType"));
        referencelinerollover.setCancelled((boolean) js.executeScript("return events.referencelinerollover.eObj.cancelled"));
        referencelinerollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencelinerollover.eObj.stopPropagation"));
        referencelinerollover.setDefaultPrevented((boolean) js.executeScript("return events.referencelinerollover.eObj.defaultPrevented"));
        referencelinerollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencelinerollover.eObj.preventDefault"));
        referencelinerollover.setDetached((boolean) js.executeScript("return events.referencelinerollover.eObj.detached"));
        referencelinerollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencelinerollover.eObj.detachHandler"));
        referencelinerollover.setChartType((String) js.executeScript("return events.referencelinerollover.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencelinerollover.eObj.data.label");
        double value = (double) js.executeScript("return events.referencelinerollover.eObj.data.value");
        String valueFormatted = (String) js.executeScript("return events.referencelinerollover.eObj.data.valueFormatted");
        
        
        
        
        Assert.assertTrue(referencelinerollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencelinerollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencelinerollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencelinerollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencelinerollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencelinerollover.getDetached()==false, "detached is false");
        Assert.assertTrue(referencelinerollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencelinerollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Line"), "label is Ref Line");
        Assert.assertTrue(value==0.5, "value is 0.5");
        Assert.assertTrue(valueFormatted.equals("0.5°C"), "valueFormatted is 0.5°C");
        
        ReferenceLineRollOver.referencelinerolloverCount();
	}
	
	public static void referencelinerolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
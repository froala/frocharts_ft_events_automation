package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceLineRollOut extends EventsTestBase {
	public static EventsBO referencelinerollout;
	private static String eventName = "referencelinerollout";
	
	@Test()
	public static void referencelinerollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencelinerollout = new EventsBO();
		
        referencelinerollout.setEventID((long) js.executeScript("return events.referencelinerollout.eObj.eventId"));
        referencelinerollout.setEventType((String) js.executeScript("return events.referencelinerollout.eObj.eventType"));
        referencelinerollout.setCancelled((boolean) js.executeScript("return events.referencelinerollout.eObj.cancelled"));
        referencelinerollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencelinerollout.eObj.stopPropagation"));
        referencelinerollout.setDefaultPrevented((boolean) js.executeScript("return events.referencelinerollout.eObj.defaultPrevented"));
        referencelinerollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencelinerollout.eObj.preventDefault"));
        referencelinerollout.setDetached((boolean) js.executeScript("return events.referencelinerollout.eObj.detached"));
        referencelinerollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencelinerollout.eObj.detachHandler"));
        referencelinerollout.setChartType((String) js.executeScript("return events.referencelinerollout.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencelinerollout.eObj.data.label");
        double value = (double) js.executeScript("return events.referencelinerollout.eObj.data.value");
        String valueFormatted = (String) js.executeScript("return events.referencelinerollout.eObj.data.valueFormatted");
        
        
        
        
        Assert.assertTrue(referencelinerollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencelinerollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencelinerollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencelinerollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencelinerollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencelinerollout.getDetached()==false, "detached is false");
        Assert.assertTrue(referencelinerollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencelinerollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Line"), "label is Ref Line");
        Assert.assertTrue(value==0.5, "value is 0.5");
        Assert.assertTrue(valueFormatted.equals("0.5°C"), "valueFormatted is 0.5°C");
        
        ReferenceLineRollOut.referencelinerolloutCount();
	}
	
	public static void referencelinerolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceZoneRollOut extends EventsTestBase{
	public static EventsBO referencezonerollout;
	private static String eventName = "referencezonerollout";
	
	@Test()
	public static void referencezonerollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencezonerollout = new EventsBO();
		
        referencezonerollout.setEventID((long) js.executeScript("return events.referencezonerollout.eObj.eventId"));
        referencezonerollout.setEventType((String) js.executeScript("return events.referencezonerollout.eObj.eventType"));
        referencezonerollout.setCancelled((boolean) js.executeScript("return events.referencezonerollout.eObj.cancelled"));
        referencezonerollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencezonerollout.eObj.stopPropagation"));
        referencezonerollout.setDefaultPrevented((boolean) js.executeScript("return events.referencezonerollout.eObj.defaultPrevented"));
        referencezonerollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencezonerollout.eObj.preventDefault"));
        referencezonerollout.setDetached((boolean) js.executeScript("return events.referencezonerollout.eObj.detached"));
        referencezonerollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencezonerollout.eObj.detachHandler"));
        referencezonerollout.setChartType((String) js.executeScript("return events.referencezonerollout.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencezonerollout.eObj.data.label");
        double valueMax = (double) js.executeScript("return events.referencezonerollout.eObj.data.valueMax");
        String valueMaxFormatted = (String) js.executeScript("return events.referencezonerollout.eObj.data.valueMaxFormatted");
        double valueMin = (double) js.executeScript("return events.referencezonerollout.eObj.data.valueMin");
        String valueMinFormatted = (String) js.executeScript("return events.referencezonerollout.eObj.data.valueMinFormatted");
        
        
        
        
        Assert.assertTrue(referencezonerollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencezonerollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencezonerollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencezonerollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencezonerollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencezonerollout.getDetached()==false, "detached is false");
        Assert.assertTrue(referencezonerollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencezonerollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Zone"), "label is Ref Zone");
        Assert.assertTrue(valueMax==0.4, "valueMax is 0.4");
        Assert.assertTrue(valueMaxFormatted.equals("0.4°C"), "valueMaxFormatted is 0.4°C");
        Assert.assertTrue(valueMin==0.15, "valueMin is 0.15");
        Assert.assertTrue(valueMinFormatted.equals("0.15°C"), "valueMinFormatted is 0.15°C");
        
        ReferenceZoneRollOut.referencezonerolloutCount();
	}
	
	public static void referencezonerolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
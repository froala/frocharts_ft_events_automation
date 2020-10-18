package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceZoneRollOver extends EventsTestBase{
	public static EventsBO referencezonerollover;
	private static String eventName = "referencezonerollover";
	
	@Test()
	public static void referencezonerollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencezonerollover = new EventsBO();
		
        referencezonerollover.setEventID((long) js.executeScript("return events.referencezonerollover.eObj.eventId"));
        referencezonerollover.setEventType((String) js.executeScript("return events.referencezonerollover.eObj.eventType"));
        referencezonerollover.setCancelled((boolean) js.executeScript("return events.referencezonerollover.eObj.cancelled"));
        referencezonerollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencezonerollover.eObj.stopPropagation"));
        referencezonerollover.setDefaultPrevented((boolean) js.executeScript("return events.referencezonerollover.eObj.defaultPrevented"));
        referencezonerollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencezonerollover.eObj.preventDefault"));
        referencezonerollover.setDetached((boolean) js.executeScript("return events.referencezonerollover.eObj.detached"));
        referencezonerollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencezonerollover.eObj.detachHandler"));
        referencezonerollover.setChartType((String) js.executeScript("return events.referencezonerollover.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencezonerollover.eObj.data.label");
        double valueMax = (double) js.executeScript("return events.referencezonerollover.eObj.data.valueMax");
        String valueMaxFormatted = (String) js.executeScript("return events.referencezonerollover.eObj.data.valueMaxFormatted");
        double valueMin = (double) js.executeScript("return events.referencezonerollover.eObj.data.valueMin");
        String valueMinFormatted = (String) js.executeScript("return events.referencezonerollover.eObj.data.valueMinFormatted");
        
        
        
        
        Assert.assertTrue(referencezonerollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencezonerollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencezonerollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencezonerollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencezonerollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencezonerollover.getDetached()==false, "detached is false");
        Assert.assertTrue(referencezonerollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencezonerollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Zone"), "label is Ref Zone");
        Assert.assertTrue(valueMax==0.4, "valueMax is 0.4");
        Assert.assertTrue(valueMaxFormatted.equals("0.4°C"), "valueMaxFormatted is 0.4°C");
        Assert.assertTrue(valueMin==0.15, "valueMin is 0.15");
        Assert.assertTrue(valueMinFormatted.equals("0.15°C"), "valueMinFormatted is 0.15°C");
        
        ReferenceZoneRollOver.referencezonerolloverCount();
	}
	
	public static void referencezonerolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
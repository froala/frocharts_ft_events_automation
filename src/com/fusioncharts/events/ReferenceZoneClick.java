package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ReferenceZoneClick extends EventsTestBase{
	public static EventsBO referencezoneclick;
	private static String eventName = "referencezoneclick";
	
	@Test()
	public static void referencezoneclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		referencezoneclick = new EventsBO();
		
        referencezoneclick.setEventID((long) js.executeScript("return events.referencezoneclick.eObj.eventId"));
        referencezoneclick.setEventType((String) js.executeScript("return events.referencezoneclick.eObj.eventType"));
        referencezoneclick.setCancelled((boolean) js.executeScript("return events.referencezoneclick.eObj.cancelled"));
        referencezoneclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.referencezoneclick.eObj.stopPropagation"));
        referencezoneclick.setDefaultPrevented((boolean) js.executeScript("return events.referencezoneclick.eObj.defaultPrevented"));
        referencezoneclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.referencezoneclick.eObj.preventDefault"));
        referencezoneclick.setDetached((boolean) js.executeScript("return events.referencezoneclick.eObj.detached"));
        referencezoneclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.referencezoneclick.eObj.detachHandler"));
        referencezoneclick.setChartType((String) js.executeScript("return events.referencezoneclick.eObj.sender.chartType()"));
        
        String label = (String) js.executeScript("return events.referencezoneclick.eObj.data.label");
        double valueMax = (double) js.executeScript("return events.referencezoneclick.eObj.data.valueMax");
        String valueMaxFormatted = (String) js.executeScript("return events.referencezoneclick.eObj.data.valueMaxFormatted");
        double valueMin = (double) js.executeScript("return events.referencezoneclick.eObj.data.valueMin");
        String valueMinFormatted = (String) js.executeScript("return events.referencezoneclick.eObj.data.valueMinFormatted");
        
        
        
        
        Assert.assertTrue(referencezoneclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(referencezoneclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(referencezoneclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(referencezoneclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(referencezoneclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(referencezoneclick.getDetached()==false, "detached is false");
        Assert.assertTrue(referencezoneclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(referencezoneclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(label.equals("Ref Zone"), "label is Ref Zone");
        Assert.assertTrue(valueMax==0.4, "valueMax is 0.4");
        Assert.assertTrue(valueMaxFormatted.equals("0.4°C"), "valueMaxFormatted is 0.4°C");
        Assert.assertTrue(valueMin==0.15, "valueMin is 0.15");
        Assert.assertTrue(valueMinFormatted.equals("0.15°C"), "valueMinFormatted is 0.15°C");
        
        ReferenceZoneClick.referencezoneclickCount();
	}
	
	public static void referencezoneclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
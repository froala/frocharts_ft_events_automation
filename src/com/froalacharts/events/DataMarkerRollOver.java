package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class DataMarkerRollOver extends EventsTestBase{
	public static EventsBO datamarkerrollover;
	private static String eventName = "datamarkerrollover";
	
	@Test()
	public static void datamarkerrollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		datamarkerrollover = new EventsBO();
		
        datamarkerrollover.setEventID((long) js.executeScript("return events.datamarkerrollover.eObj.eventId"));
        datamarkerrollover.setEventType((String) js.executeScript("return events.datamarkerrollover.eObj.eventType"));
        datamarkerrollover.setCancelled((boolean) js.executeScript("return events.datamarkerrollover.eObj.cancelled"));
        datamarkerrollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.datamarkerrollover.eObj.stopPropagation"));
        datamarkerrollover.setDefaultPrevented((boolean) js.executeScript("return events.datamarkerrollover.eObj.defaultPrevented"));
        datamarkerrollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.datamarkerrollover.eObj.preventDefault"));
        datamarkerrollover.setDetached((boolean) js.executeScript("return events.datamarkerrollover.eObj.detached"));
        datamarkerrollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.datamarkerrollover.eObj.detachHandler"));
        datamarkerrollover.setChartType((String) js.executeScript("return events.datamarkerrollover.eObj.sender.chartType()"));
        
        long binEnd = (long) js.executeScript("return events.datamarkerrollover.eObj.data.binEnd");
        long binStart = (long) js.executeScript("return events.datamarkerrollover.eObj.data.binStart");
        double binValue = (double) js.executeScript("return events.datamarkerrollover.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.datamarkerrollover.eObj.data.binValueFormatted");
        String measure = (String) js.executeScript("return events.datamarkerrollover.eObj.data.measure");
        String series = (String) js.executeScript("return events.datamarkerrollover.eObj.data.series");
        String identifier = (String) js.executeScript("return events.datamarkerrollover.eObj.data.identifier");
        String tooltipText = (String) js.executeScript("return events.datamarkerrollover.eObj.data.tooltipText[0]");
        long timestamp = (long) js.executeScript("return events.datamarkerrollover.eObj.data.timestamp");
        String timeText = (String) js.executeScript("return events.datamarkerrollover.eObj.data.timeText");
        String timeFormatter = (String) js.executeScript("return events.datamarkerrollover.eObj.data.timeFormatter");
        
        
        Assert.assertTrue(datamarkerrollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(datamarkerrollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(datamarkerrollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(datamarkerrollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(datamarkerrollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(datamarkerrollover.getDetached()==false, "detached is false");
        Assert.assertTrue(datamarkerrollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(datamarkerrollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(identifier.equals("D"), "identifier is D");
        Assert.assertTrue(measure.equals("Measure1"), "measure is Measure1");
        Assert.assertTrue(timeFormatter.equals("%Y-%m-%d"), "timeFormatter is %Y-%m-%d");
        Assert.assertTrue(timeText.equals("1980-12-19"), "timeText is 1980-12-19");
        
        DataMarkerRollOver.datamarkerrolloverCount();
	}
	
	public static void datamarkerrolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
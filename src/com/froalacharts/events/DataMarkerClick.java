package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class DataMarkerClick extends EventsTestBase{
	public static EventsBO datamarkerclick;
	private static String eventName = "datamarkerclick";
	
	@Test()
	public static void datamarkerclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		datamarkerclick = new EventsBO();
		
        datamarkerclick.setEventID((long) js.executeScript("return events.datamarkerclick.eObj.eventId"));
        datamarkerclick.setEventType((String) js.executeScript("return events.datamarkerclick.eObj.eventType"));
        datamarkerclick.setCancelled((boolean) js.executeScript("return events.datamarkerclick.eObj.cancelled"));
        datamarkerclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.datamarkerclick.eObj.stopPropagation"));
        datamarkerclick.setDefaultPrevented((boolean) js.executeScript("return events.datamarkerclick.eObj.defaultPrevented"));
        datamarkerclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.datamarkerclick.eObj.preventDefault"));
        datamarkerclick.setDetached((boolean) js.executeScript("return events.datamarkerclick.eObj.detached"));
        datamarkerclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.datamarkerclick.eObj.detachHandler"));
        datamarkerclick.setChartType((String) js.executeScript("return events.datamarkerclick.eObj.sender.chartType()"));
        
        long binEnd = (long) js.executeScript("return events.datamarkerclick.eObj.data.binEnd");
        long binStart = (long) js.executeScript("return events.datamarkerclick.eObj.data.binStart");
        double binValue = (double) js.executeScript("return events.datamarkerclick.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.datamarkerclick.eObj.data.binValueFormatted");
        String measure = (String) js.executeScript("return events.datamarkerclick.eObj.data.measure");
        String series = (String) js.executeScript("return events.datamarkerclick.eObj.data.series");
        String identifier = (String) js.executeScript("return events.datamarkerclick.eObj.data.identifier");
        String tooltipText = (String) js.executeScript("return events.datamarkerclick.eObj.data.tooltipText[0]");
        long timestamp = (long) js.executeScript("return events.datamarkerclick.eObj.data.timestamp");
        String timeText = (String) js.executeScript("return events.datamarkerclick.eObj.data.timeText");
        String timeFormatter = (String) js.executeScript("return events.datamarkerclick.eObj.data.timeFormatter");
        
        
        Assert.assertTrue(datamarkerclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(datamarkerclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(datamarkerclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(datamarkerclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(datamarkerclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(datamarkerclick.getDetached()==false, "detached is false");
        Assert.assertTrue(datamarkerclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(datamarkerclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(identifier.equals("D"), "identifier is D");
        Assert.assertTrue(measure.equals("Measure1"), "measure is Measure1");
        Assert.assertTrue(timeFormatter.equals("%Y-%m-%d"), "timeFormatter is %Y-%m-%d");
        Assert.assertTrue(timeText.equals("1980-12-19"), "timeText is 1980-12-19");
        
        DataMarkerClick.datamarkerclickCount();
	}
	
	public static void datamarkerclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
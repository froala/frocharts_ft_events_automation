package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataMarkerRollOut extends EventsTestBase {
	public static EventsBO datamarkerrollout;
	private static String eventName = "datamarkerrollout";
	
	@Test()
	public static void datamarkerrollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		datamarkerrollout = new EventsBO();
		
        datamarkerrollout.setEventID((long) js.executeScript("return events.datamarkerrollout.eObj.eventId"));
        datamarkerrollout.setEventType((String) js.executeScript("return events.datamarkerrollout.eObj.eventType"));
        datamarkerrollout.setCancelled((boolean) js.executeScript("return events.datamarkerrollout.eObj.cancelled"));
        datamarkerrollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.datamarkerrollout.eObj.stopPropagation"));
        datamarkerrollout.setDefaultPrevented((boolean) js.executeScript("return events.datamarkerrollout.eObj.defaultPrevented"));
        datamarkerrollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.datamarkerrollout.eObj.preventDefault"));
        datamarkerrollout.setDetached((boolean) js.executeScript("return events.datamarkerrollout.eObj.detached"));
        datamarkerrollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.datamarkerrollout.eObj.detachHandler"));
        datamarkerrollout.setChartType((String) js.executeScript("return events.datamarkerrollout.eObj.sender.chartType()"));
        
        long binEnd = (long) js.executeScript("return events.datamarkerrollout.eObj.data.binEnd");
        long binStart = (long) js.executeScript("return events.datamarkerrollout.eObj.data.binStart");
        double binValue = (double) js.executeScript("return events.datamarkerrollout.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.datamarkerrollout.eObj.data.binValueFormatted");
        String measure = (String) js.executeScript("return events.datamarkerrollout.eObj.data.measure");
        String series = (String) js.executeScript("return events.datamarkerrollout.eObj.data.series");
        String identifier = (String) js.executeScript("return events.datamarkerrollout.eObj.data.identifier");
        String tooltipText = (String) js.executeScript("return events.datamarkerrollout.eObj.data.tooltipText[0]");
        long timestamp = (long) js.executeScript("return events.datamarkerrollout.eObj.data.timestamp");
        String timeText = (String) js.executeScript("return events.datamarkerrollout.eObj.data.timeText");
        String timeFormatter = (String) js.executeScript("return events.datamarkerrollout.eObj.data.timeFormatter");
        
        
        Assert.assertTrue(datamarkerrollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(datamarkerrollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(datamarkerrollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(datamarkerrollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(datamarkerrollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(datamarkerrollout.getDetached()==false, "detached is false");
        Assert.assertTrue(datamarkerrollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(datamarkerrollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(identifier.equals("D"), "identifier is D");
        Assert.assertTrue(measure.equals("Measure1"), "measure is Measure1");
        Assert.assertTrue(timeFormatter.equals("%Y-%m-%d"), "timeFormatter is %Y-%m-%d");
        Assert.assertTrue(timeText.equals("1980-12-19"), "timeText is 1980-12-19");
        
        DataMarkerRollOut.datamarkerrolloutCount();
	}
	
	public static void datamarkerrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
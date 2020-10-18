package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class TimeMarkerRollOver extends EventsTestBase{
	public static EventsBO timemarkerrollover;
	private static String eventName = "timemarkerrollover";
	
	@Test()
	public static void timemarkerrollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timemarkerrollover = new EventsBO();
		
        timemarkerrollover.setEventID((long) js.executeScript("return events.timemarkerrollover.eObj.eventId"));
        timemarkerrollover.setEventType((String) js.executeScript("return events.timemarkerrollover.eObj.eventType"));
        timemarkerrollover.setCancelled((boolean) js.executeScript("return events.timemarkerrollover.eObj.cancelled"));
        timemarkerrollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.timemarkerrollover.eObj.stopPropagation"));
        timemarkerrollover.setDefaultPrevented((boolean) js.executeScript("return events.timemarkerrollover.eObj.defaultPrevented"));
        timemarkerrollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.timemarkerrollover.eObj.preventDefault"));
        timemarkerrollover.setDetached((boolean) js.executeScript("return events.timemarkerrollover.eObj.detached"));
        timemarkerrollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.timemarkerrollover.eObj.detachHandler"));
        timemarkerrollover.setChartType((String) js.executeScript("return events.timemarkerrollover.eObj.sender.chartType()"));
        
        long start = (long) js.executeScript("return events.timemarkerrollover.eObj.data.start");
        long end = (long) js.executeScript("return events.timemarkerrollover.eObj.data.end");
        String startText = (String) js.executeScript("return events.timemarkerrollover.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timemarkerrollover.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timemarkerrollover.eObj.data.formatter");
        String label = (String) js.executeScript("return events.timemarkerrollover.eObj.data.label");
        String type = (String) js.executeScript("return events.timemarkerrollover.eObj.data.type");
        
        
        Assert.assertTrue(timemarkerrollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timemarkerrollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timemarkerrollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timemarkerrollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timemarkerrollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timemarkerrollover.getDetached()==false, "detached is false");
        Assert.assertTrue(timemarkerrollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timemarkerrollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        Assert.assertTrue(startText.equals("1980-12-23"), "startText is 1980-12-23");
        Assert.assertTrue(endText.equals("1980-12-24"), "endText is 1980-12-24");
        Assert.assertTrue(formatter.equals("%Y-%m-%d"), "formatter is %Y-%m-%d");
        Assert.assertTrue(label.equals("This is a time marker"), "label is 'This is a time marker'");
        Assert.assertTrue(type.equals("minimal"), "type is minimal");
        
        TimeMarkerRollOver.timemarkerrolloverCount();
	}
	
	public static void timemarkerrolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
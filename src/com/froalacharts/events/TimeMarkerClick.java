package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class TimeMarkerClick extends EventsTestBase{
	public static EventsBO timemarkerclick;
	private static String eventName = "timemarkerclick";
	
	@Test()
	public static void timemarkerclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timemarkerclick = new EventsBO();
		
        timemarkerclick.setEventID((long) js.executeScript("return events.timemarkerclick.eObj.eventId"));
        timemarkerclick.setEventType((String) js.executeScript("return events.timemarkerclick.eObj.eventType"));
        timemarkerclick.setCancelled((boolean) js.executeScript("return events.timemarkerclick.eObj.cancelled"));
        timemarkerclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.timemarkerclick.eObj.stopPropagation"));
        timemarkerclick.setDefaultPrevented((boolean) js.executeScript("return events.timemarkerclick.eObj.defaultPrevented"));
        timemarkerclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.timemarkerclick.eObj.preventDefault"));
        timemarkerclick.setDetached((boolean) js.executeScript("return events.timemarkerclick.eObj.detached"));
        timemarkerclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.timemarkerclick.eObj.detachHandler"));
        timemarkerclick.setChartType((String) js.executeScript("return events.timemarkerclick.eObj.sender.chartType()"));
        
        long start = (long) js.executeScript("return events.timemarkerclick.eObj.data.start");
        long end = (long) js.executeScript("return events.timemarkerclick.eObj.data.end");
        String startText = (String) js.executeScript("return events.timemarkerclick.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timemarkerclick.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timemarkerclick.eObj.data.formatter");
        String label = (String) js.executeScript("return events.timemarkerclick.eObj.data.label");
        String type = (String) js.executeScript("return events.timemarkerclick.eObj.data.type");
        
        
        Assert.assertTrue(timemarkerclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timemarkerclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timemarkerclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timemarkerclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timemarkerclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timemarkerclick.getDetached()==false, "detached is false");
        Assert.assertTrue(timemarkerclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timemarkerclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        Assert.assertTrue(startText.equals("1980-12-23"), "startText is 1980-12-23");
        Assert.assertTrue(endText.equals("1980-12-24"), "endText is 1980-12-24");
        Assert.assertTrue(formatter.equals("%Y-%m-%d"), "formatter is %Y-%m-%d");
        Assert.assertTrue(label.equals("This is a time marker"), "label is 'This is a time marker'");
        Assert.assertTrue(type.equals("minimal"), "type is minimal");
        
        TimeMarkerClick.timemarkerclickCount();
	}
	
	public static void timemarkerclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
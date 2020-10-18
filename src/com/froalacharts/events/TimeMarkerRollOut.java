package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class TimeMarkerRollOut extends EventsTestBase{
	public static EventsBO timemarkerrollout;
	private static String eventName = "timemarkerrollout";
	
	@Test()
	public static void timemarkerrollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timemarkerrollout = new EventsBO();
		
        timemarkerrollout.setEventID((long) js.executeScript("return events.timemarkerrollout.eObj.eventId"));
        timemarkerrollout.setEventType((String) js.executeScript("return events.timemarkerrollout.eObj.eventType"));
        timemarkerrollout.setCancelled((boolean) js.executeScript("return events.timemarkerrollout.eObj.cancelled"));
        timemarkerrollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.timemarkerrollout.eObj.stopPropagation"));
        timemarkerrollout.setDefaultPrevented((boolean) js.executeScript("return events.timemarkerrollout.eObj.defaultPrevented"));
        timemarkerrollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.timemarkerrollout.eObj.preventDefault"));
        timemarkerrollout.setDetached((boolean) js.executeScript("return events.timemarkerrollout.eObj.detached"));
        timemarkerrollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.timemarkerrollout.eObj.detachHandler"));
        timemarkerrollout.setChartType((String) js.executeScript("return events.timemarkerrollout.eObj.sender.chartType()"));
        
        long start = (long) js.executeScript("return events.timemarkerrollout.eObj.data.start");
        long end = (long) js.executeScript("return events.timemarkerrollout.eObj.data.end");
        String startText = (String) js.executeScript("return events.timemarkerrollout.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timemarkerrollout.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timemarkerrollout.eObj.data.formatter");
        String label = (String) js.executeScript("return events.timemarkerrollout.eObj.data.label");
        String type = (String) js.executeScript("return events.timemarkerrollout.eObj.data.type");
        
        
        Assert.assertTrue(timemarkerrollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timemarkerrollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timemarkerrollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timemarkerrollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timemarkerrollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timemarkerrollout.getDetached()==false, "detached is false");
        Assert.assertTrue(timemarkerrollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timemarkerrollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        Assert.assertTrue(startText.equals("1980-12-23"), "startText is 1980-12-23");
        Assert.assertTrue(endText.equals("1980-12-24"), "endText is 1980-12-24");
        Assert.assertTrue(formatter.equals("%Y-%m-%d"), "formatter is %Y-%m-%d");
        Assert.assertTrue(label.equals("This is a time marker"), "label is 'This is a time marker'");
        Assert.assertTrue(type.equals("minimal"), "type is minimal");
        
        TimeMarkerRollOut.timemarkerrolloutCount();
	}
	
	public static void timemarkerrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
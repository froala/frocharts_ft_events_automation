package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.testcases.SpecificEventsTest;
import com.froalacharts.util.EventsBO;

public class CustomRangeSelect extends EventsTestBase{
	public static EventsBO customrangeselect;
	private static String eventName = "customrangeselect";
	
	@Test()
	public static void customrangeselect()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		customrangeselect = new EventsBO();
		
        customrangeselect.setEventID((long) js.executeScript("return events.customrangeselect.eObj.eventId"));
        customrangeselect.setEventType((String) js.executeScript("return events.customrangeselect.eObj.eventType"));
        customrangeselect.setCancelled((boolean) js.executeScript("return events.customrangeselect.eObj.cancelled"));
        customrangeselect.setStopPropagation((Map<String, Object>) js.executeScript("return events.customrangeselect.eObj.stopPropagation"));
        customrangeselect.setDefaultPrevented((boolean) js.executeScript("return events.customrangeselect.eObj.defaultPrevented"));
        customrangeselect.setPreventDefault((Map<String, Object>) js.executeScript("return events.customrangeselect.eObj.preventDefault"));
        customrangeselect.setDetached((boolean) js.executeScript("return events.customrangeselect.eObj.detached"));
        customrangeselect.setDetachHandler((Map<String, Object>) js.executeScript("return events.customrangeselect.eObj.detachHandler"));
        customrangeselect.setChartType((String) js.executeScript("return events.customrangeselect.eObj.sender.chartType()"));
        
        long start = (long) js.executeScript("return events.customrangeselect.eObj.data.start");
        long end = (long) js.executeScript("return events.customrangeselect.eObj.data.end");
        String startText = (String) js.executeScript("return events.customrangeselect.eObj.data.startText");
        String endText = (String) js.executeScript("return events.customrangeselect.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.customrangeselect.eObj.data.formatter");
        
        
        Assert.assertTrue(customrangeselect.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(customrangeselect.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(customrangeselect.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(customrangeselect.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(customrangeselect.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(customrangeselect.getDetached()==false, "detached is false");
        Assert.assertTrue(customrangeselect.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(customrangeselect.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        Assert.assertTrue(startText.equals(SpecificEventsTest.boCRS.getStartDateTimeNav()), "startText is correct");
        Assert.assertTrue(endText.equals(SpecificEventsTest.boCRS.getEndDateTimeNav()), "endText is correct");
        Assert.assertTrue(formatter.equals("%b %d, %Y"), "formatter is %b %d, %Y");
        
        CustomRangeSelect.customrangeselectCount();
	}
	
	public static void customrangeselectCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}
}

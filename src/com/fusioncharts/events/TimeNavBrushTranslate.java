package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.testcases.SpecificEventsTest;
import com.fusioncharts.util.EventsBO;

public class TimeNavBrushTranslate extends EventsPageObjectModel {

	public static EventsBO timenavbrush;
	private static String eventName = "timenavbrush";
	
	@Test()
	public static void timenavbrush()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timenavbrush = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        timenavbrush.setEventID((long) js.executeScript("return events.timenavbrush.eObj.eventId"));
        timenavbrush.setEventType((String) js.executeScript("return events.timenavbrush.eObj.eventType"));
        timenavbrush.setCancelled((boolean) js.executeScript("return events.timenavbrush.eObj.cancelled"));
        timenavbrush.setStopPropagation((Map<String, Object>) js.executeScript("return events.timenavbrush.eObj.stopPropagation"));
        timenavbrush.setDefaultPrevented((boolean) js.executeScript("return events.timenavbrush.eObj.defaultPrevented"));
        timenavbrush.setPreventDefault((Map<String, Object>) js.executeScript("return events.timenavbrush.eObj.preventDefault"));
        timenavbrush.setDetached((boolean) js.executeScript("return events.timenavbrush.eObj.detached"));
        timenavbrush.setDetachHandler((Map<String, Object>) js.executeScript("return events.timenavbrush.eObj.detachHandler"));
        timenavbrush.setChartType((String) js.executeScript("return events.timenavbrush.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.timenavbrush.eObj.data.start");
        long end = (long) js.executeScript("return events.timenavbrush.eObj.data.end");
        String startText = (String) js.executeScript("return events.timenavbrush.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timenavbrush.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timenavbrush.eObj.data.formatter");
        String action = (String) js.executeScript("return events.timenavbrush.eObj.data.action");
        
        
        Assert.assertTrue(timenavbrush.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timenavbrush.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timenavbrush.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timenavbrush.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timenavbrush.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timenavbrush.getDetached()==false, "detached is false");
        Assert.assertTrue(timenavbrush.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timenavbrush.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(startText.equals(SpecificEventsTest.boAfterTranslate.getStartDateTimeNav()), "startText is matching");
        Assert.assertTrue(endText.equals(SpecificEventsTest.boAfterTranslate.getEndDateTimeNav()), "endText is matching");
        Assert.assertTrue(formatter.equals("%b %d, %Y"), "formatter is %b %d, %Y");
        Assert.assertTrue(action.equals("translate"), "action is translate");
        
        TimeNavBrushTranslate.timenavbrushCount();
	}
	
	public static void timenavbrushCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
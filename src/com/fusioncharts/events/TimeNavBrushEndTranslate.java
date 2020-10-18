package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.testcases.SpecificEventsTest;
import com.fusioncharts.util.EventsBO;

public class TimeNavBrushEndTranslate extends EventsPageObjectModel{

	public static EventsBO timenavbrushend;
	private static String eventName = "timenavbrushend";
	
	@Test()
	public static void timenavbrushend()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timenavbrushend = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        timenavbrushend.setEventID((long) js.executeScript("return events.timenavbrushend.eObj.eventId"));
        timenavbrushend.setEventType((String) js.executeScript("return events.timenavbrushend.eObj.eventType"));
        timenavbrushend.setCancelled((boolean) js.executeScript("return events.timenavbrushend.eObj.cancelled"));
        timenavbrushend.setStopPropagation((Map<String, Object>) js.executeScript("return events.timenavbrushend.eObj.stopPropagation"));
        timenavbrushend.setDefaultPrevented((boolean) js.executeScript("return events.timenavbrushend.eObj.defaultPrevented"));
        timenavbrushend.setPreventDefault((Map<String, Object>) js.executeScript("return events.timenavbrushend.eObj.preventDefault"));
        timenavbrushend.setDetached((boolean) js.executeScript("return events.timenavbrushend.eObj.detached"));
        timenavbrushend.setDetachHandler((Map<String, Object>) js.executeScript("return events.timenavbrushend.eObj.detachHandler"));
        timenavbrushend.setChartType((String) js.executeScript("return events.timenavbrushend.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.timenavbrushend.eObj.data.start");
        long end = (long) js.executeScript("return events.timenavbrushend.eObj.data.end");
        String startText = (String) js.executeScript("return events.timenavbrushend.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timenavbrushend.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timenavbrushend.eObj.data.formatter");
        String action = (String) js.executeScript("return events.timenavbrushend.eObj.data.action");
        
        
        Assert.assertTrue(timenavbrushend.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timenavbrushend.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timenavbrushend.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timenavbrushend.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timenavbrushend.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timenavbrushend.getDetached()==false, "detached is false");
        Assert.assertTrue(timenavbrushend.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timenavbrushend.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(startText.equals(SpecificEventsTest.boAfterTranslate.getStartDateTimeNav()), "startText is matching");
        Assert.assertTrue(endText.equals(SpecificEventsTest.boAfterTranslate.getEndDateTimeNav()), "endText is matching");
        Assert.assertTrue(formatter.equals("%b %d, %Y"), "formatter is %b %d, %Y");
        Assert.assertTrue(action.equals("translate"), "action is translate");
        
        TimeNavBrushEndTranslate.timenavbrushendCount();
	}
	
	public static void timenavbrushendCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
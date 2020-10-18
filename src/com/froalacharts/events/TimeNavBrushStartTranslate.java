package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.testcases.SpecificEventsTest;
import com.froalacharts.util.EventsBO;

public class TimeNavBrushStartTranslate extends EventsPageObjectModel {

	public static EventsBO timenavbrushstart;
	private static String eventName = "timenavbrushstart";
	
	@Test()
	public static void timenavbrushstart()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		timenavbrushstart = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        timenavbrushstart.setEventID((long) js.executeScript("return events.timenavbrushstart.eObj.eventId"));
        timenavbrushstart.setEventType((String) js.executeScript("return events.timenavbrushstart.eObj.eventType"));
        timenavbrushstart.setCancelled((boolean) js.executeScript("return events.timenavbrushstart.eObj.cancelled"));
        timenavbrushstart.setStopPropagation((Map<String, Object>) js.executeScript("return events.timenavbrushstart.eObj.stopPropagation"));
        timenavbrushstart.setDefaultPrevented((boolean) js.executeScript("return events.timenavbrushstart.eObj.defaultPrevented"));
        timenavbrushstart.setPreventDefault((Map<String, Object>) js.executeScript("return events.timenavbrushstart.eObj.preventDefault"));
        timenavbrushstart.setDetached((boolean) js.executeScript("return events.timenavbrushstart.eObj.detached"));
        timenavbrushstart.setDetachHandler((Map<String, Object>) js.executeScript("return events.timenavbrushstart.eObj.detachHandler"));
        timenavbrushstart.setChartType((String) js.executeScript("return events.timenavbrushstart.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.timenavbrushstart.eObj.data.start");
        long end = (long) js.executeScript("return events.timenavbrushstart.eObj.data.end");
        String startText = (String) js.executeScript("return events.timenavbrushstart.eObj.data.startText");
        String endText = (String) js.executeScript("return events.timenavbrushstart.eObj.data.endText");
        String formatter = (String) js.executeScript("return events.timenavbrushstart.eObj.data.formatter");
        String action = (String) js.executeScript("return events.timenavbrushstart.eObj.data.action");
        
        
        Assert.assertTrue(timenavbrushstart.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(timenavbrushstart.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(timenavbrushstart.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(timenavbrushstart.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(timenavbrushstart.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(timenavbrushstart.getDetached()==false, "detached is false");
        Assert.assertTrue(timenavbrushstart.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(timenavbrushstart.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(startText.equals(SpecificEventsTest.boBeforeTranslate.getStartDateTimeNav()), "startText is matching");
        Assert.assertTrue(endText.equals(SpecificEventsTest.boBeforeTranslate.getEndDateTimeNav()), "endText is matching");
        Assert.assertTrue(formatter.equals("%b %d, %Y"), "formatter is %b %d, %Y");
        Assert.assertTrue(action.equals("translate"), "action is translate");
        
        TimeNavBrushStartTranslate.timenavbrushstartCount();
	}
	
	public static void timenavbrushstartCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
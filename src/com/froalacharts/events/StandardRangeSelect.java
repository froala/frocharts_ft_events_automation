package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.testcases.SpecificEventsTest;
import com.froalacharts.util.EventsBO;

public class StandardRangeSelect extends EventsTestBase{
	public static EventsBO standardrangeselect;
	private static String eventName = "standardrangeselect";
	
	@Test()
	public static void standardrangeselect()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		standardrangeselect = new EventsBO();
		
        standardrangeselect.setEventID((long) js.executeScript("return events.standardrangeselect.eObj.eventId"));
        standardrangeselect.setEventType((String) js.executeScript("return events.standardrangeselect.eObj.eventType"));
        standardrangeselect.setCancelled((boolean) js.executeScript("return events.standardrangeselect.eObj.cancelled"));
        standardrangeselect.setStopPropagation((Map<String, Object>) js.executeScript("return events.standardrangeselect.eObj.stopPropagation"));
        standardrangeselect.setDefaultPrevented((boolean) js.executeScript("return events.standardrangeselect.eObj.defaultPrevented"));
        standardrangeselect.setPreventDefault((Map<String, Object>) js.executeScript("return events.standardrangeselect.eObj.preventDefault"));
        standardrangeselect.setDetached((boolean) js.executeScript("return events.standardrangeselect.eObj.detached"));
        standardrangeselect.setDetachHandler((Map<String, Object>) js.executeScript("return events.standardrangeselect.eObj.detachHandler"));
        standardrangeselect.setChartType((String) js.executeScript("return events.standardrangeselect.eObj.sender.chartType()"));
        
        
        long multiplier = (long) js.executeScript("return events.standardrangeselect.eObj.data.multiplier");
        String text = (String) js.executeScript("return events.standardrangeselect.eObj.data.text");
        String unit = (String) js.executeScript("return events.standardrangeselect.eObj.data.unit");
        
        
        Assert.assertTrue(standardrangeselect.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(standardrangeselect.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(standardrangeselect.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(standardrangeselect.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(standardrangeselect.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(standardrangeselect.getDetached()==false, "detached is false");
        Assert.assertTrue(standardrangeselect.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(standardrangeselect.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(multiplier==7, "multiplier is 7");
        Assert.assertTrue(text.equals("7D"), "text is 7D");
        Assert.assertTrue(unit.equals("day"), "unit is day");
        
        StandardRangeSelect.standardrangeselectCount();
	}
	
	public static void standardrangeselectCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}
}

package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;


public class ChartTypeInvalid extends EventsTestBase {

	public static EventsBO charttypeinvalid;
	private static String eventName = "charttypeinvalid";
	
	@Test()
	public static void charttypeinvalid()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		charttypeinvalid = new EventsBO();
		System.out.println(charttypeinvalid);
		
		
        charttypeinvalid.setEventID((long) js.executeScript("return events.charttypeinvalid.eObj.eventId"));
        charttypeinvalid.setEventType((String) js.executeScript("return events.charttypeinvalid.eObj.eventType"));
        charttypeinvalid.setCancelled((boolean) js.executeScript("return events.charttypeinvalid.eObj.cancelled"));
        charttypeinvalid.setStopPropagation((Map<String, Object>) js.executeScript("return events.charttypeinvalid.eObj.stopPropagation"));
        charttypeinvalid.setDefaultPrevented((boolean) js.executeScript("return events.charttypeinvalid.eObj.defaultPrevented"));
        charttypeinvalid.setPreventDefault((Map<String, Object>) js.executeScript("return events.charttypeinvalid.eObj.preventDefault"));
        charttypeinvalid.setDetached((boolean) js.executeScript("return events.charttypeinvalid.eObj.detached"));
        charttypeinvalid.setDetachHandler((Map<String, Object>) js.executeScript("return events.charttypeinvalid.eObj.detachHandler"));
       // charttypeinvalid.setChartType((String) js.executeScript("return events.charttypeinvalid.eObj.sender.chartType()"));
        
        Assert.assertTrue(charttypeinvalid.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(charttypeinvalid.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(charttypeinvalid.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(charttypeinvalid.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(charttypeinvalid.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(charttypeinvalid.getDetached()==false, "detached is false");
        Assert.assertTrue(charttypeinvalid.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        //Assert.assertTrue(charttypeinvalid.getChartType().equals("_timeseries"), "sender.chartType is _timeseries");
        
        ChartTypeInvalid.charttypeinvalidCount();
	}
	
	public static void charttypeinvalidCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
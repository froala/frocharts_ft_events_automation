package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class ContainerNotFound extends EventsTestBase {


	public static EventsBO containernotfound;
	private static String eventName = "containernotfound";
	
	@Test()
	public static void containernotfound()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		containernotfound = new EventsBO();
		
        containernotfound.setEventID((long) js.executeScript("return events.containernotfound.eObj.eventId"));
        containernotfound.setEventType((String) js.executeScript("return events.containernotfound.eObj.eventType"));
        containernotfound.setCancelled((boolean) js.executeScript("return events.containernotfound.eObj.cancelled"));
        containernotfound.setStopPropagation((Map<String, Object>) js.executeScript("return events.containernotfound.eObj.stopPropagation"));
        containernotfound.setDefaultPrevented((boolean) js.executeScript("return events.containernotfound.eObj.defaultPrevented"));
        containernotfound.setPreventDefault((Map<String, Object>) js.executeScript("return events.containernotfound.eObj.preventDefault"));
        containernotfound.setDetached((boolean) js.executeScript("return events.containernotfound.eObj.detached"));
        containernotfound.setDetachHandler((Map<String, Object>) js.executeScript("return events.containernotfound.eObj.detachHandler"));
        containernotfound.setChartType((String) js.executeScript("return events.containernotfound.eObj.sender.chartType()"));
        
        Assert.assertTrue(containernotfound.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(containernotfound.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(containernotfound.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(containernotfound.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(containernotfound.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(containernotfound.getDetached()==false, "detached is false");
        Assert.assertTrue(containernotfound.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(containernotfound.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        ContainerNotFound.containernotfoundCount();
	}
	
	public static void containernotfoundCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
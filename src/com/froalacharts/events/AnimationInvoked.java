package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class AnimationInvoked extends EventsTestBase {
	public static EventsBO animationinvoked;
	private static String eventName = "animationinvoked";
	
	@Test()
	public static void animationinvoked()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver; 		
		animationinvoked = new EventsBO();		
        animationinvoked.setEventID((long) js.executeScript("return events.animationinvoked.eObj.eventId"));
        animationinvoked.setEventType((String) js.executeScript("return events.animationinvoked.eObj.eventType"));
        animationinvoked.setCancelled((boolean) js.executeScript("return events.animationinvoked.eObj.cancelled"));
        animationinvoked.setStopPropagation((Map<String, Object>) js.executeScript("return events.animationinvoked.eObj.stopPropagation"));
        animationinvoked.setDefaultPrevented((boolean) js.executeScript("return events.animationinvoked.eObj.defaultPrevented"));
        animationinvoked.setPreventDefault((Map<String, Object>) js.executeScript("return events.animationinvoked.eObj.preventDefault"));
        animationinvoked.setDetached((boolean) js.executeScript("return events.animationinvoked.eObj.detached"));
        animationinvoked.setDetachHandler((Map<String, Object>) js.executeScript("return events.animationinvoked.eObj.detachHandler"));
        animationinvoked.setChartType((String) js.executeScript("return events.animationinvoked.eObj.sender.chartType()"));
        
        
        long duration = (long) js.executeScript("return events.animationinvoked.eObj.data.duration");
        
        
        
        Assert.assertTrue(animationinvoked.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(animationinvoked.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(animationinvoked.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(animationinvoked.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(animationinvoked.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(animationinvoked.getDetached()==false, "detached is false");
        Assert.assertTrue(animationinvoked.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(animationinvoked.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        
        Assert.assertTrue(duration==1000, "drawCount is 1");
        
        AnimationInvoked.animationinvokedCount();
	}
	
	public static void animationinvokedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}


}

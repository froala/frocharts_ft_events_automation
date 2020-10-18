package com.froalacharts.events;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;
import com.froalacharts.util.TestUtil;
import com.froalacharts.util.ValidateAttributes;
import java.util.*; 

public class Loaded extends EventsTestBase {
	public static EventsBO loaded;
	private static String eventName = "loaded";
	
	@Test()
	public static void loaded()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		loaded = new EventsBO();
		
        loaded.setEventID((long) js.executeScript("return events.loaded.eObj.eventId"));
        loaded.setEventType((String) js.executeScript("return events.loaded.eObj.eventType"));
        loaded.setCancelled((boolean) js.executeScript("return events.loaded.eObj.cancelled"));
        loaded.setStopPropagation((Map<String, Object>) js.executeScript("return events.loaded.eObj.stopPropagation"));
        loaded.setDefaultPrevented((boolean) js.executeScript("return events.loaded.eObj.defaultPrevented"));
        loaded.setPreventDefault((Map<String, Object>) js.executeScript("return events.loaded.eObj.preventDefault"));
        loaded.setDetached((boolean) js.executeScript("return events.loaded.eObj.detached"));
        loaded.setDetachHandler((Map<String, Object>) js.executeScript("return events.loaded.eObj.detachHandler"));
        loaded.setChartType((String) js.executeScript("return events.loaded.eObj.sender.chartType()"));
        
        String renderer = (String) js.executeScript("return events.loaded.eObj.data.renderer");
        String type = (String) js.executeScript("return events.loaded.eObj.data.type");
        
        
        
        
        Assert.assertTrue(loaded.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(loaded.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(loaded.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(loaded.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(loaded.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(loaded.getDetached()==false, "detached is false");
        Assert.assertTrue(loaded.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(loaded.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(renderer.equals("javascript"), "renderer is javascript");
        Assert.assertTrue(type.equals("timeseries"), "type is timeseries");
        
        Loaded.loadedCount();
	}
	
	public static void loadedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
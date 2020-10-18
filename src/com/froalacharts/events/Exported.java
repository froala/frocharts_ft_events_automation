package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class Exported extends EventsTestBase {

	public static EventsBO exported;
	private static String eventName = "exported";
	
	@Test()
	public static void exported()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		exported = new EventsBO();
		
        exported.setEventID((long) js.executeScript("return events.exported.eObj.eventId"));
        exported.setEventType((String) js.executeScript("return events.exported.eObj.eventType"));
        exported.setCancelled((boolean) js.executeScript("return events.exported.eObj.cancelled"));
        exported.setStopPropagation((Map<String, Object>) js.executeScript("return events.exported.eObj.stopPropagation"));
        exported.setDefaultPrevented((boolean) js.executeScript("return events.exported.eObj.defaultPrevented"));
        exported.setPreventDefault((Map<String, Object>) js.executeScript("return events.exported.eObj.preventDefault"));
        exported.setDetached((boolean) js.executeScript("return events.exported.eObj.detached"));
        exported.setDetachHandler((Map<String, Object>) js.executeScript("return events.exported.eObj.detachHandler"));
       // exported.setChartType((String) js.executeScript("return events.exported.eObj.sender.chartType()"));
        
        
        String DOMId = (String) js.executeScript("return events.exported.eObj.data.DOMId");
        String fileName = (String) js.executeScript("return events.exported.eObj.data.fileName");
        long height = (long) js.executeScript("return events.exported.eObj.data.height");
        long width = (long) js.executeScript("return events.exported.eObj.data.width");
        String notice = (String) js.executeScript("return events.exported.eObj.data.notice");
        String statusCode = (String) js.executeScript("return events.exported.eObj.data.statusCode");
        String statusMessage = (String) js.executeScript("return events.exported.eObj.data.statusMessage");
        
        
        
        Assert.assertTrue(exported.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(exported.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(exported.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(exported.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(exported.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(exported.getDetached()==false, "detached is false");
        Assert.assertTrue(exported.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        //Assert.assertTrue(exported.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(DOMId.equals("fusiontimeid"), "DOMId is fusiontimeid");
        Assert.assertTrue(fileName.equals("FusionCharts.png"), "fileName is FusionCharts.png");
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        
        Exported.exportedCount();
	}
	
	public static void exportedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
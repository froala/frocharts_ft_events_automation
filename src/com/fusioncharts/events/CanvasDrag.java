package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.testcases.SpecificEventsTest;
import com.fusioncharts.util.EventsBO;

public class CanvasDrag extends EventsTestBase{

	public static EventsBO canvasdrag;
	private static String eventName = "canvasdrag";
	
	@Test()
	public static void canvasdrag()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		canvasdrag = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        canvasdrag.setEventID((long) js.executeScript("return events.canvasdrag.eObj.eventId"));
        canvasdrag.setEventType((String) js.executeScript("return events.canvasdrag.eObj.eventType"));
        canvasdrag.setCancelled((boolean) js.executeScript("return events.canvasdrag.eObj.cancelled"));
        canvasdrag.setStopPropagation((Map<String, Object>) js.executeScript("return events.canvasdrag.eObj.stopPropagation"));
        canvasdrag.setDefaultPrevented((boolean) js.executeScript("return events.canvasdrag.eObj.defaultPrevented"));
        canvasdrag.setPreventDefault((Map<String, Object>) js.executeScript("return events.canvasdrag.eObj.preventDefault"));
        canvasdrag.setDetached((boolean) js.executeScript("return events.canvasdrag.eObj.detached"));
        canvasdrag.setDetachHandler((Map<String, Object>) js.executeScript("return events.canvasdrag.eObj.detachHandler"));
        canvasdrag.setChartType((String) js.executeScript("return events.canvasdrag.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.canvasdrag.eObj.data.start");
        long end = (long) js.executeScript("return events.canvasdrag.eObj.data.end");
        
        
        Assert.assertTrue(canvasdrag.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(canvasdrag.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(canvasdrag.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(canvasdrag.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(canvasdrag.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(canvasdrag.getDetached()==false, "detached is false");
        Assert.assertTrue(canvasdrag.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(canvasdrag.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        
        CanvasDrag.canvasdragCount();
	}
	
	public static void canvasdragCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
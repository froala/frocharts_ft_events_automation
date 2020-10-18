package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class ChartRollOver extends EventsTestBase {

	public static EventsBO chartrollover;
	private static String eventName = "chartrollover";
	
	@Test()
	public static void chartrollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		chartrollover = new EventsBO();
		
        chartrollover.setEventID((long) js.executeScript("return events.chartrollover.eObj.eventId"));
        chartrollover.setEventType((String) js.executeScript("return events.chartrollover.eObj.eventType"));
        chartrollover.setCancelled((boolean) js.executeScript("return events.chartrollover.eObj.cancelled"));
        chartrollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.chartrollover.eObj.stopPropagation"));
        chartrollover.setDefaultPrevented((boolean) js.executeScript("return events.chartrollover.eObj.defaultPrevented"));
        chartrollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.chartrollover.eObj.preventDefault"));
        chartrollover.setDetached((boolean) js.executeScript("return events.chartrollover.eObj.detached"));
        chartrollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.chartrollover.eObj.detachHandler"));
        chartrollover.setChartType((String) js.executeScript("return events.chartrollover.eObj.sender.chartType()"));
        
        
        long chartX = (long) js.executeScript("return events.chartrollover.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.chartrollover.eObj.data.chartY");
        long pageX = (long) js.executeScript("return events.chartrollover.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.chartrollover.eObj.data.pageY");
        long pixelHeight = (long) js.executeScript("return events.chartrollover.eObj.data.pixelHeight");
        long pixelWidth = (long) js.executeScript("return events.chartrollover.eObj.data.pixelWidth");
        long height = (long) js.executeScript("return events.chartrollover.eObj.data.height");
        long width = (long) js.executeScript("return events.chartrollover.eObj.data.width");
        String id = (String) js.executeScript("return events.chartrollover.eObj.data.id");
        String containerid = (String) js.executeScript("return events.chartrollover.eObj.data.container.id");
        
        
        Assert.assertTrue(chartrollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(chartrollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(chartrollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(chartrollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(chartrollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(chartrollover.getDetached()==false, "detached is false");
        Assert.assertTrue(chartrollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(chartrollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        Assert.assertTrue(pixelWidth==1200, "pixelWidth is 1200");
        Assert.assertTrue(pixelHeight==2000, "pixelHeight is 2000");
        Assert.assertTrue(id.equals("fusiontimeid"), "id is fusiontimeid");
        
        ChartRollOver.chartrolloverCount();
	}
	
	public static void chartrolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
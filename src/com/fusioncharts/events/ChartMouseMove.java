package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ChartMouseMove extends EventsTestBase {

	public static EventsBO chartmousemove;
	private static String eventName = "chartmousemove";
	
	@Test()
	public static void chartmousemove()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		chartmousemove = new EventsBO();
		
        chartmousemove.setEventID((long) js.executeScript("return events.chartmousemove.eObj.eventId"));
        chartmousemove.setEventType((String) js.executeScript("return events.chartmousemove.eObj.eventType"));
        chartmousemove.setCancelled((boolean) js.executeScript("return events.chartmousemove.eObj.cancelled"));
        chartmousemove.setStopPropagation((Map<String, Object>) js.executeScript("return events.chartmousemove.eObj.stopPropagation"));
        chartmousemove.setDefaultPrevented((boolean) js.executeScript("return events.chartmousemove.eObj.defaultPrevented"));
        chartmousemove.setPreventDefault((Map<String, Object>) js.executeScript("return events.chartmousemove.eObj.preventDefault"));
        chartmousemove.setDetached((boolean) js.executeScript("return events.chartmousemove.eObj.detached"));
        chartmousemove.setDetachHandler((Map<String, Object>) js.executeScript("return events.chartmousemove.eObj.detachHandler"));
        chartmousemove.setChartType((String) js.executeScript("return events.chartmousemove.eObj.sender.chartType()"));
        
        
        long chartX = (long) js.executeScript("return events.chartmousemove.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.chartmousemove.eObj.data.chartY");
        long pageX = (long) js.executeScript("return events.chartmousemove.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.chartmousemove.eObj.data.pageY");
        long pixelHeight = (long) js.executeScript("return events.chartmousemove.eObj.data.pixelHeight");
        long pixelWidth = (long) js.executeScript("return events.chartmousemove.eObj.data.pixelWidth");
        long height = (long) js.executeScript("return events.chartmousemove.eObj.data.height");
        long width = (long) js.executeScript("return events.chartmousemove.eObj.data.width");
        String id = (String) js.executeScript("return events.chartmousemove.eObj.data.id");
        String containerid = (String) js.executeScript("return events.chartmousemove.eObj.data.container.id");
        
        
        Assert.assertTrue(chartmousemove.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(chartmousemove.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(chartmousemove.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(chartmousemove.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(chartmousemove.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(chartmousemove.getDetached()==false, "detached is false");
        Assert.assertTrue(chartmousemove.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(chartmousemove.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        Assert.assertTrue(pixelWidth==1200, "pixelWidth is 2000");
        Assert.assertTrue(pixelHeight==2000, "pixelHeight is 1200");
        Assert.assertTrue(id.equals("fusiontimeid"), "id is fusiontimeid");
        
        ChartMouseMove.chartmousemoveCount();
	}
	
	public static void chartmousemoveCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
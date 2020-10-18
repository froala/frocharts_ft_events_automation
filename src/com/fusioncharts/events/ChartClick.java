package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class ChartClick extends EventsTestBase {

	public static EventsBO chartclick;
	private static String eventName = "chartclick";
	
	@Test()
	public static void chartclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		chartclick = new EventsBO();
		
        chartclick.setEventID((long) js.executeScript("return events.chartclick.eObj.eventId"));
        chartclick.setEventType((String) js.executeScript("return events.chartclick.eObj.eventType"));
        chartclick.setCancelled((boolean) js.executeScript("return events.chartclick.eObj.cancelled"));
        chartclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.chartclick.eObj.stopPropagation"));
        chartclick.setDefaultPrevented((boolean) js.executeScript("return events.chartclick.eObj.defaultPrevented"));
        chartclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.chartclick.eObj.preventDefault"));
        chartclick.setDetached((boolean) js.executeScript("return events.chartclick.eObj.detached"));
        chartclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.chartclick.eObj.detachHandler"));
        chartclick.setChartType((String) js.executeScript("return events.chartclick.eObj.sender.chartType()"));
        
        
        long chartX = (long) js.executeScript("return events.chartclick.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.chartclick.eObj.data.chartY");
        long pageX = (long) js.executeScript("return events.chartclick.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.chartclick.eObj.data.pageY");
        long pixelHeight = (long) js.executeScript("return events.chartclick.eObj.data.pixelHeight");
        long pixelWidth = (long) js.executeScript("return events.chartclick.eObj.data.pixelWidth");
        long height = (long) js.executeScript("return events.chartclick.eObj.data.height");
        long width = (long) js.executeScript("return events.chartclick.eObj.data.width");
        String id = (String) js.executeScript("return events.chartclick.eObj.data.id");
        String containerid = (String) js.executeScript("return events.chartclick.eObj.data.container.id");
        
        
        Assert.assertTrue(chartclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(chartclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(chartclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(chartclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(chartclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(chartclick.getDetached()==false, "detached is false");
        Assert.assertTrue(chartclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(chartclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        Assert.assertTrue(pixelWidth==1200, "pixelWidth is 2000");
        Assert.assertTrue(pixelHeight==2000, "pixelHeight is 1200");
        Assert.assertTrue(id.equals("fusiontimeid"), "id is fusiontimeid");
        
        ChartClick.chartclickCount();
	}
	
	public static void chartclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class ChartRollOut extends EventsTestBase {

	public static EventsBO chartrollout;
	private static String eventName = "chartrollout";
	
	@Test()
	public static void chartrollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		chartrollout = new EventsBO();
		
        chartrollout.setEventID((long) js.executeScript("return events.chartrollout.eObj.eventId"));
        chartrollout.setEventType((String) js.executeScript("return events.chartrollout.eObj.eventType"));
        chartrollout.setCancelled((boolean) js.executeScript("return events.chartrollout.eObj.cancelled"));
        chartrollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.chartrollout.eObj.stopPropagation"));
        chartrollout.setDefaultPrevented((boolean) js.executeScript("return events.chartrollout.eObj.defaultPrevented"));
        chartrollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.chartrollout.eObj.preventDefault"));
        chartrollout.setDetached((boolean) js.executeScript("return events.chartrollout.eObj.detached"));
        chartrollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.chartrollout.eObj.detachHandler"));
        chartrollout.setChartType((String) js.executeScript("return events.chartrollout.eObj.sender.chartType()"));
        
        
        long chartX = (long) js.executeScript("return events.chartrollout.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.chartrollout.eObj.data.chartY");
        long pageX = (long) js.executeScript("return events.chartrollout.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.chartrollout.eObj.data.pageY");
        long pixelHeight = (long) js.executeScript("return events.chartrollout.eObj.data.pixelHeight");
        long pixelWidth = (long) js.executeScript("return events.chartrollout.eObj.data.pixelWidth");
        long height = (long) js.executeScript("return events.chartrollout.eObj.data.height");
        long width = (long) js.executeScript("return events.chartrollout.eObj.data.width");
        String id = (String) js.executeScript("return events.chartrollout.eObj.data.id");
        String containerid = (String) js.executeScript("return events.chartrollout.eObj.data.container.id");
        
        
        Assert.assertTrue(chartrollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(chartrollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(chartrollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(chartrollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(chartrollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(chartrollout.getDetached()==false, "detached is false");
        Assert.assertTrue(chartrollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(chartrollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(height==2000, "height is 2000");
        Assert.assertTrue(width==1200, "width is 1200");
        Assert.assertTrue(pixelWidth==1200, "pixelWidth is 1200");
        Assert.assertTrue(pixelHeight==2000, "pixelHeight is 2000");
        Assert.assertTrue(id.equals("fusiontimeid"), "id is fusiontimeid");
        
        ChartRollOut.chartrolloutCount();
	}
	
	public static void chartrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
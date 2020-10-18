package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class LegendItemRollOut extends EventsTestBase {
	public static EventsBO legenditemrollout;
	private static String eventName = "legenditemrollout";
	
	@Test()
	public static void legenditemrollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		legenditemrollout = new EventsBO();
		
        legenditemrollout.setEventID((long) js.executeScript("return events.legenditemrollout.eObj.eventId"));
        legenditemrollout.setEventType((String) js.executeScript("return events.legenditemrollout.eObj.eventType"));
        legenditemrollout.setCancelled((boolean) js.executeScript("return events.legenditemrollout.eObj.cancelled"));
        legenditemrollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.legenditemrollout.eObj.stopPropagation"));
        legenditemrollout.setDefaultPrevented((boolean) js.executeScript("return events.legenditemrollout.eObj.defaultPrevented"));
        legenditemrollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.legenditemrollout.eObj.preventDefault"));
        legenditemrollout.setDetached((boolean) js.executeScript("return events.legenditemrollout.eObj.detached"));
        legenditemrollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.legenditemrollout.eObj.detachHandler"));
        legenditemrollout.setChartType((String) js.executeScript("return events.legenditemrollout.eObj.sender.chartType()"));
        
        long chartX = (long) js.executeScript("return events.legenditemrollout.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.legenditemrollout.eObj.data.chartY");
        String datasetName = (String) js.executeScript("return events.legenditemrollout.eObj.data.datasetName");
        String id = (String) js.executeScript("return events.legenditemrollout.eObj.data.id");
        String legendItemId = (String) js.executeScript("return events.legenditemrollout.eObj.data.legendItemId");
        String legendItemIndex = (String) js.executeScript("return events.legenditemrollout.eObj.data.legendItemIndex");
        long pageX = (long) js.executeScript("return events.legenditemrollout.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.legenditemrollout.eObj.data.pageY");
        boolean visible = (boolean) js.executeScript("return events.legenditemrollout.eObj.data.visible");
        
        
        Assert.assertTrue(legenditemrollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(legenditemrollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(legenditemrollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(legenditemrollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(legenditemrollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(legenditemrollout.getDetached()==false, "detached is false");
        Assert.assertTrue(legenditemrollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(legenditemrollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(datasetName.equals("US"), "datasetName is US");
        Assert.assertTrue(id.equals("chartAPI_timeseries_1"), "id is chartAPI_timeseries_1");
        Assert.assertTrue(legendItemId.equals("legendItem_legendItem_1"), "id is legendItem_legendItem_1");
        Assert.assertTrue(visible==false, "visible is false");
        
        LegendItemRollOut.legenditemrolloutCount();
	}
	
	public static void legenditemrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}

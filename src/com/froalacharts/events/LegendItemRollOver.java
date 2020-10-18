package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class LegendItemRollOver extends EventsTestBase {
	public static EventsBO legenditemrollover;
	private static String eventName = "legenditemrollover";
	
	@Test()
	public static void legenditemrollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		legenditemrollover = new EventsBO();
		
        legenditemrollover.setEventID((long) js.executeScript("return events.legenditemrollover.eObj.eventId"));
        legenditemrollover.setEventType((String) js.executeScript("return events.legenditemrollover.eObj.eventType"));
        legenditemrollover.setCancelled((boolean) js.executeScript("return events.legenditemrollover.eObj.cancelled"));
        legenditemrollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.legenditemrollover.eObj.stopPropagation"));
        legenditemrollover.setDefaultPrevented((boolean) js.executeScript("return events.legenditemrollover.eObj.defaultPrevented"));
        legenditemrollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.legenditemrollover.eObj.preventDefault"));
        legenditemrollover.setDetached((boolean) js.executeScript("return events.legenditemrollover.eObj.detached"));
        legenditemrollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.legenditemrollover.eObj.detachHandler"));
        legenditemrollover.setChartType((String) js.executeScript("return events.legenditemrollover.eObj.sender.chartType()"));
        
        long chartX = (long) js.executeScript("return events.legenditemrollover.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.legenditemrollover.eObj.data.chartY");
        String datasetName = (String) js.executeScript("return events.legenditemrollover.eObj.data.datasetName");
        String id = (String) js.executeScript("return events.legenditemrollover.eObj.data.id");
        String legendItemId = (String) js.executeScript("return events.legenditemrollover.eObj.data.legendItemId");
        String legendItemIndex = (String) js.executeScript("return events.legenditemrollover.eObj.data.legendItemIndex");
        long pageX = (long) js.executeScript("return events.legenditemrollover.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.legenditemrollover.eObj.data.pageY");
        boolean visible = (boolean) js.executeScript("return events.legenditemrollover.eObj.data.visible");
        
        
        Assert.assertTrue(legenditemrollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(legenditemrollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(legenditemrollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(legenditemrollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(legenditemrollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(legenditemrollover.getDetached()==false, "detached is false");
        Assert.assertTrue(legenditemrollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(legenditemrollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(datasetName.equals("US"), "datasetName is US");
        Assert.assertTrue(id.equals("chartAPI_timeseries_1"), "id is chartAPI_timeseries_1");
        Assert.assertTrue(legendItemId.equals("legendItem_legendItem_1"), "id is legendItem_legendItem_1");
        Assert.assertTrue(visible==false, "visible is false");
        
        LegendItemRollOver.legenditemrolloverCount();
	}
	
	public static void legenditemrolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}

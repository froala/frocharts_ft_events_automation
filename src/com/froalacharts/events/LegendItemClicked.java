package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class LegendItemClicked extends EventsTestBase {
	public static EventsBO legenditemclicked;
	private static String eventName = "legenditemclicked";
	
	@Test()
	public static void legenditemclicked()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		legenditemclicked = new EventsBO();
		
        legenditemclicked.setEventID((long) js.executeScript("return events.legenditemclicked.eObj.eventId"));
        legenditemclicked.setEventType((String) js.executeScript("return events.legenditemclicked.eObj.eventType"));
        legenditemclicked.setCancelled((boolean) js.executeScript("return events.legenditemclicked.eObj.cancelled"));
        legenditemclicked.setStopPropagation((Map<String, Object>) js.executeScript("return events.legenditemclicked.eObj.stopPropagation"));
        legenditemclicked.setDefaultPrevented((boolean) js.executeScript("return events.legenditemclicked.eObj.defaultPrevented"));
        legenditemclicked.setPreventDefault((Map<String, Object>) js.executeScript("return events.legenditemclicked.eObj.preventDefault"));
        legenditemclicked.setDetached((boolean) js.executeScript("return events.legenditemclicked.eObj.detached"));
        legenditemclicked.setDetachHandler((Map<String, Object>) js.executeScript("return events.legenditemclicked.eObj.detachHandler"));
        legenditemclicked.setChartType((String) js.executeScript("return events.legenditemclicked.eObj.sender.chartType()"));
        
        long chartX = (long) js.executeScript("return events.legenditemclicked.eObj.data.chartX");
        long chartY = (long) js.executeScript("return events.legenditemclicked.eObj.data.chartY");
        String datasetName = (String) js.executeScript("return events.legenditemclicked.eObj.data.datasetName");
        String id = (String) js.executeScript("return events.legenditemclicked.eObj.data.id");
        String legendItemId = (String) js.executeScript("return events.legenditemclicked.eObj.data.legendItemId");
        String legendItemIndex = (String) js.executeScript("return events.legenditemclicked.eObj.data.legendItemIndex");
        long pageX = (long) js.executeScript("return events.legenditemclicked.eObj.data.pageX");
        long pageY = (long) js.executeScript("return events.legenditemclicked.eObj.data.pageY");
        boolean visible = (boolean) js.executeScript("return events.legenditemclicked.eObj.data.visible");
        
        
        Assert.assertTrue(legenditemclicked.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(legenditemclicked.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(legenditemclicked.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(legenditemclicked.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(legenditemclicked.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(legenditemclicked.getDetached()==false, "detached is false");
        Assert.assertTrue(legenditemclicked.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(legenditemclicked.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(datasetName.equals("US"), "datasetName is US");
        Assert.assertTrue(id.equals("chartAPI_timeseries_1"), "id is chartAPI_timeseries_1");
        Assert.assertTrue(legendItemId.equals("legendItem_legendItem_1"), "id is legendItem_legendItem_1");
        Assert.assertTrue(visible==false, "visible is false");
        
        LegendItemClicked.legenditemclickedCount();
	}
	
	public static void legenditemclickedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}

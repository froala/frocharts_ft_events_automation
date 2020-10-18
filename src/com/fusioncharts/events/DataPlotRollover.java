package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataPlotRollover extends EventsTestBase {

	public static EventsBO dataplotrollover;
	private static String eventName = "dataplotrollover";
	
	@Test()
	public static void dataplotrollover()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataplotrollover = new EventsBO();
		
        dataplotrollover.setEventID((long) js.executeScript("return events.dataplotrollover.eObj.eventId"));
        dataplotrollover.setEventType((String) js.executeScript("return events.dataplotrollover.eObj.eventType"));
        dataplotrollover.setCancelled((boolean) js.executeScript("return events.dataplotrollover.eObj.cancelled"));
        dataplotrollover.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataplotrollover.eObj.stopPropagation"));
        dataplotrollover.setDefaultPrevented((boolean) js.executeScript("return events.dataplotrollover.eObj.defaultPrevented"));
        dataplotrollover.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataplotrollover.eObj.preventDefault"));
        dataplotrollover.setDetached((boolean) js.executeScript("return events.dataplotrollover.eObj.detached"));
        dataplotrollover.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataplotrollover.eObj.detachHandler"));
        dataplotrollover.setChartType((String) js.executeScript("return events.dataplotrollover.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.dataplotrollover.eObj.data.start");
        long end = (long) js.executeScript("return events.dataplotrollover.eObj.data.end");
        String startText = (String) js.executeScript("return events.dataplotrollover.eObj.data.startText");
        String endText = (String) js.executeScript("return events.dataplotrollover.eObj.data.endText");
        String timeFormatter = (String) js.executeScript("return events.dataplotrollover.eObj.data.timeFormatter");
        String binUnit = (String) js.executeScript("return events.dataplotrollover.eObj.data.binUnit");
        long binMultiplier = (long) js.executeScript("return events.dataplotrollover.eObj.data.binMultiplier");
        String aggregation = (String) js.executeScript("return events.dataplotrollover.eObj.data.aggregation");
        String measure = (String) js.executeScript("return events.dataplotrollover.eObj.data.measure");
        double binValue = (double) js.executeScript("return events.dataplotrollover.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.dataplotrollover.eObj.data.binValueFormatted");
        String plotType = (String) js.executeScript("return events.dataplotrollover.eObj.data.plotType");
        String series = (String) js.executeScript("return events.dataplotrollover.eObj.data.series");
        String seriesValue = (String) js.executeScript("return events.dataplotrollover.eObj.data.seriesValue");
        
        
        Assert.assertTrue(dataplotrollover.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataplotrollover.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataplotrollover.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataplotrollover.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataplotrollover.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataplotrollover.getDetached()==false, "detached is false");
        Assert.assertTrue(dataplotrollover.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataplotrollover.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        
        Assert.assertTrue(startText.equals("1980-12-12"), "startText is 1980-12-12");
        Assert.assertTrue(endText.equals("1980-12-13"), "startText is 1980-12-13");
        Assert.assertTrue(timeFormatter.equals("%Y-%m-%d"), "timeFormatter is %Y-%m-%d");
        Assert.assertTrue(binUnit.equals("Day"), "binUnit is Day");
        Assert.assertTrue(binMultiplier==1, "binMultiplier is 1");
        Assert.assertTrue(aggregation.equals("average"), "aggregation is average");
        Assert.assertTrue(measure.equals("Measure1"), "measure is Measure1");
        Assert.assertTrue(binValue==0.513393, "binValue is 0.513393");
        Assert.assertTrue(binValueFormatted.equals("0.51°C"), "binValueFormatted is 0.51°C");
        Assert.assertTrue(plotType.equals("column"), "plotType is column");
        Assert.assertTrue(series.equals("Country"), "series is Country");
        Assert.assertTrue(seriesValue.equals("US"), "seriesValue is US");
        
        DataPlotRollover.dataplotrolloverCount();
	}
	
	public static void dataplotrolloverCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
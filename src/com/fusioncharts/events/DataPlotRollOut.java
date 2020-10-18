package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataPlotRollOut extends EventsTestBase {

	public static EventsBO dataplotrollout;
	private static String eventName = "dataplotrollout";
	
	@Test()
	public static void dataplotrollout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataplotrollout = new EventsBO();
		
        dataplotrollout.setEventID((long) js.executeScript("return events.dataplotrollout.eObj.eventId"));
        dataplotrollout.setEventType((String) js.executeScript("return events.dataplotrollout.eObj.eventType"));
        dataplotrollout.setCancelled((boolean) js.executeScript("return events.dataplotrollout.eObj.cancelled"));
        dataplotrollout.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataplotrollout.eObj.stopPropagation"));
        dataplotrollout.setDefaultPrevented((boolean) js.executeScript("return events.dataplotrollout.eObj.defaultPrevented"));
        dataplotrollout.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataplotrollout.eObj.preventDefault"));
        dataplotrollout.setDetached((boolean) js.executeScript("return events.dataplotrollout.eObj.detached"));
        dataplotrollout.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataplotrollout.eObj.detachHandler"));
        dataplotrollout.setChartType((String) js.executeScript("return events.dataplotrollout.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.dataplotrollout.eObj.data.start");
        long end = (long) js.executeScript("return events.dataplotrollout.eObj.data.end");
        String startText = (String) js.executeScript("return events.dataplotrollout.eObj.data.startText");
        String endText = (String) js.executeScript("return events.dataplotrollout.eObj.data.endText");
        String timeFormatter = (String) js.executeScript("return events.dataplotrollout.eObj.data.timeFormatter");
        String binUnit = (String) js.executeScript("return events.dataplotrollout.eObj.data.binUnit");
        long binMultiplier = (long) js.executeScript("return events.dataplotrollout.eObj.data.binMultiplier");
        String aggregation = (String) js.executeScript("return events.dataplotrollout.eObj.data.aggregation");
        String measure = (String) js.executeScript("return events.dataplotrollout.eObj.data.measure");
        double binValue = (double) js.executeScript("return events.dataplotrollout.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binValueFormatted");
        String plotType = (String) js.executeScript("return events.dataplotrollout.eObj.data.plotType");
        String series = (String) js.executeScript("return events.dataplotrollout.eObj.data.series");
        String seriesValue = (String) js.executeScript("return events.dataplotrollout.eObj.data.seriesValue");
        
        
        Assert.assertTrue(dataplotrollout.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataplotrollout.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataplotrollout.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataplotrollout.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataplotrollout.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataplotrollout.getDetached()==false, "detached is false");
        Assert.assertTrue(dataplotrollout.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataplotrollout.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
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
        
        DataPlotRollOut.dataplotrolloutCount();
	}
	
	public static void dataplotrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
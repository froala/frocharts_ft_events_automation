package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class DataPlotClick extends EventsTestBase {

	public static EventsBO dataplotclick;
	private static String eventName = "dataplotclick";
	
	@Test()
	public static void dataplotclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataplotclick = new EventsBO();
		
        dataplotclick.setEventID((long) js.executeScript("return events.dataplotclick.eObj.eventId"));
        dataplotclick.setEventType((String) js.executeScript("return events.dataplotclick.eObj.eventType"));
        dataplotclick.setCancelled((boolean) js.executeScript("return events.dataplotclick.eObj.cancelled"));
        dataplotclick.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataplotclick.eObj.stopPropagation"));
        dataplotclick.setDefaultPrevented((boolean) js.executeScript("return events.dataplotclick.eObj.defaultPrevented"));
        dataplotclick.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataplotclick.eObj.preventDefault"));
        dataplotclick.setDetached((boolean) js.executeScript("return events.dataplotclick.eObj.detached"));
        dataplotclick.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataplotclick.eObj.detachHandler"));
        dataplotclick.setChartType((String) js.executeScript("return events.dataplotclick.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.dataplotclick.eObj.data.start");
        long end = (long) js.executeScript("return events.dataplotclick.eObj.data.end");
        String startText = (String) js.executeScript("return events.dataplotclick.eObj.data.startText");
        String endText = (String) js.executeScript("return events.dataplotclick.eObj.data.endText");
        String timeFormatter = (String) js.executeScript("return events.dataplotclick.eObj.data.timeFormatter");
        String binUnit = (String) js.executeScript("return events.dataplotclick.eObj.data.binUnit");
        long binMultiplier = (long) js.executeScript("return events.dataplotclick.eObj.data.binMultiplier");
        String aggregation = (String) js.executeScript("return events.dataplotclick.eObj.data.aggregation");
        String measure = (String) js.executeScript("return events.dataplotclick.eObj.data.measure");
        double binValue = (double) js.executeScript("return events.dataplotclick.eObj.data.binValue");
        String binValueFormatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binValueFormatted");
        String plotType = (String) js.executeScript("return events.dataplotclick.eObj.data.plotType");
        String series = (String) js.executeScript("return events.dataplotclick.eObj.data.series");
        String seriesValue = (String) js.executeScript("return events.dataplotclick.eObj.data.seriesValue");
        
        
        Assert.assertTrue(dataplotclick.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataplotclick.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataplotclick.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataplotclick.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataplotclick.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataplotclick.getDetached()==false, "detached is false");
        Assert.assertTrue(dataplotclick.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataplotclick.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
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
        
        DataPlotClick.dataplotclickCount();
	}
	
	public static void dataplotclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
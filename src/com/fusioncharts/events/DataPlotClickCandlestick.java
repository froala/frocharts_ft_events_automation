package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataPlotClickCandlestick extends EventsTestBase{

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
        String aggregationMeasure1 = (String) js.executeScript("return events.dataplotclick.eObj.data.aggregation.Measure1");
        String measure = (String) js.executeScript("return events.dataplotclick.eObj.data.measure");
        double binValue = (double) js.executeScript("return events.dataplotclick.eObj.data.binValue");
        String binValueFomatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binValueFomatted");
        String measureOpen = (String) js.executeScript("return events.dataplotclick.eObj.data.measureOpen");
        String measureHigh = (String) js.executeScript("return events.dataplotclick.eObj.data.measureHigh");
        String measureLow = (String) js.executeScript("return events.dataplotclick.eObj.data.measureLow");
        String measuresClose = (String) js.executeScript("return events.dataplotclick.eObj.data.measuresClose");
        double binOpen = (double) js.executeScript("return events.dataplotclick.eObj.data.binOpen");
        String binOpenFormatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binOpenFormatted");
        double binHigh = (double) js.executeScript("return events.dataplotclick.eObj.data.binHigh");
        String binHighFormatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binHighFormatted");
        double binLow = (double) js.executeScript("return events.dataplotclick.eObj.data.binLow");
        String binLowFormatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binLowFormatted");
        double binClose = (double) js.executeScript("return events.dataplotclick.eObj.data.binClose");
        String binCloseFormatted = (String) js.executeScript("return events.dataplotclick.eObj.data.binCloseFormatted");
        
        
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
        Assert.assertTrue(aggregationMeasure1.equals("first"), "aggregationMeasure1 is first");
        Assert.assertTrue(measure.equals("Measure4"), "measure is Measure4");
        Assert.assertTrue(binValue==0.513393, "binValue is 0.513393");
        Assert.assertTrue(binValueFomatted.equals("0.51"), "binValueFomatted is 0.51");
        Assert.assertTrue(measureOpen.equals("Measure1"), "measureOpen is Measure1");
        Assert.assertTrue(measureHigh.equals("Measure2"), "measureHigh is Measure2");
        Assert.assertTrue(measureLow.equals("Measure3"), "measureLow is Measure3");
        Assert.assertTrue(measuresClose.equals("Measure4"), "measuresClose is Measure4");
        Assert.assertTrue(binOpen==0.513393, "binOpen is 0.513393");
        Assert.assertTrue(binHigh==0.515625, "binHigh is 0.515625");
        Assert.assertTrue(binLow==0.513393, "binLow is 0.513393");
        Assert.assertTrue(binClose==0.513393, "binClose is 0.513393");
        Assert.assertTrue(binOpenFormatted.equals("0.51"), "binOpenFormatted is 0.51");
        Assert.assertTrue(binHighFormatted.equals("0.52"), "binHighFormatted is 0.52");
        Assert.assertTrue(binLowFormatted.equals("0.51"), "binLowFormatted is 0.51");
        Assert.assertTrue(binCloseFormatted.equals("0.51"), "binCloseFormatted is 0.51");
        
        DataPlotClickCandlestick.dataplotclickCount();
	}
	
	public static void dataplotclickCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataPlotRollOutCandlestick extends EventsTestBase {

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
        String aggregationMeasure1 = (String) js.executeScript("return events.dataplotrollout.eObj.data.aggregation.Measure1");
        String measure = (String) js.executeScript("return events.dataplotrollout.eObj.data.measure");
        double binValue = (double) js.executeScript("return events.dataplotrollout.eObj.data.binValue");
        String binValueFomatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binValueFomatted");
        String measureOpen = (String) js.executeScript("return events.dataplotrollout.eObj.data.measureOpen");
        String measureHigh = (String) js.executeScript("return events.dataplotrollout.eObj.data.measureHigh");
        String measureLow = (String) js.executeScript("return events.dataplotrollout.eObj.data.measureLow");
        String measuresClose = (String) js.executeScript("return events.dataplotrollout.eObj.data.measuresClose");
        double binOpen = (double) js.executeScript("return events.dataplotrollout.eObj.data.binOpen");
        String binOpenFormatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binOpenFormatted");
        double binHigh = (double) js.executeScript("return events.dataplotrollout.eObj.data.binHigh");
        String binHighFormatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binHighFormatted");
        double binLow = (double) js.executeScript("return events.dataplotrollout.eObj.data.binLow");
        String binLowFormatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binLowFormatted");
        double binClose = (double) js.executeScript("return events.dataplotrollout.eObj.data.binClose");
        String binCloseFormatted = (String) js.executeScript("return events.dataplotrollout.eObj.data.binCloseFormatted");
        
        
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
        
        DataPlotRollOutCandlestick.dataplotrolloutCount();
	}
	
	public static void dataplotrolloutCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
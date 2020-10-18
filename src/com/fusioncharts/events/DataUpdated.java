package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataUpdated extends EventsTestBase {

	public static EventsBO dataupdated;
	private static String eventName = "dataupdated";
	
	@Test()
	public static void dataupdated()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataupdated = new EventsBO();
		
        dataupdated.setEventID((long) js.executeScript("return events.dataupdated.eObj.eventId"));
        dataupdated.setEventType((String) js.executeScript("return events.dataupdated.eObj.eventType"));
        dataupdated.setCancelled((boolean) js.executeScript("return events.dataupdated.eObj.cancelled"));
        dataupdated.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataupdated.eObj.stopPropagation"));
        dataupdated.setDefaultPrevented((boolean) js.executeScript("return events.dataupdated.eObj.defaultPrevented"));
        dataupdated.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataupdated.eObj.preventDefault"));
        dataupdated.setDetached((boolean) js.executeScript("return events.dataupdated.eObj.detached"));
        dataupdated.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataupdated.eObj.detachHandler"));
        dataupdated.setChartType((String) js.executeScript("return events.dataupdated.eObj.sender.chartType()"));
        
        String dataFormat = (String) js.executeScript("return events.dataupdated.eObj.data.dataFormat");
        String format = (String) js.executeScript("return events.dataupdated.eObj.data.format");
        String caption = (String) js.executeScript("return events.dataupdated.eObj.data.data.caption.text");
        String subcaption = (String) js.executeScript("return events.dataupdated.eObj.data.dataSource.subcaption.text");
        boolean nativeAtt = (boolean) js.executeScript("return events.dataupdated.eObj.data.native");
        boolean silent = (boolean) js.executeScript("return events.dataupdated.eObj.data.silent");
        
        
        Assert.assertTrue(dataupdated.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataupdated.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataupdated.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataupdated.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataupdated.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataupdated.getDetached()==false, "detached is false");
        Assert.assertTrue(dataupdated.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataupdated.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(dataFormat.equals("json"), "dataFormat is json");
        Assert.assertTrue(format.equals("json"), "format is json");
        Assert.assertTrue(caption.equals("I am a caption"), "Caption is correct");
        Assert.assertTrue(subcaption.equals("I am a subcaption"), "Subcaption is correct");
        Assert.assertTrue(nativeAtt, "displayingMessage is true");
        Assert.assertTrue(silent, "displayingMessage is true");
        
        DataUpdated.dataupdatedCount();
	}
	
	public static void dataupdatedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
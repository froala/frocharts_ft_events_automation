package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class BeforeDataUpdate extends EventsTestBase {
	public static EventsBO beforedataupdate;
	private static String eventName = "beforedataupdate";
	
	@Test()
	public static void beforedataupdate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforedataupdate = new EventsBO();
		
        beforedataupdate.setEventID((long) js.executeScript("return events.beforedataupdate.eObj.eventId"));
        beforedataupdate.setEventType((String) js.executeScript("return events.beforedataupdate.eObj.eventType"));
        beforedataupdate.setCancelled((boolean) js.executeScript("return events.beforedataupdate.eObj.cancelled"));
        beforedataupdate.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforedataupdate.eObj.stopPropagation"));
        beforedataupdate.setDefaultPrevented((boolean) js.executeScript("return events.beforedataupdate.eObj.defaultPrevented"));
        beforedataupdate.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforedataupdate.eObj.preventDefault"));
        beforedataupdate.setDetached((boolean) js.executeScript("return events.beforedataupdate.eObj.detached"));
        beforedataupdate.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforedataupdate.eObj.detachHandler"));
        beforedataupdate.setChartType((String) js.executeScript("return events.beforedataupdate.eObj.sender.chartType()"));
        
        String dataFormat = (String) js.executeScript("return events.beforedataupdate.eObj.data.dataFormat");
        String format = (String) js.executeScript("return events.beforedataupdate.eObj.data.format");
        String caption = (String) js.executeScript("return events.beforedataupdate.eObj.data.data.caption.text");
        String subcaption = (String) js.executeScript("return events.beforedataupdate.eObj.data.dataSource.subcaption.text");
        boolean nativeAtt = (boolean) js.executeScript("return events.beforedataupdate.eObj.data.native");
        boolean silent = (boolean) js.executeScript("return events.beforedataupdate.eObj.data.silent");
        
        
        Assert.assertTrue(beforedataupdate.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforedataupdate.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforedataupdate.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforedataupdate.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforedataupdate.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforedataupdate.getDetached()==false, "detached is false");
        Assert.assertTrue(beforedataupdate.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforedataupdate.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(dataFormat.equals("json"), "dataFormat is json");
        Assert.assertTrue(format.equals("json"), "format is json");
        Assert.assertTrue(caption.equals("I am a caption"), "Caption is correct");
        Assert.assertTrue(subcaption.equals("I am a subcaption"), "Subcaption is correct");
        Assert.assertTrue(nativeAtt, "displayingMessage is true");
        Assert.assertTrue(silent, "displayingMessage is true");
        
        BeforeDataUpdate.beforedataupdateCount();
	}
	
	public static void beforedataupdateCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}

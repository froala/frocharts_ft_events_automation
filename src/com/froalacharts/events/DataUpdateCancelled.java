package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class DataUpdateCancelled extends EventsTestBase {

	public static EventsBO dataupdatecancelled;
	private static String eventName = "dataupdatecancelled";
	
	@Test()
	public static void dataupdatecancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataupdatecancelled = new EventsBO();
		
        dataupdatecancelled.setEventID((long) js.executeScript("return events.dataupdatecancelled.eObj.eventId"));
        dataupdatecancelled.setEventType((String) js.executeScript("return events.dataupdatecancelled.eObj.eventType"));
        dataupdatecancelled.setCancelled((boolean) js.executeScript("return events.dataupdatecancelled.eObj.cancelled"));
        dataupdatecancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataupdatecancelled.eObj.stopPropagation"));
        dataupdatecancelled.setDefaultPrevented((boolean) js.executeScript("return events.dataupdatecancelled.eObj.defaultPrevented"));
        dataupdatecancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataupdatecancelled.eObj.preventDefault"));
        dataupdatecancelled.setDetached((boolean) js.executeScript("return events.dataupdatecancelled.eObj.detached"));
        dataupdatecancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataupdatecancelled.eObj.detachHandler"));
        dataupdatecancelled.setChartType((String) js.executeScript("return events.dataupdatecancelled.eObj.sender.chartType()"));
        
        String caption = (String) js.executeScript("return events.dataupdatecancelled.eObj.data.data.caption.text");
        String dataFormat = (String) js.executeScript("return events.dataupdatecancelled.eObj.data.dataFormat");
        String subcaption = (String) js.executeScript("return events.dataupdatecancelled.eObj.data.dataSource.subcaption.text"); 
        String format = (String) js.executeScript("return events.dataupdatecancelled.eObj.data.format");
       
        
        Assert.assertTrue(dataupdatecancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataupdatecancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataupdatecancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataupdatecancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataupdatecancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataupdatecancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(dataupdatecancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataupdatecancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(caption.equals("I am a caption"), "Caption is 'I am a caption'");
        Assert.assertTrue(dataFormat.equals("json"), "dataFormat is json");
        Assert.assertTrue(subcaption.equals("I am a subcaption"), "subcaption is 'I am a subcaption'");
        Assert.assertTrue(format.equals("json"), "Format is json");
        
        DataUpdateCancelled.dataupdatecancelledCount();
	}
	
	public static void dataupdatecancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}
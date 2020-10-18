package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforeExport extends EventsTestBase {

	public static EventsBO beforeexport;
	private static String eventName = "beforeexport";
	
	@Test()
	public static void beforeexport()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforeexport = new EventsBO();
		
        beforeexport.setEventID((long) js.executeScript("return events.beforeexport.eObj.eventId"));
        beforeexport.setEventType((String) js.executeScript("return events.beforeexport.eObj.eventType"));
        beforeexport.setCancelled((boolean) js.executeScript("return events.beforeexport.eObj.cancelled"));
        beforeexport.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforeexport.eObj.stopPropagation"));
        beforeexport.setDefaultPrevented((boolean) js.executeScript("return events.beforeexport.eObj.defaultPrevented"));
        beforeexport.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforeexport.eObj.preventDefault"));
        beforeexport.setDetached((boolean) js.executeScript("return events.beforeexport.eObj.detached"));
        beforeexport.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforeexport.eObj.detachHandler"));
        beforeexport.setChartType((String) js.executeScript("return events.beforeexport.eObj.sender.chartType()"));
        
        
        String bgColor = (String) js.executeScript("return events.beforeexport.eObj.data.bgcolor");
        String bgAlpha = (String) js.executeScript("return events.beforeexport.eObj.data.bgalpha");
        String exportaction = (String) js.executeScript("return events.beforeexport.eObj.data.exportaction");
        String exportfilename = (String) js.executeScript("return events.beforeexport.eObj.data.exportfilename");
        String exporthandler = (String) js.executeScript("return events.beforeexport.eObj.data.exporthandler");
        String exportformat = (String) js.executeScript("return events.beforeexport.eObj.data.exportformat");
        String exportparameters = (String) js.executeScript("return events.beforeexport.eObj.data.exportparameters");
        String exporttargetwindow = (String) js.executeScript("return events.beforeexport.eObj.data.exporttargetwindow");
        String exportcallback = (String) js.executeScript("return events.beforeexport.eObj.data.exportcallback");
        long exportwithimages = (long) js.executeScript("return events.beforeexport.eObj.data.exportwithimages");
        String exportformatsCSV = (String) js.executeScript("return events.beforeexport.eObj.data.exportformats.CSV");
        
        
        Assert.assertTrue(beforeexport.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforeexport.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforeexport.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforeexport.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforeexport.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforeexport.getDetached()==false, "detached is false");
        Assert.assertTrue(beforeexport.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforeexport.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(bgColor.equals("#ffffff"), "bgColor is #ffffff");
        Assert.assertTrue(bgAlpha.equals("1"), "bgAlpha is 1");
        Assert.assertTrue(exportaction.equals("download"), "exportaction is download");
        Assert.assertTrue(exportfilename.equals("FusionCharts"), "exportfilename is FusionCharts");
        Assert.assertTrue(exporthandler.equals("http://export.api3.fusioncharts.com/"), "exporthandler is http://export.api3.fusioncharts.com/");
        Assert.assertTrue(exportformat.equalsIgnoreCase("PNG"), "exportformat is PNG");
        Assert.assertTrue(exporttargetwindow.equals("_self"), "exporttargetwindow is _self");
        Assert.assertTrue(exportwithimages==1, "exportwithimages is 1");
        Assert.assertTrue(exportformatsCSV.equals("Export As CSV"), "exportformatsCSV is Export As CSV");
        
        BeforeExport.beforeexportCount();
	}
	
	public static void beforeexportCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}



}

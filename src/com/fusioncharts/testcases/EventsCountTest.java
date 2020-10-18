package com.fusioncharts.testcases;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventsCountTest 
{
	public static LinkedHashMap<String,Integer>  eventCount = new LinkedHashMap<String,Integer> ();
	
	@Test(groups = { "includetest" })
	public static void eventsCountTest()
	{
		System.out.println("eventCount.get(\"beforedispose\") = "+eventCount.get("beforedispose"));
		System.out.println("eventCount.get(\"beforedraw\") = "+eventCount.get("beforedraw"));
		System.out.println("eventCount.get(\"beforeexport\") = "+eventCount.get("beforeexport"));
		System.out.println("eventCount.get(\"beforeinitialize\") = "+eventCount.get("beforeinitialize"));
		System.out.println("eventCount.get(\"beforeprint\") = "+eventCount.get("beforeprint"));
		System.out.println("eventCount.get(\"beforerender\") = "+eventCount.get("beforerender"));
		System.out.println("eventCount.get(\"beforeresize\") = "+eventCount.get("beforeresize"));
		System.out.println("eventCount.get(\"canvasdrag\") = "+eventCount.get("canvasdrag"));
		System.out.println("eventCount.get(\"canvasdragend\") = "+eventCount.get("canvasdragend"));
		System.out.println("eventCount.get(\"canvasdragstart\") = "+eventCount.get("canvasdragstart"));
		System.out.println("eventCount.get(\"canvaswheel\") = "+eventCount.get("canvaswheel"));
		System.out.println("eventCount.get(\"chartclick\") = "+eventCount.get("chartclick"));
		System.out.println("eventCount.get(\"chartmousemove\") = "+eventCount.get("chartmousemove"));
		System.out.println("eventCount.get(\"chartrollout\") = "+eventCount.get("chartrollout"));
		System.out.println("eventCount.get(\"chartrollover\") = "+eventCount.get("chartrollover"));
		System.out.println("eventCount.get(\"charttypeinvalid\") = "+eventCount.get("charttypeinvalid"));
		System.out.println("eventCount.get(\"containernotfound\") = "+eventCount.get("containernotfound"));
		System.out.println("eventCount.get(\"customrangeselect\") = "+eventCount.get("customrangeselect"));
		System.out.println("eventCount.get(\"dataloaded\") = "+eventCount.get("dataloaded"));
		System.out.println("eventCount.get(\"datamarkerclick\") = "+eventCount.get("datamarkerclick"));
		System.out.println("eventCount.get(\"datamarkerrollout\") = "+eventCount.get("datamarkerrollout"));
		System.out.println("eventCount.get(\"datamarkerrollover\") = "+eventCount.get("datamarkerrollover"));
		System.out.println("eventCount.get(\"dataplotclick\") = "+eventCount.get("dataplotclick"));
		System.out.println("eventCount.get(\"dataplotrollout\") = "+eventCount.get("dataplotrollover"));
		System.out.println("eventCount.get(\"dataplotrollover\") = "+eventCount.get("dataplotrollover"));
		System.out.println("eventCount.get(\"dataupdatecancelled\") = "+eventCount.get("dataupdatecancelled"));
		System.out.println("eventCount.get(\"dataupdated\") = "+eventCount.get("dataupdated"));
		System.out.println("eventCount.get(\"disposecancelled\") = "+eventCount.get("disposecancelled"));
		System.out.println("eventCount.get(\"disposed\") = "+eventCount.get("disposed"));
		System.out.println("eventCount.get(\"drawcancelled\") = "+eventCount.get("drawcancelled"));
		System.out.println("eventCount.get(\"drawcomplete\") = "+eventCount.get("drawcomplete"));
		System.out.println("eventCount.get(\"exportcancelled\") = "+eventCount.get("exportcancelled"));
		System.out.println("eventCount.get(\"exported\") = "+eventCount.get("exported"));
		System.out.println("eventCount.get(\"initialized\") = "+eventCount.get("initialized"));
		System.out.println("eventCount.get(\"legenditemclicked\") = "+eventCount.get("legenditemclicked"));
		System.out.println("eventCount.get(\"legenditemrollout\") = "+eventCount.get("legenditemrollout"));
		System.out.println("eventCount.get(\"legenditemrollover\") = "+eventCount.get("legenditemrollover"));
		System.out.println("eventCount.get(\"loaded\") = "+eventCount.get("loaded"));
		System.out.println("eventCount.get(\"nodatatodisplay\") = "+eventCount.get("nodatatodisplay"));
		System.out.println("eventCount.get(\"printcancelled\") = "+eventCount.get("printcancelled"));
		System.out.println("eventCount.get(\"printcomplete\") = "+eventCount.get("printcomplete"));
		System.out.println("eventCount.get(\"ready\") = "+eventCount.get("ready"));
		System.out.println("eventCount.get(\"referencelineclick\") = "+eventCount.get("referencelineclick"));
		System.out.println("eventCount.get(\"referencelinerollout\") = "+eventCount.get("referencelinerollout"));
		System.out.println("eventCount.get(\"referencelinerollover\") = "+eventCount.get("referencelinerollover"));
		System.out.println("eventCount.get(\"referencezoneclick\") = "+eventCount.get("referencezoneclick"));
		System.out.println("eventCount.get(\"referencezonerollout\") = "+eventCount.get("referencezonerollout"));
		System.out.println("eventCount.get(\"referencezonerollover\") = "+eventCount.get("referencezonerollover"));
		System.out.println("eventCount.get(\"rendercancelled\") = "+eventCount.get("rendercancelled"));
		System.out.println("eventCount.get(\"rendercomplete\") = "+eventCount.get("rendercomplete"));
		System.out.println("eventCount.get(\"rendered\") = "+eventCount.get("rendered"));
		System.out.println("eventCount.get(\"resizecancelled\") = "+eventCount.get("resizecancelled"));
		System.out.println("eventCount.get(\"resized\") = "+eventCount.get("resized"));
		System.out.println("eventCount.get(\"selectionchange\") = "+eventCount.get("selectionchange"));
		System.out.println("eventCount.get(\"standardrangeselect\") = "+eventCount.get("standardrangeselect"));
		System.out.println("eventCount.get(\"timemarkerclick\") = "+eventCount.get("timemarkerclick"));
		System.out.println("eventCount.get(\"timemarkerrollout\") = "+eventCount.get("timemarkerrollout"));
		System.out.println("eventCount.get(\"timemarkerrollover\") = "+eventCount.get("timemarkerrollover"));
		System.out.println("eventCount.get(\"timenavbrushend\") = "+eventCount.get("timenavbrushend"));
		System.out.println("eventCount.get(\"timenavbrush\") = "+eventCount.get("timenavbrush"));
		System.out.println("eventCount.get(\"timenavbrushstart\") = "+eventCount.get("timenavbrushstart"));
		
		
		
		Assert.assertTrue(eventCount.get("animationinvoked")==1, "animationinvoked count is 1");
		Assert.assertTrue(eventCount.get("beforedispose")==1, "beforedataupdate count is 1");
	}
	
	@Test(groups = { "includetest" })
	public void animationinvokedCountValidate()
	{
		int animationinvokedCount = eventCount.get("animationinvoked");
		Assert.assertTrue(animationinvokedCount==1, "animationinvoked event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforedataupdateCountValidate()
	{
		int beforedataupdateCount = eventCount.get("beforedataupdate");
		Assert.assertTrue(beforedataupdateCount==1, "beforedataupdate event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforedisposeCountValidate()
	{
		int beforedisposeCount = eventCount.get("beforedispose");
		Assert.assertTrue(beforedisposeCount==1, "beforedispose event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforedrawCountValidate()
	{
		int beforedrawCount = eventCount.get("beforedraw");
		Assert.assertTrue(beforedrawCount==1, "beforedraw event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforeexportCountValidate()
	{
		int beforeexportCount = eventCount.get("beforeexport");
		Assert.assertTrue(beforeexportCount==1, "beforeexport event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforeinitializeCountValidate()
	{
		int beforeinitializeCount = eventCount.get("beforeinitialize");
		Assert.assertTrue(beforeinitializeCount==1, "beforeinitialize event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforeprintCountValidate()
	{
		int beforeprintCount = eventCount.get("beforeprint");
		Assert.assertTrue(beforeprintCount==1, "beforeprint event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforerenderCountValidate()
	{
		int beforerenderCount = eventCount.get("beforerender");
		Assert.assertTrue(beforerenderCount==1, "beforerender event trigger count");
	}
	
	@Test(groups = { "includetest" })
	public void beforeresizeCountValidate()
	{
		int beforeresizeCount = eventCount.get("beforeresize");
		Assert.assertTrue(beforeresizeCount==1, "beforeresize event trigger count");
	}
	
}

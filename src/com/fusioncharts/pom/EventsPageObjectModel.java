package com.fusioncharts.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.util.EventsBO;

public class EventsPageObjectModel extends EventsTestBase{
	
	@FindBy(tagName="svg")
	WebElement svgElement;
	private static EventsPageObjectModel pomObj = new EventsPageObjectModel();
	
	
	public EventsPageObjectModel()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean ischartRendered()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {Thread.sleep(3000);} catch (InterruptedException e){e.printStackTrace();}
		
		if(svgElement.isDisplayed())
			return true;
		else
			return false;
	}
	
	public WebElement getSVG()
	{
		return svgElement;
	}
	
	public void chartRollOverClickRollOut()
	{
		try {Thread.sleep(3000);} catch (InterruptedException e){e.printStackTrace();}
		
		pomObj.getSVG().click();
		
		Actions action = new Actions(driver);
		
		action.moveToElement(pomObj.getSVG()).build().perform();
		action.click(pomObj.getSVG());
		action.moveByOffset(10, 0);
		action.moveByOffset(300, 0);
		action.moveByOffset(300, 0);
		
		action.build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	}
	
	public WebElement dataplotColumnFirst()
	{
		WebElement columnPlotsParent = driver.findElement(By.xpath("//*[contains(@class,'column-plot-meso')]"));
		return columnPlotsParent.findElement(By.tagName("rect"));
	}
	
	public WebElement legend()
	{
		return driver.findElement(By.xpath("//*[contains(@class,'-item')]"));
	}
	
	public WebElement dataplotCandleStick()
	{
		WebElement candleStickParent=null;
		List<WebElement> candleStickAll = driver.findElements(By.xpath("//*[contains(@class,'bullGroup-meso')]"));
		for(WebElement elem : candleStickAll)
		{
			if(elem.findElements(By.xpath(".//*")).size()>0)
			{
				candleStickParent=elem.findElement(By.tagName("path"));
				break;
			}
		}
		return candleStickParent;
	}
	
	
	public void dataplotRollOverClickRollOut()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement firstPlot = pomObj.dataplotColumnFirst();
		WebElement candleStickFirstPlot = pomObj.dataplotCandleStick();
		
		pomObj.getSVG().click();
		//firstPlot.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(firstPlot).build().perform();
		action.click(firstPlot);
		action.moveByOffset(200, 0);
		
		action.build().perform();
	}
	
	public void dataplotRollOverClickRollOutCandleStick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement candleStickFirstPlot = pomObj.dataplotCandleStick();
		
		pomObj.getSVG().click();
		//candleStickFirstPlot.click();
		
		js.executeScript("arguments[0].scrollIntoView(true);", candleStickFirstPlot);
		
		action.moveToElement(candleStickFirstPlot).build().perform();
		action.click(candleStickFirstPlot).build().perform();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
//		action.click(candleStickFirstPlot).build().perform();
		action.moveByOffset(200, 0).build().perform();
		
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	}
	
	public void legendRollOverClickRollOut()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement legend = pomObj.legend().findElement(By.tagName("rect"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", legend);
//		legend.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(legend).build().perform();
		action.click(legend).build().perform();
		action.moveByOffset(0, 30).build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	}
	
	private WebElement timeNav()
	{
		return driver.findElement(By.xpath("//*[contains(@class,'-brush-group')]"));
	}
	
	public WebElement timeNavBody()
	{
		int cnt = 0;
		List<WebElement> timeNavChildElems = pomObj.timeNav().findElements(By.xpath(".//*"));
		for(WebElement child : timeNavChildElems)
		{
			cnt++;
			if(cnt==1)
				return child;
		}
		return null;
	}
	
	public WebElement timeNavRightEnd()
	{
		int cnt = 0;
		List<WebElement> timeNavChildElems = pomObj.timeNav().findElements(By.xpath(".//*"));
		for(WebElement child : timeNavChildElems)
		{
			cnt++;
			if(cnt==5)
				return child;
		}
		return null;
	}
	
	public WebElement timeNavLeftEnd()
	{
		int cnt = 0;
		List<WebElement> timeNavChildElems = pomObj.timeNav().findElements(By.xpath(".//*"));
		for(WebElement child : timeNavChildElems)
		{
			cnt++;
			if(cnt==3)
				return child;
		}
		return null;
	}
	
	public void dragTimeNavRightBy(int i)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(pomObj.timeNavRightEnd()).build().perform();
		action.moveByOffset(i, 0).build().perform();
		action.release().build().perform();
	}
	
	public void dragTimeNavBodyBy(int i)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(pomObj.timeNavBody()).build().perform();
		action.moveByOffset(i, 0).build().perform();
		action.release().build().perform();
	}
	
	public String timeNavStartDate()
	{
		int cnt=0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.timeNavBody());
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		action.moveToElement(pomObj.timeNavBody()).build().perform();
		List<WebElement> timeNavChildTexts = pomObj.timeNav().findElements(By.tagName("text"));
		for(WebElement text : timeNavChildTexts)
		{
			cnt++;
			if(cnt==1)
				return text.getText();
		}
		return null;
	}
	
	public String timeNavEndDate()
	{
		int cnt=0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.timeNavBody());
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		action.moveToElement(pomObj.timeNavBody()).build().perform();
		List<WebElement> timeNavChildTexts = pomObj.timeNav().findElements(By.tagName("text"));
		for(WebElement text : timeNavChildTexts)
		{
			cnt++;
			if(cnt==2)
				return text.getText();
		}
		return null;
	}
	
	public void canvasZoomIn() throws AWTException
	{
		WebElement canvas = driver.findElement(By.xpath("//*[contains(@class,'-canvas-tropo')]")).findElement(By.tagName("rect"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);", canvas);
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		action.moveToElement(canvas).build().perform();
		action.click().build().perform();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		
		Robot robot = new Robot();
		robot.mouseMove(800, 750);
		robot.setAutoDelay(100);
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		robot.mouseWheel(1);
		robot.mouseWheel(2);
		robot.mouseWheel(2);
		try {Thread.sleep(3000);} catch (InterruptedException e){e.printStackTrace();}
	}
	
	
	public void canvasDrag()
	{
		WebElement canvas = driver.findElement(By.xpath("//*[contains(@class,'-canvas-tropo')]")).findElement(By.tagName("rect"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);", canvas);
		action.moveToElement(canvas).build().perform();
		action.clickAndHold(canvas).build().perform();
		action.moveByOffset(200, 0).build().perform();
		action.release().build().perform();
		try {Thread.sleep(4000);} catch (InterruptedException e){e.printStackTrace();}
	}
	
	public WebElement srs()
	{
		return driver.findElement(By.xpath("//*[contains(@class,'-srs-tool')]"));
	}
	
	
	public WebElement exportBtn()
	{
		return driver.findElement(By.xpath("//*[contains(@class,'-button')]"));
		
	}
	
	public WebElement crs()
	{
		return driver.findElement(By.xpath("//*[contains(@class,'-range-selector-text')]")).findElement(By.tagName("rect"));
	}
	
	public WebElement ApplyButtonCRS()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.crs());
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.exportBtn());
		try {Thread.sleep(3000);} catch (InterruptedException e){e.printStackTrace();}
		pomObj.crs().click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'fc-cal-container')]")));
		WebElement applyBtn = driver.findElement(By.xpath("//*[text() = 'Apply']"));
		return applyBtn;
	}
	
	public WebElement dataMarker()
	{
		List<WebElement> markerGrp = driver.findElements(By.xpath("//*[contains(@class,'-markerGroup-thermo')]"));
		for(WebElement marker:markerGrp)
		{
			try
			{
				WebElement dataMarker = marker.findElement(By.tagName("text"));
				return dataMarker;
			}
			catch(Exception e)
			{
				
			}
		}
		return null;	
	}
	
	public void dataMarkerRollOverClickRollOut()
	{

		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		
		pomObj.dataMarker().click();
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.exportBtn());
		action.moveToElement(pomObj.dataMarker()).build().perform();
		action.click(pomObj.dataMarker());
		action.moveByOffset(100, 0);
		
		action.build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	
	}
	
	public WebElement timeMarker()
	{
		List<WebElement> markerGrp = driver.findElements(By.xpath("//*[contains(@class,'-time-marker-min-group')]"));
		for(WebElement marker:markerGrp)
		{
			try
			{
				WebElement timeMarker = marker.findElement(By.tagName("text"));
				return timeMarker;
			}
			catch(Exception e)
			{
				
			}
		}
		return null;	
	}
	
	
	public void timeMarkerRollOverClickRollOut()
	{
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		
		pomObj.timeMarker().click();
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.timeMarker());
		action.moveToElement(pomObj.timeMarker()).build().perform();
		action.click(pomObj.timeMarker());
		action.moveByOffset(-100, 0);
		
		action.build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	
	}
	
	public WebElement refLine()
	{
		List<WebElement> refLineParent = driver.findElements(By.xpath("//*[contains(@class,'-reference-line-group')]"));
		for(WebElement elem:refLineParent)
		{
			try
			{
				WebElement refLine = elem.findElement(By.tagName("circle"));
				return refLine;
			}
			catch(Exception e)
			{
				
			}
		}
		return null;	
	}
	
	
	public void refLineRollOverClickRollOut()
	{

		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		
		pomObj.refLine().click();
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.refLine());
		action.moveToElement(pomObj.refLine()).build().perform();
		action.click(pomObj.refLine());
		action.moveByOffset(-100, 0);
		
		action.build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	
	}
	
	public WebElement refZone()
	{
		List<WebElement> refZoneParent = driver.findElements(By.xpath("//*[contains(@class,'-reference-zone-hover-elem-group')]"));
		for(WebElement elem:refZoneParent)
		{
			try
			{
				WebElement refZone = elem.findElement(By.tagName("circle"));
				return refZone;
			}
			catch(Exception e)
			{
				
			}
		}
		return null;	
	}
	
	
	public void refZoneRollOverClickRollOut()
	{

		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		
		pomObj.refZone().click();
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		js.executeScript("arguments[0].scrollIntoView(true);", pomObj.refZone());
		action.moveToElement(pomObj.refZone()).build().perform();
		action.click(pomObj.refZone());
		action.moveByOffset(-100, 0);
		
		action.build().perform();
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
	
	}
}

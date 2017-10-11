package testCase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import org.junit.Test;

public class Enduro {
	
public static String targetPage ="https://www.1enduro.pl/";
public static WebDriver driver = new ChromeDriver();


	public static void main(String[] args) {
		setUp(targetPage);
		// Checking page Tittle
		mainPageTittleTest();
		// Step
		WebElement gearLink = driver.findElement(By.xpath("//*[@id=\"menu-item-25\"]/a"));
		gearLink.click();
		// Checking Page Tittle
		gearPageTittleTest();
		// Step
		WebElement gear = driver.findElement(By.partialLinkText("7 rowerów"));
		gear.click();
		// Step
		articlePageTittleTest();
		// Step
		WebElement gravel = driver.findElement(By.partialLinkText("Marin"));
		gravel.click();
		tearDown();
	}

	@Test
	public static void mainPageTittleTest() {
		String pageTittle = driver.getTitle();
		assertEquals(pageTittle, "1Enduro - blog rowerowy o enduro MTB : 1Enduro");
	}
	@Test
	public static void gearPageTittleTest() {
		String gearPageTittle = driver.getTitle();
		assertEquals(gearPageTittle,"Sprzêt - rowery, czêœci i akcesoria enduro - 1Enduro : 1Enduro");
	}
	@Test
	public static void articlePageTittleTest() {
		String articlePageTittle = driver.getTitle();
		assertEquals(articlePageTittle, "7 rowerów, które kupisz zamiast iPhone X : 1Enduro");
	}
	
	public static void setUp(String page) {
		driver.get(page);
		driver.manage().window().maximize();
	}
	
	public static void tearDown() {
		driver.quit();
	}

}

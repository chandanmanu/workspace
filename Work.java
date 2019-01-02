import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Work {

	
		
		
		static {

			System.setProperty("webdriver.chrome.driver","/home/tyss/chromedriver");
		}
		public static class Ladder {

		

		public static void main(String[] args) throws Exception {

			// TODO Auto-generated method stub

			// WebDriver driver1=new FirefoxDriver();

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.urbanladder.com/");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();

			Thread.sleep(2000);


			List<WebElement> outerList = driver.findElements(By.xpath("//span[@class='topnav_itemname']"));

			// WebElement
			// sales=driver.findElement(By.xpath("//li/span[contains(text(),'Sale')]"));

			Actions actions = new Actions(driver);

			int row = 0;
			for (int i = 0; i < outerList.size(); i++)

			{
				WebElement mainMenu = outerList.get(i);

				actions.moveToElement(mainMenu).perform();
				System.out.println(mainMenu.getText());
				String v = mainMenu.getText();
				//Assert.assertEquals(readFromXl(row,0),v);
		writeToXl(row, v);

		
		row++;

				Thread.sleep(50);

				//List<WebElement> lst = driver.findElements(By.xpath("(//div[@class='subnavlist_wrapper clearfix'])"));
				List<WebElement> lst = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li/span[contains(text(),'"+mainMenu.getText()+"')]/../div//a"));

				// System.out.println(lst.size());

				for (int j = 0; j < lst.size(); j++) {
					WebElement submenu = lst.get(j);
					//System.out.println(submenu.getText());
					String v1 = submenu.getText();
					//Thread.sleep(5000);
					System.out.println(v1);
					//Assert.assertEquals(readFromXl(row,0),v1);

					Day2_excel.writeToXl(row++, v1);
				

				}
			}
		}

		public static void writeToXl(int r, String v) throws Exception {
			Workbook w = WorkbookFactory.create(new FileInputStream("./input/data.xlsx"));
			w.getSheet("Sheet1").getRow(r).createCell(1).setCellValue(v);
			Thread.sleep(50);
			w.write(new FileOutputStream("./input/data.xlsx"));

		}
		
			public static String readFromXl(int r,int col) throws Exception {
			Workbook w = WorkbookFactory.create(new FileInputStream("./input/data.xlsx"));
			String act=w.getSheet("Sheet1").getRow(r).getCell(col).getStringCellValue();
			// int noofrows = w.getSheet("Sheet1").getLastRowNum();
			// System.out.println(noofrows);
			 return act;
			 
			 
	         /*   //System.out.println(noOfColumns);
	            String[] Headers = new String[noOfColumns];
	            for (int j=0;j<noOfColumns;j++){
	                Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
	            }*/
		}
	

}


}

		
	}

}



for (int i = 0; i < mainmenu.size(); i++)

{
	WebElement mainMenu1 = mainmenu1.get(i);

	action.moveToElement(mainMenu).perform();
	System.out.println(mainMenu.getText());
	String v = mainMenu.getText();

public static void photo(WebDriver driver, String S) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./Photo/"+S+".png");

package Cucumber.MakeMyTripFinal;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test {
	
	public static String Price_of_each_adult="0";
	public static String Price_of_each_Children="0";
	public static String Price_of_each_Infant="0";
	public static String from_city="Delhi";
	public static String to_city="Patna";
	public static String departureDate="24-08-2021";
	public static String departureDate1="24/08/2021";
	public static String noOfAdult="2";
	public static String Children="3";
	public static String infant="2";
	public static String Fee_Surcharges="0";
	public static String other_charge="0";
	public static String totalPrice="0";
	
	
	public static void validateCountPerson(String regex,String validate,String exact_data) {
		
		 Pattern P1= Pattern.compile(regex);
 	     Matcher m1 = P1.matcher(validate);
 	    if (m1.find()) {
 	    	String final_ans=(m1.group());
 	    	System.out.println(final_ans.substring(1));
 	    	Assert.assertEquals(exact_data,final_ans.substring(1) );
 	    } 
		
	}
	
	
	public static String price_indivisual(String regex_price,String priceDetail) {
		
		Pattern P1=Pattern.compile(regex_price);
		Matcher m1=P1.matcher(priceDetail);
		String Price_of_each=null;
		
 	   if (m1.find()) {
	    	String final_ans=(m1.group());
	    	Price_of_each=final_ans.substring(0, final_ans.length()-1);
	    	Price_of_each=Price_of_each.replace(",", "");
	    } 
 	   System.out.println(Price_of_each);
 	  return Price_of_each;
 	   
	}
	
	
	public static void validateAmount() {
		int amountPridicted=(Integer.parseInt(Price_of_each_adult))*(Integer.parseInt(noOfAdult))+(Integer.parseInt(Price_of_each_Children))*(Integer.parseInt(Children))+(Integer.parseInt(Price_of_each_Infant))*(Integer.parseInt(infant))+(Integer.parseInt(Fee_Surcharges))+(Integer.parseInt(other_charge));
		int intTotalPrice=Integer.parseInt(totalPrice);
		
		Assert.assertEquals(amountPridicted, intTotalPrice);
		System.out.println("TOTAL AMOUNT VALIDATED");
	
	}
	
	public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\raushan.kum\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	Actions actions=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait=new WebDriverWait(driver,15);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	String parent=driver.getWindowHandle();
	WebDriverWait wait1=new WebDriverWait(driver,30);
	System.out.println(parent);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")));
	
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX1111111");
	
	
	
	try {
	WebElement logFar=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']//p[@class='login__earn font18 latoBlack appendBottom20 defaultCursor']")));
	if(logFar.isEnabled()) {
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();	
	}
	}catch(Exception e) {
		
		System.out.println("Proceed Ahead");
		
	}

	
	
//	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
	

//	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
//	
//	
	WebElement x=driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']"));
	actions.doubleClick(x);
	
	driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX22222222");
	WebElement trip=driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']"));
//	String s1=driver.getWindowHandle();
//	System.out.println(s1);
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX33333332");
	if(trip.isSelected()) {
		System.out.println("Already Selecetd44444444");
	}else {
		trip.click();
		System.out.println("Already Selecetd555555555");
	}
	driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and text()='RETURN']")).click();
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']")));
	WebElement selectedTrip=driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));
	Assert.assertEquals(selectedTrip.isEnabled(), true, "VERTFIED THE SELECTED TRIP IS OF ONE WAY ");
	System.out.println("###################");
//	String x1=driver.getWindowHandle();
//	System.out.println(x1);
	WebElement x1=driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@role='grid'][2]//div[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[text()='2']"));
	js.executeScript("arguments[0].click();", x1);
//	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']")));
	driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
	System.out.println("###################");
	///////////////////////888888888888888888888888888888888////////////////////////////
	
	if(Integer.parseInt(noOfAdult)<Integer.parseInt(infant)) {
		Assert.fail();
	}
	
	
	
	driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']")));
	driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text'  and @placeholder='From']")).sendKeys("Delhi");
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-autosuggest__section-title']//p[contains(text(),'SUGGESTIONS')]")));
	System.out.println("12345678");
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]//p[contains(text(),'Delhi')]")));
	driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]")).click();
	
	driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text' and @placeholder='To']")).sendKeys("Patna");
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-autosuggest__section-title']//p[contains(text(),'SUGGESTIONS')]")));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]//p[contains(text(),'Patna')]")));
	driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]")).click();
	
	String month="June 2021";
	String exp_date="12";
	
	while(true) {
		String text_shown=driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']//div")).getText();
		System.out.println(text_shown);
		if(text_shown.equals(month)) {
			break;
		}else {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
	}
	
	driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='dateInnerCell']//p[text()="+exp_date+"]//ancestor::div[@class='DayPicker-Day']")).click();

	driver.findElement(By.xpath("//label[@for='travellers']//span[@class='lbl_input latoBold appendBottom10']")).click();
	
	
	String noOfAdult1="'"+"adults-"+noOfAdult+"'";
	if(noOfAdult.isEmpty()) {
		System.out.println("NO ADILRT");
	}
	else if(Integer.parseInt(noOfAdult)>9) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='adults-10']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfAdult1+"]")).click();
	}
	
	String noOfChildren="'"+"children-"+Children+"'";
	if(Children.isEmpty()) {
		System.out.println("NO Children");
	}
	else if(Integer.parseInt(noOfAdult)>6) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='children-7']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfChildren+"]")).click();
	}
	
	
	
	String noOfinfants="'"+"infants-"+infant+"'";
	
	if(infant.isEmpty()) {
		System.out.println("NO infant");
	}
	else if(Integer.parseInt(noOfAdult)>6) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='infants-7']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfinfants+"]")).click();
	}
	
	
	driver.findElement(By.xpath("//div[@class='right makeFlex hrtlCenter']//button[@data-cy='travellerApplyBtn']")).click();
	
	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")).click();
	WebDriverWait wait11=new WebDriverWait(driver,20);
	wait11.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loadingIcon']")));
//	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flightsContainer makeFlex spaceBetween']")));
	
	
	
	System.out.println("HELLO");
	
	WebElement AirlineFilter=driver.findElement(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Arrival at')]"));
	String  Airplane_="IndiGo"; 
	WebElement  xx1=driver.findElement(By.xpath("//span[@class='truncate' and contains(text(),'IndiG')]//parent::span[contains(@title,'IndiG')]//parent::span//parent::div"));
	js.executeScript("arguments[0].click()", xx1);
	String verify_Arirline=driver.findElement(By.xpath("//ul[@class='appliedFilter']//li")).getText();
	Assert.assertEquals( Airplane_.toUpperCase(),verify_Arirline,"NOT VERIFIED THE AIROPLANE");
	
	
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Airline')]")));
	
	String page_source=driver.getPageSource();
//	System.out.println(page_source);
	
	
	Pattern p= Pattern.compile("<span class=\"boldFont blackText airlineName\">[A-Za-z0-9\\s]+</span>");
    Matcher m = p.matcher(page_source);
   
    while (m.find()) {
    	String type_air=m.group();
    	  String regex = ">[A-Za-z0-9\\s]+<";
    	   Pattern P1= Pattern.compile(regex);
    	    Matcher m1 = P1.matcher(type_air);
    	    while (m1.find())
    	    {
    	       String check=m1.group();
    	       check=check.substring(1,check.length()-1);
    	       
    	       Assert.assertEquals(Airplane_.toUpperCase(),check.toUpperCase(),"NOT VERIFIED THE AIROPLANE");
    	       
    	    }
    	
    	
    }
    
   /*********************/ 
    p=Pattern.compile("<p class=\"darkText\">[A-Za-z0-9\\s]+</p>");
    m = p.matcher(page_source);
    int count=0;
    while (m.find()) {
    	String type_air=m.group();
    	String regex = ">[A-Za-z0-9\\s]+<";
    	   Pattern P1= Pattern.compile(regex);
    	    Matcher m1 = P1.matcher(type_air);
    	   if(m1.find())
    	    {  
    	    if(count%2==0) {
    	       String check1=m1.group();
    	       check1=check1.substring(1,check1.length()-1);
    	       System.out.println(check1);
    	       regex = "[Delhi]+";
    	       P1= Pattern.compile(regex);
    	       m1 = P1.matcher(check1);
    	       Assert.assertTrue(m1.find());
    	    }else {
    	       String check2=m1.group();
      	       check2=check2.substring(1,check2.length()-1);
      	       System.out.println(check2);
      	       regex="[Patna]+";
      	     P1= Pattern.compile(regex);
      	     m1 = P1.matcher(check2); 
      	     Assert.assertTrue(m1.find()); 
    	    }
    	  
    	       
    	    }
    	   count++;
    	    
    	   
}
    
    
    /* VALIDATE THE DEPARTURE DATE*/
    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    String date_shown=driver.findElement(By.xpath("//div[@class='weeklyFareItems active']//p[@class='blackFont fontSize12 appendBottom3']")).getText();
    System.out.println(date_shown);
    String year="2021";
    String month1="June";
	String exp_date1="12";
	
	//VERIFY DATE  Sat, Jun 12
	String verify=" "+month1.substring(0,3)+" "+exp_date1;
	String forVerify[]=date_shown.split(",");
	Assert.assertEquals(forVerify[1], verify,"VERIFIED DATE NOT DONE");
	
	
	//select the type of sort
	String type_sort="Duration";
	String sort="Accendings";
	if(sort=="Accending") {
		System.out.println("ENTERD");
	WebElement click1=driver.findElement(By.xpath("//div[@id='sorting-togglers']//span[contains(text(),'Duration')]//parent::span[@class='pointer']"));
	js.executeScript("arguments[0].click()",click1);
	}else {
		System.out.println("ENTERD11");
		WebElement click1=driver.findElement(By.xpath("//div[@id='sorting-togglers']//span[contains(text(),'Duration')]//parent::span[@class='pointer']"));
		js.executeScript("arguments[0].click()",click1);
		js.executeScript("arguments[0].click()",click1);	
	}
	
	String card_no="3";
	driver.findElement(By.xpath("//div[@class='fli-list ']["+card_no+"]//button[@class='ViewFareBtn  text-uppercase ']")).click();
	
	WebElement scroll_view=driver.findElement(By.xpath("//div[@class='fli-list ']["+card_no+"]//div[@class='viewFareRowWrap'][2]"));
	js.executeScript("arguments[0].scrollIntoView(true);", scroll_view);
	
	
	String fare_type="'"+"Saver"+"'";
	driver.findElement(By.xpath("//div[@class='fli-list ']["+card_no+"]//div[@class='collapse show']//p[@class='fareNameHead blackFont blackText appendBottom3' and contains( text(),"+fare_type+")]// ancestor::div[@class='viewFareRowWrap']//div[@class='viewFareBtnCol']//button")).click();
    
	////validate from,to,and airline fron new page
	
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
 
    
//	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='review-page']")));
	
	String FightName=driver.findElement(By.xpath("//p[@class='append_bottom5 font14 LatoBold']")).getText();
	Assert.assertEquals(Airplane_.toUpperCase(),FightName.toUpperCase());
	
//////	////validate to
//	
	String to=driver.findElement(By.xpath("//div[@class='fli-time-section pull-left']//p[@class='dept-city']//span[@class='LatoBold']")).getText();
	 String regex = "[Delhi]+";
     Pattern P1= Pattern.compile(regex);
     Matcher m1 = P1.matcher(to);
     Assert.assertTrue(m1.find());
//////	
//   
     String from=driver.findElement(By.xpath("//div[@class='fli-time-section pull-left']//p[@class='arrival-city']//span[@class='LatoBold']")).getText();
	 regex = "[Patna]+";
     P1= Pattern.compile(regex);
     m1 = P1.matcher(from);
     Assert.assertTrue(m1.find());
//    
     
     System.out.println("Hello Good");
     
  
 	
 	String Adult_detail;
 	String Infant_detail;
 	String Children_detail;
 	String regexNoOfindivisual="\\([0-9,]+";
	String indivisualPrice="[0-9,]+\\)";
	
	

 	if(Integer.parseInt(noOfAdult)>=1 &&Integer.parseInt(Children)>=1 && Integer.parseInt(infant)>=1) {
 		///ADULT///
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult); 
	    Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail); 
	    ///Children///
 	    
 		Children_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Children')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Children_detail,Children); 
 	    Price_of_each_Children=price_indivisual(indivisualPrice,Children_detail); 
 	    
 		
 		//Infants////
 		Infant_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][3]//span[contains(text(),'Infant')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Infant_detail,infant); 
  	    Price_of_each_Infant=price_indivisual(indivisualPrice,Infant_detail); 
  	     
 		
 		
 		
 		
 	}else if(Integer.parseInt(noOfAdult)>=1 &&Integer.parseInt(Children)>=1) {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail); 
 	   
 		
 		Children_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Children')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Children_detail,Children); 
 	    Price_of_each_Children=price_indivisual(indivisualPrice,Children_detail); 
 		
 	}else if(Integer.parseInt(noOfAdult)>=1 && Integer.parseInt(infant)>=1) {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail);  
 		Infant_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Infant')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Infant_detail,infant); 
  	    Price_of_each_Infant=price_indivisual(indivisualPrice,Infant_detail); 
 		
 	}else {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail);  	
 	}
     
    
 	Fee_Surcharges=driver.findElement(By.xpath("//span[text()='Fee & Surcharges']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")).getText();
 	Fee_Surcharges=Fee_Surcharges.replace("₹", "");
 	Fee_Surcharges=Fee_Surcharges.replace(",", "");
 	Fee_Surcharges=Fee_Surcharges.replace(" ", "");
 	
 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")).getText();
 	other_charge=other_charge.replace("₹", "");
 	other_charge=other_charge.replace(" ", "");
 	
 	
 	totalPrice=driver.findElement(By.xpath("//span[text()='Total Amount:']//ancestor::div[@class='fareSmry-sctn reqPad-fareSmry-sctn']//span[@class='font20']//span//span")).getText();
 	totalPrice=totalPrice.replace("₹", "");
 	totalPrice=totalPrice.replace(",", "");
 	totalPrice=totalPrice.replace(" ", "");
 	
 	
 	validateAmount();
 	
 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
 	
 	try {
 	   driver.findElement(By.xpath("//span[text()='Charity']"));
 	   WebElement charity=driver.findElement(By.xpath("//span[contains(text(),'Thank You for Donating ')]"));
 	  js.executeScript("arguments[0].scrollIntoView(true);",charity );
 	  charity.click();
 	 other_charge="0";
 	   
 	   
 	} catch (Exception e) {
 		
 		System.out.println("NO CHARITY OPTION IS AVAILABLE");
 	  
 	}
 	
 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
 	
 	try {
 		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")));
 		Assert.fail();
  	   }catch(Exception e) {
  		 other_charge="0";
  		 System.out.println("OTHER NOT FOUND");
  	   }
  	   
 	
 	WebElement insurance=driver.findElement(By.xpath("//p[text()='Add-ons']"));
 	 js.executeScript("arguments[0].scrollIntoView(true);",insurance );
 	driver.findElement(By.xpath("//div[@class='labeltext block paddL30']")).click();
 	
 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
 	
 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//following-sibling::div[@class='fareSmry-wrap']//span[@class='font16 LatoBold text-right']//span")).getText();
 	other_charge=other_charge.replace("₹", "");
 	other_charge=other_charge.replace(" ", "");
 	System.out.println(other_charge);
 	
 	totalPrice=driver.findElement(By.xpath("//span[text()='Total Amount:']//ancestor::div[@class='fareSmry-sctn reqPad-fareSmry-sctn']//span[@class='font20']//span//span")).getText();
 	totalPrice=totalPrice.replace("₹", "");
 	totalPrice=totalPrice.replace(",", "");
 	totalPrice=totalPrice.replace(" ", "");
 	
 	
 	
 	String s1=driver.getWindowHandle();
 	validateAmount();
 	driver.switchTo().window(s1);
 	driver.navigate().back();
 	
 	driver.close();
 	driver.quit();
 	
 	
}
}

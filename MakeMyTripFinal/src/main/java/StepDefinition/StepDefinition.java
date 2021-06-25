package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends AllMethods {
//	
//@Before
//public void set_up_the_driver() {
//	setUpTheDriver();
//}
//
//@When("Navigate to make My trip")
//public void navigate_to_make_my_trip() {
//	driver.get("https://www.makemytrip.com/");
//	WebDriverWait wait1=new WebDriverWait(driver,10);
//	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")));
//	
//}
//
//@Then("Handle The Login POPUP")
//public void handle_the_login_popup() {
//	handleLoginPopUp();
//}
//
//@Given("Chosse the trip type {string} and Select that")
//public void chosse_the_trip_type_and_select_that(String string) {
//    trip=string;
//    chooseTripType(); 
//}
//
//@Then("Validate Trip")
//public void validate_trip() {
//    validateTrip();
//}
//
//
//@Then("Select your needed trip again")
//public void select_your_needed_trip_again() {
//	if(trip.equals("oneWayTrip")) {
//	WebElement x1=driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@role='grid'][2]//div[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[text()='2']"));
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click();", x1);
//	driver.findElement(By.xpath("//li[@data-cy="+"'"+trip+"'"+"]")).click();
//	}else {
//		driver.findElement(By.xpath("//li[@data-cy="+"'"+trip+"'"+"]")).click();
//	}
//}
//
//@Then("Fill {string} and {string} city  also {string} and {string} if needed")
//public void fill_and_city_also_and_if_needed(String string, String string2, String string3, String string4) {
//    fromCity=string;
//    toCity=string2;
//    departureDate=string3;
//    returnDate=string4;
//    dateModify( departureDate, returnDate);
//    setCity(fromCity,toCity);
//    
//    if(trip.equals("roundTrip")) {
//    	System.out.println("---------------");
//    	System.out.println(retMonth+retYear);
//    	System.out.println(retDate);
//    	selectDate(depMonth+depYear,depDate);
//    	selectDate( retMonth+retYear,retDate);
//    	System.out.println("---------------");
//    }else {
//    	selectDate(depMonth+" "+depYear,depDate);
//    }
//    
//    
//}
//
//@Then("Fill detail of number Traverllers as {string} or {string} or {string}")
//public void fill_detail_of_number_traverllers_as_or_or(String string, String string2, String string3) {
//	 noOfAdult=string;
//	 Children=string2;
//	 infant=string3;
//	 setDetailOfTraverlers(noOfAdult,Children,infant);
//}
//
//
//	@Then("Search for the result and wait for loading the page")
//	public void search_for_the_result_and_wait_for_loading_the_page() {
//		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")).click();
//		WebDriverWait wait11=new WebDriverWait(driver,30);
//		wait11.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loadingIcon']")));
//////		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flightsContainer makeFlex spaceBetween']")));
//	}
//
//	@Then("Choose {string} and Validate that  Airline from filter box")
//	public void choose_and_validate_that_airline_from_filter_box(String string) {
//	   airCompany=string;
//	   selectAndVerifyAirline(airCompany);
//	   
//	}
//	
//	@Then("verify  Applied_Airline, From_City,To_City from each and every card")
//	public void verify_applied_airline_from_city_to_city_from_each_and_every_card() {
//		   verifyEachCardDetailsTrip(toCity,fromCity,airCompany); 
//	   
//	}
//	
//	
//	@Then("validate Departure Date and ReturnDate if Round Trip")
//	public void validate_departure_date_and_return_date_if_round_trip() {
//	   if(trip.equals("roundTrip")) {
//		   validateTheDatesBothSide(fromCity,depMonth,depDate);  ///for departure
//		   validateTheDatesBothSide(toCity,retMonth,retDate);
//	   }else {
//		   validateTheDatesOneSide(depMonth,depDate);
//	   }
//	}
//	
//
//@Then("Enter the Sorting name {string} and {string} if Round Trip {string} and {string}")
//public void enter_the_sorting_name_and_if_round_trip_and(String string, String string2, String string3, String string4) {
//	basisOfSort1=string;
//	typeOfSort1=string2;
//	basisOfSort2=string3;
//	typeOfSort2=string4;
//	
//	 if(trip.equals("roundTrip")) {
//		   sortDeptTrip(basisOfSort1,typeOfSort1);
//		   sortRetTrip(basisOfSort2,typeOfSort2);
//	   }else {
//		   sortTrip(basisOfSort1,typeOfSort1);
//	   }
//    
//}
//
//	@Then("Select the card no {string}")
//	public void select_the_card_no(String string) {
//		card1=string;
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		 if(trip.equals("roundTrip")) {
//			 WebElement scroll_view=driver.findElement(By.xpath("//div[@class='paneView'][1]//label[@class='splitViewListing  ']["+card1+"]"));
//			 js.executeScript("arguments[0].scrollIntoView(true);", scroll_view);
//			 scroll_view.click();				
//				driver.findElement(By.xpath("//div[@class='paneView'][2]//label[contains(@class,'splitViewListing')]["+card1+"]")).click();
//				driver.findElement(By.xpath("//button[text()='Book Now']")).click();
//		   }else {
//			  
//			    driver.findElement(By.xpath("//div[@class='fli-list ']["+card1+"]//button[@class='ViewFareBtn  text-uppercase ']")).click();
//				WebElement scroll_view=driver.findElement(By.xpath("//div[@class='fli-list ']["+card1+"]//div[@class='viewFareRowWrap'][2]"));
//				js.executeScript("arguments[0].scrollIntoView(true);", scroll_view);
//				
//		   }
//	    
//	}
//
//
//	
//	@Then("Select typeOfTrip {string} and proceed for review detail")
//	public void select_type_of_trip_and_proceed_for_review_detail(String string) {
//	   plan=string;
//	   if(trip.equals("roundTrip"))
//		   selectPlanRound(plan);
//	   else
//		   selectPlanOne( plan,card1);
//		   
//	}
//
//	
//
//@Then("Validate AirPlaneName and departure detail and arrival detail in both cases also return detial in case of Round")
//public void validate_air_plane_name_and_departure_detail_and_arrival_detail_in_both_cases_also_return_detial_in_case_of_round() {
//	if(trip.equals("roundTrip")) {
//		validateReviewPage(airCompany,toCity,fromCity);
//		
//	}else {
//		validateReviewPageOneWay(airCompany,toCity,fromCity);
//		
//		
//	}
//}
//
//@Then("Validate the price and  no of Adult,infant,Children as previously selected  detail  and by expanding others and remove charity")
//public void validate_the_price_and_no_of_adult_infant_children_as_previously_selected_detail_and_by_expanding_others_and_remove_charity() {
//     validateReviewPaymentCard();
//}
//
//@Then("Add insurance then Again verify the Price")
//public void add_insurance_then_again_verify_the_price() {
//       insuranceAndVerifyAgain();
//}




	
}
	



#Author:raushan.kum@highradius.com
Feature: Testing of the MakeMyTrip
  Writing a script to Automate Flight Booking through MakeMyTrip.

 Background: Setup the Driver and navigate to the MakeMyTrip and chosse the type of trip.
 		 When Navigate to make My trip 
 		 Then Handle The Login POPUP
 		
 		
 		Scenario: Full Operations For Flight Booking
 			Given Chosse the trip type "<type_of_trip>" and Select that
    	Then Validate Trip
    	Then Select your needed trip again
    	Then Fill "<from>" and "<to>" city  also "<departure>" and "<return>" if needed
    	Then Fill detail of number Traverllers as "<Adult>" or "<Children>" or "<Infants>"
			Then Search for the result and wait for loading the page
			Then Choose "<Airline>" and Validate that  Airline from filter box
			Then verify  Applied_Airline, From_City,To_City from each and every card
			Then validate Departure Date and ReturnDate if Round Trip
			Then Enter the Sorting name "<sort_name1>" and "<sort_type1>" if Round Trip "<sort_name2>" and "<sort_type2>"
			Then Select the card no "<cardNo1>" 
			Then Select typeOfTrip "<tripPackage>" and proceed for review detail
			Then Validate AirPlaneName and departure detail and arrival detail in both cases also return detial in case of Round
			Then Validate the price and  no of Adult,infant,Children as previously selected  detail  and by expanding others and remove charity 
			And  Add insurance then Again verify the Price
			Then Close the page and Navigate to home page
			 
			
			
			
	# checked one  		
	# | Round Trip    |   Mumbai		| Kolkata  |  2021-06-05 | 2021-09-08 |    3       |    2       |    1    |  IndiGo  | Price      | Accending | Duration  | Decending |     2   |Family Fare|		
	#| OneWayTrip    |   Mumbai		| Kolkata  |  2021-06-05 |            |    3       |    2       |    1    |  IndiGo  | Price      | Accending |           |           |     2   |Family fare|		
    	
       


			 Examples: 
      | type_of_trip  |    from     |    to    |   departure |  return    |    Adult   |  Children  | Infants |  Airline | sort_name1 |sort_type1 | sort_name2| sort_type2| cardNo1 |tripPackage|
      | OneWayTrip    |   Mumbai		| Kolkata  |  2021-06-05 |            |    3       |    2       |    1    |  IndiGo  | Price      | Accending |           |           |     2   |Family fare|
     

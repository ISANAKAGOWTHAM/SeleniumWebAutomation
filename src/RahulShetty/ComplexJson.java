package RahulShetty;


import org.testng.annotations.Test;

import Files.PayLoads;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;



public class ComplexJson {
	
	public static void main (String[] args) {
	
	//RestAssured.baseURI("")
	
	
	
	
	JsonPath js = new JsonPath(PayLoads.Course());
	
	//1. Print No of courses returned by API
	
	int count=js.getInt("courses.size()");
	
	System.out.println(count);
	
	//2.Print Purchase Amount
	
	int purchaseamount=js.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseamount);
	
	//3. Print Title of the first course
	
	String Coursetitle=js.getString("courses[0].title");
	System.out.println(Coursetitle);
	
	
	//4. Print All course titles and their respective Prices
	
	
	for(int i=0; i<count; i++) 
	{
		String coursetitles=js.get("courses["+i+"].title");
		System.out.println(coursetitles);
		 System.out.println( js.get("courses["+i+"].price").toString());
		
	}
	
	//5. Print no of copies sold by RPA Course
	
	System.out.println("Print no of copies sold by RPA Course");
	
	for(int i=0;i<count;i++) {
		String titles=js.get("courses["+i+"].title");
		if(titles.equalsIgnoreCase("RPA")) {
			
			int copies=js.get("courses["+i+"].copies");
			System.out.println(copies);
			break;
		}
		
		
	}
	
	
	
	}	

}

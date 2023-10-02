package RahulShetty;
import org.testng.annotations.Test;

import Files.PayLoads;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

public class Jsonpath {

	public static void main(String[] args) {
		
		
		JsonPath js = new JsonPath(PayLoads.Course());
		
		
		//1. Print No of courses returned by API
		
		
     int count=		js.getInt("courses.size()");
     
     System.out.println(count);
     
     
 	//2.Print Purchase Amount
     
     int pueshaseamount=js.getInt("dashboard.purchaseAmount");
     System.out.println(pueshaseamount);
     
     //3.Print Title of the first course
     
     String title=js.getString("courses[0].title");
     System.out.println(title);
     
     //4. Print All course titles and their respective Prices
     
     for(int i=0;i<count;i++) {
    	 
    	 String coursetitle=js.get("courses["+i+"].title");
    	 System.out.println(coursetitle);
    	 
    	 System.out.println(js.get("courses["+i+"].price").toString());
     }
     
     //5. Print no of copies sold by RPA Course
     
     for(int i=0;i<count;i++) {
    	 
    	 String coursetitles=js.get("courses["+i+"].title");
    	 if(coursetitles.equalsIgnoreCase("RPA")) {
    		 int copies=js.get("courses["+i+"].copies");
    		 System.out.println(copies);
    		 break;
    	 }
    	 
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

	}

}

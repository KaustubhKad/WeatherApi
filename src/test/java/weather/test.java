package weather;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class test  {
	public String city1;
	public String city2;
	//City obj= new City();
	

	
	
	
		
		
		@Test(priority = 1)
		public void testGet(){
			//Specify base URI
			  RestAssured.baseURI="http://api.openweathermap.org";
			  
			  //Request object
			  RequestSpecification httpRequest=RestAssured.given();
			  
			  JSONObject requestParams=new JSONObject();
			  requestParams.put("external_id", "DEMO_TEST001");
			  requestParams.put("name", "Interview Station 1");
			  requestParams.put("latitude",33.33);		 
			  requestParams.put( "longitude", -111.43);
			  requestParams.put("altitude",444);
			 
			  
			  httpRequest.header("Content-Type","application/json");
			  
			  httpRequest.body(requestParams.toJSONString());
			  
			  
			  Response response=httpRequest.request(Method.POST,"/data/3.0/stations");
		
			  
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:" +responseBody);
			  System.out.println(response.getStatusCode());
			  
		}
		
		@Test(priority = 2)
		public void testpost1(){
			
			//Specify base URI
			  RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
			  
			  //Request object
			  RequestSpecification httpRequest=RestAssured.given();
			  
			  JSONObject requestParams=new JSONObject();
			  requestParams.put("external_id", "DEMO_TEST001");
			  requestParams.put("name", "Interview Station 1");
			  requestParams.put("latitude",33.33);		 
			  requestParams.put( "longitude", -111.43);
			  requestParams.put("altitude",444);
			  
			  
	  httpRequest.header("Content-Type","application/json");
			  
			  httpRequest.body(requestParams.toJSONString());
			  
			  
			  Response response=httpRequest.when().queryParam("appid","e802").post("stations");
		
			  
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:" +responseBody);
			  System.out.println(response.getStatusCode());
			  
			  int statusCode=response.getStatusCode();
			  System.out.println("Status code is: "+statusCode);
			  Assert.assertEquals(statusCode, 201);
			  
			  
			  
			  JsonPath jsonPathEvaluator = response.jsonPath();
			  city1 = jsonPathEvaluator.get("ID");
			  
//			
//			  obj.setCity2(city1);
			  
			  
			  
			  

	}
		
		
		@Test(priority = 3)
		public  void testpost2(){
			
			//Specify base URI
			  RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
			  
			  //Request object
			  RequestSpecification httpRequest=RestAssured.given();
			  
			  JSONObject requestParams=new JSONObject();
			  requestParams.put("external_id", "Interview1");
			  requestParams.put("name", "Interview Station 2");
			  requestParams.put("latitude",33.44);		 
			  requestParams.put( "longitude", -12.44);
			  requestParams.put("altitude",444);
			  
			  
	  httpRequest.header("Content-Type","application/json");
			  
			  httpRequest.body(requestParams.toJSONString());
			  
			  
			  Response response=httpRequest.when().queryParam("appid","e802").post("stations");
		
			  
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:" +responseBody);
			  System.out.println(response.getStatusCode());
			  
			  int statusCode=response.getStatusCode();
			  System.out.println("Status code is: "+statusCode);
			  Assert.assertEquals(statusCode, 201);
			  
			  
			  
			  JsonPath jsonPathEvaluator = response.jsonPath();
			  city2 = jsonPathEvaluator.get("ID");
			  
			  
//			  obj.setCity2(city2);
//			  
			 
			  

	}
		
			@Test(priority = 4)
			public void testGet2(){
				//Specify base URI
				  RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
				  
				  //Request object
				  RequestSpecification httpRequest=RestAssured.given();
				
				  
				  
				  Response response=httpRequest.queryParam("appid","e802").get("stations");
			
				  
				  
				  String responseBody=response.getBody().asString();
				  System.out.println("Response Body is:" +responseBody);
				  System.out.println(response.getStatusCode());
				  
				  int statusCode=response.getStatusCode();
				  System.out.println("Status code is: "+statusCode);
				  Assert.assertEquals(statusCode, 200);
				  //JsonPath jsonPathEvaluator = response.jsonPath();
				  
				  
				  
				  

		}
			
			@Test(priority = 5)
			public void deleteWeatherRecord() {
				
				
				
				
					
				
					
				RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
				 RequestSpecification httpRequest=RestAssured.given()	;
					
				// Add a header stating the Request body is a JSON
				httpRequest.header("Content-Type", "application/json");	
				
			    // Delete the request and check the response
				 Response response=httpRequest.queryParam("appid","e802").delete("stations/"+city1);		
				
				int statusCode = response.getStatusCode();
				System.out.println(response.asString());
				System.out.println(statusCode);
				Assert.assertEquals(statusCode, 204);
					
				
				
				}
			
			
			@Test(priority = 6)
			public void deleteWeatherRecord2() {
				
				//Object city2=obj.getCity2();
				
				System.out.println(city2);
				
				
					
				RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
				 RequestSpecification httpRequest=RestAssured.given()	;
					
				// Add a header stating the Request body is a JSON
				httpRequest.header("Content-Type", "application/json");	
				
			    // Delete the request and check the response
				Response response=httpRequest.queryParam("appid","e802").delete("stations/"+city2);		
					
				int statusCode = response.getStatusCode();
				System.out.println(response.asString());
				System.out.println(statusCode);
				Assert.assertEquals(statusCode, 204);
				
				 
				
				}
			
			@Test(priority = 7)
			public void deleteWeatherRecord3() {
					
				//
					
				RestAssured.baseURI="http://api.openweathermap.org/data/3.0/";
				 RequestSpecification httpRequest=RestAssured.given()	;
					
				// Add a header stating the Request body is a JSON
				httpRequest.header("Content-Type", "application/json");	
				
			     // Delete the request and check the response
				Response response=httpRequest.queryParam("appid","e802").delete("stations/"+city1);		
					
				int statusCode = response.getStatusCode();
				System.out.println(response.asString());
				Assert.assertEquals(statusCode, 404);
					
				String jsonString =response.asString();
				Assert.assertEquals(jsonString.contains("Station not found"), true);
				}

}

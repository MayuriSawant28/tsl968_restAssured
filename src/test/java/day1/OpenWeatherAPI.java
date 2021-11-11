package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class OpenWeatherAPI {
  @Test
  public void getWeatherInfo() {
	  
	  RestAssured.given()
	             .when()
	                .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=b8ceecaecef9a86a14874ae24e8a3f31")
	             .then()
	               .log()
	               .body()
	               .statusCode(200);//200 for successfull
	                  
	  
	  
  }
  @Test(enabled=true,description="Getting weather API information generally")
  public void getWeatherInfo2() {
	  Response res =RestAssured.given()
			        .when()
	                  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=b8ceecaecef9a86a14874ae24e8a3f31");
	  System.out.println(res.prettyPrint());
	  System.out.println(res.getTime());
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getContentType());
	  
	  
	  
  }
  @Test(enabled=true,description="Getting weather API information generally")
  public void getWeatherInfo3() {
	  Map<String,String> param=new HashMap<String,String>();
	  param.put("q","Mumbai");
	  param.put("appid","b8ceecaecef9a86a14874ae24e8a3f31");
	  
	  
	  RestAssured.given()
			                      //.queryParam("q","Mumbai")
			                      //.queryParam("appid","b8ceecaecef9a86a14874ae24e8a3f31")
	                            .params(param)
			                    .when()
	                                .get("http://api.openweathermap.org/data/2.5/weather")
	                            .then()
	                              .log()
	         	                  .body()
	         	                  .statusCode(200);//200 for successfull
	         	                  
	                           
	  
	  
  }
  
  
}

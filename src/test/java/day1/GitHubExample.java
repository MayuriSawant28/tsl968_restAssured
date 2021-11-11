package day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GitHubExample {
  @Test(enabled=false,description="getting all repositories")
  public void getAllRepo(){
	  given()
	     .auth()
	     .oauth2("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")
	  .when()
	     .get("https://api.github.com/user/repos")//to get this go in repositories 
	  .then()
	      .log()
	      .body()
	      .statusCode(200)
	      .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	  
  }
  @Test(enabled=true,description="Adding Repository")
  public void addRepository(){
	  JSONObject js = new JSONObject();
	  js.put("name","tsl968-restAssured");
	  js.put("description","I am created by restassured");
	  js.put("homepage","https://github.com/MayuriSawant28");
	  
	  
	  
	  given()
	     .auth()
	     .oauth2("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")
	     .header("Content-Type","application/json")
	     .body(js.toJSONString())
	     
	  .when()
	     .post("https://api.github.com/user/repos")//to get this go in repositories 
	  .then()
	      .log()
	      .body()
	      .statusCode(201)
	      .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	  
  }

  
  
  
  
  
}

package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PositiveTest {
	String id;
	// to run this code keep enabled =true
  @Test(enabled =false,description="for getting all contact List")
  public void getAllContactList() {
	  given()
	  .when()
	      .get("http://3.13.86.142:3000/contacts")
	  .then()
	      .log()
	      .body()
	      .statusCode(200);
	  
  }
  @Test(enabled=true,description ="Adding contacts")
  public void addContact() {
	  JSONObject loc = new JSONObject();
	  loc.put("city","Pune");
	  loc.put("country","India");
	  
	  JSONObject emp=new JSONObject();
	  emp.put("jobTitle","Automation Tester");
	  emp.put("company","LTI");
	  
	  
	  JSONObject ob= new JSONObject();
	  ob.put("firstName","Mayuri");
	  ob.put("lastName","Sawant");
	  ob.put("email","mayusawant@1234.com");
	  ob.put("location",loc);
	  ob.put("employer",emp);
	  
	  
	  id=given()
	       .header("Content-Type","application/json")
	       .body(ob.toJSONString())
	  .when()
	       .post("http://3.13.86.142:3000/contacts")
	  .then()
	      .log()
	      .body()
	      .statusCode(200)
	      //now to extract the id assigned to newly added contact
	      .extract()
	      .jsonPath()
	      .get("_id");
	  
	  System.out.println("ID is" +id);	  
  }
  @Test(enabled=true,dependsOnMethods="addContact",description ="getting contact details using given ID")
  public void getContact() {
	  given()
	  .when()
	     .get("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	      .log()
	      .body()
	      .statusCode(200);
	  
  } 
  @Test(enabled=true,dependsOnMethods="getContact",description ="updating  contacts")
  public void updateContact() {
	  JSONObject loc = new JSONObject();
	  loc.put("city","Pune");
	  loc.put("country","India");
	  
	  JSONObject emp=new JSONObject();
	  emp.put("jobTitle","Automation Tester");
	  emp.put("company","LTI");
	  
	  
	  JSONObject ob= new JSONObject();
	  ob.put("firstName","Bhavana");
	  ob.put("lastName","Sawant");
	  ob.put("email","mayusawant@1234.com");
	  ob.put("location",loc);
	  ob.put("employer",emp);
	  
	  
	  given()
	       .header("Content-Type","application/json")
	       .body(ob.toJSONString())
	  .when()
	       .put("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	      .log()
	      .body()
	      .statusCode(204);//to update 
	      
  }
  @Test(enabled=true,dependsOnMethods="updateContact",description ="getting contact details using given ID")
  public void deleteContact() {
	  given()
	  .when()
	     .delete("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	      .log()
	      .body()
	      .statusCode(204);
  
  } 
}

package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java Created to perform Create, delete, update and read to request the user API

public class UserEndPoints {
	
	
	public static Response CreateUser(UserPojo payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return res;
		
	}
	
	public static Response GetUser(String username)
	{
		Response res=given()
			.pathParam("username", username)
		.when()
			.get(Routes.get_url);
		
		return res;
		
	}
	
	public static Response UpdateUser(String username, UserPojo payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(Routes.update_url);
		
		return res;
		
	}
	
	public static Response DeleteUser(String username)
	{
		Response res=given()
			.pathParam("username", username)
		.when()
			.delete(Routes.delete_url);
		
		return res;
		
	}

}

package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.UserPojo;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker f;
	UserPojo userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void SetUp()
	{
		f=new Faker();
		userpayload=new UserPojo();
		
		userpayload.setId(f.idNumber().hashCode());
		userpayload.setUsername(f.name().username());
		userpayload.setFirstName(f.name().firstName());
		userpayload.setLastName(f.name().lastName());
		userpayload.setEmail(f.internet().safeEmailAddress());
		userpayload.setPassword(f.internet().password(5, 10));
		userpayload.setPhone(f.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void TestPostUserByName()
	{
		
		logger.info("--------Create User Info-----------------");
		Response res=UserEndPoints2.CreateUser(userpayload);
	    res.then().log().all();
	    Assert.assertEquals(res.getStatusCode(),200);
	    logger.info("--------User Info Created-----------------");
	    
	 // Log the created user details to ensure the user was created
        System.out.println("Created User: " + userpayload.getUsername());
	}
	
	@Test(priority=2)
	public void TestGetUsersByName()
	{
		// Adding a small delay to ensure the user creation is processed
        try {
            Thread.sleep(5000); // wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        logger.info("--------Display User Info-----------------");
		Response response=UserEndPoints2.GetUser(this.userpayload.getUsername());
		response.then().log().all();
		// Log the response body to check if user exists
        System.out.println("Response Body: " + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("--------User Info Displayed-----------------");
	}
	
	@Test(priority=3)
	public void TestUpdateUserByName()
	{
		
		logger.info("--------Updating User Info-----------------");
		userpayload.setFirstName(f.name().firstName());
		userpayload.setLastName(f.name().lastName());
		userpayload.setEmail(f.internet().safeEmailAddress());
		
		Response res=UserEndPoints2.UpdateUser(this.userpayload.getUsername(), userpayload);
	    res.then().log().all();
	    Assert.assertEquals(res.getStatusCode(),200);
	    logger.info("--------User Info Updated-----------------");
	    //Check data by get req
	    Response responseAfterUpdate=UserEndPoints2.GetUser(this.userpayload.getUsername());
	    responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
	}
	
	@Test(priority=4)
	public void TestDeleteUserByName()
	{
		logger.info("--------Deleting User Info-----------------");
		Response resAfterDelete=UserEndPoints2.DeleteUser(this.userpayload.getUsername());
		resAfterDelete.then().log().all();
		Assert.assertEquals(resAfterDelete.getStatusCode(),200);
		logger.info("--------User Info Deleted-----------------");
	}

}

package api.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserPojo;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTesst {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void TestPostUser(String ID, String UserName, String FirstName, String LastName, String EmailID, String Password, String PhoneNumber)
	{
		UserPojo userPayload=new UserPojo();
		userPayload.setId(Integer.parseInt(ID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(EmailID);
		userPayload.setPassword(Password);
		userPayload.setPhone(PhoneNumber);
		
		Response res= UserEndPoints.CreateUser(userPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void TestDeleteUser(String UserName)
	{
		Response resAfterDelete=UserEndPoints.DeleteUser(UserName);
		Assert.assertEquals(resAfterDelete.getStatusCode(),200);
	}

}

package api.endpoints;


import static io.restassured.RestAssured.given;

import api.payload.PetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetsEndPoints {
	
	public static Response CreatePet(PetPojo payload)
	{

		 Response res=given()
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(payload)
		
		.when()
			.post(Routes.postPet_url);
			
		return res;
	}
	
	public static Response GetPetInfo(int petId)
	{

		Response res=given()
				.pathParam("id", petId)
		.when()
			.get(Routes.getPet_url);
			
		return res;
	}
	
	public static Response UpdatePetInfo(int petId,PetPojo payload)
	{

		 Response res=given()
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.pathParam("id", petId)
		 	.body(payload)
		
		.when()
			.patch(Routes.updatePet_url);
		    //.put(Routes.updatePet_url.replace("{id}", String.valueOf(petId)));
		return res;
	}
	
	public static Response DeletPetInfo(int petId)
	{

		Response res=given()
				.pathParam("id", petId)
		.when()
			.delete(Routes.deletePet_url);
			
		return res;
	}
	
	
	
}

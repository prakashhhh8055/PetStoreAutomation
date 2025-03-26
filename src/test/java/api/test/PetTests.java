package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetsEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Category;
import api.payload.PetPojo;
import api.payload.Tag;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTests {
	
	PetPojo payload;
    Faker f;
    
    @BeforeClass
    void setup() {
        f = new Faker();
        payload = new PetPojo();

        // Setting id as a random number (hashCode used here for randomness)
        payload.setId(f.number().randomDigitNotZero());

        // Setting pet name using Faker's animal names
        payload.setPetname(f.animal().name());

        // Setting status to a random value from the options available
        payload.setStatus(f.options().option("available", "sold", "adopted"));

        // Setting the Category
        Category category = new Category();
        category.setId(f.number().randomDigitNotZero());  // Random category ID
        category.setName(f.commerce().department());  // Random category name from commerce department
        payload.setCategory(category);

        // Setting photo URLs (generate random URLs)
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(f.internet().url());
        photoUrls.add(f.internet().url());
        payload.setPhotoUrls(photoUrls);

        // Setting tags (generate 3 random tags)
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < 3; i++) {  // Generating 3 random tags
            Tag tag = new Tag();
            tag.setId(f.idNumber().hashCode());  // Set random ID for tag
            tag.setName(f.lorem().word());  // Set random word as tag name
            tags.add(tag);
        }
        payload.setTags(tags);  // Assign the list of tags to the pet
    }
    
    @Test(priority=1)
    public void postPet()
    {
    	Response res = PetsEndPoints.CreatePet(payload);
    	res.then().log().all();
    	Assert.assertEquals(res.getStatusCode(),200);
    	Assert.assertEquals(res.getContentType(),"application/json");
    }
    
    @Test(priority=2)
    public void getPet()
    {
    	Response res = PetsEndPoints.GetPetInfo(this.payload.getId());
    	res.then().log().all();
    	Assert.assertEquals(res.getStatusCode(),200);
    }
    
    @Test(priority=3)
    public void updatePet()
    {
        //f = new Faker();
        //payload = new PetPojo();

        // Setting id as a random number (hashCode used here for randomness)
        payload.setId(f.number().randomDigitNotZero());

        // Setting pet name using Faker's animal names
        payload.setPetname(f.animal().name());

        // Setting status to a random value from the options available
        payload.setStatus(f.options().option("available", "sold", "adopted"));

        // Setting the Category
        Category category = new Category();
        category.setId(f.number().randomDigitNotZero());  // Random category ID
        category.setName(f.commerce().department());  // Random category name from commerce department
        payload.setCategory(category);

        // Setting photo URLs (generate random URLs)
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(f.internet().url());
        photoUrls.add(f.internet().url());
        payload.setPhotoUrls(photoUrls);

        // Setting tags (generate 3 random tags)
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < 3; i++) {  // Generating 3 random tags
            Tag tag = new Tag();
            tag.setId(f.idNumber().hashCode());  // Set random ID for tag
            tag.setName(f.lorem().word());  // Set random word as tag name
            tags.add(tag);
        }
        payload.setTags(tags);  // Assign the list of tags to the pet
    	
        //int petId = payload.getId();
    	Response res = PetsEndPoints.UpdatePetInfo(this.payload.getId(), payload);
    	res.then().log().all();
    	Assert.assertEquals(res.getStatusCode(),200);
    	Assert.assertEquals(res.getContentType(),"application/json");
    	
    	
    	Response resAfterUpdate= PetsEndPoints.GetPetInfo(this.payload.getId());
	    resAfterUpdate.then().log().all();
		//Assert.assertEquals(resAfterUpdate.getStatusCode(),200);
    }
    @Test(priority=4)
    public void DeletePet()
    {
    	Response res = PetsEndPoints.DeletPetInfo(this.payload.getId());
    	res.then().log().all();
    	Assert.assertEquals(res.getStatusCode(),200);
    }
    
    
    

}

package api.endpoints;



/*
  Swagger Base URI -> https://petstore.swagger.io
 
 Create User (POST)--> https://petstore.swagger.io/v2/user

 Update User (PUT) --> https://petstore.swagger.io/v2/user/{username}

 Delete User (DELETE) -->https://petstore.swagger.io/v2/user/{username}

Get User (GET) --> https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {
	
	public static String baseUrl="https://petstore.swagger.io/v2";
	
	//User Model
	
	public static String  post_url=baseUrl+"/user";
	public static String  get_url=baseUrl+"/user/{username}";
	public static String  update_url=baseUrl+"/user/{username}";
	public static String  delete_url=baseUrl+"/user/{username}";
	
	public static String  postPet_url=baseUrl+"/pet";
	public static String  getPet_url=baseUrl+"/pet/{id}";
	public static String  updatePet_url=baseUrl+"/pet/{id}";
	public static String  deletePet_url=baseUrl+"/pet/{id}";

}

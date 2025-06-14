package main;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Contacts API endpoint from MockAPI.org
		InsuranceExpChecker contactAPI = new InsuranceExpChecker();
		String response = contactAPI.getInfo();
		
		//System.out.println(response);
		
		
		//Converts the json response from the api to som
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Users>>(){}.getType();
        List<Users> people = gson.fromJson(response, listType);
        
        //Goes through the users collected in the endpoint and sorts them
        
        Date todayDate = new Date();
        int MAX_NAME_LENGTH = 35;
        
        for (Users p : people) {
        	if (p.getPolicyExpiry().after(todayDate)) {
        		System.out.printf("%2d - %-" + MAX_NAME_LENGTH + "s   %-9s  %n", p.getId(), p.getName(), "Not Expired");
        	}
        	
        	if (p.getPolicyExpiry().before(todayDate))  {
        		System.out.printf("%2d - %-" + MAX_NAME_LENGTH + "s   %-9s %n",
        	            p.getId(), p.getName(), "EXPIRED");
        	}
        	
	}

}
}

package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InsuranceExpChecker {
	
	private static final String BASE_URL = "https://684cd24d65ed08713914599d.mockapi.io/api/insurance/Users";
	
	private HttpClient client;
	
	InsuranceExpChecker(){
		client = HttpClient.newHttpClient();
	}
	
	public String getInfo() throws IOException, InterruptedException{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_URL))
				.GET().build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
	
}

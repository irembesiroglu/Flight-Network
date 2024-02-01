import java.util.Collections; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightNetwork {
	public static Digraph buildFlightNetwork(String filePath) {
		Digraph flightNetwork = new Digraph();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	         String line;
	         while ((line = br.readLine()) != null) {
	             String[] cities = line.split(",");
	             if (cities.length == 2) {
	                 String source = cities[0].trim();
	                 String destination = cities[1].trim();

	                 if (!flightNetwork.getCities().contains(source)) {
	                     flightNetwork.getCities().add(source);
	                 }

	                 if (!flightNetwork.getCities().contains(destination)) {
	                     flightNetwork.getCities().add(destination);
	                 }

	                 flightNetwork.addEdge(source, destination);
	             }
	         }
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return flightNetwork;
	}
	
	public static List<String> findCitiesWithinHops(Digraph flightNetwork, String startCity, int maxHops) {
	    List<String> result = new ArrayList<>();
	    dfs(flightNetwork, startCity, 0, maxHops, new ArrayList<>(), result);
	    return result;
	}
	
	private static void dfs(Digraph flightNetwork, String currentCity, int currentHops, int maxHops, List<String> path, List<String> result) {
	    if (currentHops <= maxHops) {
	        path.add(currentCity);
	        if (currentHops == maxHops) {
	            result.add(String.join("-", path));
	        } else {
	            for (String neighbor : flightNetwork.getAdjacentCities(currentCity)) {
	                dfs(flightNetwork, neighbor, currentHops + 1, maxHops, new ArrayList<>(path), result);
	            }
	        }
	    }
	}
		 
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String filePath = scanner.nextLine();

	    Digraph flightNetwork = buildFlightNetwork(filePath);

	    int maxHops = 0;
	    try {
	        maxHops = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(1);
	    }

	    String startCity = scanner.nextLine();

	    List<String> routes = findCitiesWithinHops(flightNetwork, startCity, maxHops);
	    Collections.sort(routes);

	    System.out.println("Number of total routes: " + routes.size());
	        System.out.println("Routes are:");
	        for (String route : routes) {
	            System.out.println(route);
	        }

	        scanner.close();
	    }
 
}

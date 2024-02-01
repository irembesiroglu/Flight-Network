import java.util.ArrayList;
import java.util.List;

public class Digraph {
	private List<String> cities;
	private List<List<String>> neighbors;
	
	public Digraph() {
	     this.cities = new ArrayList<>();
	     this.neighbors = new ArrayList<>();
	 }
	
	public void addEdge(String source, String destination) {
	     int sourceIndex = getIndex(source);
	     int destIndex = getIndex(destination);

	     while (neighbors.size() <= sourceIndex) {
	         neighbors.add(new ArrayList<>());
	     }

	     neighbors.get(sourceIndex).add(destination);
	 }
	
	public List<String> getAdjacentCities(String city) {	
	     int index = getIndex(city);
	     return index != -1 ? neighbors.get(index) : new ArrayList<>();
	 }
	
	private int getIndex(String city) {
	     for (int i = 0; i < cities.size(); i++) {
	         if (cities.get(i).equals(city)) {
	             return i;
	         }
	     }
	     return -1;
	 }
	
	public List<String> getCities() {
	     return cities;
	 }
}

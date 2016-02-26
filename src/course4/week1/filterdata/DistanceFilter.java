package course4.week1.filterdata;

public class DistanceFilter implements Filter {
	
	private Location loc;
	private double maxdistance;
	
	public DistanceFilter(Location place, double distance) {
		loc = place;
		maxdistance = distance;
	}
	
	public String getName(){
		return "Distance";
	}
	
	@Override
	public boolean satisfies(QuakeEntry qe) {
		return qe.getLocation().distanceTo(loc) <= maxdistance;
	}

}

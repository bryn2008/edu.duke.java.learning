package course4.week1.filterdata;

public class DistanceFilter implements Filter {
	
	private Location loc;
	private double maxdistance;
	
	public DistanceFilter(Location myloc, double distance) {
		loc = myloc;
		maxdistance = distance;
	}
	
	@Override
	public boolean satisfies(QuakeEntry qe) {
		return qe.getLocation().distanceTo(loc) <= maxdistance;
	}

}

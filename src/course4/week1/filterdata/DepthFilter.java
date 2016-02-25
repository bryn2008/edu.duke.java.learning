package course4.week1.filterdata;

public class DepthFilter implements Filter {
	
	private double minDepth;
	private double maxDepth;
	
	public DepthFilter(double min, double max){
		minDepth = min;
		maxDepth = max;
	}
	
	public boolean satisfies(QuakeEntry qe){
		return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
	}

}

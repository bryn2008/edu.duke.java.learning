package course4.week1.filterdata;

public class DepthFilter implements Filter {
	
	private int minDepth;
	private int maxDepth;
	
	public DepthFilter(int min, int max){
		minDepth = min;
		maxDepth = max;
	}
	
	public boolean satisfies(QuakeEntry qe){
		return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
	}

}

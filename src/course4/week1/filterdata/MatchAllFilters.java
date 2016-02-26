package course4.week1.filterdata;

import java.util.ArrayList;

public class MatchAllFilters implements Filter {

	private ArrayList<Filter> filters;

	public MatchAllFilters() {
		filters = new ArrayList<Filter>();
	}

	public void addFilter(Filter f) {
		filters.add(f);
	}
	
	public String getName(){
		String filter = "";
		for (Filter f : filters) {
			filter += f.getName()+" ";
			}
		return filter;
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		for (Filter f : filters) {
			if (!f.satisfies(qe)) {
				return false;
			}
		}
		return true;
	}

}

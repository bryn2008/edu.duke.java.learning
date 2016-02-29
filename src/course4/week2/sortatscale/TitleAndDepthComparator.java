package course4.week2.sortatscale;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {

	@Override
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {

		int infoComparison = qe1.getInfo().compareTo(qe2.getInfo());
		if (infoComparison == 0) {
			if(qe1.getDepth() < qe2.getDepth()){
				return -1;
			}
			return 0;
		}
		return infoComparison;
	}
}

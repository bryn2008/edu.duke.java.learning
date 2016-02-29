package course4.week2.sortatscale;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {

	@Override
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {
		String lastWordOne = qe1.getInfo().substring(qe1.getInfo().lastIndexOf(" ") + 1);
		String lastWordTwo = qe2.getInfo().substring(qe2.getInfo().lastIndexOf(" ") + 1);
		int infoComparison = lastWordOne.compareTo(lastWordTwo);
		if (infoComparison == 0) {
			if(qe1.getMagnitude() < qe2.getMagnitude()){
				return -1;
			}else if (qe1.getMagnitude() > qe2.getMagnitude()){
				return 1;
			}
			return 0;
		}
		return infoComparison;
	}

}

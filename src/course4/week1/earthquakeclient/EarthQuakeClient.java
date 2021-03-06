package course4.week1.earthquakeclient;

import java.util.*;

public class EarthQuakeClient {

	private String filePath = "src/course4/week1/earthquakeclient/";
	private String url = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

	public EarthQuakeClient() {
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk");
		System.setProperty("http.proxyPort", "8080");
	}

	public static void main(String[] args) {

		EarthQuakeClient eqc = new EarthQuakeClient();
		// eqc.createCSV();
		// eqc.bigQuakes();
		// eqc.closeToMe();
		//eqc.quakesOfDepth();
		eqc.quakesByPhase();

	}

	public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			if (qe.getMagnitude() > magMin) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			if (qe.getLocation().distanceTo(from) < distMax) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for (QuakeEntry qe : list) {
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n", qe.getLocation().getLatitude(), qe.getLocation().getLongitude(),
					qe.getMagnitude(), qe.getInfo());
		}

	}

	public void bigQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = filePath + "data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");
		ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
		System.out.println("All quakes bigger than 5.0");
		for (QuakeEntry qe : listBig) {
			System.out.println(qe);
		}
	}

	public void createCSV() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedata.atom";
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: " + list.size());
	}

	public void closeToMe() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = filePath + "data/nov20quakedatasmall.atom";
		String source = url;
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes.");

		// Durham, NC
		// Location city = new Location(35.988, -78.907);
		// Bridgeport, CA
		Location city = new Location(38.17, -118.82);
		ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000 * 1000, city);
		for (int k = 0; k < close.size(); k++) {
			QuakeEntry entry = close.get(k);
			double distanceInMeters = city.distanceTo(entry.getLocation());
			System.out.println(distanceInMeters / 1000 + " " + entry.getInfo());
		}

	}

	public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth) {

		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			if (qe.getDepth() > minDepth && qe.getDepth() < maxDepth) {
				answer.add(qe);
			}
		}
		return answer;

	}

	public void quakesOfDepth() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedata.atom";
		// String source = url;
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes.");
		double minDepth = -4000.0;
		double maxDepth = -2000.0;
		System.out.println("Find quakes with depth between " + minDepth + " and " + maxDepth);
		ArrayList<QuakeEntry> qe = filterByDepth(list, minDepth, maxDepth);
		for (int k = 0; k < qe.size(); k++) {
			QuakeEntry entry = qe.get(k);
			System.out.println(entry.toString());
		}
		System.out.println("Found " + qe.size() + " that match that criteria");

	}

	public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase) {

		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			String quakeName = qe.getInfo();
			String start = quakeName.substring(0, phrase.length());
			String end = quakeName.substring(quakeName.length() - phrase.length());
			if (where.contains("start") && start.contains(phrase)) {
				answer.add(qe);
			} else if (where.contains("end") && end.contains(phrase)) {
				answer.add(qe);
			} else if (where.contains("any") && quakeName.contains(phrase)) {
				answer.add(qe);
			}
		}

		return answer;

	}

	public void quakesByPhase() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = filePath + "data/nov20quakedata.atom";
		// String source = url;
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes.");
		String where = "any";
		String phrase = "Can";
		ArrayList<QuakeEntry> qe = filterByPhrase(list, where, phrase);
		for (int k = 0; k < qe.size(); k++) {
			QuakeEntry entry = qe.get(k);
			System.out.println(entry.toString());
		}
		System.out.println("Found " + qe.size() + " that match " + phrase + " at " + where);

	}

}

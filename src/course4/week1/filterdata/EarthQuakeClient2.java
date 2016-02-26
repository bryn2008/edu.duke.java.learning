package course4.week1.filterdata;

import java.util.*;

public class EarthQuakeClient2 {
    
	private String filePath = "src/course4/week1/earthquakeclient/";
	
	public EarthQuakeClient2(){
		// TODO Auto-generated constructor stub
		
		System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
	}
	
	public static void main(String[] args){
		
		EarthQuakeClient2 quakeClientTwo = new EarthQuakeClient2();
		//quakeClientTwo.createCSV();
		quakeClientTwo.quakesWithFilter();
	}
	
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = filePath + "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilters maf = new MatchAllFilters();
        Location Billund = new Location (55.7308, 9.1153);
        maf.addFilter(new MagnitudeFilter(0.0, 5.0));
        maf.addFilter(new DistanceFilter(Billund, 3000000));
        maf.addFilter(new PharseFilter("any", "e"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());
        
        /*MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new DepthFilter(-180000.0, -30000.0));
        maf.addFilter(new MagnitudeFilter(1.0, 4.0));
        maf.addFilter(new PharseFilter("end", "o"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(3.5, 4.5));
        maf.addFilter(new DepthFilter(-55000.0, -20000.0));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        Location Denver = new Location(39.7392, -104.9903);
        maf.addFilter(new DistanceFilter(Denver, 1000000));
        maf.addFilter(new PharseFilter("end", "a"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(0.0, 2.0));
        maf.addFilter(new DepthFilter(-100000.0, -10000.0));
        maf.addFilter(new PharseFilter("any", "a"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        
        /*MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(4.0, 5.0));
        maf.addFilter(new DepthFilter(-35000.0, -12000.0));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        Location Japan = new Location( 35.42, 139.43);
        maf.addFilter(new DistanceFilter(Japan, 10000000));
        maf.addFilter(new PharseFilter("end", "Japan"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The numbe of quakes found is: " + quakes.size());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        Location Tulsa = new Location(36.1314, -95.9372);
        maf.addFilter(new MagnitudeFilter(0.0, 3.0));
        maf.addFilter(new DistanceFilter(Tulsa, 10000000));
        maf.addFilter(new PharseFilter("any", "Ca"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("The number of quakes found is: " + quakes.size());
        System.out.println("Filters used are: " + maf.getName());*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        Location Japan = new Location( 35.42, 139.43);
        maf.addFilter(new DistanceFilter(Japan, 10000000));
        maf.addFilter(new PharseFilter("end", "Japan"));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }*/
        
        /*MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(4.0, 5.0));
        maf.addFilter(new DepthFilter(-35000.0, -12000.0));
        ArrayList<QuakeEntry> quakes  = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }*/
        
        /*Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } */
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = filePath + "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    
}

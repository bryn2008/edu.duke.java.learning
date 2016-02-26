package course4.week1.filterdata;

public class PharseFilter implements Filter {
	
	private String where;
	private String phrase;
	
	public PharseFilter(String place, String str) {
		where = place;
		phrase = str;
	}
	
	public String getName(){
		return "Pharse";
	}
	
	@Override
	public boolean satisfies(QuakeEntry qe) {
		if("start".equalsIgnoreCase(where)){
			return qe.getInfo().substring(0, phrase.length()).equals(phrase);
		}else if("end".equalsIgnoreCase(where)){
			return qe.getInfo().substring(qe.getInfo().length() - phrase.length()).equals(phrase);
		}else if("any".equalsIgnoreCase(where)){
			return qe.getInfo().contains(phrase);
		}
		return false;
	}
	
}

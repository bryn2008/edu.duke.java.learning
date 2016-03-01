package course4.week3.generatingrandomtext;

import java.util.ArrayList;

import edu.duke.FileResource;

public class Tester {
	
	private String filePath = "src/course4/week3/generatingrandomtext/data/";
	
	public static void main(String[] args){
		Tester myObj = new Tester();
		//myObj.testGetFollows();
		myObj.testGetFollowsWithFile();
	}
    
	public void testGetFollows() {
		
		MarkovOne markov = new MarkovOne("this is a test yes this is a test.");
		ArrayList<String> al = markov.getFollows("es");
		System.out.println(al);
		
	}
	
	public void testGetFollowsWithFile() {
		
		FileResource fr = new FileResource(filePath + "confucius.txt");
		String st = fr.asString();
		MarkovOne markov = new MarkovOne(st);
		ArrayList<String> al = markov.getFollows("t");
		System.out.println(al.size());
	}
	
	
}

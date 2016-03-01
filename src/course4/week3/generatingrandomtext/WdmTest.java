package course4.week3.generatingrandomtext;

import java.util.ArrayList;

public class WdmTest {

	public static void main(String[] args) {

		MarkovOne markovOne = new MarkovOne();
		markovOne.setTraining("this is a test yes this is a test.");
		ArrayList<String> al = markovOne.getFollows("t");
		for (String a: al) {
			System.out.print(a);
			System.out.print(" ");
		}
		System.out.println();
	}

}

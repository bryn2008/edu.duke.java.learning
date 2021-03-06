package course4.week3.markovmodel;

import edu.duke.*;

public class MarkovRunnerWithInterface {
	
	private String filePath = "src/course4/week3/markovmodel/";
	
	public static void main(String[] args){
		MarkovRunnerWithInterface myObj = new MarkovRunnerWithInterface();
		myObj.runMarkov();
	}
	
	public void runModel(IMarkovModel markov, String text, int size, int seed){
		markov.setRandom(seed);
		markov.setTraining(text);
		markov.buildMap();
		System.out.println("running with " + markov);
		for (int k=0; k <1; k++){
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}
	
	public void runMarkov(){
		FileResource fr = new FileResource(filePath + "data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		
		int size = 100;
		int seed = 615;
		
		EfficientMarkovModel emm = new EfficientMarkovModel(5);
        runModel(emm, st, size, seed);
		
        /*MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);*/
		
	}
	
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}

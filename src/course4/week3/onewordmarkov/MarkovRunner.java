package course4.week3.onewordmarkov;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
	
	private String filePath = "src/course4/week3/onewordmarkov/data/";
	
	public static void main(String[] args){
		MarkovRunner runner = new MarkovRunner();
		runner.runMarkov();
	}
	
    /*public void runModel(IMarkovModel markov, String text, int size){ 
    	markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    }*/ 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
    	markov.setRandom(seed);
    	markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    }

    public void runMarkov() { 
        FileResource fr = new FileResource(filePath + "confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordTwo markovWord = new MarkovWordTwo(); 
        runModel(markovWord, st, 200, 549); 
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
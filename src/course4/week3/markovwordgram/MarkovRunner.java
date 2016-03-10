package course4.week3.markovwordgram;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    
	private String filePath = "src/course4/week3/markovwordgram/data/";
	
	public static void main(String[] args){
		MarkovRunner myObj = new MarkovRunner();
		//myObj.runMarkov();
		//myObj.testHashMap();
		myObj.testHashMapTwo();
	}
	
	public void testHashMap(){
	    String text = "this is a test yes this is really a test"; 
	    int myOrder = 2;
	    int size = 50/myOrder;
	    int seed = 42;
	    EfficientMarkovWord markovWord = new EfficientMarkovWord(myOrder);
	    markovWord.setTraining(text); 
	    markovWord.setRandom(seed);
        markovWord.getRandomText(size); 
	}
	
	public void testHashMapTwo(){
	    //String text = "this is a test yes this is really a test yes a test this is wow";
	    String text = "this is a test yes"; 
	    int myOrder = 2;
	    int size = 20;
	    int seed = 2;
	    EfficientMarkovWord markovWord = new EfficientMarkovWord(myOrder);
	    markovWord.setTraining(text); 
	    markovWord.setRandom(seed);
        //markovWord.getRandomText(size);
        System.out.println("running with " + markovWord); 
        for(int k=0; k < 1; k++){ 
            String st = markovWord.getRandomText(size); 
            printOut(st); 
        }
	}

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
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
        int myOrder = 3;
        int size = 20/myOrder;
        int seed = 643;
        MarkovWord markovWord = new MarkovWord(myOrder);
        runModel(markovWord, st, size, seed); 
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

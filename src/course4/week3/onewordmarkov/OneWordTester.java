package course4.week3.onewordmarkov;

public class OneWordTester {
	
	public static void main(String[] args){
		OneWordTester myObj = new OneWordTester();
		//myObj.testIndexOf();
		myObj.runMarkov();
	}
	
	public void testIndexOf(){
		String st = "this is just a test yes this is a simple test";
		String[] words = st.split(" ");
		String target = "test"; 
		int start = 5;
		MarkovWordOne markovWord = new MarkovWordOne();
		markovWord.testIndexOf(words, target, start);
	}
	
	public void runMarkov() { 
        String st = "this is just a test yes this is a simple test"; 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne(); 
        markovWord.setTraining(st);
        //markovWord.setRandom(175);
        int size = 120;
        System.out.println("running with " + markovWord); 
        for(int k=0; k < 3; k++){ 
            String str = markovWord.getRandomText(size); 
            printOut(str); 
        }
        
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

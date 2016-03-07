package course4.week3.markovwordgram;

public class WordGram {
    
	private String[] myWords;
    //private int myHash;

    public String[] getMyWords() {
		return myWords;
	}

	public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
    	return myWords.length;
    }

    public String toString(){
        String ret = "";
        for (int k=0; k < myWords.length; k++){
        	ret += myWords[k] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if (this.length() != other.length()){
        	return false;
        }
        for (int k=0; k< myWords.length; k++){
        	if (! myWords[k].equals(other.wordAt(k))){
        		return false;
        	}
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	
    	int length = myWords.length;
    	String[] out = new String[length];
    	for(int i=0; i<length-1; i++){
    		out[i] = myWords[i+1];
    	}
    	out[length-1] = word;
    	WordGram ans = new WordGram(out, 0, myWords.length);        
        return ans;
    }

}
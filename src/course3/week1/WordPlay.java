package course3.week1;

//import edu.duke.*;
//import java.util.*;

public class WordPlay {
    
	public static void main (String [] args){
		
		WordPlay myObj = new WordPlay();
		myObj.emphasize();
	}
	
	public boolean isVowel (char ch) {
        //Checks the char passed into the method isVowel to see if the char is a vowel
        //note both upper and lower case vowels have been checked in the if statment
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;    
        }       
        return false;
        //Returns true if the char is a vowel and false if it is not a vowel
    }    
 
    public void replaceVowels(){
        //Created a String named phase for the input phrase and converted to a char Array named ch
        String phase = "Hello World, HOW IS YOUR DAY?";
        char[] ch = phase.toCharArray();
        
        //A for loop to loop through each instace of a char in the string phase
        for(int i = 0; i < phase.length(); i++){
            if (isVowel(ch[i])) {   //calls the isVowel method to check if th char is a vowel
                ch[i] = '*';     //replace the letter with *
            }
        }
        //Print out the new ch
        System.out.println(ch);

    }    

        public boolean isOddOrEvenVowel (char ch) { //this method is called from "emphasize()"
        //Checks the char passed into the method isOddOrEvenVowel to see if the char is 'a' or 'A'
        //note both upper and lower case vowels have been checked in the if statment
        if (ch == 'a' || ch == 'A' ) {
            return true;    
        }       
        return false;
        //Returns true if the char is 'a' or 'A' and false if it is not 'a' or 'A'
    }    
    
    public void emphasize(){
        //Created a String named phase for the input phrase and converted to a char Array named character
        //String phase = "Mary Bella Abracadabra";
        String phase = "dna ctgaaactga";
        char[] character = phase.toCharArray();
        
        //A for loop to loop through each instace of a char in the string phase ad decide if odd or even
        for(int i = 0; i < phase.length(); i++){
            //Check if letter is a vowel
            if(isOddOrEvenVowel(character[i])){  //calls the isOddOrEvenVowel method to check if th char is a vowel
                //Check if the vowel is at an even or odd position in the string
                if (i%2==0) {    //uses the modulus to check if the char is even
                    //if the char is a vowel and even....
                    character[i] = '*';       //replace the letter with * 
                }
                else if(i%2!=0){//if the char is a vowel but not even...
                    character[i] = '+';   //replace the odd vowel with +
                }
            }
            //it the char is not a vowel then nothing happens
        }
        //Prints out the new phase string
        System.out.println(character);
    }    

    //Area for testing code
    public void testArea(){
        //String ch = "ABCDASDFAW";
        //ch = ch.toLowerCase();
        //System.out.println(ch);

        
    }
    
}

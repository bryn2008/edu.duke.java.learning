package course3.week1;


public class CaesarBreaker {
    
	public static void main (String [] args){
		
		CaesarBreaker myObj = new CaesarBreaker();
		myObj.testDecrypt();
		
	}
	
	
	public void countLetters(){
		
		//simular method created in the WordLengths Class
		
	}

	public void maxIndex(){
		
		//simular method created in the WordLengths Class
		
	}
	
	public void decrypt(){
		
		String input = "Hello"; 
		int key = 15;
		
		//The input must be in upper case
		input = input.toUpperCase();
		
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(input, key);
		
		System.out.println(message);
		
	}
	
	public void testDecrypt(){
		
		decrypt();
		
	}
	
	public void halfOfString(){
		
		//Two perameters String message and int start
		
	}
	
	public void getKey(){
		
		//One perameter String s
		//Method should call countLetters
	
	}
	
	public void decryptTwoKeys(){
		
		//Sting encrypted
		
	}
	
	
}

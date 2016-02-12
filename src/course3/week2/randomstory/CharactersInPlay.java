package course3.week2.randomstory;

import java.util.ArrayList;

import edu.duke.*;

public class CharactersInPlay {
	
	private ArrayList<String> charecterNames;
	private ArrayList<Integer> charecterNameCount;
	
	public CharactersInPlay(){
		
		charecterNames = new ArrayList<String>();
		charecterNameCount = new ArrayList<Integer>();
		
	}
	
	public static void main(String[] args){
		
		CharactersInPlay myObj = new CharactersInPlay();
		myObj.tester();
	}
	
	public void update(String person){
		
		//updates the two Array List's, adding the Characters name if it's not already there and this line as one speaking part for this person
		
		if (! charecterNames.contains(person)){
			charecterNames.add(person);
			charecterNameCount.add(0);
			int nameDex = charecterNames.indexOf(person);
			charecterNameCount.set(nameDex, 1);
		}
		else {
			int nameDex = charecterNames.indexOf(person);
			int cerrentValue = charecterNameCount.get(nameDex);
			cerrentValue++;
			charecterNameCount.set(nameDex, cerrentValue);
		}
	}
	
	public void findAllCharecters(){
		
		charecterNames.clear();
		charecterNameCount.clear();
		
		FileResource fr = new FileResource("QuizGladLibsData/errors.txt");
		
		for (String line : fr.lines()){
			if(line.contains(".")){
				int lineEnd = line.indexOf(".");
				String name = line.substring(0, lineEnd);
				update(name);
			}
		}

	}
	
	public void tester(){
		
		findAllCharecters();
		//System.out.println("The total number of Character names are: "+ charecterNames.size());
		for (int i =0; i<charecterNames.size();i++){
			System.out.println(charecterNames.get(i)+" "+charecterNameCount.get(i));
		}
		
		System.out.println(" ");
		
		int num1 = 55;
		int num2 = 100;
		charactersWithNumParts(num1, num2);

	}
	
	public void charactersWithNumParts(int num1, int num2){
		
		/*Write a void method called charactersWithNumParts that has two int parameters named num1 and num2, 
		 * where you can assume num1 should be less than or equal to num2. 
		 * This method should print out the names of all those characters that have exactly number speaking parts, 
		 * where number is greater than or equal to num1 and less than or equal to num2. 
		 * Add code in tester to test this method out.
		*/
		
		for (int x : charecterNameCount){
			if ( x > num1 && x <= num2){
				//get the charecterName for the character at the charecterNameCount x position
				int currCharacterDex = charecterNameCount.indexOf(x);
				int cerrentValue = charecterNameCount.get(currCharacterDex);				
				System.out.println(charecterNames.get(currCharacterDex)+" "+cerrentValue);
			}
		}
	}

}

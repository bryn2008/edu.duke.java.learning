package course4.week3.markovmodel;

public interface IMarkovModel {
	
	public void setTraining(String text);
	
	public String getRandomText(int numChars);
	
	public void buildMap();
	
	public void setRandom(int seed);
	
}

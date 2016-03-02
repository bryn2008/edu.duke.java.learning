package course4.week3.markovmodel;

public interface IMarkovModel {
	public void setTraining(String text);
	
	public String getRandomText(int numChars);

}

package models;

import java.io.Serializable;

public class WordsModel implements Serializable{
	private static final long serialVersionUID = 1L;
	public String[] words;

	public WordsModel(String[] words) 
	{
		this.words = words;
	}
	
	public WordsModel() {}
	
	public void setWords(String[] words)
	{
		this.words = words;
	}
	
	public String[] getWords()
	{
		return words;
	}
	
	
}
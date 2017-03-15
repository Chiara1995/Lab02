package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private Map<String,String> word=new TreeMap<String,String>();
	
	public void addWord(String a, String t){
		if(!word.containsKey(a))
			word.put(a, t);
		else{
			if(!word.values().contains(t))
				word.put(a, word.get(a)+", "+t);
		}
	}
	
	public String TranslationWord(String a){
		if(word.containsKey(a))
			return word.get(a);
		else
			return "Word isn't in the dictionary";
	}
}

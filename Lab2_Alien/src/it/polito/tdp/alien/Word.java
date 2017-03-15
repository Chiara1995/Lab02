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
		boolean trovato=true;
		List<String> risultato=new LinkedList<String>();
		//numero ricorrenze ? nella parola
		int cont=0;
		for(int h=0; h<a.length(); h++){
			if(a.charAt(h)=='?')
				cont++;
		}
		if(cont==0){
			//nessun carattere ?
			if(word.containsKey(a))
				return word.get(a);
			else
				return "Word isn't in the dictionary";
		}
		if(cont==1){
			//un carattere ?
			List<String> ltemp=new LinkedList<String>();
			ltemp.addAll(word.keySet());
			for(int j=0; j<ltemp.size(); j++){
				if(ltemp.get(j).length()==a.length()){
					for(int k=0; k<ltemp.get(j).length(); k++){
						trovato=true;
						if(ltemp.get(j).charAt(k)!=a.charAt(k) && a.charAt(k)!='?'){
							trovato=false;
							break;
						}
					}
					if(trovato==true)
						risultato.add(ltemp.get(j));
				}
			}
			if(risultato.size()!=0){
				String stampa="";
				for(int g=0; g<risultato.size(); g++){
					stampa+=risultato.get(g)+" "+word.get(risultato.get(g))+"\n";
				}
				return stampa;
			}
			
			return "Wildcard isn't in the dictionary"; 
		}
		return "Insert only one character ?";	
	}
}

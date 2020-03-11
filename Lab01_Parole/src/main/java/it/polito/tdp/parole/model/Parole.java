package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole;  
		
	public Parole() {
		//TODO
		parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(parole, new ComparatorParole());
		return parole;
	}
	
	public void reset() {
		// TODO
		parole.clear();
	}

	public void cancella(String p) {
		for (String string : parole) {
    		if (string.compareTo(p)==0) { 
    			parole.remove(string);
    			return;}}
		
	}
}

package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatorParole implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s1.toUpperCase().compareTo(s2.toUpperCase());
	}

}

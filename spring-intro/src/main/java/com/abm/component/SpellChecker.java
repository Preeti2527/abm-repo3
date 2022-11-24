package com.abm.component;

import org.springframework.stereotype.Component;

@Component("splChckr")
public class SpellChecker {
	

	public void checkSpellingMistake(String document) {
		System.err.println("spell checker executed for " + document);
	}

}

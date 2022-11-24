package com.abm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {
	
	@Autowired
	private SpellChecker sp;
	
	
public void loadDocument(String document) {
	
	System.out.println("text editor loaded" +document);
	
	//SpellChecker sp=new SpellChecker();
	sp.checkSpellingMistake(document);
		
	}

}

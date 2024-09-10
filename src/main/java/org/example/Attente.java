package org.example;

import java.util.ArrayList;
import java.util.List;

public class Attente {

	private final TriageType triageType;
	
	private List<String> personeList;
	
	public Attente(TriageType triageType) {
		this.triageType = triageType;
		this.personeList = new ArrayList<>();
	}

	public void addPersone(String name, int gravity) {
		if(this.triageType == TriageType.GRAVITY && gravity > 5) {
			this.personeList.addFirst(name);
		} else {
			this.personeList.add(name);
		}
	}

	public int getSize() {
		return personeList.size();
	}

	public String getElement(int index) {
		return this.personeList.get(index);
	}
	
}
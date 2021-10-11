package com.medicavrai.webapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class FrequenceQuantiqueService {

	public ArrayList<String> getFrequenceSonTellurique() {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(frequenceRandomString());
		}
		return arrayList;
	}

	private String frequenceRandomString() {
		int min = 300;
		int max = 800;
		int nombreAleatoire = min + (int) (Math.random() * ((max - min) + 1));
		String valueOf = String.valueOf(nombreAleatoire);
		return valueOf;
	}

}

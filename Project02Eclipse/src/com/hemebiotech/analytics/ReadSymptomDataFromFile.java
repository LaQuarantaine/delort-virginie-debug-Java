package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Cette méthode implémente l'interface ISymptomReader.
	 * création d'une liste
	 * @param aucun
	 * @return une liste de String
	 * @throws peut soulever 2 types d'exceptions 
	 */
	
	@Override
	public List<String> getSymptoms() {		
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				
				String line = reader.readLine();
			
				if (line == null) {
					System.out.println("Le fichier est vide.");
				}
				else {
					while (line != null) {
						result.add(line);
						line = reader.readLine();
					}
				}
				
				reader.close();
				
			} 
			catch (FileNotFoundException e) {
	            System.out.println("Erreur : Le fichier spécifié n'existe pas.");
	            e.printStackTrace();  
				}
			
			catch (IOException e) { 
				System.out.println("Erreur : ");
				e.printStackTrace();
			} 
		}
		return result;
	}

}

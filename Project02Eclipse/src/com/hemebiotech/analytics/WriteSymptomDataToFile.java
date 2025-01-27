package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Cette méthode implémente l'interface ISymptomWriter.
	 * écriture sur un fichier de sortie
	 * @param Map<String, Integer> symptoms
	 * @return void / ne retourne rien
	 * @throws peut soulever 2 types d'exceptions 
	 */
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\src\\result.out"))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } 
		
		catch (FileNotFoundException e) {
            System.out.println("Erreur : Le fichier de destination n'existe pas.");
            e.printStackTrace();  
			}
		
		catch (IOException e) { 
			System.out.println("Erreur : ");
			e.printStackTrace();
		} 
		
   }

}



package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {

	
	public static void main(String args[]) {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\symptoms.txt");
		
		List<String> symptoms = reader.getSymptoms();	// Appel du résultat de la méthode getSymptoms() et stockage du résultat dans "symptoms"
        
		System.out.println("Liste brute des symptômes sans tri :"); //affichage d'un titre (non demandé)
        for (String symptom : symptoms) {
        System.out.println(symptom);	// affichage de la liste (non demandée) pour vérification
        }
        
        Map<String, Integer> symptomCount = new HashMap<>();	
        for (String symptom : symptoms) {						// comptage des occurences pour chaque symptome
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }
        
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile ("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\src\\result.out");
		
        // Écriture d'un tableau symptôme/occurrence dans le fichier result.out
        writer.writeSymptoms(symptomCount);

    }	
}
		


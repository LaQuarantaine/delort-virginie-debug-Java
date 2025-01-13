package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {

    private ISymptomReader reader; //attribut de la classe
    private ISymptomWriter writer; //attribut de la classe
    
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { //constructeur avec 2 objets en paramètres (ISymptomReader et ISymptomWriter)
        this.reader = reader; //permet de réunir au sein d'un seul objet les propriétés de reader et de writer
        this.writer = writer;
    }
        
    public List<String> getSymptoms() {  //appel à la méthode getSymptoms. Possible car méthode déclarée public
        return reader.getSymptoms();  //retour d'une List liée à l'objet reader et selon la méthode getSymptoms
    }

     public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> countSymptoms = new HashMap<>();	//création d'1 instance HashMap qui contiendra la List symptoms au format Map (passage d'une List à une Map)
        for (String symptom : symptoms) {	//pour chaque clé String de la Map, parcourir la list symptoms				
        	countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1); //pour chaque clé, vérifie s'il existe et ajoute 1 si existe déjà
            }
        return countSymptoms; //renvoi une instance HashMap sur la base de la List symptoms avec une occurence par clé lue par la Map
      }
        
        
     public Map<String, Integer> sortSymptoms(Map<String, Integer> compteur) { 
        Map<String, Integer> sortSymptoms = new TreeMap<>(compteur); //création d'une instance TreeMap qui permet le tri d'une Map
        return sortSymptoms; //récupère les données de la HashMap et les retournent triées grace à TreeMap
     }
        
     public void writeSymptoms(Map<String, Integer> symptoms) { 
        writer.writeSymptoms(symptoms);
     }
    
    
	public static void main(String args[]) {
	
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\symptoms.txt");
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile ("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\src\\result.out");
		AnalyticsCounter ac = new AnalyticsCounter(reader, writer);
		
		List<String> symptoms = ac.getSymptoms();
		ac.countSymptoms(symptoms);
		
		Map<String, Integer> countSymptoms = ac.countSymptoms(symptoms);
		
		Map<String, Integer> sortSymptoms = ac.sortSymptoms(countSymptoms);
		
		writer.writeSymptoms(sortSymptoms);
		
		}
	}	
       	
		


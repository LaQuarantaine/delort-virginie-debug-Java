package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile ("C:\\Users\\cvign\\Documents\\delort-virginie-debug-Java\\Project02Eclipse\\src\\result.out");
		AnalyticsCounter ac = new AnalyticsCounter(reader, writer);
		
			
		List<String> symptoms = ac.getSymptoms();
				
		Map<String, Integer> countSymptoms = ac.countSymptoms(symptoms);
		
		Map<String, Integer> sortSymptoms = ac.sortSymptoms(countSymptoms);
		
		writer.writeSymptoms(sortSymptoms);	
	}
}

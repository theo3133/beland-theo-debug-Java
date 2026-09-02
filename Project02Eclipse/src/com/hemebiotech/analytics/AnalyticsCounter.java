package com.hemebiotech.analytics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter){
		this.symptomReader= symptomReader;
		this.symptomWriter= symptomWriter;
	}
	
	 public List<String> getSymptoms(){
		return symptomReader.GetSymptoms();
	}
		
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> countSymp = new HashMap<String, Integer>();
		for ( String symptom : symptoms){
			if (countSymp.containsKey(symptom)){
				countSymp.put(symptom, countSymp.get(symptom) + 1);
			}else{
				countSymp.put(symptom,1);
			}
		}
		return countSymp;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		Map<String, Integer> mapTriee = new TreeMap<String, Integer>(symptoms);
		return mapTriee;
	}
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		symptomWriter.writeSymptoms(symptoms);
	}
}

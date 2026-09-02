package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filepath;

	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        Set<String> symptomKeys = symptoms.keySet();
        try (FileWriter writer = new FileWriter(filepath)) {

            for (String symptom : symptomKeys) {
                Integer nombreSymptome = symptoms.get(symptom);
                writer.write(symptom + ": " + nombreSymptome + "\n");
            }

        } catch (IOException e) {
            System.out.println("une erreur est survenue avec le fichier");
        }

    }
}

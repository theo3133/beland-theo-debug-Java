package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Écrit dans un fichier texte les symptômes et leur nombre d'occurrences.
 * Chaque association est enregistrée sur une ligne distincte.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filePath;

	/**
	 * Crée un rédacteur pour le fichier de destination indiqué.
	 *
	 * @param filePath chemin absolu ou relatif du fichier de sortie
	 */
	public WriteSymptomDataToFile (String filePath) {
		this.filePath = filePath;
	}

    /**
     * Écrit chaque symptôme et sa quantité dans le fichier configuré, au format
     * {@code symptôme: quantité}.
     *
     * @param symptoms association entre les symptômes et leurs quantités
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        Set<String> symptomKeys = symptoms.keySet();
        try (FileWriter writer = new FileWriter(filePath)) {

            for (String symptom : symptomKeys) {
                Integer nombreSymptome = symptoms.get(symptom);
                writer.write(symptom + ": " + nombreSymptome + "\n");
            }

        } catch (IOException e) {
            System.out.println("une erreur est survenue avec le fichier");
        }

    }
}

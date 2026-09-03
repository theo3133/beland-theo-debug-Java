package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Point d'entrée de l'application d'analyse des symptômes.
 */
public class Main {
    /**
     * Lance la lecture, le comptage, le tri puis l'écriture des symptômes.
     *
     * @param args arguments transmis au lancement de l'application ; ils ne sont
     *             pas utilisés
     */
    public static void main(String[] args) {
        ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomDataToFile write = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(read, write);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        analyticsCounter.writeSymptoms(sortymptoms);

    }
}

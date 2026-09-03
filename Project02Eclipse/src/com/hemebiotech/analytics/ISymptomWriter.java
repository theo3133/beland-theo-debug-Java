package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Définit le contrat d'un composant capable d'écrire les symptômes comptés
 * dans une destination.
 */
public interface ISymptomWriter {

    /**
     * Écrit chaque symptôme avec son nombre d'occurrences.
     *
     * @param symptoms association entre les symptômes et leurs quantités
     */
    public void writeSymptoms(Map<String, Integer> symptoms) ;
    
}

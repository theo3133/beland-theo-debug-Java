package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
	/**
	 * Récupère tous les symptômes disponibles dans la source de données.
	 *
	 * @return la liste brute des symptômes, ou une liste vide si aucune donnée
	 *         n'est disponible
	 */
	List<String> getSymptoms();
}

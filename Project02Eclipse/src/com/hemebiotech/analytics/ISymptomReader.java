package com.hemebiotech.analytics;

import java.util.List;

/**
 * Définit le contrat d'un composant capable de lire des symptômes depuis une
 * source de données.
 * Les symptômes sont retournés sous forme de liste brute, sans obligation de
 * tri et avec d'éventuels doublons.
 */
public interface ISymptomReader {
	/**
	 * Récupère tous les symptômes disponibles dans la source de données.
	 *
	 * @return la liste brute des symptômes, ou une liste vide si aucune donnée
	 *         n'est disponible
	 */
	List<String> getSymptoms();
}

package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lit une liste de symptômes depuis un fichier texte contenant un symptôme par
 * ligne.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	/**
	 * Crée un lecteur pour le fichier indiqué.
	 *
	 * @param filePath chemin absolu ou relatif du fichier contenant les symptômes
	 */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Lit toutes les lignes du fichier configuré et les retourne sans les trier
	 * ni supprimer les doublons.
	 *
	 * @return la liste brute des symptômes lus, ou une liste vide si aucune
	 *         donnée ne peut être récupérée
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filePath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}

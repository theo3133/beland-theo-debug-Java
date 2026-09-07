package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Orchestre la lecture, le comptage, le tri et l'écriture des symptômes.
 * Cette classe délègue les accès aux fichiers aux implémentations de
 * {@link ISymptomReader} et {@link ISymptomWriter} qui lui sont fournies.
 */
public class AnalyticsCounter {
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	/**
	 * Crée un analyseur utilisant le lecteur et le rédacteur indiqués.
	 *
	 * @param symptomReader lecteur chargé de récupérer les symptômes
	 * @param symptomWriter rédacteur chargé d'enregistrer le résultat de l'analyse
	 */
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	/**
	 * Récupère la liste brute des symptômes auprès du lecteur configuré.
	 * La liste peut contenir plusieurs occurrences d'un même symptôme.
	 *
	 * @return la liste des symptômes lus depuis la source de données
	 */
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	/**
	 * Compte le nombre d'occurrences de chaque symptôme.
	 *
	 * @param symptoms liste brute des symptômes à compter
	 * @return une association entre chaque symptôme et son nombre d'occurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymp = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (countSymp.containsKey(symptom)) {
				countSymp.put(symptom, countSymp.get(symptom) + 1);
			} else {
				countSymp.put(symptom, 1);
			}
		}
		return countSymp;
	}

	/**
	 * Trie les symptômes par ordre alphabétique en conservant leur quantité.
	 *
	 * @param symptoms symptômes comptés à trier
	 * @return une nouvelle map dont les clés sont triées par ordre alphabétique
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> mapTriee = new TreeMap<String, Integer>(symptoms);
		return mapTriee;
	}

	/**
	 * Transmet les symptômes comptés et triés au rédacteur configuré.
	 *
	 * @param symptoms symptômes et quantités à écrire dans la destination
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}

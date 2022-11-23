package main;

import java.util.Random;

import tableau.Tableau2x;
import types.Tableau;

public class NombresPremiers {
	/**
	 * Déterminer si un entier est premier
	 * @param n : un entier à vérifier
	 * @param premiers : un tableau contenant des nombres premiers dans l'intervalle [2; n-1]
	 * @pre n >= 2
	 * @return vrai si l'entier n est premier
	 */
	public static boolean estPremier(int n, Tableau<Integer> premiers) {
		assert n >= 2;
		for(int i=0; i<(premiers.size())/2; i++) {
			if(n%premiers.get(i)==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int calculerNombresPremiers(int N, Tableau<Integer> t){
		assert N >= 2;
		for(int i=2; i<N; i++) {
			if(t.full()) return t.get(t.size()-1);
			if(estPremier(i, t)) {
				t.push_back(i);
			}
		}
		return N;
	}
	
	public static Tableau2x<Integer> remplirHasard(int nb){
		Random rand = new Random();
		Tableau2x<Integer> tableau = new Tableau2x<Integer>(nb);
		for(int i=0; i<nb; i++) {
			tableau.push_back(rand.nextInt(nb));
		}
		return tableau;
	}
	
	public static int eliminerPresents(Tableau<Integer> t1, Tableau<Integer> t2) {
		int i=0;
		int nbSupprimes = 0;
		int sizeInit = t1.size();
		while(i<t1.size()) {
			if(estPresent(t1.get(i),t2, t2.size())) {
				t1.set(i, t1.get(t1.size()-1));
				t1.pop_back();
				nbSupprimes++;
			}else {
				i+=1;
			}
		}
		return nbSupprimes;
	}

	
	/**
	 * Effectue une recherche dichotomique d'un entier dans un tableau trié
	 * @param n : un entier à chercher
	 * @param tableau : un tableau d'entier triés
	 * @param tailleTableau: la taille du tableau
	 * @return true si l'element est dans la liste, false sinon
	 */
	public static boolean estPresent(int n, Tableau<Integer> tableau, int tailleTableau) {
		int start = 0;
		int end = tailleTableau;
		while((end-start)>1) {
			int mid = (start+end)/2;
			int val = tableau.get(mid);
			if(val==n) return true;
			if(val>n) {
				end = mid;
			}else {
				start = mid;
			}
		}
		int mid = (start+end)/2;
		return (tableau.get(mid)==n);
	}
	
}

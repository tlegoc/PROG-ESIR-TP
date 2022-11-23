package main;

import java.util.Scanner;

import tableau.Block;
import tableau.Tableau2x;
import types.Tableau;
import types.Array;

public class NombresPremiers {

    public static Boolean estPremier(int n, Tableau<Integer> nombresPremiers) {
        int i = 0;
        // On verifie que la division de n par un nombre premier quelconque est
        // differente de 0
        // Si c'est le cas, alors n est premier
        while (i < nombresPremiers.size()) {
            if (n % nombresPremiers.get(i) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int calculerNombresPremiers(int n, Tableau<Integer> nombresPremiers) {
        // On commence a 2 car 1 n'est pas premier
        for (int i = 2; i <= n; i++) {
            if (estPremier(i, nombresPremiers)) {
                try {
                    nombresPremiers.push_back(i);
                } catch (Exception e) {
                    // Si on arrive a la fin de la capacite du tableau, on s'arrete.
                    return i;
                }
            }
        }

        return n;
    }

    public static Block<Integer> remplirHasard(int nb) {
        Block<Integer> tab = new Block<Integer>(nb);
        for (int i = 0; i < nb; i++) {
            tab.push_back((int) (Math.random() * nb));
        }
        return tab;
    }

    // Pour une raison inconnue la classe Block ne fonctionne pas UNIQUEMENT quand
    // j'execute ce main
    public static Tableau<Integer> remplirHasard2Test(int nb) {
        Tableau<Integer> tab = new Tableau2x<Integer>(nb);
        for (int i = 0; i < nb; i++) {
            tab.push_back((int) (Math.random() * nb));
        }
        return tab;
    }



    //
    //
    // Merci a Pol de m'avoir file ces 2 fonctions, mon cerveau etait en train d'exploser
    // Donc faites lui des gros bisous

    public static Boolean estCroissant(Tableau<Integer> tab) {
        for (int i = 0; i < tab.size() - 1; i++) {
            if (tab.get(i) > tab.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    /* 
    public static int eliminerPresents(Tableau<Integer> t1, Tableau<Integer> t2) {
        // Celle la si vous avez des questions posez les parce qu'elle est pas evidente

        //Pas oblige vuq qu'on assume que c'est deja le cas mais j'aime pas les surprises
        assert estCroissant(t2) : "t2 n'est pas croissant";

        int i = 0;
        int nbSupprimes = 0;
        while (i < t1.size()) {
            //Si l'element t1[i] est dans le tableau 2, on le supprime
            if (estPresent(t1.get(i), t2, t2.size())) {
                //Pour eviter le decalage, on prend le dernier element du tableau et on le met a la place de l'element supprime
                //On decremente la taille du tableau ensuite.
                t1.set(i, t1.get(t1.size() - 1));
                t1.pop_back();
                nbSupprimes++;
            } else {
                //Sinon on passe a la case suivante
                i++;
            }
        }

        return nbSupprimes;
    }*/

    public static int eliminerPresents(Tableau<Integer> t1, Tableau<Integer> t2) {
        // t1 est quelconque et t2 est trie par ordre croissant.
        // Eliminer les valeurs de t1 qui sont presentes dans t2 sans decaler les
        // valeurs dans t1
        // On retournera le nombre d'entiers supprimes

        int i = 0;
        int j = 0;
        int nbSupprimes = 0;

        while (i < t1.size()) {
            if (j >= t2.size()) {
                j = 0;
                i++;
            } else if (t1.get(i).equals(t2.get(j))) {
                t1.set(i, t1.get(t1.size() - 1));
                t1.pop_back();
                nbSupprimes++;
                j = 0;
            } else {
                j++;
            }
        }

        return nbSupprimes;
    }

    /**
	 * Effectue une recherche dichotomique d'un entier dans un tableau trie
	 * @param n : un entier a chercher
	 * @param tableau : un tableau d'entier tries
	 * @param tailleTableau: la taille du tableau
	 * @return true si l'element est dans la liste, false sinon
	 */
    public static boolean estPresent(int n, Tableau<Integer> tableau, int tailleTableau) {
        int start = 0;
        int end = tailleTableau;
        while ((end - start) > 1) {
            int mid = (start + end) / 2;
            int val = tableau.get(mid);
            if (val == n)
                return true;
            if (val > n) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int mid = (start + end) / 2;
        return (tableau.get(mid) == n);
    }
}

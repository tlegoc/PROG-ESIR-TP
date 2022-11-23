package rationnel;

import types.Rationnel;
import util.Couple;
import util.Outils;

public class RationnelCouple implements Rationnel {

    private Couple<Integer, Integer> valeurs;

    // Constructeur qui prend en entier un numérateur et dénominateur
    public RationnelCouple(int num, int den) {
        // Vérifie que le dénominateur est différent de 0
        assert den != 0 : "ERREUR d'appel : dénominateur nul";

        // On crée un couple avec le numérateur et le dénominateur
        this.valeurs = new Couple<Integer, Integer>(0, 0);

        // Si le numérateur est différent de 0
        if (num != 0) {
            // On utilise le pgcd pour réduire la fraction
            int pgcd = Outils.pgcd(Math.abs(num), Math.abs(den));
            this.valeurs.setFirst(num / pgcd);
            this.valeurs.setSecond(den / pgcd);
            // On inverse le signe si le dénominateur est négatif, c'est plus propre d'avoir
            // le numérateur négatif
            if (this.valeurs.getSecond() < 0) {
                this.valeurs.setFirst(-this.valeurs.getFirst());
                this.valeurs.setSecond(-this.valeurs.getSecond());
            }
        } else {
            // Si le numérateur est égal à 0, on met le dénominateur à 1, ça simplifie les
            // calculs
            this.valeurs.setFirst(0);
            this.valeurs.setSecond(1);
        }
    }

    public RationnelCouple(int num) {
        // petit tips, si tu fais ça c'est comme si tu faisais new RationnelCouple(num,
        // 1)
        this(num, 1);
    }

    public RationnelCouple(Rationnel r) {
        // De même
        this(r.getNumerateur(), r.getDenominateur());
    }

    public boolean equals(Rationnel r) {
        // Tu compare ce rationnel (this) et l'autre rationnel (r)
        // == compare les valeurs
        return this.getNumerateur() == r.getNumerateur() && this.getDenominateur() == r.getDenominateur();
    }

    public Rationnel somme(Rationnel r) {
        // Comme quand tu fais la somme de deux fractions à la main, sauf qu'en plus
        // On utilise new RationnelCouple, qui va nous simplifier tout seul les
        // fractions
        return new RationnelCouple(
                this.getNumerateur() * r.getDenominateur() + r.getNumerateur() * this.getDenominateur(),
                this.getDenominateur() * r.getDenominateur());
    }

    public Rationnel inverse() {
        // Pas besoin d'expliquer je pense
        assert this.getNumerateur() != 0 : "ERREUR d'appel : numérateur nul";
        return new RationnelCouple(this.getDenominateur(), this.getNumerateur());
    }

    public double valeur() {
        // On retourne la valeur du rationnel
        // Tu divise le numérateur par le dénominateur, et tu le cast en double en
        // faisant (double) ton_calcul
        // Si tu le fais pas ça peut faire des erreurs de calculs
        return (double) this.getNumerateur() / this.getDenominateur();
    }

    public int getNumerateur() {
        return this.valeurs.getFirst();
    }

    public int getDenominateur() {
        return this.valeurs.getSecond();
    }

    public int compareTo(Rationnel r) {
        // C'est littéralement une soustraction
        return this.getNumerateur() * r.getDenominateur() - r.getNumerateur() * this.getDenominateur();
    }

    public String toString() {
        /*
         * on aurait pu écrire ça comme ça
         * if (this.getDenominateur() == 1) {
         * return this.getNumerateur() + "";
         * } else {
         * return this.getNumerateur() + "/" + this.getDenominateur();
         * }
         * 
         * ça permet de pas afficher le dénominateur si il est égal à 1, mais c'est pas
         * obligatoire
         */
        return this.getNumerateur() + (this.getDenominateur() != 1 ? "/" + this.getDenominateur() : "");
    }
}

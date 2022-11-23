package rationnel;

import types.Rationnel;
import util.Outils;

public class RationnelSimple implements Rationnel {

    private int num;
    private int den;
    
    /*
     * C'est le même code que RationnelCouple sans l'utilisation de couple
     * à la place on utilise deux variables num et den
     */

    public RationnelSimple(int num, int den) {
        //Vérifie que le dénominateur est différent de 0
        assert den != 0 : "ERREUR d'appel : dénominateur nul";
        if (num != 0) {
            int pgcd = Outils.pgcd(Math.abs(num), Math.abs(den));
            this.num = num / pgcd;
            this.den = den / pgcd;
            if (this.den < 0) {
                this.num = -this.num;
                this.den = -this.den;
            }
        } else {
            this.num = 0;
            this.den = 1;
        }
    }

    public RationnelSimple(int num) {
        this(num, 1);
    }

    public RationnelSimple(Rationnel r) {
        this(r.getNumerateur(), r.getDenominateur());
    }

    public boolean equals(Rationnel r) {
        return this.num == r.getNumerateur() && this.den == r.getDenominateur();
    }

    public Rationnel somme(Rationnel r) {
        return new RationnelSimple(this.num * r.getDenominateur() + r.getNumerateur() * this.den, this.den * r.getDenominateur());
    }

    public Rationnel inverse() {
        assert this.num != 0 : "ERREUR d'appel : numérateur nul";
        return new RationnelSimple(this.den, this.num);
    }

    public double valeur() {
        return (double) this.num / this.den;
    }

    public int getNumerateur() {
        return this.num;
    }

    public int getDenominateur() {
        return this.den;
    }

    public int compareTo(Rationnel r) {
        return this.num * r.getDenominateur() - r.getNumerateur() * this.den;
    }

    public String toString() {
        return this.num + (this.den != 1 ? "/" + this.den : "");
    }
}

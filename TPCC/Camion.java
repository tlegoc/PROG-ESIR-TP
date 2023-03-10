public abstract class Camion extends Vehicule {
    
    protected double palierMin80;
    protected double palierMin90;
    protected double palierMax90;
    protected double palierMax110;



    public Camion(String immatriculation) {
        super(immatriculation);
    }

    // On peut faire plus simple
    // public abstract double calculerVitesseMax();
    // Puis on modifie le calcul dans chaque camion.
    public double calculerVitesseMax() {
        if (this.charge == 0) return 130;
        else if (this.charge <= palierMax110) return 110;
        else if (this.charge > palierMin90 && this.charge <= palierMax90) return 90;
        else return 80; //On pourrais mettre if (this.charge > palierMin80)
    }

    public double getPoidsTotal() {
        return getPoidsVide() + charge;
    }

    public void ajouterCharge(double ch) {
        if (charge + ch <= chargeMax) {
            charge += ch;
        } else {
            throw new IllegalArgumentException("Charge trop importante");
        }
    }
}

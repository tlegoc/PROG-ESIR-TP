public abstract class Vehicule implements IVehicule {
    
    protected String immatriculation;
    protected double poidsVide;
    protected double chargeMax;
    protected double charge;

    public Vehicule(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public String getImmatriculation() {
        return immatriculation;
    }
    
    public double getPoidsVide() {
        return poidsVide;
    }

    // Question 7
    public double getConsommation(double v) {
        return Outils.consommation(getPoidsTotal(), v);
    }

    public abstract double getPoidsTotal();
    public abstract double calculerVitesseMax();
    public abstract void ajouterCharge(double ch);
}

public interface IVehicule {
    public String getImmatriculation();
    public double getPoidsVide();
    public double getPoidsTotal();
    public double calculerVitesseMax();

    // Ajouter la charge ch
    // @post la charge finale ne doit pas dépasser la charge maximale
    public void ajouterCharge(double ch);
}
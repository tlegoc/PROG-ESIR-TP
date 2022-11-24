package v2;

public abstract class Vehicule implements IVehicule {
    

    private int longueur;
    protected int passagers;
    protected String immatriculation;

    public Vehicule(String immatriculation, int passagers, int longueur) {
        this.immatriculation = immatriculation;
        this.passagers = passagers;
        this.longueur = longueur;
    }

    @Override
    public int getPassagers() {
        return passagers;
    }

    @Override
    public int getLongueur() {
        return longueur;
    }

    @Override
    public String getImmatriculation() {
        return immatriculation;
    }

    @Override
    public abstract float calculerTarif();

    @Override
    public abstract String toString();

    @Override
    public abstract IVehicule clone();

    @Override
    public int compareTo(IVehicule o) {
        return this.getLongueur() - o.getLongueur();
    }

}

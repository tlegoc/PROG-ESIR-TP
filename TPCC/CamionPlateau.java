public class CamionPlateau extends Camion {
 
    public CamionPlateau(String immatriculation) {
        super (immatriculation);

        this.poidsVide = 35000;
        this.chargeMax = 20000;
        this.palierMin80 = 7000;
        this.palierMax90 = 7000;
        this.palierMin90 = 3000;
        this.palierMax110 = 3000;
    }
}

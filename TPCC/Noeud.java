public class Noeud {
    public Noeud gauche;
    public Noeud droit;
    public int valeur;

    public Noeud(int valeur) {
        this.valeur = valeur;
    }

    public static void invertArbre(Noeud n) {
        if (n == null) {
            return;
        }

        switch (n.valeur) {
            case 0:
                n.valeur = 1;
                break;
            case 1:
                n.valeur = 0;
                break;
            default:
                break;
        }

        Noeud.invertArbre(n.gauche);
        Noeud.invertArbre(n.droit);
    }

    public static int pixelsAllumes(Noeud n, int profondeur) {
        if (n == null) {
            return 0;
        }

        int pixelsAllumes = 0;
        if (n.valeur == 1) {
            pixelsAllumes += Math.pow(2, 8-profondeur);
        }

        pixelsAllumes += Noeud.pixelsAllumes(n.gauche, profondeur + 1);
        pixelsAllumes += Noeud.pixelsAllumes(n.droit, profondeur + 1);

        return pixelsAllumes;
    }
}

package v1;



//C'est ici que j'ecris mon main, mais vous le faites ou vous voulez
public class Test {
    public static void main(String[] args) {
        Ferry ferry = new Ferry(100, 100);

        IVehicule v;


        //Je choisis un vehicule aleatoirement
        //Math.random() renvoie un flottant entre 0 et 1
        //Vous voyez ensuite comment selectionner a partir de ça
        do {
            double r = Math.random();
            if (r < 1.0 / 4.0)
                v = new Auto("AA-123-AA", 2, false);
            else if (r < 2.0 / 4.0)
                v = new Ambulance("CC-123-CC", 2, false);
            else if (r < 3.0 / 4.0)
                v = new Cycle("CY-123-CY");
            else
                v = new Bus("BB-123-BB", 10, (int) (Math.random() * 18 + 2));
        } while (ferry.ajouter(v));
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^
        //ferry.ajouter() renvoie vrai si le vehicule a ete ajoute
        //Dans ce cas si le vehicule ne peut pas, cela veut dire que le ferry est plein.
        //On sort donc de la boucle
        //Le do while permet de faire au moins une fois la boucle
        //Sinon j'aurai du executer le code une fois avant la boucle
        
        ferry.trier();
        System.out.println(ferry);
        System.out.println(ferry.calculerTarif() + "€");
    }
}

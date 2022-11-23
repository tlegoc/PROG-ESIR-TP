package util;

import rationnel.RationnelSimple;
import rationnel.RationnelCouple;
import types.Rationnel;

import java.util.Scanner;

public class ClientRationnel {
    public static Rationnel lireRationnel(Scanner input) {
        // Lis un rationnel depuis l'entrée standard
        System.out.print("Entrez le numérateur : ");

        //input.nextInt() lis un entier depuis la console
        int num = input.nextInt();

        System.out.print("Entrez le dénominateur : ");
        int den = input.nextInt();

        //on utilise cette fonction pour créer un rationnel de type aléatoire, cf plus bas
        return makeRationnel(num, den);
    }

    public static void main(String[] args) {

        //On créé deux rationnels de valeur 0, pour éviter que les comparaisons foirent
        //Si on ne fait pas ça le programme crashe
        Rationnel lastRationnel = makeRationnel(0, 1);
        Rationnel currentRationnel = makeRationnel(0, 1);

        // Le tableau est de taille 0 car on modifie sa taille pour être sûr d'avoir la
        // place de stocker les rationnels
        Rationnel[] rationnels = new Rationnel[0];

        //ne s'arrête pas tant qu'on a pas utilisé break;
        while (true) {
            //lastRationnel et currentRationnel sont échangés, currentRationnel doit logiquement contenir l'ancien maintenant
            lastRationnel = currentRationnel;

            //on lit un rationnel depuis l'entrée standard
            currentRationnel = lireRationnel(new Scanner(System.in));
        
            // Vérifie que le rationnel est différent de 0
            // Si il est égal à zéro, quitte
            if (currentRationnel.valeur() == 0) {
                System.out.println("Le rationnel est égal à zéro, fin du programme");
                //Quite la boucle while
                break;
            }


            // Sinon écris dans la console le rationnel lu au format:
            // courant = 2/3 ; 2/3 + 0 = 2/3 ; inverse = 3/2 ; valeur = 0.6666666666666666 ;
            // 2/3 > 0 ; 2/3 != 0
            //C'est une purge, vraiment essaie pas de comprendre j'aurai pu le faire plus simplement mais je voulais flex
            System.out.print("courant = " + currentRationnel + " ; ");
            System.out.print(
                    currentRationnel + " + " + lastRationnel + " = " + currentRationnel.somme(lastRationnel) + " ; ");
            System.out.print("inverse = " + currentRationnel.inverse() + " ; ");
            System.out.print("valeur = " + currentRationnel.valeur() + " ; ");
            System.out.println((currentRationnel.equals(lastRationnel)
                    ? currentRationnel + " = " + lastRationnel + " ; " + currentRationnel + " = " + lastRationnel
                    : (currentRationnel.compareTo(lastRationnel) > 0 ? currentRationnel + " > " + lastRationnel
                            : currentRationnel + " < " + lastRationnel) + " ; " + currentRationnel + " != "
                            + lastRationnel));


            // On ajoute une case au tableau en créant une copie temporaire
            Rationnel[] temp = new Rationnel[rationnels.length + 1];
            //On copie les valeurs dans le tableau temporaire, qui normalement fait une case de plus
            for (int i = 0; i < rationnels.length; i++)
                temp[i] = rationnels[i];
            // On modifie le tableau original avec le nouveau plus grand
            rationnels = temp;

            // On ajoute le nouveau rationnel dans rationnels
            //la fonction le place de façon à ce que le tableau soit trié
            insererRationnel(currentRationnel, rationnels, rationnels.length);

            //On affiche
            afficher(rationnels, rationnels.length);

            //Self explanatory
            System.out.println("Somme du tableau: ");
            System.out.println(sommeRationnels(rationnels, rationnels.length));
        }
    }

    public static Rationnel makeRationnel(int num, int den) {
        //Math.random() nous donne un nombre aléatoire entre 0 et 1, ça permet de créer un rationnel de type aléatoire
        if (Math.random() > .5) {
            System.out.println("Création d'un rationnel simple");
            return new RationnelSimple(num, den);
        } else {
            System.out.println("Création d'un rationnel couple");
            return new RationnelCouple(num, den);
        }
    }

    public static void afficher(Rationnel[] rationnels, int nb) {
        //Boucle qui affiche tous les rationnels du tableau
        for (int i = 0; i < nb && i < rationnels.length; i++) {
            System.out.println(rationnels[i] + ", valeur: " + rationnels[i].valeur());
        }
    }

    /**
     * inserer le rationnel nouveau dans le tableau les Rationnels
     * 
     * @param nouveau    : le nouveau Rationnel a inserer
     * @param rationnels : le tableau de rationnel
     * @param nb         : le nombre de rationnel dans le tableau
     */
    public static void insererRationnel(Rationnel nouveau, Rationnel[] rationnels, int nb) {
        // On ajoute le nouveau rationnel de façon à ce que le tableau soit trié
        // par ordre croissant
        int i = 0;

        // On cherche la position ou inserer le nouveau rationnel (cad au moment ou il deviens plus grand)
        while (i < nb && rationnels[i] != null && nouveau.compareTo(rationnels[i]) > 0)
            i++;

        //on décale tout
        for (int j = nb >= rationnels.length ? rationnels.length - 1 : nb; j > i; j--)
            rationnels[j] = rationnels[j - 1];

        //on insère
        rationnels[i] = nouveau;
    }

    /**
     * @param rationnels : le tableau de rationnel
     * @param nb         : le nombre de rationnel dans le tableau
     * @return la somme des rationnels du tableau
     */
    public static Rationnel sommeRationnels(Rationnel[] rationnels, int nb) {
        Rationnel somme = makeRationnel(0, 1);

        //Pour chaque rationnel dans le tableau, on ajoute la valeur du rationnel a somme
        for (int i = 0; i < nb && i < rationnels.length; i++)
            somme = somme.somme(rationnels[i]);
            
        return somme;
    }
}

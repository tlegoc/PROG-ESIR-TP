package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Un ferry transporte des vehicules
 */
public class Ferry {
  // Liste de vehicules. On pourrais faire un tableau mais il faudrait l'aggrandir
  // a chaque fois
  // Ici on peut juste faire vehicules.add() et ca marche
  List<IVehicule> vehicules;
  private int vehicleCapacity;
  private int passagerCapacity;

  // Constructeur
  public Ferry(int p_vehicleCapacity, int p_passagerCapacity) {
    this.vehicleCapacity = p_vehicleCapacity;
    this.passagerCapacity = p_passagerCapacity;
    vehicules = new ArrayList<IVehicule>();
  }

  // accesseurs
  public int getCapaLongueur() {
    return vehicleCapacity;
  }

  public int getCapaPassagers() {
    return passagerCapacity;
  }

  //La longueur est calculee en fonction des vehicules qui sont dedans
  public int getLongueur() {
    int longueur = 0;
    //Pour chaque vehicule dans la liste
    for (IVehicule iVehicule : vehicules) {
      //On ajoute sa longueur a la longueur totale
      longueur += iVehicule.getLongueur();
    }

    return longueur;
  }

  //Meme chose que pour getLongueur()
  public int getPassagers() {
    int passagers = 0;
    for (IVehicule iVehicule : vehicules) {
      passagers += iVehicule.getPassagers();
    }

    return passagers;
  }

  /**
   * ajouter un vehicule dans le ferry.
   * sans effet s'il n'y a plus de place
   * 
   * @param v : vehicule a ajouter
   * @return vrai si l'ajout a eu lieu, faux sinon
   */
  public boolean ajouter(IVehicule v) {
    if (getLongueur() + v.getLongueur() <= vehicleCapacity && getPassagers() + v.getPassagers() <= passagerCapacity) {
      vehicules.add(v.clone());
      return true;
    }

    return false;
  }

  // calculer le tarif de l'ensemble des vehicules presents dans le ferry
  public float calculerTarif() {
    //Meme calcul que getLongueur() et getPassagers()
    int tarifTotal = 0;
    for (IVehicule iVehicule : vehicules) {
      tarifTotal += iVehicule.calculerTarif();
    }

    return tarifTotal;
  }

  // representation affichable du ferry
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("\n");

    //Pour chaque vehicule on recupere la representation affichable en string
    for (IVehicule iVehicule : vehicules) {
      //On l'ajoute a notre stringbuilder via result.append(NOTRETEXTE)
      result.append(iVehicule.toString() + "\n");
    }
    //On renvoie le resultat
    //Le deleteCharAt() permet de supprimer le dernier caractere, ici un retour a la ligne
    //Pas oblige mais plus joli
    return result.deleteCharAt(result.length() - 1).toString();
  }

  //Tri
  public void trier() {
    //Pour ca on utilise la fonction Colletions.sort(MALISTE, [OPTIONEL SI TU AS IMPLEMENTE COMPARABLE]COMPARATEUR)
    //Le comparateur est une fonction lambda. Elles sont definies dans IVehiculeComparator
    Collections.sort(vehicules, IVehiculeComparator.compareLongueurCroissant());
  }
}

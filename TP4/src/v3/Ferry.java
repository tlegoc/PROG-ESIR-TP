package v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Un ferry transporte des vehicules
 */
public class Ferry {
  List<IVehicule> vehicules;
  private int vehicleCapacity;
  private int passagerCapacity;

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

  public int getLongueur() {
    int longueur = 0;
    for (IVehicule iVehicule : vehicules) {
      longueur += iVehicule.getLongueur();
    }

    return longueur;
  }

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
  public boolean ajouter(IVehicule v, Tarif t) {
    if (getLongueur() + v.getLongueur() <= vehicleCapacity && getPassagers() + v.getPassagers() <= passagerCapacity && !tarifs.containsKey(v.getImmatriculation())) {
      vehicules.add(v.clone());
      tarifs.put(v.getImmatriculation(), t);
      return true;
    }


    return false;
  }



  protected static HashMap<String, Tarif> tarifs = new HashMap<>();
  
  // calculer le tarif de l'ensemble des vehicules presents dans le ferry
  public float calculerTarif() {
    int tarifTotal = 0;
    for (IVehicule iVehicule : vehicules) {
      tarifTotal += tarifs.get(iVehicule.getImmatriculation()).calculerTarif(iVehicule);
    }

    return tarifTotal;
  }

  // representation affichable du ferry
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("\n");

    for (IVehicule iVehicule : vehicules) {
      result.append(iVehicule.toString() + "\n");
    }

    return result.deleteCharAt(result.length() - 1).toString();
  }

  public void trier() {
    Collections.sort(vehicules, IVehiculeComparator.compareMulti(IVehiculeComparator.compareTarifCroissant(tarifs), IVehiculeComparator.compareLongueurCroissant()));
  }
}

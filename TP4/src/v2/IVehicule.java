package v2;

/*
 * 
 * PAS DE CHANGEMENT
 * 
 * 
 */

import java.lang.Cloneable;

/**
 * Modèle de vehicule
 */
public interface IVehicule extends Cloneable, Comparable<IVehicule>
{
  // determiner la longueur d'un vehicule
  public int getLongueur();

  // determiner le nombre de passagers
  public int getPassagers();

  // connaître l'immatriculation
  public String getImmatriculation();

  // representation affichable
  public String toString();

  // calculer le tarif du vehicule
  public float calculerTarif();

  public IVehicule clone();

}

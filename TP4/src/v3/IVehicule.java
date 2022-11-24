package v3;

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

  public IVehicule clone();

}

import types.ABinHuffman;
import types.Couple;
import types.ListeABH;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import outilsHuffman.OutilsHuffman;

/**
 * Réalisation du codage d'un texte par la méthode de Huffman
 */

public class CodageHuffman {
  public static void main(String[] args) {
    // ------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à coder (À FAIRE)
    // ------------------------------------------------------------------------
    Scanner sc = new Scanner(System.in);
    String nomFichier = "TP3/a.txt";
    sc.close();

    // ------------------------------------------------------------------------
    // 1. Lire le texte (DONNÉ)
    // ------------------------------------------------------------------------
    char[] texte = OutilsHuffman.lireFichier(nomFichier);

    // ------------------------------------------------------------------------
    // 2. Calculer la table des fréquences des caractères (À FAIRE)
    // ------------------------------------------------------------------------
    int[] tableFrequences = calculerFrequences(texte);

    // ------------------------------------------------------------------------
    // 3. Enregistrer la table de fréquences dans le fichier de sortie (DONNÉ)
    // ------------------------------------------------------------------------
    OutilsHuffman.enregistrerTableFrequences(tableFrequences, nomFichier + ".code");

    // ------------------------------------------------------------------------
    // 4. Construire l'arbre de codage de Huffman (DONNÉ - À FAIRE)
    // ------------------------------------------------------------------------
    ABinHuffman arbreCodageHuffman = construireArbreHuffman(tableFrequences);

    // ------------------------------------------------------------------------
    // Afficher l'arbre de codage de Huffman (DÉJÀ FAIT)
    // ------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    DecodageHuffman.afficherHuffman(arbreCodageHuffman);

    // ------------------------------------------------------------------------
    // 5. Construire la table de codage associée (À FAIRE)
    // ------------------------------------------------------------------------
    String[] tablecodage = construireTableCodage(arbreCodageHuffman);

    // ------------------------------------------------------------------------
    // 5.1. afficher la table de codage (À FAIRE)
    // ------------------------------------------------------------------------
    System.out.println("Table de codage associée au texte " + nomFichier);
    afficherTableCodage(tablecodage);

    // ------------------------------------------------------------------------
    // 6. coder le texte avec l'arbre de Huffman (À FAIRE)
    // ------------------------------------------------------------------------
    StringBuilder texteCode = coderTexte(texte, tablecodage);

    // ------------------------------------------------------------------------
    // 7. enregistrer le texte codé (DONNÉ)
    // ------------------------------------------------------------------------
    OutilsHuffman.enregistrerTexteCode(texteCode, nomFichier + ".code");

    // ------------------------------------------------------------------------
    // xx. calculer et afficher les stats (À FAIRE)
    // ------------------------------------------------------------------------
    // calculer la taille du fichier non codé
    // calculer la taille du fichier codé
    long tailleFichierNonCode = (new File(nomFichier)).length();
    long tailleFichierCode = (new File(nomFichier + ".code")).length();
    // calculer le taux de compression
    double tauxCompression = (double) tailleFichierCode / tailleFichierNonCode;
    // afficher les stats
    System.out.println("Taille du fichier non codé : " + tailleFichierNonCode + " octets");
    System.out.println("Taille du fichier codé : " + tailleFichierCode + " octets");
    System.out.println("Taux de compression : " + tauxCompression);

  }

  /**
   * 2. calculer la fréquence d'apparition de chaque caractère
   * 
   * @param tcar tableau des caractères du texte
   * @return tableau de fréquence des caractères, indicé par les caractères
   */
  public static int[] calculerFrequences(char[] tcar) {
    int[] tableFrequences = new int[256];
    Arrays.fill(tableFrequences, 0);
    for (char c : tcar)
      tableFrequences[c]++;

    return tableFrequences;
  }

  /**
   * 4. construire un arbre de codage de Huffman par sélection et combinaison
   * des éléments minimaux
   * 
   * @param tableFrequences table des fréquences des caractères
   * @return arbre de codage de Huffman
   */
  public static ABinHuffman construireArbreHuffman(int[] tableFrequences) {
    ListeABH listeABH = faireListeAbinHuffman(tableFrequences);

    while (listeABH.size() > 1) {
      listeABH.sort((a, b) -> a.getValeur().deuxieme() - b.getValeur().deuxieme());
      ABinHuffman a = listeABH.getFirst();
      listeABH.remove(a);
      ABinHuffman b = listeABH.getFirst();
      listeABH.remove(b);
      ABinHuffman c = new ABinHuffman();
      c.setValeur(new Couple<>('.', a.getValeur().deuxieme() + b.getValeur().deuxieme()));
      c.setGauche(a);
      c.setDroit(b);
      listeABH.add(c);
    }

    return listeABH.get(0);
  }

  /**
   * 4.1 Faire une liste triée dont chaque élément est un arbreBinaire<br>
   * comprenant un unique sommet dont l'étiquette est un couple
   * <caractère, fréquence>, trié par fréquence croissante
   * 
   * @param tableFrequences : table des fréquences des caractères
   * @return la liste triée
   */
  private static ListeABH faireListeAbinHuffman(int[] tableFrequences) {
    ListeABH liste = new ListeABH();

    for (int i = 0; i < tableFrequences.length; i++) {
      if (tableFrequences[i] > 0) {
        ABinHuffman a = new ABinHuffman();
        a.setValeur(new Couple<Character, Integer>((char) i, tableFrequences[i]));
        liste.add(a);
      }
    }

    liste.sort((a, b) -> a.getValeur().deuxieme() - b.getValeur().deuxieme());
    return liste;
  }

  /**
   * 5. construire la table de codage correspondant à l'arbre de Huffman
   * 
   * @param abinHuff : arbre de Huffman
   * @return table de (dé)codage indicé par les caractères
   */
  public static String[] construireTableCodage(ABinHuffman abinHuff) {
    String[] table = new String[256];
    Arrays.fill(table, null);
    construireTableCodageRec(table, abinHuff, "");
    return table;
  }

  public static void construireTableCodageRec(String[] table, ABinHuffman a, String currentPath) {

    if (a.estFeuille())
      table[a.getValeur().premier()] = currentPath;
    else {
      if (a.existeGauche())
        construireTableCodageRec(table, a.filsGauche(), currentPath + "0");
      if (a.existeDroit())
        construireTableCodageRec(table, a.filsDroit(), currentPath + "1");
    }
  }

  /**
   * 5.1. Afficher la table de codage associée au texte
   * 
   * @param tablecodage : table de codage associée au texte
   */
  public static void afficherTableCodage(String[] tablecodage) {
    for (int i = 0; i < tablecodage.length; i++) {
      if (tablecodage[i] != null)
        System.out.println((char) i + " : " + tablecodage[i]);
    }
  }

  /**
   * 6. Coder un texte à l'aide de la table de codage
   * 
   * @param texte       à coder
   * @param tablecodage : table de codage associée au texte
   * @return texte codé
   */
  public static StringBuilder coderTexte(char[] texte, String[] tablecodage) {
    StringBuilder texteCode = new StringBuilder();
    for (char c : texte)
      texteCode.append(tablecodage[c]);
    return texteCode;
  }
}// CodageHuffman

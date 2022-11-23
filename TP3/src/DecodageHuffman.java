import types.ABinHuffman;

import outilsHuffman.OutilsHuffman;

/**
 * Réalisation du décodage d'un texte par la méthode de Huffman
 */

public class DecodageHuffman {
  public static void main(String[] args) {
    // ------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à décoder (À FAIRE)
    // ------------------------------------------------------------------------
    String nomFichier = "test.txt.code";

    // ------------------------------------------------------------------------
    // 1. Lire et construire la table de fréquences (DONNÉ)
    // ------------------------------------------------------------------------
    int[] tableFrequences = OutilsHuffman.lireTableFrequences(nomFichier);

    // ------------------------------------------------------------------------
    // 2. Construire l'arbre de Huffman (DONNÉ)
    // ------------------------------------------------------------------------
    ABinHuffman arbreHuffman = OutilsHuffman.construireArbreHuffman(tableFrequences);

    // ------------------------------------------------------------------------
    // 2.1 afficher l'arbre de Huffman (À FAIRE)
    // ------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    afficherHuffman(arbreHuffman);

    // ------------------------------------------------------------------------
    // 3. Lire le texte codé (DONNÉ)
    // ------------------------------------------------------------------------
    String texteCode = OutilsHuffman.lireTexteCode(nomFichier);

    // ------------------------------------------------------------------------
    // 4. Décoder le texte (À FAIRE)
    // ------------------------------------------------------------------------
    StringBuilder texteDecode = decoderTexte(texteCode, arbreHuffman);

    // ------------------------------------------------------------------------
    // 5. Enregistrer le texte décode (DONNÉ)
    // ------------------------------------------------------------------------
    System.out.println("texte décodé:\n\n" + texteDecode);
    OutilsHuffman.enregistrerTexte(texteDecode, nomFichier + ".decode");
  }

  /**
   * 4. décoder une chaîne (non vide) encodée par le codage de Huffman
   * 
   * @param texteCode    : chaîne de "0/1" à décoder
   * @param arbreHuffman : arbre de (dé)codage des caractères
   */
  public static StringBuilder decoderTexte(String texteCode, ABinHuffman arbreHuffman) {
    String texte = texteCode;
    StringBuilder texteDecode = new StringBuilder();

    ABinHuffman current = arbreHuffman;
    while (texte.length() > 0) {
      if (texte.charAt(0) == '0') {
        if (!current.existeGauche())
          throw new Error("Erreur de décodage");

        current = current.filsGauche();
        texte = texte.substring(1);
        if (current.estFeuille()) {
          texteDecode.append(current.getValeur().premier());
          current = arbreHuffman;
        }
      } else if (texte.charAt(0) == '1') {
        if (!current.existeDroit())
          throw new Error("Erreur de décodage");
          
        current = current.filsDroit();
        texte = texte.substring(1);
        if (current.estFeuille()) {
          texteDecode.append(current.getValeur().premier());
          current = arbreHuffman;
        }
      } else {
        throw new Error("Erreur de décodage");
      }
    }

    return texteDecode;
  }

  /**
   * 2.1 afficher un arbre de Huffman
   * 
   * @param a : arbre binaire de Huffman
   */
  public static void afficherHuffman(ABinHuffman a) {
    afficherHuffmanRec(a, "");
  }

  public static void afficherHuffmanRec(ABinHuffman a, String currentPath) {

    if (a.estFeuille())
      System.out.println("<" + a.getValeur() + "> : " + currentPath);
    else {
      if (a.existeGauche())
        afficherHuffmanRec(a.filsGauche(), currentPath + "0");
      if (a.existeDroit())
        afficherHuffmanRec(a.filsDroit(), currentPath + "1");
    }
  }

} // DecodageHuffman

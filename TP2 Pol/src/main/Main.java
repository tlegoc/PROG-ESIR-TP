package main;

import java.util.Scanner;

import tableau.Tableau2x;
import types.Tableau;

public class Main {
	public static void main(String[] args) {
		Tableau<Integer> tableau = new Tableau2x<Integer>(100);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier: ");
		int N = sc.nextInt();
		sc.close();
		
		int last = NombresPremiers.calculerNombresPremiers(N, tableau);
		System.out.println("Nombres premiers: "+tableau.toString());
		System.out.println("Dernier nombre testé: "+last);
		Tableau2x<Integer> rand = NombresPremiers.remplirHasard(last);
		System.out.println("Nombres aleatoires: "+rand.toString());
		int elimines = NombresPremiers.eliminerPresents(rand, tableau);
		System.out.println(elimines+" entiers premiers éliminés");
		System.out.println("Tableau de nombre aléatoires: "+rand.toString());
	}
}

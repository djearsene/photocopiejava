/*
 * Un magasin de reprographie facture : 
 * - 0,10 € les dix premières photocopies, 
 * - 0,09 € les vingt suivantes, 
 * - 0,08 € au-delà.
 * Écrivez un algorithme qui demande à l’utilisateur le nombre de photocopies effectuées 
 * et qui affiche la facture correspondante.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        // création de l'objet scanner
        Scanner sc = new Scanner(System.in);
        try {
            // Demander à l'utilisateur de saisir un nombre de photocopies
            System.out.println("Entrez le nombre de photocopies :");

            // Lire le nombre saisi au clavier
            int nombre = sc.nextInt();
            double facture = 0.0;

            // Calcul de la facture en fonction du nombre de photocopies
            if (nombre <= 10) {
                facture = nombre * 0.10;
            } else if (nombre <= 30) {
                // 10 premières à 0,10 € et les suivantes à 0,09 €
                facture = (10 * 0.10) + (nombre - 10) * 0.09;
            } else {
                // 10 premières à 0,10 €, les 20 suivantes à 0,09 €, et le reste à 0,08 €
                facture = (10 * 0.10) + (20 * 0.09) + (nombre - 30) * 0.08;
            }

            // Affichage du montant total de la facture
            System.out.println("Le montant de votre facture est de : " + facture + " €");
        } catch (InputMismatchException e) {
            // Gestion des erreurs si l'utilisateur n'entre pas un nombre entier
            System.out.println("Veuillez entrer un nombre entier.");
        } finally {
            // Fermer le scanner
            sc.close();
        }
    }
}

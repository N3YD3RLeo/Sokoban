import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecteurNiveaux {
    Scanner FichierScanner;
    Niveau niveau;

    LecteurNiveaux(String nom_fichier){
        File fichier = new File(nom_fichier);

        try {
            FichierScanner = new Scanner(fichier);
        }
        catch (FileNotFoundException e){
            System.out.println("Erreur : " + e);
            System.exit(1);
        }
    }

    int decodeCase(char c){
        switch (c){
            case('#'): // Mur
                return 6;
            case('@'): // Joeur
                return 1;
            case('+'): // Joeur sur un objectif
                return 2;
            case('$'): // Boite
                return 3;
            case('*'): // Boite sur un objectif
                return 4;
            case('.'): // Objectif
                return 5;
            case (' '): // Sol
                return 0;
        }
        return -1;
    }

    Niveau lisProchainNiveau() {

        niveau = new Niveau(100, 100);

        if (!FichierScanner.hasNextLine()) {
            return null;
        }

        String ligne = " ";
        int i = 0;
        niveau.nb_colonnes = 0;
        niveau.nb_lignes = 0;

        while(!ligne.isEmpty() && FichierScanner.hasNextLine()){
            ligne = FichierScanner.nextLine();

            if(ligne.startsWith(";")) { // est commentaire
                niveau.nom = ligne.substring(2, ligne.length());
            }
            else { // est grille
                for (int j = 0; j < ligne.length(); j++) {
                    niveau.grille[i][j] = decodeCase(ligne.charAt(j));
                }

                if (niveau.nb_colonnes < ligne.length()) {
                    niveau.nb_colonnes = ligne.length();
                }
                i++;
            }
        }

        niveau.nb_lignes = i-1;

        return niveau;
    }
}

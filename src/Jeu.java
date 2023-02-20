import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Jeu {

	Niveau niveauActuel;
	LecteurNiveaux l;
	RedacteurNiveau r;

	Jeu(){
		try {
			InputStream in = new FileInputStream("res/Niveaux/Original.txt");
			l = new LecteurNiveaux(in);
			r = new RedacteurNiveau(System.out);
		} catch (FileNotFoundException e) {
			System.err.println("ERREUR : impossible de trouver le fichier de niveaux");
			System.exit(1);
		}

	}


	boolean NiveauSuivant(){
		if ((niveauActuel = l.lisProchainNiveau()) != null){
			r.ecrisNiveau(niveauActuel);
			return true;
		}
		else {
			return false;
		}
	}
}

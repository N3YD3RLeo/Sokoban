
import Global.Configuration;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;


 class DessinNiveau extends JComponent {
	Image imgVide, imgMur, imgPousseur, imgCaisse, imgBut;
	 static final int MUR = 1;
	 static final int POUSSEUR = 2;
	 static final int CAISSE = 4;
	 static final int BUT = 8;
	Jeu j;

	public DessinNiveau(Jeu j) {
		// Chargement des images

		this.j = j;

		try {
			InputStream in;
			in = Configuration.ouvre("Images/Pousseur.png");
			// Chargement d'une image utilisable dans Swing
			imgPousseur = ImageIO.read(in);

			in = Configuration.ouvre("Images/Sol.png");
			// Chargement d'une image utilisable dans Swing
			imgVide = ImageIO.read(in);

			in = Configuration.ouvre("Images/But.png");
			// Chargement d'une image utilisable dans Swing
			imgBut = ImageIO.read(in);

			in = Configuration.ouvre("Images/Caisse.png");
			// Chargement d'une image utilisable dans Swing
			imgCaisse = ImageIO.read(in);

			in = Configuration.ouvre("Images/Mur.png");
			// Chargement d'une image utilisable dans Swing
			imgMur = ImageIO.read(in);

		} catch (FileNotFoundException e) {
			System.err.println("ERREUR : impossible de trouver le fichier" + e);
			System.exit(2);
		} catch (IOException e) {
			System.err.println("ERREUR : impossible de charger l'image" + e);
			System.exit(3);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// Graphics 2D est le vrai type de l'objet passé en paramètre
		// Le cast permet d'avoir acces a un peu plus de primitives de dessin
		Graphics2D drawable = (Graphics2D) g;

		// On reccupere quelques infos provenant de la partie JComponent
		int largeur = getSize().width;
		int hauteur = getSize().height;

		// On calcule le centre de la zone et un rayon
		Point center = new Point(largeur/2, hauteur/2);

		// On efface tout
		drawable.clearRect(0, 0, largeur, hauteur);

		// On récupère un niveau
		Niveau niveau = j.niveauActuel;

		int caseTaille = Math.min(largeur/niveau.colonnes(), hauteur/niveau.lignes());
		int x, y;

		// On affiche un niveau
		for (int colonne = 0; colonne < niveau.colonnes(); colonne++) {
			for (int ligne = 0; ligne < niveau.lignes(); ligne++) {
				x = colonne*caseTaille;
				y = ligne*caseTaille;

				drawable.drawImage(imgVide, x, y, caseTaille, caseTaille, null);

				switch (niveau.cases[ligne][colonne]){
					case (MUR):
						drawable.drawImage(imgMur, x, y, caseTaille, caseTaille, null);
						break;
					case (POUSSEUR):
						drawable.drawImage(imgPousseur, x, y, caseTaille, caseTaille, null);
						break;
					case (CAISSE):
						drawable.drawImage(imgCaisse, x, y, caseTaille, caseTaille, null);
						break;
					case (BUT):
						drawable.drawImage(imgBut, x, y, caseTaille, caseTaille, null);
						break;
					default:
						break;
				}
			}
		}
	}
}

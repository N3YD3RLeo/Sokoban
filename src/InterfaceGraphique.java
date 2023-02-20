/*
 * Sokoban - Encore une nouvelle version (à but pédagogique) du célèbre jeu
 * Copyright (C) 2018 Guillaume Huard
 *
 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).
 *
 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.
 *
 * Contact:
 *          Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */

import javax.swing.*;
import java.awt.*;

// L'interface runnable déclare une méthode run
public class InterfaceGraphique implements Runnable {
	boolean maximized;

	JFrame frame;
	Jeu j;
	InterfaceGraphique(Jeu j) {
		this.j = j;
		maximized = false;
	}

	static void demarrer(Jeu j) {
		SwingUtilities.invokeLater(new InterfaceGraphique(j));
	}

	public void toggleFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		if (maximized) {
			device.setFullScreenWindow(null);
			maximized = false;
		} else {
			device.setFullScreenWindow(frame);
			maximized = true;
		}
	}

	public void run() {
		// Creation d'une fenetre
		frame = new JFrame("Sokoban");

		// Ajout de notre composant de dessin dans la fenetre
		frame.add(new DessinNiveau(j));

		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// On fixe la taille et on démarre
//		frame.setSize(500, 300);

		toggleFullscreen();
		frame.setVisible(true);

	}
}


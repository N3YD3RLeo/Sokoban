public class Main {
    public static void main(String[] args) {
        LecteurNiveaux grille = new LecteurNiveaux("C:\\Users\\mrleo\\Desktop\\level.txt");
        RedacteurNiveau afficher = new RedacteurNiveau(System.out);

        Niveau niveau_actuel = grille.lisProchainNiveau();

        while (niveau_actuel != null){

            afficher.ecrisNiveau(niveau_actuel);

            System.out.println("Le niveau de nom '" + niveau_actuel.nom + "' et de taille (" + niveau_actuel.nb_lignes + ", " + niveau_actuel.nb_colonnes + ") à été chargé.");

            niveau_actuel = grille.lisProchainNiveau();

        }

        SequenceListe seq = new SequenceListe();
        seq.insereTete(3);
        seq.insereTete(2);
        seq.insereTete(1);
        seq.insereQueue(4);

        System.out.println(seq.toString());

        seq.extraitTete();

        System.out.println(seq.toString());

    }
}
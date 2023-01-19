public class Niveau {
    int [][] grille;
    String nom;

    int nb_lignes, nb_colonnes;

    Niveau(int ligne, int colonne){
        grille = new int[50][50];
    }

    void fixeNom(String s) {
        nom = s;
        return;
    }

    void videCase(int i, int j) {
        grille[i][j]=0;
        return;
    }

    void ajouteMur(int i, int j) {
        grille[i][j]=6;
        return;
    }

    int lignes() {
        return nb_lignes;
    }

    int colonnes() {
        return nb_colonnes;
    }

    String nom(){
        return "nom";
    }

    boolean estVide(int i, int j) {
        return grille[i][j]== 0;
    }

    boolean aMur(int i, int j) {
        return grille[i][j]== 6;
    }

    boolean aBut(int i, int j) {
        return grille[i][j]== 5;
    }

    boolean aPousseur(int i, int j) {
        return grille[i][j]== 1;
    }

    boolean aCaisse(int i, int j) {
        return grille[i][j]== 3;
    }
}

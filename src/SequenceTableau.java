public class SequenceTableau {

    int[] tableau;
    int nb_elements;

    SequenceTableau(int taille_max){
        tableau = new int[taille_max];
        nb_elements = 0;
    }

    public String toString(){

        if(estVide()){
            return "[]";
        }


        String res = "[";

        for (int i = 0; i<nb_elements-1; i++){
            res+= tableau[i] + ", ";
        }

        res += tableau[nb_elements-1] + "]";

        return res;
    }
    void insereTete(int element){
        if (estVide()){
            tableau[0] = element;
            nb_elements = 1;
            return;
        }
        try {
            for (int i = nb_elements; i > 0; i--) {
                tableau[i] = tableau[i - 1];
            }
            tableau[0] = element;
            nb_elements += 1;
        }
        catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("Erreur : " + exception);
            System.exit(1);
        }
    }

    void insereQueue(int element){
        try {
            tableau[nb_elements] = element;
            nb_elements += 1;
        }
        catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("Erreur : " + exception);
            System.exit(1);
        }
    }

    int extraitTete(){
        int res = tableau[0];
        for (int i = 1; i<nb_elements; i++){
            tableau[i-1] = tableau[i];
        }

        nb_elements--;
        return res;
    }

    boolean estVide(){
        return nb_elements==0;
    }
}

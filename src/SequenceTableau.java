public class SequenceTableau {

    int[] tableau;
    private int taille_max;
    private int deb;
    int nb_elements;

    SequenceTableau(int taille_max){
        tableau = new int[taille_max];
        this.taille_max = taille_max;
        this.nb_elements = 0;
    }

    public String toString(){

        if(estVide()){
            return "[]";
        }

        String res = "[";

        for (int i = deb; i<deb+nb_elements-1; i++){
            res+= tableau[modulo(i)] + ", ";
        }

        res += tableau[modulo(deb+nb_elements)-1] + "]";

        return res;
    }

    int atIndex(int index){
        return tableau[modulo(deb+index)];
    }

    void insereTete(int element){
        if (estVide()){
            tableau[deb] = element;
            nb_elements = 1;
            return;
        }
        deb = modulo(deb-1);
        tableau[deb] = element;
        nb_elements += 1;
    }

    private int modulo(int index){
        int res = index % taille_max;
        if (res<0){
            res+= taille_max;
        }
        return res;
    }

    void insereQueue(int element){
        tableau[modulo(deb+nb_elements)] = element;
        nb_elements += 1;
    }

    int extraitTete(){
        int res = tableau[deb];
        deb = modulo(deb+1);

        nb_elements--;
        return res;
    }

    boolean estVide(){
        return nb_elements == 0;
    }
}

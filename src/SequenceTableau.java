public class SequenceTableau {

    int[] tableau;
    int taille_max;
    private int deb;
    int taille;

    SequenceTableau(int taille_max){
        tableau = new int[taille_max];
        this.taille_max = taille_max;
        this.taille = 0;
    }

    public String toString(){

        if(estVide()){
            return "[]";
        }

        String res = "[";

        for (int i = deb; i<deb+taille-1; i++){
            res+= tableau[modulo(i)] + ", ";
        }

        res += tableau[modulo(deb+taille-1)] + "]";

        return res;
    }

    void redimensionner(){
        if (taille>=taille_max){
            //System.out.println("Redimensionner ... (" + taille + "," + taille_max*2 + ")");
            int[] nouveau_tableau = new int[taille_max*2];
            for(int i=0; i<taille; i++){
                nouveau_tableau[i]=tableau[modulo(deb+i)];
            }
            taille_max=taille_max*2;
            deb=0;
            tableau=nouveau_tableau;
        }
    }

    int atIndex(int index){
        return tableau[modulo(deb+index)];
    }

    void insereTete(int element){
        redimensionner();
        deb = modulo(deb-1);
        tableau[deb] = element;
        taille += 1;
    }

    private int modulo(int index){
        int res = index % taille_max;
        if (res<0){
            res+= taille_max;
        }
        return res;
    }

    void insereQueue(int element){
        redimensionner();
        tableau[modulo(deb+taille)] = element;
        taille += 1;
    }

    int extraitTete(){
        int res = tableau[deb];
        deb = modulo(deb+1);

        taille--;
        return res;
    }

    boolean estVide(){
        return taille == 0;
    }
}

public class SequenceListe{
    Noeud tete;

    public String toString(){
        Noeud actuel = tete;

        if (estVide()){
            return "Vide";
        }

        String res = "";

        while (actuel.suivant != null){
            res += actuel.element + "->";
            actuel = actuel.suivant;
        }
        res += actuel.element;

        return res;
    }
    void insereTete(int element){
        Noeud nouveau = new Noeud();
        nouveau.element = element;
        nouveau.suivant = tete;
        tete = nouveau;
    }

    void insereQueue(int element){
        Noeud actuel = tete;

        Noeud nouveau = new Noeud();
        nouveau.element = element;

        if (estVide()){
            tete = nouveau;
            return;
        }

        while (actuel.suivant != null){
            actuel = actuel.suivant;
        }

        actuel.suivant = nouveau;
    }

    int extraitTete(){
        int element = tete.element;
        tete = tete.suivant;
        return element;
    }

    boolean estVide(){
        return tete==null;
    }
}

class Noeud {
    int element;
    Noeud suivant;
}
import java.io.PrintStream;
import java.io.OutputStream;


public class RedacteurNiveau {
    PrintStream sortie;
    RedacteurNiveau(OutputStream out) {
        sortie = new PrintStream(out);
    }

    void ecrisNiveau(Niveau niveau){
        for (int i=0; i < niveau.lignes(); i++){
            for (int j=0; j < niveau.colonnes(); j++){
                sortie.print(codeCase(niveau.grille[i][j]));
            }
            sortie.println();
        }
    }

    char codeCase(int x){
        switch (x){
            case(6): // Mur
                return '#';
            case(1): // Joeur
                return '@';
            case(2): // Joeur sur un objectif
                return '+';
            case(3): // Boite
                return '$';
            case(4): // Boite sur un objectif
                return '*';
            case(5): // Objectif
                return '.';
            case (0): // Sol
                return ' ';
        }
        return 'X';
    }
}

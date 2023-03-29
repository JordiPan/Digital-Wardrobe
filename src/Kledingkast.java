import java.util.ArrayList;

public class Kledingkast {
    //er komt zeker nog constructor met voorgemaakte categorieen als this ding
    private ArrayList<Categorie> categorieen = new ArrayList<>();


    public Kledingkast(ArrayList<Categorie> categorieen) {
        this.categorieen = categorieen;
    }
    public ArrayList<Categorie> getCategorieen() {
        return categorieen;
    }

    //ja uhh volgens mij moet string
    public void verwijderCategorie(String gekregenCategorie) {
        for (Categorie categorie: categorieen) {
            if (categorie.getNaam().equals(gekregenCategorie)) {
                categorieen.remove(categorie);
                return;
            }
        }
    }

    public void voegToe(Categorie categorie) {
        categorieen.add(categorie);
    }

    //maakt categorie en returnt naar processor zodat de processor meteen voegToe() kan gebruiken...
    // is dit wel handig? kan het liever niet in een methode komen? schizo behaviour
    public Categorie maakCategorie(String naam) {
        return new Categorie(naam);
    }

    public boolean checkOfCategorieBestaat(String categorieNaam) {
        return false;
    }
}

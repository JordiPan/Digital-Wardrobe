import java.util.ArrayList;

public class Kledingkast {
    private ArrayList<Categorie> categorieen = new ArrayList<>();


    public Kledingkast(ArrayList<Categorie> categorieen) {
        this.categorieen = categorieen;
    }
    public ArrayList<Categorie> getCategorieen() {
        return categorieen;
    }

    public boolean verwijderCategorie(String gekregenCategorie) {
        for (Categorie categorie: categorieen) {
            if (categorie.getNaam().equals(gekregenCategorie)) {
                categorieen.remove(categorie);
                return true;
            }
        }
        return false;
    }

    public void voegToe(String categorieNaam) {
        Categorie categorie = new Categorie(categorieNaam);
        categorieen.add(categorie);
    }

    //maakt categorie en returnt naar processor zodat de processor meteen voegToe() kan gebruiken...
//    public Categorie maakCategorie(String naam) {
//        return new Categorie(naam);
//    }

    public boolean checkOfCategorieBestaat(String categorieNaam) {
        return false;
    }
}

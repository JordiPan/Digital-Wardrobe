import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CategorieTest {

    @Test
    public void categorieToevoegenTest() {
        int verwachtGrootte = 3;

        ArrayList<Categorie> categorieen = new ArrayList<>();
        Kledingkast kledingkast = new Kledingkast(categorieen);
        kledingkast.voegToe("cat1");
        kledingkast.voegToe("cat2");
        kledingkast.voegToe("cat3");

        Assertions.assertEquals(verwachtGrootte, kledingkast.getCategorieen().size());
    }

    @Test
    public void categorieVerwijderTest() {
        ArrayList<Categorie> verwacht = new ArrayList<>();
        verwacht.add(new Categorie("test1"));
        verwacht.add(new Categorie("test2"));

        ArrayList<Categorie> categorieen = new ArrayList<>();
        categorieen.add(new Categorie("test1"));
        categorieen.add(new Categorie("test2"));
        categorieen.add(new Categorie("test3"));
        Kledingkast kledingkast = new Kledingkast(categorieen);
        kledingkast.verwijderCategorie("test3");

        ArrayList<Categorie> resultaat = kledingkast.getCategorieen();

        Assertions.assertEquals(verwacht.size(),resultaat.size());
    }
}
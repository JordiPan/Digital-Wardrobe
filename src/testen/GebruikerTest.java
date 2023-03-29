import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GebruikerTest {
    @Test
    public void WachtwoordTesten() {
        Gebruiker gebruiker = new Gebruiker("test", "test", 1);
        boolean resultaat = gebruiker.checkWachtwoord("Test");

        Assertions.assertFalse(resultaat);
    }
}

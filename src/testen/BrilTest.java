import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

public class BrilTest {
    @Test
    public void testBrilDetails() {
        String verwacht = "Het is een bril. Ook is de bril niet getint met een sterkte van 4.0 en het is gemaakt door: Specsavers";

        Bril bril = new Bril("bril1", "Het is een bril.", 44.64, new Date(), false, 4.0, "Specsavers");
        String resultaat = bril.getDetails();

        Assertions.assertEquals(verwacht, resultaat);
    }
}

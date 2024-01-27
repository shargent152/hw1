import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class GuitarTester {
    @Test
    public void GuitarTest() throws IOException {
        String serialNumber = "8092835092";
        double price = 900;
        String builder = "Zepllen";
        String model = "guitar";
        String type = "bass";
        String backWood = "burdendy";
        String topWood = "blue";
        Guitar guitar = new Guitar(serialNumber,price,builder,model,type,backWood,topWood);
        assertDoesNotThrow(() -> Invertory.addGuitar(guitar.getSerialNumber(), guitar.getPrice(), guitar.getBuilder(), guitar.getModel(), guitar.getType(), guitar.backWood, guitar.topWood));
        assertEquals(Invertory.guitars.get(0),Invertory.getGuitar("8092835092"));
        assertEquals(Invertory.guitars.get(0),Invertory.searchGuitar(guitar));
    }
}

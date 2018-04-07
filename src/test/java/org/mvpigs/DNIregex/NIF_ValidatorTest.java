package org.mvpigs.DNIregex;

import org.junit.Test;

import static org.junit.Assert.*;

public class NIF_ValidatorTest {

    @Test
    public void mainDNICorrect() {
        String[]args = {"DNI","78484464T","72376173A","01817200Q","95882054E","63587725Q",
                "26861694V","21616083Q","26868974Y","40135330P","89044648X"};
        NIF_Validator.main(args);
    }
    @Test
    public void mainDNIIncorrect() {
        String[]args = {"DNI","7848446T","72376173I","01817200O","95882054Ñ","63587725U",
                "126861694V","21616083I","26868974O","401U35330","89044648a"};
        NIF_Validator.main(args);
    }
    @Test
    public void mainNIECorrect() {
        String[]args = {"NIE","Y8484464T","X2376173A","Z1817200Q","X5882054E","Y3587725Q",
                "Z6861694V","X1616083Q","Y6868974Y","Z0135330P","X9044648X"};
        NIF_Validator.main(args);
    }
    @Test
    public void mainNIEIncorrect() {
        String[]args = {"NIE","7848446T","A2376173I","B1817200Z","Y5882054Ñ","P3587725S",
                "T26861694V","X211616083X","Z26868974O","401U3533Y","y9044648A"};
        NIF_Validator.main(args);
    }

}
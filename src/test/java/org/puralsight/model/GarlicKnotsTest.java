package org.puralsight.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.puralsight.enums.PizzaSize;

import static org.junit.jupiter.api.Assertions.*;

class GarlicKnotsTest {


    private GarlicKnots garlicKnots;

    // Runs before EVERY test
    @BeforeEach
    void setUp() {
        // Arrange (setup)
        garlicKnots = new GarlicKnots();
        garlicKnots.setQuantity(10);
    }

    //Clear All every test
    @AfterEach
    void clearUp(){
        garlicKnots=null;
    }

    @Test
    void shouldCalculateTotalPriceWithQuantity() {

        // Act (run method)
        double price = garlicKnots.getTotalPrice();

        // Assert (check result)
        assertEquals(1.5 * 10, price);
    }
}
package org.puralsight.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.puralsight.enums.PizzaSize;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    private Pizza pizza;

    // Runs before EVERY test
    @BeforeEach
    void setUp() {
        // Arrange (setup)
        pizza = new Pizza();
        pizza.setPizzaSize(PizzaSize.MEDIUM);
    }

    //Clear All every test
    @AfterEach
    void clearUp(){
        pizza=null;
    }


    @Test
    void shouldCalculateTotalPizzaPriceWithQuantity() {
        pizza.setQuantity(2);
        // Act (run method)
        double price = pizza.getTotalPrice();

        // Assert (check result)
        assertEquals(24.00, price);
    }

    @Test
    void shouldCalculateBasePizzaPrice() {

        // Act (run method)
        double price = pizza.getPrice();

        // Assert (check result)
        assertEquals(12.00, price);
    }
}
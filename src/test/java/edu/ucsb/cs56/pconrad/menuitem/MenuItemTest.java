package edu.ucsb.cs56.pconrad.menuitem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;


public class MenuItemTest {

    private MenuItem smallPokeBowl;
    private MenuItem soda;

    @Before
    public void setUp() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        soda = new MenuItem("Soda", 149, "Drinks");
    }

    @Test
    public void test_getCategory_Bowl(){
	assertEquals("Poke Bowls", smallPokeBowl.getCategory());
    }

    @Test
    public void test_getCategory_Drink(){
	assertEquals("Drinks", soda.getCategory());
    }

    @Test
    public void test_getName_Bowl(){
	assertEquals("Small Poke Bowl", smallPokeBowl.getName());
    }

    @Test
    public void test_getName_Drink(){
	assertEquals("Soda", soda.getName());
    }
    
    @Test
    public void test_getPrice_Bowl(){
        assertEquals("$10.49", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_Drink(){
	assertEquals("$1.49", soda.getPrice());
    }

    @Test
    public void test_getPrice_10_Bowl() {
        assertEquals("    $10.49", smallPokeBowl.getPrice(10));
    }

    @Test
    public void test_getPrice_15_Drink(){
	assertEquals("          $1.49", soda.getPrice(15));
    }

    @Test
    public void test_getPrice_7_Bowl() {
        assertEquals(" $10.49", smallPokeBowl.getPrice(7));
    }

    @Test
    public void test_getPrice_9_Drink(){
	assertEquals("    $1.49", soda.getPrice(9));
    }

    @Test
    public void test_getPrice_6_Bowl() {
        assertEquals("$10.49", smallPokeBowl.getPrice(6));
    }

    @Test
    public void test_getPrice_20_Drink(){
	assertEquals("               $1.49", soda.getPrice(20));
    }

    @Test(expected = MenuItem.TooNarrowException.class)
    public void test_getPrice_5_Bowl() {
        smallPokeBowl.getPrice(5);
    }

    @Test(expected = MenuItem.TooNarrowException.class)
    public void test_getPrice_n1_Drink(){
	soda.getPrice(-1);
    }

    @Test(expected = MenuItem.TooNarrowException.class)
    public void test_getPrice_0_Bowl() {
        smallPokeBowl.getPrice(0);
    }

    @Test(expected = MenuItem.TooNarrowException.class)
    public void test_getPrice_1_Soda() {
        smallPokeBowl.getPrice(1);
    }
    
    @Test
    public void test_getPriceInCents_Bowl(){
	assertEquals(1049, smallPokeBowl.getPriceInCents());
    }

    @Test
    public void test_getPriceInCents_Drink(){
	assertEquals(149, soda.getPriceInCents());
    }

    @Test
    public void test_toString_Bowl(){
        assertEquals("Small Poke Bowl,1049,Poke Bowls", smallPokeBowl.toString());
    }

    @Test
    public void test_toString_Drink(){
	assertEquals("Soda,149,Drinks", soda.toString());
    }

}

package com.techelevator.view;

import com.techelevator.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest {
    @Before
    public void setTestVariables() {
        Inventory.setInventoryFile("C:\\Users\\16466\\Desktop\\meritamerica\\repos\\Capstone Projects\\capstone-1\\vendingmachine.csv");
        Inventory.restockInventory();
    }

    @Test
    public void check_if_restock_inventory_sets_variables_Test() {
        Assert.assertEquals("Potato Crisps", Inventory.getItemName().get("A1"));
        Assert.assertEquals("Chip", Inventory.getItemType().get("A1"));
        Assert.assertEquals(305.0, Inventory.getItemPrice().get("A1"), 0);
        Assert.assertEquals(5, Inventory.getItemQuantity().get("A1"), 0);
    }}


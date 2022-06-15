package com.techelevator.view;

import com.techelevator.Inventory;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {
    @Test
    public void restockInventoryTest(){

//        //ARRANGE
        Inventory inventoryTest = new Inventory();

//        //ACT
        inventoryTest.restockInventory();

//        //ASSERT
        Assert.assertEquals("Potato Crisps", inventoryTest.getItemName().get("A1"));
        Assert.assertEquals("Chip", inventoryTest.getItemType().get("A1"));
        Assert.assertEquals(3.05, inventoryTest.getItemPrice().get("A1"),0);
        Assert.assertEquals(5, inventoryTest.getItemQuantity().get("A1"),0);
    }
}

package com.techelevator.view;

import com.techelevator.Money;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MoneyTest {
    @After
    public void clean_Values (){
        Money.setCurrentAmount(0);
    }
@Test
    public void feedBillsProcessor_working_Test(){
    Money.feedBillsProcessor(1);
    Assert.assertEquals(100,Money.getCurrentAmount());
}
@Test
    public void feedBillsProcessor_reject_non_bill_values_Test (){
    Money.feedBillsProcessor(7);
    Assert.assertEquals(0,Money.getCurrentAmount());
}
@Test
public void displayCurrentAmount_working_Test(){
    Money.setCurrentAmount(500);
    Assert.assertEquals(5.0, Money.displayCurrentAmount(),0);
    Money.setCurrentAmount(0);
    Assert.assertEquals(0.0,Money.displayCurrentAmount(),0);
}
@Test
public void displayCurrentAmount_negative_Test(){
    Money.setCurrentAmount(-5);
    Assert.assertEquals(0.0,Money.displayCurrentAmount(),0);
}

@Test
    public void does_changeDivider_reset_current_amount_Test(){
    Money.setCurrentAmount(50);
    Money.changeDivider();
    Assert.assertEquals(0,Money.getCurrentAmount());
}
    @Test
    public void does_changeDivider_reset_current_amfgfgount_Test(){
        Map<Double,Integer> t = new HashMap<>();

    }
//1 $2.00 bill
//3 quarters
//2 $20.00 bills
//1 $5.00 bill
//1 $50.00 bill


//public static void changeCalculator(int amount){
//        int quantity = 0;
//        quantity = currentAmount/amount;
//        moneyCount.put((amount/100.0),quantity);
//        currentAmount-=(amount*quantity);


}

package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    private BigDecimal balance;
    private BankAccount bankAccount;
    @Before
    public void setUp(){
        this.balance = new BigDecimal("100");
        this.bankAccount = new BankAccount("bank",balance);
    }
   @Test (expected = IllegalArgumentException.class)
    public void testSetNameShouldThrowWhenNameLengthIsLessThanThreeSymbols(){

       BankAccount bankAccount = new BankAccount("ab",this.balance);
   }
   @Test (expected = IllegalArgumentException.class)
    public void testSetNameShouldThrowWhenNameLengthIsMoreThanTwentyFiveSymbols(){
       BankAccount bankAccount = new BankAccount("aaaaaaaaaaaaaaaaaaaaaaaaaaa",this.balance);
   }
   @Test (expected = IllegalArgumentException.class)
    public void testSetBalanceShouldThrowWhenBalanceIsNegative(){
        BankAccount bankAccount = new BankAccount("bank",new BigDecimal("-2"));

   }


   @Test (expected = UnsupportedOperationException.class)
    public void testDepositAmountShouldThrowWhenEqualToZero(){
        this.bankAccount.deposit(new BigDecimal("0"));

   }
    @Test (expected = UnsupportedOperationException.class)
    public void testDepositAmountShouldThrowWhenIsNegative(){
        this.bankAccount.deposit(new BigDecimal("-2"));

    }
    @Test
    public void testDepositShouldSetDepositCorrectly(){
        this.bankAccount.deposit(new BigDecimal("100"));
        Assert.assertEquals(new BigDecimal("200"),this.bankAccount.getBalance());
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testWithdrawShouldThrowWhenIsLessThanBalance(){
        this.bankAccount.withdraw(new BigDecimal("101"));
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testWithdrawShouldThrowWhenAmountIsNegative(){
        this.bankAccount.withdraw(new BigDecimal("-2"));
    }
    @Test
    public void testWithdrawShouldSetBalanceCorrectly(){
        this.bankAccount.withdraw(new BigDecimal("80"));
        Assert.assertEquals(new BigDecimal("20"),this.bankAccount.getBalance());
    }
    @Test
    public  void testWithdrawShouldReturnAmount(){
        BigDecimal withdraw = this.bankAccount.withdraw(new BigDecimal("80"));
        Assert.assertEquals(new BigDecimal("80"),withdraw);
    }
    @Test
    public void testGetNameShouldGetNameFromCurrentInstance(){
        Assert.assertEquals("bank",this.bankAccount.getName());
    }
}
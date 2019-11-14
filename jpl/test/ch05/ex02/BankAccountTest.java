package jpl.ch05.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch05.ex02.BankAccount.History;

public class BankAccountTest {

	@Test
	public void SucBankAccountList() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.deposit(10000);
		bankAccount.deposit(1000);
		History baHistory = bankAccount.getHistoryObj();
		assertThat(baHistory.next().toString(), is("0:deposit 10000"));
	}

	@Test
	public void SucKeepListSizeIsTen() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.deposit(1);
		bankAccount.deposit(2);
		bankAccount.deposit(3);
		bankAccount.deposit(4);
		bankAccount.deposit(5);
		bankAccount.withdraw(6);
		bankAccount.deposit(7);
		bankAccount.deposit(8);
		bankAccount.deposit(9);
		bankAccount.deposit(10);
		bankAccount.deposit(11);
		History baHistory = bankAccount.getHistoryObj();
		assertThat(baHistory.next().toString(), is("0:deposit 1"));
	}
}

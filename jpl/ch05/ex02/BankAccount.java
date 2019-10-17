package jpl.ch05.ex02;

import java.util.LinkedList;

// Static にすべきでない。
// p116
public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History history;

	public BankAccount() {
		this.history = new History();
	}

	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + ":" + act + " " + amount;
		}
	}

	public class History{
		private LinkedList<Action> actionHistory;
		History(){
			actionHistory = new LinkedList<Action>();
		}

		public void addAction(Action action) {
			if (actionHistory.size() > 10) {
				actionHistory.pollFirst();
			}
			actionHistory.add(action);
		}

		public Action next() {
			return actionHistory.poll();
		}
	}

	public void deposit(long amount){
		balance += amount;
		this.history.addAction(new Action("deposit", amount));
	}

	public void withdraw(long amount){
		balance -= amount;
		this.history.addAction(new Action("withdraw", amount));
	}

	public History getHistoryObj() {
		return history;
	}
}

package Behavioural;

import java.util.*;

public class Client {
	
	public static void main(String args[]) {
		
		VendingMachine vendingMachine = new VendingMachine();
		
		vendingMachine.insertCash();
		vendingMachine.selectProduct();
		vendingMachine.dispenseProduct();
		
		vendingMachine.setState(new OutOfStockState());
		
		vendingMachine.insertCash();
		vendingMachine.selectProduct();
		vendingMachine.dispenseProduct();
	}
}


public interface VendingMachineState {
	void insertCash(VendingMachine vendingMachine);
	void selectProduct(VendingMachine vendingMachine);
	void dispenseProduct(VendingMachine vendingMachine);
}

class IdealState implements VendingMachineState {
	
	@Override
	public void insertCash(VendingMachine vendingMachine) {
		System.out.println("Cash inserted. Select a product");
		vendingMachine.setState(new CashInsertedState());
	}
	
	@Override
	public void selectProduct(VendingMachine vendingMachine) {
		System.out.println("Please insert Cash before selecting products");
	}
	
	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Please insert Cash");
	}
	
}

class CashInsertedState implements VendingMachineState {
	
	@Override
	public void insertCash(VendingMachine vendingMachine) {
		System.out.println("Cash Already inserted. please select products");
	}
	
	@Override
	public void selectProduct(VendingMachine vendingMachine) {
		System.out.println("Product selected");
		vendingMachine.setState(new ProductDispenseState());
	}
	
	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("please a select product");
	}
	
}


class ProductDispenseState implements VendingMachineState {
	
	@Override
	public void insertCash(VendingMachine vendingMachine) {
		System.out.println("Please wait. Currently dispensing a product.");
	}
	
	@Override
	public void selectProduct(VendingMachine vendingMachine) {
		System.out.println("Please wait. Currently dispensing a product.");
	}
	
	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Product Dispensed. Returning to idle state.");
		vendingMachine.setState(new IdealState());
	}
	
}

class OutOfStockState implements VendingMachineState {
	
	@Override
	public void insertCash(VendingMachine vendingMachine) {
		System.out.println("Out of stocks. No product available");
	}
	
	@Override
	public void selectProduct(VendingMachine vendingMachine) {
		System.out.println("Out of stocks. The product is not available");
	}
	
	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Out of stocks. Product cannot be dispensed");
	}
	
}


class VendingMachine  {
	VendingMachineState state;
	
	public VendingMachine() {
		this.state = new IdealState();
	}
	
	public void setState(VendingMachineState state) {
		this.state = state;
	}
	
	
	public void insertCash() {
		this.state.insertCash(this);
	}
	
	
	public void selectProduct() {
		this.state.selectProduct(this);
	}
	
	
	public void dispenseProduct() {
		this.state.dispenseProduct(this);
	}
	
	
}
package org.bank.BackSystem.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bank.BackSystem.control.BankSystem;
import org.bank.BackSystem.entity.Account;
import org.bank.BackSystem.entity.BonusAccount;
import org.bank.BackSystem.entity.SavingsAccount;

public class Console {
	
	public static void main(String[] args) {
		BankSystem bankSystem = new BankSystem();
		Scanner input = new Scanner(System.in);
		int option = -1;
		
		System.out.println("Welcome!");
		do {
			System.out.println("\n\n1- Register account");
			System.out.println("2- Consult balance");
			System.out.println("3- Credit");
			System.out.println("4- Debit");
			System.out.println("5- Transfer");
			System.out.println("6- Earn interest");
			System.out.println("0- Exit");
			System.out.println("-------------------------");
			System.out.print("Input the number of desired option: ");
			try {
				option = input.nextInt();
				
				switch (option) {
				case 1: {
					System.out.println("Which is the account type?");
					System.out.println("1- Normal");
					System.out.println("2- Bonus");
					System.out.println("3- Savings");
					
					int type = input.nextInt();
					
					if (type == 1) {
						System.out.print("> Input the code account (integer > 0): ");
						int code = input.nextInt();
						if (code < 0)
							System.out.println("> Invalid code! Must be higher than 0!");
						else if (bankSystem.register(code) == true)
							System.out.println("> Account registred!");
						else System.out.println("> Account already exists!");
					} else if (type == 2) {
						System.out.print("> Input the code account (integer > 0): ");
						int code = input.nextInt();

						Account newAccount = new BonusAccount(code);
						if (code < 0)
							System.out.println("> Invalid code! Must be higher than 0!");
						else if (bankSystem.register(newAccount) == true)
							System.out.println("> Account registred!");
						else System.out.println("> Account already exists!");
					} else if (type == 3) {
						System.out.print("> Input the code account (integer > 0): ");
						int code = input.nextInt();
						System.out.print("> Input initial balance (integer): ");
						double value = input.nextDouble();
						
						Account newAccount = new SavingsAccount(code);
						newAccount.setBalance(value);
						
						if (code < 0)
							System.out.println("> Invalid code! Must be higher than 0!");
						else if (bankSystem.register(newAccount) == true)
							System.out.println("> Account registred!");
						else System.out.println("> Account already exists!");
					}

					break;
				}
				case 2: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					Account account = bankSystem.getAccount(code);
					if (account != null) {
						System.out.println("> Balance: " + account.getBalance());
					} else System.out.println("> Account doesn't exist!");
					break;
				}
				case 3: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					System.out.print("> Input value to credit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.credit(code, value);
					System.out.println(message);
					break;
				}
				case 4: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					System.out.print("> Input value to debit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.debit(code, value);
					System.out.println(message);
					break;
				}
				case 5: {
					System.out.print("> Input the SOURCE account code (integer): ");
					int code_source = input.nextInt();
					System.out.print("> Input the DESTINATION account code (integer): ");
					int code_destination = input.nextInt();
					System.out.print("> Input value to debit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.transfer(code_source, code_destination, value);
					System.out.println(message);
					break;
				}
				case 6: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("> Input the interest rate ([0,100]): ");
					double ratio = Double.parseDouble(br.readLine());
					String message = bankSystem.earnInterest(code, ratio);
					System.out.println(message);
					break;
				}
				default:
					break;
				}
				
			} catch (NumberFormatException | IOException | InputMismatchException e) {
				System.out.println("[please, input a valid value]");
				input.nextLine();
			}
			
			
		} while(option != 0);
		System.out.println("Goodbye!");
		input.close();
	}
}

package com.account;

import java.util.Scanner;

public class AccountExample {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.println("<선택> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		String ano;
		String owner;
		int balance;
		
		System.out.println("---------------------------------------");
		System.out.println("계좌생성");
		System.out.println("---------------------------------------");
		System.out.print("계좌번호: ");
		ano = sc.next();
		System.out.println("계좌주: ");
		owner = sc.next();
		System.out.println("초기입금액: ");
		balance = sc.nextInt();
		
		Account account = new Account(ano, owner, balance);
		
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("---------------------------------------");
		System.out.println("계좌목록");
		System.out.println("---------------------------------------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.println(accountArray[i].getAno() + accountArray[i].getOwner() + accountArray[i].getBalance());
			} else {
				break;
			}
		}
	}

	private static void deposit() {
		String ano;
		int balance;
		
		System.out.println("---------------------------------------");
		System.out.println("예금");
		System.out.println("---------------------------------------");
		
		System.out.println("계좌번호: ");
		ano = sc.next();
		System.out.println("예금액: ");
		balance = sc.nextInt();
		
		for (int i = 0; i <accountArray.length; i++) {	
			if (accountArray[i].getAno().equals(ano)) {
				int oriBal =  accountArray[i].getBalance();
				oriBal += balance;
				accountArray[i].setBalance(oriBal);
				
				System.out.println("예금이 성공되었습니다.");
				System.out.println("이전 : " + (oriBal - balance) + " 예금 후 : " + oriBal);
				break;
			} else {
				System.out.println("해당 계좌번호는 없습니다.");
				break;
			}
			
		}
		
	}

	private static void withdraw() {
		String ano;
		int balance;
		
		System.out.println("---------------------------------------");
		System.out.println("출금");
		System.out.println("---------------------------------------");
		
		System.out.println("계좌번호: ");
		ano = sc.next();
		System.out.println("출금액: ");
		balance = sc.nextInt();
		
		for (int i = 0; i <accountArray.length; i++) {	
			int oriBal =  accountArray[i].getBalance();
			if (oriBal > balance || oriBal == balance) {
				if (accountArray[i].getAno().equals(ano)) {
					oriBal -= balance;
					accountArray[i].setBalance(oriBal);
					
					System.out.println("출금이 성공되었습니다.");
					System.out.println("이전 : " + (oriBal + balance) + " 출금 후 : " + oriBal);
					break;
				} else {
					System.out.println("해당 계좌번호는 없습니다.");
					break;
				}
			} else {
				System.out.println("계좌에 존재하는 금액을 초과하였습니다.");
				break;
			}
		}
	}
}

package com.employee;

import java.util.Scanner;

public class EmployeeSimulator {
	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("> Please introduce your department");
		
		boolean play = true;

		while(play) {
			System.out.println("1.HR | 2.SALES | 3. IT | 4. 종료");
			System.out.println("> Let me know about your depratment");

			int	dept = scn.nextInt();

			if (dept == 1) {
				Employee hr = new Hr();
				
				hr.introduceDepartment();
				hr.introduceCs();
				hr.introduceProficency();
				
				// computerskill class 추가 후 set사용
				System.out.println("----------강제set----------");
				hr.setCs(new IntermediateComputing());
				hr.introduceCs();
				
				System.out.println("-----------------------------");
			} else if (dept == 2) {
				Employee sales = new Sales();
				
				sales.introduceDepartment();
				sales.introduceCs();
				sales.introduceProficency();
				
				System.out.println("-----------------------------");
			} else if (dept == 3) {
				Employee it = new It();
				
				it.introduceDepartment();
				it.introduceCs();
				it.introduceProficency();
				
				System.out.println("-----------------------------");
			} else if (dept == 4) {
				System.out.println("Bye~ Have a good day~!");
				play = false;
			} else {
				System.out.println("You press wrong number. Try Again");
			}
			
		}
	}
	
}

package com.BMS;


import java.util.InputMismatchException;
import java.util.Scanner;

 class Menu_Driven_BMS {

    public static void main(String[] args) {
        BMS_Loader bms=new BMS_Loader();
        Scanner sc=new Scanner(System.in);
        System.out.println("******Welcome to Anonymous Bank******");
        while(true) {
            System.out.println("""
				~~~~~~Welcome to Laxmi Cheat Fund Banking Services~~~~~~
				      ----------21 din main paisa Double----------
				      
				Press 1 to open account in our bank 		:~
				Press 2 to check your account details 		:~
				Press 3 to deposit money in your account 	:~
				Press 4 to withdraw money from your account 	:~
				Press 5 to close your account 			:~
				Press 6 to exit 				:~ 
				""");
            int choice=sc.nextInt();
            while(!(choice>=0 && choice<6)) {
                System.out.println("!!Invalid choice!!\nTry Again : ");
                choice=sc.nextInt();
            }
            if(choice==0) {
                System.out.println("******!!Thank you for choosing our bank!!******");
                break;
            }else {
                try {
                    if(choice==1) {
                        bms.storeData();
                    }else if(choice==2) {
                        bms.displayData();
                    }else if(choice==3 || choice==4 || choice==5) {
                        bms.updateData(choice);
                    }
                }catch(InputMismatchException e) {
                    System.out.println("!!Invalid entry!!");
                }catch(Exception e) {
                    System.out.println(e.getMessage());
                }finally {
                    System.out.println("[1-->Main Menu],[0-->Exit]");
                    int choice1=sc.nextInt();
                    while(!(choice1==0||choice1==1)) {
                        System.out.println("!!Invalid choice!!\nTry Again : ");
                        choice1=sc.nextInt();
                    }
                    if(choice1==1) {
                        continue;
                    }else if(choice1==0) {
                        System.out.println("******!!Thank you for choosing our bank!!******");
                        break;
                    }
                }
            }
        }
    }
}

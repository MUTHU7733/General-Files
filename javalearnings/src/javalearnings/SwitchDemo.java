package javalearnings;

import java.util.Scanner;

public class SwitchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first number :");
        a=sc.nextInt();
        System.out.println("Enter your second number :");
        b=sc.nextInt();
        char operator;
        System.out.println("choose operator : +,-,*,/,%");
        operator=sc.next().charAt(0);
        switch(operator) {
        	case '+':
        		System.out.println(a+"+"+b+"="+ (a+b));
        		break;
        	case '-':
        		System.out.println(a+"-"+b+"="+ (a-b));
        		break;	
        	case '*':
        		System.out.println(a+"*"+b+"="+ (a*b));
        		break;
        	case '/':
        		System.out.println(a+"/"+b+"="+ (a/b));
        		break;	
        	case '%':
        		System.out.println(a+"%"+b+"="+ (a%b));
        		break;
        }
	
        	
	}

}

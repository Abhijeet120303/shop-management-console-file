package shop;
import java.io.IOException;
import java.util.Scanner;
import product.productManagemet;
import user.userManagement;
public class shopManagmet {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		boolean canIKeepRunnigTheprogram=true;
		
		System.out.println("Enter Username :");
		String username=sc.nextLine();
		System.out.println("Enter Password :");
		String password=sc.nextLine();
		if(!userManagement.login(username, password)) {
			System.out.println("Login Failed");
			
		}
		while(canIKeepRunnigTheprogram==true) {
			
			
			System.out.println("@@@ Welcome To Shop Management @@@");
			System.out.println("1.User Management");
			System.out.println("2.Product Management");
			System.out.println("3.Quit");
			int a=sc.nextInt();
			if(a==1) {
				userManagement.user();
			}else if(a==2) {
				productManagemet.productmanagemet();
			}else if(a==3) {
				canIKeepRunnigTheprogram=false;
				System.out.println("Program Closed");
			}
		}

	}

}

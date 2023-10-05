package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class userManagement {
	static ArrayList<user> al=new ArrayList();

	public static void user() throws IOException {
		loadData();
		Scanner sc=new Scanner(System.in);
		boolean canIKeepRunningTheProgram=true;
		while(canIKeepRunningTheProgram==true) {
			System.out.println("** Welcome To User Management **");
			System.out.println("1.Add User");
			System.out.println("2.Search User");
			System.out.println("3.Edit User");
			System.out.println("4.Delete User");
			System.out.println("5.Quit User");
			int choise=sc.nextInt();
			if(choise==1) {
				addUser();
				System.out.println("\n");
			}else if(choise==2) {
				System.out.println("Enter Name Which Want To Serach");
				sc.nextLine();
				String s=sc.next();
				serachUser(s);
			}else if(choise==3) {
				System.out.println("Enter Name Which Want To Edit");
				sc.nextLine();
				String e=sc.next();
				editUser(e);
			}else if(choise==4) {
				System.out.println("Enter Name Which Want Delete");
				sc.nextLine();
				String d=sc.nextLine();
				deleteUser(d);
			}else if(choise==5) {
				 writeData();
				canIKeepRunningTheProgram=false;
				System.out.println("Program Closed");
			}
		}

	}
	public static void addUser() {
		Scanner sc=new Scanner(System.in);
		user u=new user();
		System.out.println("Enter Username :");
		u.username=sc.next();
		System.out.println("Enter Password :");
		u.password=sc.next();
		System.out.println("Enter Salary :");
		u.sal=sc.next();
		System.out.println("Enter Role :");
		u.roal=sc.next();
		
		System.out.println("Username :"+u.username);
		System.out.println("Password :"+u.password);
		System.out.println("Salary :"+u.sal);
		System.out.println("Roal :"+u.roal);
		
		al.add(u);
	}
	public static void serachUser(String s) {
		for(user u:al) {
			if(u.username.equalsIgnoreCase(s)) {
				System.out.println("Username :"+u.username);
				System.out.println("Password :"+u.password);
				System.out.println("Salary :"+u.sal);
				System.out.println("Roal :"+u.roal);
				return;
			}
		}
		System.out.println("User Not Found");
	}
	public static void editUser(String e) {
		Scanner sc=new Scanner(System.in);
		for(user u:al) {
			if(u.username.equalsIgnoreCase(e)) {
				System.out.println("Enter Username :");
				u.username=sc.next();
				System.out.println("Enter Password :");
				u.password=sc.next();
				System.out.println("Enter Salary :");
				u.sal=sc.next();
				System.out.println("Enter Role :");
				u.roal=sc.next();
				return;
			}
		}
		System.out.println("User Not Found");
	}
	public static void deleteUser(String f) {
		Iterator<user> itr=al.iterator();
		while(itr.hasNext()) {
			user g=itr.next();
			if(g.username.equalsIgnoreCase(f)) {
				itr.remove();
				System.out.println("User "+g.username+" Has Been Deleted");
				return;
			}
		}
		System.out.println("User Not Found");
	}
	public static void writeData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\shopManagemet4\\src\\user\\user.csv");
		FileWriter fr=new FileWriter(file,false);
		BufferedWriter br=new BufferedWriter(fr);
		for(user u:al) {
			br.write(u.username+","+u.password+","+u.sal+","+u.roal+"\n");
		}
		br.close();
		fr.close();
		file=null;
	}
	public static void loadData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\shopManagemet4\\src\\user\\user.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null) {
			user u=new user();
			String[] arr=line.split(",");
			if(arr.length>3) {
				u.username=arr[0];
				u.password=arr[1];
				u.sal=arr[2];
				u.roal=arr[3];
				al.add(u);
				
			}
		}
		br.close();
		fr.close();
		file=null;
	}
	public static boolean login(String username,String password) throws IOException {
		loadData();
		Iterator<user> itr=al.iterator();
		while(itr.hasNext()) {
			user u=itr.next();
			if((u.username.equalsIgnoreCase(username)) && (u.password.equalsIgnoreCase(password))) {
				System.out.println("Login Succsful");
				return true;
			}
		}
		return false;
	}
	

}

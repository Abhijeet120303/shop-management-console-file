package product;

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

public class productManagemet {
	static ArrayList<product> al=new ArrayList();
	

	public static void productmanagemet() throws IOException {
		loadData();
		Scanner sc=new Scanner(System.in);
		boolean canIKeepRunninngTheProgram=true;
		while(canIKeepRunninngTheProgram==true) {
			System.out.println("$$$ Welcome To Shop Management $$$");
			System.out.println("1.Add Product");
			System.out.println("2.Search Product");
			System.out.println("3.Edit Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Quit Product");
			int choise=sc.nextInt();
			if(choise==1) {
				addProduct();
				System.out.println("\n");
			}else if(choise==2) {
				System.out.println("Enter name which want to search");
				sc.nextLine();
				String s=sc.next();
				searchProduct(s);
			}else if(choise==3) {
				System.out.println("Enter Name Which Want Edit");
				sc.nextLine();
				String e=sc.next();
				editUser(e);
			}else if(choise==4) {
				System.out.println("Enter Name Which Want To Delete ");
				sc.next();
				String d=sc.next();
				deleteProduct(d);	
			}else if(choise==5) {
				writeData();
				canIKeepRunninngTheProgram=false;
				System.out.println("Program Closed");
			}
		}

	}
	public static void addProduct() {
		Scanner sc=new Scanner(System.in);
		product p=new product();
		System.out.println("Enter Product Id");
		p.ID=sc.next();
		System.out.println("Enter Product name");
		p.name=sc.next();
		System.out.println("Enter Product price");
		p.price=sc.next();
		System.out.println("Enter Product quantity");
		p.quatity=sc.next();
		
		System.out.println("ID :"+p.ID);
		System.out.println("Name :"+p.name);
		System.out.println("Price :"+p.price);
		System.out.println("Quantity :"+p.quatity);
		
		al.add(p);
	}
	public static void searchProduct(String s) {
		for(product p:al) {
			if(p.name.equalsIgnoreCase(s)) {
				System.out.println("ID :"+p.ID);
				System.out.println("Name :"+p.name);
				System.out.println("Price :"+p.price);
				System.out.println("Quantity :"+p.quatity);
				return;
			}
		}
		System.out.println("Product Not Found");
	}
	public static void editUser(String e) {
		Scanner sc=new Scanner(System.in);
		for(product p:al) {
			if(p.name.equalsIgnoreCase(e)) {
				System.out.println("Enter Product Id");
				p.ID=sc.next();
				System.out.println("Enter Product name");
				p.name=sc.next();
				System.out.println("Enter Product price");
				p.price=sc.next();
				System.out.println("Enter Product quantity");
				p.quatity=sc.next();
				return;
				
			}
		}
		System.out.println("Product Not Found");
	}
	public static void deleteProduct(String d) {
		Iterator<product> itr=al.iterator();
		while(itr.hasNext()) {
			product p=itr.next();
			if(p.name.equalsIgnoreCase(d)) {
				itr.remove();
				System.out.println("Product "+p.name+" Has Been Deleted");
			}
		}
		System.out.println("Prouct Not Found");
	}
	public static void writeData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\shopManagemet4\\src\\product\\stored.csv");
		FileWriter fw=new FileWriter(file,false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(product p:al) {
			bw.write(p.ID+","+p.name+","+p.price+","+p.quatity+"\n");
		}
		bw.close();
		fw.close();
		
	}
	public static void loadData() throws IOException {
		File file=new File("C:\\Users\\Abhijeet\\eclipse-workspace\\shopManagemet4\\src\\product\\stored.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null) {
			product p=new product();
			String[] arr=line.split(",");
			if(arr.length>3) {
				p.ID=arr[0];
				p.name=arr[1];
				p.price=arr[2];
				p.quatity=arr[3];
				al.add(p);
			}
		}
		br.close();
		fr.close();
		file=null;
	}
}

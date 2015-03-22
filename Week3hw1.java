import java.io.*;
import java.util.*;
import java.util.Scanner;

class Week3hw1{
	public static void main(String[] args){
		ArrayList<String> a = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String str;
		int count = 0;
		System.out.println("Input a sentence : ");
		str = s.nextLine();		
		String[] temp = str.split(" |,|\\.|;|!|\\?");
		for(String i : temp){
			if(i.matches("[A-Za-z]+")){
				a.add(i.toLowerCase());
			}
			else if(i.matches("[0-9]+")){
				count += Integer.parseInt(i);
			}
		}
		if(count != 0){
			a.add(Integer.toString(count));
		}
		for(int i = 0; i < a.size(); i++){
			System.out.println(a.get(i));
		}
	}
}
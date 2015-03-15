import java.io.*;
import java.util.*;
import java.util.Scanner;

class Week3hw2
{
	public static void main(String[] args)
	{
		HashMap h = new HashMap();
		Scanner s = new Scanner(System.in);
		String option;
		boolean exit = false;
		
		while(true)
		{
			System.out.println("請輸入 1)新增資料 2)查詢資料 -1)離開 : ");
			option = s.next();
			switch(option)
			{
				case "1":
					try
					{
						System.out.println("請輸入學生姓名 : ");
						String t1 = s.next();
						System.out.println("請輸入學生成績 : ");
						int t2 = s.nextInt();
						h.put(t1, t2);
					}
					catch(Exception e)
					{
						System.out.println("error : " + e);
					}
					break;
				case "2":
					try
					{
						System.out.println("請輸入學生姓名 : ");
						String t3 = s.next();
						if(h.get(t3) != null)
						{
							System.out.println("學生姓名\t學生成績");
							System.out.println(t3 + "\t" + "\t" + h.get(t3));
						}
						else
						{
							System.out.println("查無資料!");
						}
					}
					catch(Exception e)
					{
						System.out.println("error : " + e);
					}
					break;
				case "-1":
					exit = true;
					break;
				default:
					System.out.println("無此選項!");
					break;
			}
			if(exit)
			{
				break;
			}
		}
	}
}
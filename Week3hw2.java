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
			System.out.println("�п�J 1)�s�W��� 2)�d�߸�� -1)���} : ");
			option = s.next();
			switch(option)
			{
				case "1":
					try
					{
						System.out.println("�п�J�ǥͩm�W : ");
						String t1 = s.next();
						System.out.println("�п�J�ǥͦ��Z : ");
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
						System.out.println("�п�J�ǥͩm�W : ");
						String t3 = s.next();
						if(h.get(t3) != null)
						{
							System.out.println("�ǥͩm�W\t�ǥͦ��Z");
							System.out.println(t3 + "\t" + "\t" + h.get(t3));
						}
						else
						{
							System.out.println("�d�L���!");
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
					System.out.println("�L���ﶵ!");
					break;
			}
			if(exit)
			{
				break;
			}
		}
	}
}
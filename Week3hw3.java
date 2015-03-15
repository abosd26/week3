import java.io.*;
import java.util.*;
import java.util.Scanner;

class Week3hw3
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		String option;
		HashMap h = new HashMap();
		boolean exit = false;
		
		fileToHash("hwtest.txt", h);
		while(true)
		{
			System.out.println("請輸入 1)新增句子 2)查詢字符出現次數 -1)存檔離開 : ");
			option = s.next();
			
			switch(option)
			{
				case "1":
					System.out.println("請輸入英文句子 : ");
					String temp1 = s.nextLine();
					temp1 = s.nextLine();
					temp1 = temp1.toLowerCase();
					String[] temp2 = temp1.split(" |,|\\.|;|!|\\?");
					for(String i : temp2)
					{
						if(h.get(i) != null)
						{
							int t = Integer.parseInt(h.get(i).toString()) + 1;
							h.put(i, t);
						}	
						else
						{
							h.put(i, 1);
						}
					}	
					break;
				case "2":
					System.out.println("請輸入欲查詢字符 : ");
					String temp3 = s.next();
					System.out.println("字符\t出現次數");
					if(h.get(temp3) != null)
					{
						System.out.println(temp3 + "\t" + h.get(temp3));
					}
					else
					{
						System.out.println(temp3 + "\t0");
					}
					break;
				case "-1":
					textToFile(h, "hwtest.txt", "UTF-8");
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
	public static void fileToHash(String fileName, HashMap h) throws Exception
	{
		boolean check = true;
		File f = new File(fileName);
		if(f.exists())
		{
			int length = (int)(f.length());
			FileInputStream fin = new FileInputStream(f);
			DataInputStream in = new DataInputStream(fin);
			byte[] bytes = new byte[length];
			in.readFully(bytes);
			String st = new String(bytes);
			if(!st.isEmpty())
			{
				String[] str = st.split("\t|\r\n");
				for(int i = 0; i < str.length; i++)
				{
					if(str[i] != null && str.length % 2 == 0)
					{
						try
						{
							int test = Integer.parseInt(str[i + 1]);
							h.put(str[i], str[++i]);
						}
						catch(Exception e)
						{
							check = false;
							System.out.println("檔案內容格式錯誤!");
							break;
						}
					}
					else
					{
						check = false;
						System.out.println("檔案內容格式錯誤!");
						break;
					}
				}
			}
		}
		else
		{
			check = false;
			System.out.println("檔案不存在!");
		}
		if(check)
		{
			System.out.println("讀檔成功!");
		}
	}
	public static void textToFile(HashMap h, String outFile, String pEncode) throws Exception 
	{
		FileOutputStream fos = new FileOutputStream(outFile);
		Writer writer;
		if (pEncode == null) 
		{
			writer =new OutputStreamWriter(fos);
		}
		else
		{
			writer = new OutputStreamWriter(fos, pEncode);
		}
		for(Object key : h.keySet())
		{
			writer.write(key + "\t" + h.get(key) + "\r\n");
		}
		writer.close();
		System.out.println("存檔成功!");
	}
}
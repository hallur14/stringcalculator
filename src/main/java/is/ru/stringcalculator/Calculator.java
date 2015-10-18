package is.ru.stringcalculator;

import java.util.Vector;

public class Calculator {

	public static int add(String text)
	{
	
		String splitter = ",|\n";
				
		if(text.startsWith("//["))
		{
			splitter = regex(text);
			splitter = securityCheck(splitter);
			text = text.substring(text.indexOf("\n") + 1);
        }
		else if(text.startsWith("//"))
		{
            splitter = String.valueOf(text.charAt(2));
			text = text.substring(text.indexOf("\n") + 1);	
        }
	
		if(text.equals(""))
		{
			return 0;
		}
		else if(splitter != ",|\n" || text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(splitter, text));
		}
		else
			return toInt(text);
	}
	
	private static String regex(String splitter){
		String reg = "";
		String temp = "";
		
		reg = splitter.substring(2, splitter.indexOf('\n'));
		
		for(int i = 0; i < reg.length(); i++)
		{
			if(reg.charAt(i) == '[')
			{
				for(i = ++i; i < reg.length(); i++)
				{
					if(reg.charAt(i) != ']')
					{
						temp += reg.charAt(i);	
					}
					else
					{
						temp += "|";
						break;
					}
				}
			}
		}
			reg = temp.substring(0, temp.length() - 1);
			//System.out.println("Regex1:");
			//System.out.println(reg);
			return reg;
		}
	
	private static String securityCheck(String splitter){
		
		String newReg = "";
		
		if(splitter.contains("|"))
		{
			for(int i = 0; i < splitter.length(); i++)
			{
				if(splitter.charAt(i) == '|')
				{
					newReg += splitter.charAt(i);
				}
				else
				{
					newReg += "//";
					newReg += splitter.charAt(i);
				}
			}
		}
		else
		{
			newReg = ("\\Q" + splitter + "\\E");
		}
		//System.out.println("SecurityCheck2");
		//System.out.println(newReg);
		return newReg;
	}
	
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String splitter, String numbers){
	    return numbers.split(splitter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
		int flag = 0;
		
		Vector<Integer> neg = new Vector<Integer>();
		
        for(String number : numbers)
		{
			if(toInt(number) < 0)
			{
				neg.add(toInt(number));
				flag = 1;
			}
		
			if(toInt(number) < 1001)
			{
				total += toInt(number);
			}
		}
		
		if(flag == 1)
		{
			String message = "Negatives not allowed: ";
			message += neg.elementAt(0);
			neg.remove(0);
			
			for(int i = 0; i < neg.size(); i++)
			{
				message += ",";
				message += neg.elementAt(i);
			}
			
			throw new RuntimeException(message);
		}
		
		return total;
    }
}
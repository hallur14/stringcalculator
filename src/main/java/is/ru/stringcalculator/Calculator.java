package is.ru.stringcalculator;

import java.util.Vector;

public class Calculator {

	public static int add(String text){
	
		String splitter = ",|\n";
	
		if(text.startsWith("//")){
            splitter = String.valueOf(text.charAt(2));
			text = text.substring(text.indexOf("\n") + 1);	
        }
	
		if(text.equals("")){
			return 0;
		}
		else if(splitter != ",|\n" || text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(splitter, text));
		}
		else
			return toInt(text);
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
		
        for(String number : numbers){
			if(toInt(number) < 0){
				neg.add(toInt(number));
				flag = 1;
			}
		
			if(toInt(number) < 1001){
				total += toInt(number);
			}
		}
		
		if(flag == 1)
		{
			String message = "Negatives not allowed: ";
			message += neg.elementAt(0);
			neg.remove(0);
			
			for(int i = 0; i < neg.size(); i++){
				message += ",";
				message += neg.elementAt(i);
			}
			
			throw new RuntimeException(message);
		}
		
		return total;
    }



}
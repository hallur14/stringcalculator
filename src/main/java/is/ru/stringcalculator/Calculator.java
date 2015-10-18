package is.ru.stringcalculator;

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
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
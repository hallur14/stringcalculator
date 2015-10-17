package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(",|\n", text));
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
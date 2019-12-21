package proga;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyTurn {
	private static final char[] VALID_CHARACTERS = new char[] { 'а', 'б', 'в',
		      'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
		      'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'щ', 'э', 'ю', '€' }; 

	private int playerNumber;
	private Scanner scanner;
	private Character playerWordLastChar;
	private HashSet<String> words;
	public String MakeTurn(String receiveWord) {
		playerWordLastChar = receiveWord.charAt(receiveWord.length() - 1);
		boolean right = false;
		String word = "";
		while(!right) {
			word = scanner.nextLine();
			if (word.isEmpty()) {
			      
			      System.out.println("¬ведите слово!");
			      continue;
			    } 
			    
			    char firstChar = word.charAt(0);
			    char lastChar = word.charAt(word.length() - 1);
			    
			    if(words.contains(word)) {
			      
			      System.out.println("“акое слово уже было!");
			      continue;
			    }
			    
			    else if (playerWordLastChar != null && firstChar != playerWordLastChar) {
			      
			      System.out.println("—лово должно начинатьс€ на \"" +  playerWordLastChar +"\"");
			      continue;
			      
			    } else if (!isLastCharValid(lastChar)) {
			      
			      System.out.println("—лово не должно оканчиватьс€ на: \"" + lastChar+ "\"");
			      continue;
			      
			    } else {
			      words.add(word);
			      playerWordLastChar = lastChar;
			      right = true;
			    }
			    
		}    
		return word;
	}
	private boolean isLastCharValid(char lastChar) {
	    for (char ch : VALID_CHARACTERS) {
	      if (ch == lastChar) {
	        return true;
	      }
	    }
	    return false;
	  }
}

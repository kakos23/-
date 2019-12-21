package proga;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyTurn {
	private static final char[] VALID_CHARACTERS = new char[] { '�', '�', '�',
		      '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
		      '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�' }; 

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
			      
			      System.out.println("������� �����!");
			      continue;
			    } 
			    
			    char firstChar = word.charAt(0);
			    char lastChar = word.charAt(word.length() - 1);
			    
			    if(words.contains(word)) {
			      
			      System.out.println("����� ����� ��� ����!");
			      continue;
			    }
			    
			    else if (playerWordLastChar != null && firstChar != playerWordLastChar) {
			      
			      System.out.println("����� ������ ���������� �� \"" +  playerWordLastChar +"\"");
			      continue;
			      
			    } else if (!isLastCharValid(lastChar)) {
			      
			      System.out.println("����� �� ������ ������������ ��: \"" + lastChar+ "\"");
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

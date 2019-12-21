package wordgame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class exam {

  public static void main(String[] args) {
    new exam().run();

  }

  private static final char[] VALID_CHARACTERS = new char[] { '�', '�', '�',
      '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
      '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�' };
  
  private Set<String> words; 

  private int playerNumber;
  private Scanner scanner;
  private Character playerWordLastChar;

  public void run() {
    words =  new HashSet<String>();
    scanner = new Scanner(System.in, "cp1251");
    playerNumber = 1;
    System.out.println("���� ��������! \n������� �����!\n��� ������������� ������ ������ ������� \"ENTER\"");
    nextPlayerTurn();		
  }

  private void nextPlayerTurn() {
    System.out.println("\n��� ������ " + playerNumber + "\n");
    while (!submitTurn()) {
    }

    playerNumber = playerNumber == 1 ? 2 : 1;
    nextPlayerTurn();

  }

  private boolean submitTurn() {
    String word = scanner.nextLine();

    if (word.isEmpty()) {
      
      System.out.println("������� �����!");
      return false;
      
    } 
    
    char firstChar = word.charAt(0);
    char lastChar = word.charAt(word.length() - 1);
    boolean submit = false;
    
    if(words.contains(word)) {
      
      System.out.println("����� ����� ��� ����!");
    }
    
    else if (playerWordLastChar != null && firstChar != playerWordLastChar) {
      
      System.out.println("����� ������ ���������� �� \"" +  playerWordLastChar +"\"");
      
    } else if (!isLastCharValid(lastChar)) {
      
      System.out.println("����� �� ������ ������������ ��: \"" + lastChar+ "\"");
      
    } else {
      words.add(word);
      playerWordLastChar = lastChar;
      submit = true;
    }
    return submit;
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
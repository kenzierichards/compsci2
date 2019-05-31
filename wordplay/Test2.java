import java.util.Scanner;

public class Test2
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the number of sentences to analyze.");
    int num = keyboard.nextInt();
    String [] sentenceArray = new String [num];
    keyboard.nextLine(); //consume the enter
    int i = 1;

    while (i <= num) //fills the array
    {
      System.out.println("Please enter sentence " + i + ":");
      sentenceArray[i-1] = keyboard.nextLine();
      i++;
    }


    for (int j = 0; j <= (num - 1); j++)
    {
      String sentence = sentenceArray[j];
      Scanner keyboard2 = new Scanner(sentence);
      System.out.println(sentence);

      int wordCounter = 0;
      int totalWordLength = 0;
      String longestWord = "";

      while (keyboard2.hasNext())
      {
        String currentWord = keyboard2.next();
        wordCounter++;
        int wordLength = currentWord.length();
        totalWordLength += wordLength;

        if (wordLength > longestWord.length())
        {
          longestWord = currentWord;
        }
      }

      int avgWordLength = (totalWordLength / wordCounter);

      String msg = "The # of words in the sentence is " + wordCounter + "\n" +
        "The average word length is " + avgWordLength + "\n" +
        "The longest word is " + longestWord + "\n";

      System.out.println(msg);
    }
  }
}

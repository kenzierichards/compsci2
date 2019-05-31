import java.util.Scanner;

public class Test1{


  public static void main (String[] args)
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

    int longestLength = sentenceArray[0].length();
    String longestSentence = sentenceArray[0];

    for (int j = 0; j <= (num - 1); j++)
    {
      String currentSent = sentenceArray[j];
      int currentSentLength = currentSent.length();

      if (currentSentLength > longestLength)
      {
        longestLength = currentSentLength;
        longestSentence = currentSent;
      }
    }

    longMsg = "The longest sentence is " + longestSentence;
    return longMsg;

    int shortestLength = sentenceArray[0].length();
    String shortestSentence = sentenceArray[0];

    for (int k = 0; k <= (num-1); k++)
    {
      String currentSent = sentenceArray[k];
      int currentSentLength = currentSent.length();

      if (currentSentLength < shortestLength)
      {
        shortestLength = currentSentLength;
        shortestSentence = currentSent;
      }
    }

    System.out.println("The shortest sentence is " + shortestSentence);

  }
}

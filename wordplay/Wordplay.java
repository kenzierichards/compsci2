import java.util.Scanner;

public class Wordplay
{
  public static void main (String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the number of sentences to analyze.");
    int num = keyboard.nextInt();
    String [] sentenceArray = new String [num];
    keyboard.nextLine(); //consume the enter
    int i = 1;
    int j = 1;

    while (i <= num) //fills the array
    {
      System.out.println("Please enter sentence " + i + ":");
      sentenceArray[i-1] = keyboard.nextLine();
      i++;
    }

    System.out.println("");

    while (j <= num) //produces analysis for each sentence
    {
      String currentString = sentenceArray[j-1];

      System.out.print("Your input " + j + " was " + currentString);

      System.out.println(anadiplosisTest(currentString));
      System.out.println(alliterationTest(currentString));
      System.out.println(lipogramTestE(currentString));
      System.out.println(lipogramTestS(currentString));
      System.out.println(moreStats(currentString)); //creativity #1
      System.out.println(""); //to make output look cleaner

      j++;
    }
    //creativity #2 -- finds longest/shortest sentence from array
    System.out.println("Additional information:");
    String longestSent = longestSentence(sentenceArray);
    System.out.print("The longest sentence you entered is " + longestSent);
    System.out.println(anadiplosisTest(longestSent));
    System.out.println(alliterationTest(longestSent));
    System.out.println(lipogramTestE(longestSent));
    System.out.println(lipogramTestS(longestSent));

    System.out.println("");

    String shortestSent = shortestSentence(sentenceArray);
    System.out.print("The shortest sentence you entered is " + shortestSent);
    System.out.println(anadiplosisTest(shortestSent));
    System.out.println(alliterationTest(shortestSent));
    System.out.println(lipogramTestE(shortestSent));
    System.out.println(lipogramTestS(shortestSent));

  }

  public static String anadiplosisTest (String str)
  {
    Scanner keyboard = new Scanner(str);
    String anadiplosisMsg = "";

    while (keyboard.hasNext())
    {
      String currentWord = keyboard.next();
      Character lastChar = currentWord.charAt(currentWord.length()-1);

      if (lastChar == ';')
      {
        String previousWord = currentWord;
        String nextWord = keyboard.next();

        if (previousWord.equals(nextWord + ";"))
        {
          anadiplosisMsg = "The input is an anadiplosis.";
        }
        else
        {
          anadiplosisMsg = "The input is not an anadiplosis.";
          break;
        }
      }

    }
    return anadiplosisMsg;
  }

  public static String alliterationTest (String str)
  {
    String alliterationMsg = "";
    String alliterationString = str;
    Character initialChar = str.charAt(0);
    char initialCharLowercase = Character.toLowerCase(initialChar);

    Scanner keyboard = new Scanner(str);

    String currentWord = "";
    Boolean isAlliteration = true;

    while (keyboard.hasNext())
    {
      currentWord = keyboard.next();
      char currentChar = currentWord.charAt(0);
      char currentCharLowercase = Character.toLowerCase(currentChar);

      if (currentWord.length() > 3) //only checks words more than 3 characters
      {
        if (currentCharLowercase == initialCharLowercase)
        {
          isAlliteration = true;
        }
        else
        {
          isAlliteration = false;
        }
      }
    }

    if (isAlliteration == true)
    {
      alliterationMsg = "The input is an alliteration.";
    }
    else
    {
      alliterationMsg = "The input is not an alliteration.";
    }

    return alliterationMsg;
  }

  public static String lipogramTestE (String str)
  {
    int lipogramLength = str.length();
    char lipogramChar = 'a';
    Boolean isLipogram = true;
    String lipogramMsgE = "";

    for (int i = 0; i < lipogramLength; i++)
    {
      lipogramChar = str.charAt(i);

      if (lipogramChar == 'e')
      {
        isLipogram = false;
        break; //breaks out of the loop once an 'e' is found
      }
    }
    if (isLipogram == true)
    {
      lipogramMsgE = "The input is a lipogram avoiding 'e'.";
    }
    else
    {
      lipogramMsgE = "The input is not a lipogram avoiding 'e'.";
    }

    return lipogramMsgE;
  }

  public static String lipogramTestS (String str)
  {
    int lipogramLength = str.length();
    char lipogramChar = 'a';
    Boolean isLipogram = true;
    String lipogramMsgS = "";

    for (int i = 0; i < lipogramLength; i++)
    {
      lipogramChar = str.charAt(i);

      if (lipogramChar == 's')
      {
        isLipogram = false;
        break; //breaks out of the loop once an 's' is found
      }
    }
    if (isLipogram == true)
    {
      lipogramMsgS = "The input is a lipogram avoiding 's'.";
    }
    else
    {
      lipogramMsgS = "The input is not a lipogram avoiding 's'.";
    }

    return lipogramMsgS;
  }

  public static String longestSentence(String [] arr)
  {
    int longestLength = arr[0].length();
    String longestSentence = arr[0];

    for (int j = 0; j <= (arr.length - 1); j++)
    {
      String currentSent = arr[j];
      int currentSentLength = currentSent.length();

      if (currentSentLength > longestLength)
      {
        longestLength = currentSentLength;
        longestSentence = currentSent;
      }
    }

    return longestSentence;
  }

  public static String shortestSentence(String [] arr)
  {
    int shortestLength = arr[0].length();
    String shortestSentence = arr[0];

    for (int k = 0; k <= (arr.length - 1); k++)
    {
      String currentSent = arr[k];
      int currentSentLength = currentSent.length();

      if (currentSentLength < shortestLength)
      {
        shortestLength = currentSentLength;
        shortestSentence = currentSent;
      }
    }

    return shortestSentence;
  }

  public static String moreStats(String sent)
  {
    int wordCounter = 0;
    int totalWordLength = 0;
    String longestWord = "";
    int avgWordLength = 0;
    int wordLength = 0;

    String sentence = sent;
    Scanner keyboard2 = new Scanner(sentence);

    while (keyboard2.hasNext())
    {
      String currentWord = keyboard2.next();
      wordCounter++;
      wordLength = currentWord.length();
      totalWordLength += wordLength;

      if (wordLength > longestWord.length())
      {
        longestWord = currentWord;
      }
    }

    avgWordLength = (totalWordLength / wordCounter);
    String msg = "The # of words in the sentence is " + wordCounter + "\n" +
      "The average word length is " + avgWordLength + "\n" +
      "The longest word is " + longestWord + "\n";
    return msg;
  }
}

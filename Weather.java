import java.util.Scanner;

public class Weather
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Hello Alvin!");
    System.out.println("What's the weather today?");
    String weather = keyboard.nextLine();
    int weightLimit = 0;
    char firstChar = (weather.charAt(0));

    if (weather.equalsIgnoreCase("rainy") || (firstChar == 'r' || firstChar == 'R'))
    {
      weather = "Rainy";
      weightLimit = 15;
      System.out.println("The smallest computer you can take is " + weightLimit + " lb.");
    }
    else if (weather.equalsIgnoreCase("sunny") || (firstChar == 's' || firstChar == 'S'))
    {
      weather = "Sunny";
      weightLimit = 25;
      System.out.println("The smallest computer you can take is " + weightLimit + " lb.");
    }
    else if (weather.equalsIgnoreCase("cloudy") || (firstChar == 'c' || firstChar == 'C'))
    {
      weather = "Cloudy";
      weightLimit = 30;
      System.out.println("The smallest computer you can take is " + weightLimit + " lb.");
    }
    else
    {
      weather = "Rainy";
      weightLimit = 15;
      System.out.println("The smallest computer you can take is " + weightLimit + " lb.");
    }

    //keyboard.nextLine();

    int compWeight = 0;
    int total = 0;
    int i = 0;
    int biggest = 0;

    //do while to ensure we get at least one input from the user
    do
    {
      System.out.print("Enter the weight of the computer: ");
      compWeight = keyboard.nextInt();

      if (compWeight < weightLimit)
      {
        break;
      }

      if (compWeight > biggest)
      {
        biggest = compWeight;
      }

      total += compWeight;
      i++;
    }
    while (compWeight >= weightLimit);


    double average = (double) total / (double) i;

    //accounts for not entering in any valid input
    if (i == 0 && compWeight < weightLimit)
    {
        average = 0;
    }

    System.out.println("");

    System.out.println("Today's report:");
    System.out.println("Weather conditions: " + weather);
    System.out.println("Number of computers: " + i);
    System.out.println("Average weight: " + average + " pounds");
    System.out.println("Biggest computer: " + biggest + " pounds");

    System.out.println("See you again in Trumbower 48!");
  }
}

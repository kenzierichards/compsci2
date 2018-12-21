//Kenzie Richards
//October 16th, 2018
//Lab 4
//Creativity: Suggested publisher method, highest/lowest book output
//Sources consulted: https://beginnersbook.com/2013/12/java-string-substring-method-example/
//Known bugs: None, but I changed the truncateTitle method for all titles longer than 27 chars
//because the formatting is more even looking this way

import java.util.*;
import java.util.ArrayList;
import java.io.*;

public class Inventory
{
  public static void main(String[] args)
  {
    try
    {
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Enter file name.");
      String fileName = keyboard.next() + ".txt";

      File f = new File(fileName);
      Scanner fileScan = new Scanner(f);

      fileScan.useDelimiter("_|\\r?\\n");
      int arraySize = fileScan.nextInt();
      int i = 0;
      double total = 0;
      double highest = 0.0;
      String highestBook = "";
      double lowest = 1000; //random high value
      String lowestBook = "";

      ArrayList <Book> bookArray = new ArrayList <Book>();

      System.out.println("ISBN\t\tAUTHOR\t\tTITLE\t\t\t\tED\tPUBLISHER\t\t QUANT\t\t PRICE\t\tTOTAL");

      while (fileScan.hasNext())
      {
        String ISBN = fileScan.next();

        String author = fileScan.next();

        String title = fileScan.next();

        String edition = fileScan.next();

        String publisher = fileScan.next();

        int quantity = fileScan.nextInt();

        double price = fileScan.nextDouble();

        if (price > highest)
        {
          highest = price;
          highestBook = title;
        }

        if (price < lowest)
        {
          lowest = price;
          lowestBook = title;
        }

        total += price;

        bookArray.add(new Book(ISBN, author, title, edition, publisher, quantity, price));
        System.out.println(bookArray.get(i));

        i++;
      }

      double average = total/(i+1);

      System.out.println("\nTotal books:" + (i+1));
      String avgString = String.format("Average price: $%.2f", average);
      System.out.println(avgString);
      String highestBookString = String.format("Most expensive book: %s - $%.2f", highestBook, highest);
      System.out.println(highestBookString);
      String lowestBookString = String.format("Least expensive book: %s - $%.2f", lowestBook, lowest);
      System.out.println(lowestBookString);
    }
    catch (IOException e)
    {
      System.out.println("Fail");
      System.out.println(e);
    }
  }
}

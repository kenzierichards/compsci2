import java.util.Scanner;
public class Book

{
  private String ISBN;
  private String author;
  private String title;
  private String edition;
  private String publisher;
  private int quantity;
  private double price;

  public Book() //constructor -- instantiates and initializes the default values of the object
  {
    ISBN = "";
    author = "";
    title = "";
    edition = "";
    publisher = "";
    quantity = 0;
    price = 0.0;
  }

  public Book(String i, String a, String t, String e, String p, int q, double pr)
  {
    ISBN = i;
    author = a;
    title = t;
    edition = e;
    publisher = p;
    quantity = q;
    price = pr;
  }

  public String truncateTitle() //returns modified string, doesn't change attribute
  {
    if (title.length() <= 14)
    {
      return title + "\t\t";
    }
    else if (title.length() > 23 && title.length() < 27)
    {
      return title;
    }
    else if (title.length() <= 27)
    {
      return title + "\t";
    }
    else
    {
      String truncTitle = title.substring(0, 26) + "...";
      return truncTitle;
    }
  }

  public String formatISBN()
  {
    String oldISBN = ISBN;
    String newISBN = "";

    newISBN = oldISBN.charAt(0) + "-" + oldISBN.substring(1, 4) +
        "-" + oldISBN.substring(4, 9) + "-" + oldISBN.charAt(9);

    return newISBN;
  }

  public String edition()
  {
    int e2 = Integer.parseInt(edition);

    if (e2 == 1)
    {
      edition = "1st";
    }
    else if (e2 == 2)
    {
      edition = "2nd";
    }
    else if (e2 == 3)
    {
      edition = "3rd";
    }
    else if (e2 > 4 && e2 <= 20)
    {
      edition = edition + "th";
    }
    else
    {
      edition = edition;
    }

    return edition;
  }

  public String getLastName()
  {
    Scanner scan = new Scanner(author);
    String first = scan.next();
    String lastName = scan.next();

    if (lastName.length() <= 7)
    {
      return lastName + "\t";
    }
    else
    {
      return lastName;
    }

  }

  public String publisher()
  {
    switch (publisher)
    {
      case "AW": publisher = "Addison Wesley\t\t";
        break;
      case "CT": publisher = "Course Technology\t";
        break;
      case "FB": publisher = "Franklin Beedle & Assoc.";
        break;
      case "HC": publisher = "Harper Collins\t\t";
        break;
      case "MH": publisher = "McGraw-Hill\t\t";
        break;
      case "OR": publisher = "O'Reilly Media, Inc\t";
        break;
      case "PH": publisher = "Prentice Hall\t\t";
        break;
      case "VI": publisher = "Vintage\t\t\t";
        break;
      default: publisher = "Unspecified\t\t";
        break;
    }
    return publisher;
  }

  public String toString()
  {
    String authorFixed = getLastName();
    String titleFixed = truncateTitle();
    String editionFixed = edition();
    String publisherFixed = publisher();

    Double total = price * quantity;

    if (price > 100)
    {
      String output = String.format("%s\t%s\t%s\t%s\t%s %d\t\t $%.2f\t$%.2f",
            formatISBN(), authorFixed, titleFixed, editionFixed, publisherFixed, quantity, price, total);
      return output;
    }
    else
    {
      String output = String.format("%s\t%s\t%s\t%s\t%s %d\t\t $%.2f\t\t$%.2f",
            formatISBN(), authorFixed, titleFixed, editionFixed, publisherFixed, quantity, price, total);

      return output;
    }
  }
}

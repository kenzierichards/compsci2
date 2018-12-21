import java.util.Scanner;
import java.util.*;

public class Multiply
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter in the first number you want to multiply:");
    int num1 = keyboard.nextInt();

    System.out.println("Enter in the second number you want to multiply:");
    int num2 = keyboard.nextInt();

    int result = multiplication(num1, num2);
    System.out.println(num1 + " * " + num2 + " = " + result);
  }

  public static int multiplication(int a, int b)
  {
    if (a == 1)
    {
      return b; //the number multiplied by 1 is itself
    }
    else
    {
      return b + multiplication(a-1, b); //repeats itself a times, adding b, until the first num becomes 1
      //i.e. does 5*4 = 4 + 4 + 4 + 4 + 4
    }
  }
}

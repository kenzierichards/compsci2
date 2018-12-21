import java.util.Scanner;

public class TesterCow{

  public static void main(String[] args)
  {
    Cow c = new Cow();
    Scanner scan = new Scanner(System.in);

    c.setName("Kenzie");
    c.setEnergy(100.0);
    c.setAge(21);

    System.out.println(c.getName());
    System.out.println(c.getEnergy());
    System.out.println(c.getAge());

    Cow c2 = new Cow("Rapunzel", 17, 19);
    System.out.println(c2.getEnergy());
  }
}

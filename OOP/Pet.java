public class Pet
{
  private String name;
  private String animal;
  private int age;

  public Pet() //default values
  {
    name = "";
    animal = "";
    age = 0;
  }

  public Pet(String n, String an, int a)
  {
    name = n;
    animal = an;
    age = a;
  }

  public static String destroy(int cat)
  {
    String temp = "";
    String objective = "Dog";

    for (int i = 0; i < cat; i++)
    {
      temp = temp + objective;
    }

    return temp;
  }

  public static void setName(String n)
  {
    name = n; //n is the variable being passed
  }

  public String getName()
  {
    return name;
  }

  public void setAge(int a)
  {
    age = a; //a is passed to this method and the age is changed
  }

  public int getAge()
  {
    return age;
  }

  public void setAnimal(String an)
  {
    animal = an;
  }

  public double getAnimal()
  {
    return animal;
  }

  public void birthday()
  {
    age++;
  }
}

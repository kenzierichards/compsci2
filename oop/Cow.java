public class Cow
{
  private String name;
  private int age;
  private double energy;

  public Cow() //constructor -- instantiates and initializes the default values of the object
  {
    name = "";
    age = 0;
    energy = 0.0;
  }

  public Cow(String n, int a, double e)
    name = n;
    age = a;
    energy = e;
  }

  public void setName(String n)
  {
    name = n; //n is the variable being passed
  }

  public String getName()
  {
    return name;
  }

  public void setAge(int a)
  {
    age = a;
  }

  public int getAge()
  {
    return age;
  }

  public void setEnergy(Double e)
  {
    e = energy;
  }

  public double getEnergy()
  {
    return energy;
  }

}

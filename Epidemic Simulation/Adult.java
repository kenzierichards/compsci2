import java.util.Random;

public class Adult extends Person
{
  private int energy;
  private Random rand = new Random();

  public Adult(String n, String d, int p, int en) //adds the fields of Person
  {
    super(n, d, p); //calls the constructor of superclass to construct using Person
    energy = en;
  }

  public void setEnergy(int en)
  {
    energy = en;
  }

  public int getEnergy()
  {
    return this.energy;
  }

  public String getStatus()
  {
    double lie = rand.nextInt(1) + 0;

    if (lie > .7)
    {
      int randStatus = rand.nextInt(1) + 0;
      if (randStatus == 0) //returns a random status
      {
        return "Susceptible";
      }
      else
      {
        return "Infectious";
      }
    }
    else
    {
      return super.getStatus();
    }
  }
}

public class Person
{
  protected String name;
  private String disease_status;
  private int position;

  public Person(String n, String d, int p)
  {
    name = n;
    disease_status = d;
    position = p;
  }

  public String getName()
  {
    return this.name;
  }

  public String getStatus()
  {
    return this.disease_status;
  }

  public void setStatus(String stat)
  {
    disease_status = stat;
  }

  public int getPosition()
  {
    return this.position;
  }

  public void setPosition (int p)
  {
    position = p;
  }

  public boolean equals (Object o)
  {
   if (this == o)
   {
     return true;
   }
   else
   {
     return false;
   }

  }

  public String toString()
  {
    String msg = this.getName() + " " + this.getStatus() + " " + this.getPosition();
    return msg;
  }
}

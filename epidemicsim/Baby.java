public class Baby extends Person
{
  private int position_y;

  public Baby(String n, String d, int p, int pos_y)
  {
    super(n, d, p);
    position_y = pos_y;
  }

  public void setPositionY(int pos)
  {
    position_y = pos;
  }

  public int getPositionY()
  {
    return this.position_y;
  }
}

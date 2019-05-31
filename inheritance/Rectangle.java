public class Rectangle
{
  private double length;
  private double width;

  public Rectangle(double l, double w)
  {
    length = l;
    width = w;
  }

  public void setLength(double l)
  {
    l = length;
  }

  public void setWidth(double w)
  {
    w = width;
  }

  public double getLength()
  {
    return length;
  }

  public double getWidth()
  {
    return width;
  }

  public double getArea()
  {
    double area = this.length * this.width;
    return area;
  }
}

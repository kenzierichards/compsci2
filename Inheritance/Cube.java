public class Cube extends Rectangle
{
  private double height;

  public Cube(double l, double w, double h)
  {
    super(l, w);
    h = height;
  }

  public double getHeight()
  {
    return height;
  }

  public double getWidth()
  {
    return width;
  }

  public double getSurfaceArea()
  {
    double cubeArea;

    cubeArea = (6 * (area ^ 2));

    return cubeArea;
  }

  public double getVolume()
  {
    double volume;

    volume = (area ^ 3);

    return volume;
  }
}

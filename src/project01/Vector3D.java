package project01;

/**
 * Project1
 * Writing and testing a class named Vector3D
 * I asked ChatGPT to write a Java method that returns the values of individual components.
 *
 * @author Ziyang Liang
 */
public class Vector3D
{
   private double x;
   private double y;
   private double z;

   /**
    * A constructor with no parameter.
    */
   public Vector3D()
   {
   }

   /**
    * constructor takes parameters.
    * @param x value takes in
    * @param y value takes in
    * @param z value takes in
    */
   public Vector3D(double x, double y, double z)
   {
      this.setX(x);
      this.setY(y);
      this.setZ(z);
   }

   private void setX(double x)
   {
      this.x = x;
   }

   private void setY(double y)
   {
      this.y = y;
   }

   private void setZ(double z)
   {
      this.z = z;
   }

   /**
    * A getter method for x
    *
    * @return value of x
    */
   public double getX()
   {
      return x;
   }

   /**
    * A getter method for y
    *
    * @return value of y
    */
   public double getY()
   {
      return y;
   }

   /**
    * A getter method for z
    *
    * @return value of z
    */
   public double getZ()
   {
      return z;
   }

   /**
    * A method getting the vector's magnitude.
    *
    * @return its magnitude
    */
   public double getMagnitude()
   {
      double magnitude;
      magnitude = Math.abs(Math.sqrt(x * x + y * y + z * z));
      return magnitude;
   }

   /**
    * A method returns a normalized version of this vector
    *
    * @return the x,y,z that after normalized.
    */
   public Vector3D normalize()
   {
      double xAfterNormalize;
      double yAfterNormalize;
      double zAfterNormalize;

      if (this.getMagnitude() != 0)
      {
         xAfterNormalize = this.getX() / this.getMagnitude();
         yAfterNormalize = this.getY() / this.getMagnitude();
         zAfterNormalize = this.getZ() / this.getMagnitude();
      } else
      {
         throw new IllegalStateException();
      }
      return new Vector3D(xAfterNormalize, yAfterNormalize, zAfterNormalize);
   }

   /**
    * A method returns the result of adding this vector to another vector
    *
    * @return The vector after adding
    */
   public Vector3D add(Vector3D another)
   {
      if (another == null)
      {
         throw new IllegalStateException("Invalid vector");
      } else
      {
         return new Vector3D(this.getX() + another.getX(), this.getY() + another.getY(),
               this.getZ() + another.getZ());
      }
   }

   /**
    * A method returns the result of multiplying this vector by a constant
    *
    * @return The new vector after multiplying
    */
   //what is the type here
   public Vector3D multiply(double constant)
   {
      return new Vector3D(this.getX() * constant, this.getY() * constant, this.getZ() * constant);
   }

   /**
    * A method returns the dot product of this vector and another vector
    *
    * @return the dot product
    */
   public double dotProduct(Vector3D another)
   {
      return x * another.x + y * another.y + z * another.z;
   }

   /**
    * A method returns the angle between two vectors in degrees
    *
    * @return the angle
    */
   public double angleBetween(Vector3D another)
   {
      double angle;
      double theirDotProd = this.dotProduct(another);
      double magnitudeProduct = this.getMagnitude() * another.getMagnitude();
      if (another == null)
      {
         throw new IllegalStateException("Invalid vector");
      }
      if (magnitudeProduct != 0)
      {
         double temp = theirDotProd / magnitudeProduct;
         temp = Math.max(-1.0, Math.min(1.0, temp));
         double theta = Math.acos(temp);
         angle = Math.toDegrees(theta);
         angle = angle + Math.ceil(-angle / 360) * 360;
         return angle;
      } else
      {
         throw new IllegalStateException("Cannot compute angle between zero vectors");
      }
   }

   /**
    * A method returns the cross product of this vector and another vector
    *
    * @return their cross product
    */
   public Vector3D crossProduct(Vector3D another)
   {
      double xAfterCrossProd = this.y * another.z - this.z * another.y;
      double yAfterCrossProd = this.z * another.x - this.x * another.z;
      double zAfterCrossProd = this.x * another.y - this.y * another.x;

      if (another == null)
      {
         throw new IllegalStateException("Invalid vector");
      } else
      {
         return new Vector3D(xAfterCrossProd, yAfterCrossProd, zAfterCrossProd);
      }
   }

   @Override public String toString()
   {
      return String.format("(%.2f", this.getX()) + "," + String.format("%.2f", this.getY()) + "," + String.format(
            "%.2f", this.getZ()) + ")";
   }
}

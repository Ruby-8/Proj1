import org.junit.jupiter.api.BeforeEach;
import project01.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * test for Project 1
 * @author Ziyang Liang
 */
public class Vector3DTest
{
   private Vector3D v1;
   private Vector3D v2;
   private Vector3D v3;

   Vector3DTest()
   {}

   @BeforeEach
   void setUp()
   {
      this.v1 = new Vector3D();
      this.v2 = new Vector3D(3,4,12);
      this.v3 = new Vector3D(-1,-3,-8);
   }

   @Test void testGetMagnitude()
   {
      assertEquals(0.0D,this.v1.getMagnitude(),0.01D);
      assertEquals(13,this.v2.getMagnitude(),0.01D);
      assertEquals(8.60,this.v3.getMagnitude(),0.01D);
   }

   @Test void testNormalize()
   {
      assertThrows(
            IllegalStateException.class,
            () -> {
               this.v1.normalize();
            }
      );
      assertEquals(0.23,this.v2.normalize().getX(),0.01D);
      assertEquals(0.31,this.v2.normalize().getY(),0.01D);
      assertEquals(0.92,this.v2.normalize().getZ(),0.01D);
   }

   @Test void testToString()
   {
      Assertions.assertEquals("(3.00,4.00,12.00)",this.v2.toString());
   }

   @Test void testAdd()
   {
      //let v1 + v2
      double xOfSum = 3;
      double yOfSum = 4;
      double zOfSum = 12;

      assertEquals(xOfSum,v1.add(v2).getX(),0.01D);
      assertEquals(yOfSum,v1.add(v2).getY(),0.01D);
      assertEquals(zOfSum,v1.add(v2).getZ(),0.01D);
   }

   @Test void testMultiply()
   { //let v3*10;
      double xOfProduct = -10;
      double yOfProduct = -30;
      double zOfProduct = -80;

      assertEquals(xOfProduct,v3.multiply(10).getX(),0.01D);
      assertEquals(yOfProduct,v3.multiply(10).getY(),0.01D);
      assertEquals(zOfProduct,v3.multiply(10).getZ(),0.01D);
   }

   @Test void testDotProduct()
   {
      assertEquals(-111, v2.dotProduct(v3), 0.01D);
      //Check the v2 and v3 are changed or not
      assertEquals(3,v2.getX());
      assertEquals(4,v2.getY());
      assertEquals(12,v2.getZ());

      assertEquals(-1,v3.getX());
      assertEquals(-3,v3.getY());
      assertEquals(-8,v3.getZ());
   }

   @Test void testAngleBetween()
   {
      Vector3D v4 = new Vector3D();
      assertThrows(
            IllegalStateException.class,
            () -> {
               v2.angleBetween(v4);
            }
      );
      assertEquals(173.01,v2.angleBetween(v3),0.01D);
   }

   @Test void testCrossProduct()
   {
      assertEquals(4.00,v2.crossProduct(v3).getX(),0.01D);
      assertEquals(12.00,v2.crossProduct(v3).getY(),0.01D);
      assertEquals(-5.00,v2.crossProduct(v3).getZ(),0.01D);
   }
}

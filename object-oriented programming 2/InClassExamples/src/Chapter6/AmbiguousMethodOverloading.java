/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6;

/**
 *
 * @author thomas.szymczak
 */
public class AmbiguousMethodOverloading {

  public static void main(String[] args) {
    System.out.println("The maximum of 3.3 and 4 is "
      + max(3.3, 4));

    System.out.println("The maximum of 3 and 4.4 is "
      + max(3, 4.4));

    // Syntax Error
    //System.out.println("The maximum of 3 and 4 is "
    //  + max(3, 4));
  }
  
  public static double max(int num1, double num2) {
      if ( num1 > num2 )
          return num1;
      else
          return num2;
  }
  
  public static double max(double num1, int num2) {
      if (num1 > num2)
          return num1;
      else
          return num2;
  }
}

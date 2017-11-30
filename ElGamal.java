import java.util.HashMap;

public class ElGamal {
  /**
   * Solving the discrete log problem (using brute force)
   * 
   * @return the value a, such that beta is equal to alpha to the a-th power
   */
  static int solveDiscreteLog(int p, int alpha, int beta) {
    if (p > 100000) throw new Error("the p value is too large to brute force!");

    for (Integer a = 0; a < p - 1; a++) {
      if (beta == (Math.pow(alpha, a) % p)) return a;
    }

    throw new Error("No a value found!");
  }
  /**
   * Computing the multiplicative inverse in modular arithmetic using the extended Euclidean algorithm
   */

  /**
   * Modular exponentiation using the repeated squaring method
   */
  static int modularExponentiation(int value, int exponent, int modulo) {
    return 1;
  }

  static void computeSubvalues(int value, int exponent, int modulo) {
    HashMap<Integer, Integer> subvalues = new HashMap<Integer, Integer>();
    
    int k = 0;
    int powerOfTwo = 1;

    do {
      double d = Math.pow(value, powerOfTwo);
      System.out.println((int) d);
      long v = ((long) d) % modulo;
      System.out.println(powerOfTwo + " | " + v);
      k++;
      powerOfTwo =(int) Math.pow(2, k);
    } while(powerOfTwo <= exponent);
  }

  /**
   * Converting from numbers back to text (Note: You need to invert the above procedure which converts from text to numbers).
   */

}
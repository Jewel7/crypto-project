/*
*Cryptograpy Project 1
*Sean Donnelly, Teresa Melgarejo, Golda Meir Chiong
*/
import java.io.*;
import java.util.*;
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
static int[] gcd(int x, int mod)//checks if an inverse is possible 
   {
        if (mod == 0)
           return new int[] { x, 1, 0 };
        
        int[] values = gcd(mod, x % mod);
        int d = values[0];
        int a = values[2];
        int b = values[1] - (x / mod) * values[2];
        return new int[] { d, a, b };
    }
   static int extendEuclid(int x, int mod)//computes inverse, if there is one
   {
      int[] values = gcd(x, mod);
      
      int d = values[0];
      int a = values[1];
      int b = values[2];
      
      if (d > 1) 
      { 
        System.out.println("No inverse found!"); 
        return 0; 
      }
      if (a > 0) 
          return a;
      
      return mod + a;
   }
  
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
  ////Jewel
  public class power{
    public static int modpow(int value , int power, int mod){
      int e = 1;
     
      for (int i = 0; i < power; i++) {
           e = ((e * value) % mod);
              
      }
          
          return e;
  }

  /**
   * Converting from numbers back to text (Note: You need to invert the above procedure which converts from text to numbers).
   */
  public static char[] numbersToText(int a){
     //The number will be a combination of 3 values randing from 0 to 25
    int firstChar = 0;
    int secondChar = 0;
    int thirdChar = 0;

    //Algorithm for converting numbers to text
    //Note: It's important to mod 26 these integers, or else you will get the wrong letters
    thirdChar = a % 26;
    a = (a - thirdChar) / 26; 
    secondChar = a % 26; 
    a = (a - secondChar) / 26; 
    firstChar = a % 26;

    //Those values are still integers, so we must convert them to ASCII then type cast to char
    //Note: 'a' in ASCII is 97
    firstChar += 'a';
    char char1 = (char) firstChar;
    secondChar += 'a';
    char char2 = (char) secondChar;
    thirdChar += 'a';
    char char3 = (char) thirdChar;
    
    return new char[] {char1, char2, char3};
  }
}

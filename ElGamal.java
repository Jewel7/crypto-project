/** 
* Cryptograpy Project 1
* Sean Donnelly, Teresa Melgarejo, Golda Meir Chiong
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
      if (beta == modularExponentiation(alpha, a, p)) return a;
    }

    throw new Error("No a value found!");
  }
  
  /**
   * Computing the multiplicative inverse in modular arithmetic using the extended Euclidean algorithm
   */
static int EEAlg_Inverse(int base, int mod, int a, int p)//pass in the base and the modulus to find the modular inverse
    {
        int x = 0, y = 1, lastX = 1, lastY = 0, temp; //declaring values

        while (mod != 0)//insures no division by zero
        {
            int quotient = base / mod;//quotient
            int remainder = base % mod;//remainder

            base = mod;
            mod = remainder;

            temp = x;
            x = lastX - quotient * x;
            lastX = temp;

            temp = y;
            y = lastY - quotient * y;
            lastY = temp;            
        }
        
        return modularExponentiation(lastX,a, p);//returns the extended Euclid Alg Inverse
        
    }
  
  
  /**
   * Modular exponentiation using the repeated squaring method
   * 
   * @return the value e
   */
  public static int modularExponentiation(int value, int power, int mod){
    int e = 1;
    for (int i = 0; i < power; i++) {
      e = ((e * value) % mod);
    }
    
    return e;
  }

  /**
   * Converting from numbers back to text (Note: You need to invert the procedure which converts from text to numbers).
   * @return char1, char2, char 3
   */
  public static char[] numbersToText(int a){
     //The number will be a combination of 3 values randing from 0 to 25
    int firstChar = 0;
    int secondChar = 0;
    int thirdChar = 0;

    //Algorithm for converting numbers to text. Note: It's important to mod 26 these integers, or else you will get the wrong letters.
    thirdChar = a % 26;
    a = (a - thirdChar) / 26; 
    secondChar = a % 26; 
    a = (a - secondChar) / 26; 
    firstChar = a % 26;

    //Those values are still integers, so we must convert them to ASCII then type cast to char. Note: 'a' in ASCII is 97.
    firstChar += 'a';
    char char1 = (char) firstChar;
    secondChar += 'a';
    char char2 = (char) secondChar;
    thirdChar += 'a';
    char char3 = (char) thirdChar;
    
    return new char[] {char1, char2, char3};
  }
}

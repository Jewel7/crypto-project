/*
*Cryptograpy Project 1
*Sean Donnelly, Teresa Melgarejo, Golda Meir Chiong
*/
import java.io.*;
import java.util.*;

public class ElGamal {
  /**
   * Solving the discrete log problem (using brute force)
   */
  
  /**
   * Computing the multiplicative inverse in modular arithmetic using the extended Euclidean algorithm
   */

  /**
   * Modular exponentiation using the repeated squaring method
   */

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
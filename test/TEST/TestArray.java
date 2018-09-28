/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Black-ish
 */
public class TestArray {
   static String numbers="0123456789";
   static  String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     static String scode="", guess="";
 static   Random rand= new Random();
static  ArrayList  string1= new ArrayList();
static  ArrayList  string2= new ArrayList();
//static Array names=new Array("Home", "Kundu", "Jomba");
 static   Scanner newtype= new Scanner(System.in);
static int numb, num;
    public static void  main(String args [])
    {
        getGuess();
   //   System.out.println("Enter number of Strings:");
       
    //  System.out.print("Enter number of Characters per string");
        //System.out.println("Numbers size" +numbers.toCharArray().length);
       // System.out.println("Alphabet size" +alphabet.toCharArray().length);
       for(int i=0; i<num; i++)
       {
        //System.out.println(" " +getString(numb));
        //string1.toString().
        string1.add(getString(numb));
       }
       System.out.println(string1);
       System.out.println(string2);
       System.out.println("" +getBoth());
    }
    public static String getString( int count)
    {
        StringBuilder cod=new StringBuilder();
        StringBuilder cod1= new StringBuilder();
        while(count--!=0)
        {
        int ch=rand.nextInt(alphabet.length());
        cod.append(alphabet.charAt(ch));
        int ns=rand.nextInt(numbers.length());
        cod1.append(numbers.charAt(ns));
        scode= cod.toString().toUpperCase() +""+cod1.toString();
        }
         return scode;
    }

 public static ArrayList getGuess()
 {
 System.out.println("Enter number of characters:");
 num=newtype.nextInt();
   //  return string1.toString();
   System.out.println("Enter number of guess:");
   numb=newtype.nextInt();
   for(int i=0; i<numb;i++);
   {
       System.out.println("Enter name:");
       guess=newtype.next();
       string2.add(guess);
   }
     return string2;
 }
 public static  boolean Compare()
 {
     if(string1.contains(string2))
     {
     System.out.println("Strings match well");
     }
 return false;
 }
 public static String  getBoth()
 {
     String bothstring;
     
     bothstring=string1 + "s" + string2;
     
 return bothstring;
 }
}

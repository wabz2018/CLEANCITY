/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Black-ish
 */
public class ReadFiles {
   
   public static void main(String... aArgs) throws IOException{
    ReadFiles parser = new ReadFiles("C:\\Users\\Black-ish\\Desktop\\newfile.txt");
    parser.processLineByLine();
    log("Done.");
  }
     public ReadFiles(String aFileName){
    fFilePath = Paths.get(aFileName);
  }
  public final void processLineByLine() throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
      while (scanner.hasNextLine()){
        processLine(scanner.nextLine());
      }      
    }
  }
  
    protected void processLine(String aLine){
    //use a second Scanner to parse the content of each line 
    try(Scanner scanner = new Scanner(aLine)){
      scanner.useDelimiter("=");
      if (scanner.hasNext()){
        //assumes the line has a certain structure
        String name = scanner.next();
        String value = scanner.next();
        log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
      }
      else {
        log("Empty or invalid line. Unable to process.");
      }
    }
    }
    private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  private static void log(Object aObject){
    System.out.println(Objects.toString(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
} 


import java.util.*;
import.java.io.*;

public class Main{
  public static void main(String [] args){
    Scanner main = new Scanner(System.in);
    System.out.println("Enter file name: ");
    String name = sc.next();
    File file = new File(name);
    
    Compiler comp = new Compiler();
    String userInput = comp.convertFile(file);
    System.out.println("File is: " + userInput);
    main.close();
  }
}



class Token{
  string lex;
  int tokenType;
}

class constructor{
  public compiler(){}
  public String convertFile(File stringFile) throws Exception{
    String fileContent = " ";
    Scanner sc = new Scanner(stringFile);
    
    while(sc.hasNext()){
      fileContent = fileContent = " " + sc.nextLine();
    }
    sc.close();
    return fileContent;
  }
}

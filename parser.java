import com.github.parser;
import com.github.main;
import com.github.token;
//import com.github.lexer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.util.ArrayList;
import java.io.util.List;
public class parsers{
  public List<Token> tokens;
  public Lexer lexer;
  public int integer;
  public InputStream stream;
  
  public parsers(String name) throws IOException {
    tokens = new ArrayList<>();
    lexer = new Lexer();
    stream = new BufferedInputStream(new FileInputStream(name));
    integer = 0;
  }
  
  public boolean trial1() throws IOException{
    boolean isRight = false;
    if(input()){
      isRight = (trial1());
    }
    stream.close();
    return isRight;
  }
  
  public boolean trial2() throws IOException{
    boolean isRight = false;
    int secTrial = integer;
    tokens.add(lexer.nextToken(stream));
    if(toksens.get(integer).getLessema().equals("Semicol")){
      integer++;
      if(input()){
        if(trial1()){
          isRight = true;
        }else{
          integer = secTrial;
        }
      }else{
        integer = secTrial;
    }else{
      isRight = true;
   return isRight;
   }
  }
  
  public boolean input() throws IOException{
    boolean isRight = false;
    int secTrial = integer;
    tokens.add(lexer.nextToken(stream));
    if(tokens.get(integer).getClasse().equals("IF")){
      integer++;
      if(expression1()){
        tokens.add(lexer.nextToken(stream));
        if(tokens.get(integer).getClasse().equals("THEN")){
          integer++;
          if(input()){
            isRight = true;
          }else{
            integer = secTrial;
          }
        }else integer = secTrial;
      }else integer = secTrial;
    }else{
      if(tokens.get(integer).getClasse().contains("ID:")){
        integer++;
        tokens.add(lexer.nextToken(stream));
        if(tokens.get(integer).getLessema().equals("ASSIGN"){
          integer++;
          if(expression1()){
            isRight = true;
          }else integer = secTrial;
        }else integer = secTrial;
      }else integer = secTrial;
    }
    return isRight;
  }
    
  public boolean expression1() throws IOException{
    boolean isRight = false;
    int secTrial = integer;
    if(tokenTerms()){
      if(expression2()){
        isRight = true;
      }else integer = secTrial;
    }else integer = secTrial;
    return isRight;
  }
           
  public boolean expression2() throws IOException{
    boolean isRight = false;
    int secTrial = integer;
    tokens.add(lexer.nextToken(stream));
    if(tokens.get(integer).getClasse().equals("RELOP")){
      integer++;
      if(tokenTerms()){
        isRight = true;
      }else integer = secTrial;
    }else isRight = true;
    return isRight;
  }
           
  public boolean tokenTerms() throws IOException{
    boolean isRight = false;
    tokens.add(lexer.nextToken(stream));
    String classe = tokens.get(integer).getClasse();
    if(classe.contains("ID:") || classe.contains("CONST") || classe.equals("TRUE") || classe.equals("FALSE")){
      integer++;
      isRight = true;
    }
    return isRight;
  }
}

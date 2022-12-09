import com.github.parser;
import com.github.main;
import com.github.token;

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
    boolean isBool = false;
    if(input()){
      isBool = (trial1());
    }
    stream.close();
    return isBool;
  }
  
  public boolean trial2() throws IOException{
    boolean isBool = false;
    int secTrial = integer;
    this.tokens.add(lexer.nextToken(stream));
    if(toksens.get(integer).getLessema().equals("Semicol")){
      integer++;
      if(input()){
        if(trial1()){
          isBool = true;
        }else{
          integer = secTrial;
        }
      }else{
        integer = secTrial;
    }else{
      isBool = true;
   return isBool;
   }
  }
  
  public boolean input() throws IOException{
    boolean isBool = false;
    int secTrial = integer;
    this.tokens.add(lexer.nextToken(stream));
    if(this.tokens.get(integer).getClasse().equals("IF")){
      integer++;
      if(expression()){
        this.tokens.add(lexer.nextToken(stream));
        if(this.tokens.get(integer).getClasse().equals("THEN")){
          integer++;
          if(input()){
            isBool = true;
          }else{
            integer = secTrial;
          }
        }else integer = secTrial;
      }else integer = secTrial;
    }else{
      if(tokens.get(integer).getClasse().contains("ID:")){
        integer++;
        this.tokens.add(lexer.nextToken(stream));
        if(this.tokens.get(integer).getLessema().equals("ASSIGN"){
          integer++;
          if(expression()){
            isBool = true;
          }else integer = secTrial;
        }else integer = secTrial;
      }else integer = secTrial;
    }
    return isBool;
  }
    
  public boolean expression() throws IOException{
    boolean isBool = false;
    int secTrial = integer;
    if(tokenTerms()){
      if(expression1()){
        isBool = true;
      }else integer = secTrial;
    }else integer = secTrial;
    return isBool;
  }
           
  public boolean expression1() throws IOException{
    boolean isBool = false;
    int secTrial = integer;
    this.tokens.add(lexer.nextToken(stream));
    if(tokens.get(integer).getClasse().equals("RELOP")){
      integer++;
      if(tokenTerms()){
        isBool = true;
      }else integer = secTrial;
    }else isBool = true;
    return isBool;
  }
           
  public boolean tokenTerms() throws IOException{
    boolean isBool = false;
    this.tokens.add(lexer.nextToken(stream));
    String classe = tokens.get(integer).getClasse();
    if(classe.contains("ID:") || classe.contains("CONST") || classe.equals("TRUE") || classe.equals("FALSE")){
      integer++;
      isBool = true;
    }
    return isBool;
  }
}

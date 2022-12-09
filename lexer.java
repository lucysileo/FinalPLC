import java.util;

public class lexer{
  private String input;
  private Token[] tokens;
  
  public Lexer(String lexerString) {
    this.lexerString = lexerString;
    this.tokens = new Token[lexerString.length()];
  }
  public void tokens(){
    int tokenInt = 0;
    for(int i = 0; i < lexerString.length(); i++){
      char char = lexerString.charAt(i);
      switch(char){
        case '+':
          tokens[tokenInt++] = new Token("+");
          break;
        case '-':
          tokens[tokenInt++] = new Token("-");
          break;
        case '*':
          tokens[tokenInt++] = new Token("*");
          break;
        case '/':
          tokens[tokenInt++] = new Token("/");
          break;
        case '^':
          tokens[tokenInt++] = new Token("^");
          break;
        case '>':
          tokens[tokenInt++] = new Token(">");
          break;
        case '<':
          tokens[tokenInt++] = new Token("<");
          break;
        case '>=':
          tokens[tokenInt++] = new Token(">=");
          break;
        case '<=':
          tokens[tokenInt++] = new Token("<=");
          break;
        case '==':
          tokens[tokenInt++] = new Token("==");
          break;
        case '.':
          tokens[tokenInt++] = new Token("Real literal", Character.toString(char));
          break;
        case '0': case '1': case '2': case '3': case '4': //natural literal
        case '5': case '6': case '7': case '8': case '9': 
          token[tokenInt++] = new Token("Natural literal", Character.toString(char));
          break;
        case 'true': case 'false': //bool literal
          tokens[tokenInt++] = new Token("Bool literal", Character.toString(char));
          break;
        case '\': //char literal
          tokens[tokenInt++] = new Token("Character literal", Character.toString(char));
          break;
        case '"': //string literal
          tokens[tokenInt++] = new Token("String literal", Character.toString(char));
          break;
          
        //keywords
        case 'for': 
          tokens[tokenInt++] = new Token("Keyword", "for");
          break;
        case 'while':
          tokens[tokenInt++] = new Token("Keyword", "for");
          break;
        case 'String': cast 'int': case 'char': case 'float': case 'bool':
          tokens[tokenInt++] = new Token("Keyword", Character.toString(char));
          break;
      }
    }
    public static void main(String[] args){
      String lexerString = "for + 5 > 2+;
      Lexer lexer = new Lexer(lexerString);
      lexer.tokens();
      Token[] tokens = lexer.tokens;
      for(Token token:tokens){
        System.out.println(token.type + " : " + token.value);
      }
    }
    class Token{
      String type;
      String value;
      Token(String type, String value){
        this.type = type;
        this.value = value;
      }
    }
  }
  
  public real_literal(int intLiteral){
    //lets the thing be able to contail fractional numbers
  }
  
}


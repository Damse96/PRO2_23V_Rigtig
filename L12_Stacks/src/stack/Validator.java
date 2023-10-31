package stack;

import java.util.ArrayList;

public class Validator {
    public Validator() {

    }


    public boolean validateBrackets(String expression){
        int count = 0;
        char test = 0;
        int top = -1;
        ArrayList<Character> openBracketList = new ArrayList<>();

      while (expression.length() > count){
          test = expression.charAt(count);
          if(checkBracket(test)){
              openBracketList.add(test);
              top++;
          }
          if(checkCloseBracket(test)){
              if(checkrightCloseBrackket(top,openBracketList,test)){
                  openBracketList.remove(top);
                  top--;
              }else {
                  return false;
              }
          }
          count++;
      }

      if(openBracketList.size() > 0){
          return false;
      }
        return true;
    }

    private boolean checkrightCloseBrackket(int top,ArrayList<Character> bracketList, char test) {
        if(inverseBracket(bracketList.get(top)) == test){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkCloseBracket(char test) {
        boolean isCloseBracket = false;
        if(')' == test || test == ']' || test == '}') {
            isCloseBracket = true;
        }
        return isCloseBracket;
    }

    private char inverseBracket(char bracket) {
        char temp = 0;
        if(bracket == '('){
            temp = ')';
        }else if(bracket == '{'){
            temp ='}';
        }else if(bracket== '['){
            temp =']';
        }
        return temp;
    }

    private boolean checkBracket(char test) {
        if( test == '('|| test =='{' ||test =='['){
            return true;
        }
        else{
            return false;
        }
    }
}

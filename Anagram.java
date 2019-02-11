package TaskAnagram;

public class Anagram {

    private String textOption ; 
    
    private int positFirstWordChar ; // Position of first word character in text's line 
    private int positLastWordChar;   // Position of last word character in text's line 
    
    private int numbOfSpace;
    private char symbolOfSpace;
    
    private int numbOfCharsThatIsNotALetter;    
    
    
    public void turnText(String text){
        textOption = text;
        positLastWordChar = textOption.length();
        symbolOfSpace = ' ';
        printCurrentText();
        calculNumbOfSpace();      
        if (numbOfSpace == 0) spaceEqualsZero() ;
        else spaceMoreThanZero() ;   
        System.out.println(" ");
    }
    
    private void printCurrentText(){
        System.out.println(textOption);
    }
    
    private void calculNumbOfSpace(){ // In the wrote text or chosen text option.
        for (int i = 0; i < textOption.length(); i++) {
            if (textOption.charAt(i) == symbolOfSpace) {
                numbOfSpace = numbOfSpace + 1;
            }
        }
    }
    
    private void spaceEqualsZero(){    
        String[] text = new String[textOption.length()];
        
        for (int a = 0; a < textOption.length(); a++) {
            text[a] = Character.toString(textOption.charAt(a));
            //
            if (Character.isLetter(textOption.charAt(a)) == false) numbOfCharsThatIsNotALetter = numbOfCharsThatIsNotALetter +1 ;        
        }

        if (numbOfCharsThatIsNotALetter == 0){
            for (int a = 0; a < text.length / 2; a++) {
                String temp = text[a];
                text[a] = text[text.length - 1 - a];
                text[text.length - 1 - a] = temp;
            }
            for (int b = 0; b < textOption.length(); b++) {
                System.out.print(text[b]);
            }
        }        
     
        else {
            String[] newString = new String[text.length];
            String[] newStrWithoutChar = new String[text.length - numbOfCharsThatIsNotALetter];
            int aaa = 0;
            
            for (int a = 0; a < text.length; a++) {
                if ( Character.isLetter(textOption.charAt(a)) == false ) newString[a] = text[a]; //New option (part of code)!
                else {
                   newStrWithoutChar[aaa] = text[a] ; aaa = aaa + 1;
                }
            }
            for (int a = 0; a < newStrWithoutChar.length / 2; a++) {                
                String temp = newStrWithoutChar[a];
                newStrWithoutChar[a] = newStrWithoutChar[newStrWithoutChar.length - 1 - a];
                newStrWithoutChar[newStrWithoutChar.length - 1 - a] = temp;
            }
            int b = 0; 
            for (int a = 0 ; a < newString.length ; a++){
                if (newString[a] == null) {newString[a] = newStrWithoutChar[b]; b = b+1 ;} 
            }
                    
            for (int a = 0; a < newString.length; a++) {
                  System.out.print(newString[a]);
            }            
        }          
    }


    private void spaceMoreThanZero(){
        for (int i = 0; i < textOption.length(); i++) {
            if (textOption.charAt(i) == symbolOfSpace) {
                positLastWordChar = i;
                revers();
                printSpace();
                positFirstWordChar = positLastWordChar+1;
            }
            
            if ( i == textOption.length()-1 ){
                positLastWordChar = textOption.length();
                revers();
            }
        }        
    }
    
    private void revers() {
        String[] lengthOfWord = new String[positLastWordChar - positFirstWordChar];
        int w = 0 ;
        numbOfCharsThatIsNotALetter = 0;
        for (int i = positFirstWordChar; i < positLastWordChar; i++) {
            lengthOfWord[w] = Character.toString(textOption.charAt(i));
            //
            if (Character.isLetter(lengthOfWord[w].charAt(0)) == false) numbOfCharsThatIsNotALetter = numbOfCharsThatIsNotALetter +1 ; 
            w = w + 1;
        }

        if (numbOfCharsThatIsNotALetter == 0){
            for (int a = 0; a < lengthOfWord.length / 2; a++) {
                String temp = lengthOfWord[a];
                lengthOfWord[a] = lengthOfWord[lengthOfWord.length - 1 - a];
                lengthOfWord[lengthOfWord.length - 1 - a] = temp;
            }
            for (int f = 0; f < lengthOfWord.length; f++) {
                System.out.print(lengthOfWord[f]);
            }     
        }
        
        else {
            String[] singleWord = new String[lengthOfWord.length];
            String[] newStrWithoutChar = new String[lengthOfWord.length - numbOfCharsThatIsNotALetter];
            int aaa = 0;
            for (int a = 0; a < lengthOfWord.length; a++) {
                if ( Character.isLetter(lengthOfWord[a].charAt(0)) == false ) singleWord[a] = lengthOfWord[a];
                else {
                   newStrWithoutChar[aaa] = lengthOfWord[a] ; aaa = aaa + 1;
                }

            }
           for (int a = 0; a < newStrWithoutChar.length / 2; a++) {                
                String temp = newStrWithoutChar[a];
                newStrWithoutChar[a] = newStrWithoutChar[newStrWithoutChar.length - 1 - a];
                newStrWithoutChar[newStrWithoutChar.length - 1 -a] = temp;
            }
            
            int b = 0; 
            for (int a = 0 ; a < singleWord.length ; a++){
                if (singleWord[a] == null) {
                    singleWord[a] = newStrWithoutChar[b];
                    b = b+1 ;
                } 
            }
                    
            for (int f = 0; f < singleWord.length; f++) {
                  System.out.print(singleWord[f]);
            }            
        }
    }
    
    private void printSpace(){
        System.out.print("_");
    }    
}

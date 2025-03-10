import java.util.Scanner;


public class prob2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String phrase;
        char ans;

        System.out.println("WORD ENLISTER PROGRAM");
        System.out.print("--------------------");
        do{
        System.out.print("\n>> Enter a phrase/sentence: ");
        phrase = sc.nextLine();
        System.out.print(">>Words Enlisted:");
        phrase = formatstring(phrase);
        extractstr(phrase);
        
        System.out.print(">> Enter 'Y' to try again: ");
        ans = sc.next().charAt(0);
        sc.nextLine();
        }while(ans=='y'||ans=='Y');

        System.out.println("\n-- Program Terminated");
        
        

    }

    static String formatstring(String phrase){
        
        phrase = phrase.toUpperCase();
       
        int i = 0, lim = phrase.length();
        char lett;
        for(i = 0; i < lim; i++){
            lett = phrase.charAt(i);
            
            if(lett>=65&&lett<=90||lett == 32){
                continue;
            }
            
            else{
                phrase = phrase.replace(lett, '+');
                
            }  
        }

        

        StringBuilder words = new StringBuilder(phrase);
        
        while(words.indexOf("+")!=-1){

        for(i = 0; i < words.length(); i++){
            lett = words.charAt(i);
            
            if(lett>=65&&lett<=90||lett == 32){
                continue;
            }
            
            else if(i<=words.length()-1){
            // System.out.println(lett);
            words.delete(i, i+1);
            }
            
        }}

        // System.out.println(words.length());    
        // System.out.println(words.toString());

        return words.toString();
    }

    static void extractstr(String phrase){
        System.out.println(phrase);
        int endindex = phrase.length();
        int numoflet = 0, numofvowels = 0, numofconso = 0;
        char letr= ' ';
        int findex = phrase.indexOf(' ');
        int i = 0, num = 1;
        String extstr = "";


        while(findex != -1){
            extstr = phrase.substring(0, findex);
            // System.out.println(extstr);
            phrase = phrase.substring(findex, endindex);
            phrase = phrase.trim();
            findex = phrase.indexOf(' ');
            endindex = phrase.length();
            // System.out.println(phrase);
            numoflet = extstr.length();

            for(i = 0;i<numoflet;i++){
                letr = extstr.charAt(i);
                if(letr == 'A'||letr == 'E'||letr == 'I'||letr == 'O'||letr == 'U')
                numofvowels++;
                else
                numofconso++;
            }

            System.out.println("\n\t[" + num + "] " + extstr);
            System.out.println("\t\t- " + numoflet + " Letter (s)");
            System.out.println("\t\t- " + numofconso + " Consonant (s)");
            System.out.println("\t\t- " + numofvowels + " Vowel (s)");

            numofconso = 0;
            numoflet = 0;
            numofvowels = 0;
            num++;

            if(findex==-1){
                extstr = phrase;

                numoflet = extstr.length();
                for(i = 0;i<numoflet;i++){
                letr = extstr.charAt(i);
                if(letr == 'A'||letr == 'E'||letr == 'I'||letr == 'O'||letr == 'U')
                numofvowels++;
                else
                numofconso++;
            }

                System.out.println("\n\t[" + num + "] " + extstr);
                System.out.println("\t\t- " + numoflet + " Letter (s)");
                System.out.println("\t\t- " + numofconso + " Consonant (s)");
                System.out.println("\t\t- " + numofvowels + " Vowel (s)");
            }
        }



    }

   

}

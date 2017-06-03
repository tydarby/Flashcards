import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashcardReader {

    public static String deckName = "";
    public ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>();
    File deck1 = new File("./data2.txt");

    public FlashcardReader(File deck){
        ArrayList<String> cards = new ArrayList<String>(); 

        Scanner textReader; //This will read through terms to create flashcards
        Scanner titleReader; //This will read the last line of the file, which holds the title
        try {

            textReader = new Scanner(deck);
            textReader.useDelimiter("\t");
            titleReader = new Scanner(deck);
            titleReader.useDelimiter("\n");
            int i = 0;

            //Adds all the text to the card arraylist
            while (textReader.hasNext()){
                cards.add(textReader.next());
                if(i>0 && i%2!=0){
                    //System.out.println(cards.get(i-1) + " " +cards.get(i));
                    //System.out.println("index :" + i );
                    flashcards.add(new Flashcard(cards.get(i-1), cards.get(i)));

                }

                i++;
                //System.out.println(i);
            } 
            //pulls the name of the deck from the file
            while(titleReader.hasNext()){
                deckName = titleReader.next();
            }
            System.out.println(deckName);

            // removes the last index
            if(cards.size()>1){
                int blankCardIndx = flashcards.size()-1;
                flashcards.remove(blankCardIndx);
            }
            //This just tests whether the arraylist is storing the strings properly
            for(Flashcard fc: flashcards){
                System.out.printf("%s\t%s\n",fc.getSide1(),fc.getSide2());
            }

            //Prints the arraylist after randomizing its order.
            //flashcards = Functions.randomizeOrder(flashcards);
            //System.out.println("\nIn randomized order\n");
            for(Flashcard fc: flashcards){

                // System.out.printf("%s\t%s\n",fc.getSide1(),fc.getSide2());
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Flashcard> getFlashcards(){
        return flashcards;
    }
}

/* This is a program that will allow the user to create and quiz themselves 
 * with virtual flashcards
 * Tyler Darby 5/8/2017
 */

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Tester extends Thread{
    //These strings represent the url for the the txt files that hold the flashcard data
    public static String path = System.getProperty("user.dir") + "\\data.txt";
    public static String path2 = System.getProperty("user.dir") + "\\data2.txt";
    public static String path3 = System.getProperty("user.dir") + "\\data3.txt";
    public static String CURRENT_PATH = "";

    public static File deck1 = new File(path);
    public static File deck2 = new File(path2);
    public static File deck3 = new File(path3);
    
    public static FlashcardReader fcr;

    private int DECK_CHOICE = 0;
    public static ArrayList<File> decks = new ArrayList<File>();

    public Tester(int i){
        DECK_CHOICE = i;
    }

    public void run(){
        System.out.println("Thread is running.");
        frameInit();
        try{
            /* this ensures that the user has finished making cards before prompting
            the user to name their deck */
            while(!FlashcardMakerFrame.isDone){
                sleep(1000); //program will check once every second
            }
        }

        catch(Exception e){
            System.out.println("Exception");
        }
        try{
            /*this will create a small dialog window prompting the user to name 
            their deck */
            if(DECK_CHOICE == 1){
                NameDialog nd = new NameDialog(deck1);
                nd.setVisible(true);
            }
            else if(DECK_CHOICE == 2){
                NameDialog nd = new NameDialog(deck2);
                nd.setVisible(true);
            }
            else if(DECK_CHOICE == 3){
                NameDialog nd = new NameDialog(deck3);
                nd.setVisible(true);
            }
            
        }
        catch(Exception e){
            System.out.println("");
        }
        try{
            //this ensures that the user has entered a deck name
            while(!NameDialog.isDone){
                sleep(1000); //program will check once every second
            }
        }
        catch(Exception e){
            System.out.println("Exception");
        }

        //now that the deck has been created, read the deck and draw the panel
        if(DECK_CHOICE == 1){
            fcr = new FlashcardReader(deck1);
        }
        else if(DECK_CHOICE == 2){
            fcr = new FlashcardReader(deck2);
        }
        else if(DECK_CHOICE == 3){
            fcr = new FlashcardReader(deck3);
        }
        panelInit();
    }

    public static void main(String[] args){
        System.out.println(path);
        decks.add(Tester.deck1);
        decks.add(deck2);
        decks.add(deck3);
        // TODO Auto-generated method stub
        Scanner kbReader = new Scanner(System.in);
        try{
            StartFrame sf = new StartFrame("test start frame");
            sf.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Something happened in initializing the start frame");
        }

    }

    /* This method creates the flaschard making frame
     * 
     */
    public void frameInit(){
        try{
            if(DECK_CHOICE == 1){
                FlashcardMakerFrame frame = new FlashcardMakerFrame("test", deck1);
                frame.setVisible(true);
            }
            else if(DECK_CHOICE == 2){
                FlashcardMakerFrame frame = new FlashcardMakerFrame("test", deck2);
                frame.setVisible(true);
            }
            else{
                FlashcardMakerFrame frame = new FlashcardMakerFrame("test", deck3);
                frame.setVisible(true);
            }

        }
        catch(IOException ioe){
            System.out.println("IOexception with FCMF");
        }

    }

    /* This method creates the main panel that shows the user
     * their flashcard deck
     */
    public static void panelInit(){
        Panel screen = new Panel(FlashcardReader.deckName, fcr.getFlashcards());
        screen.setVisible(true);
    }
}

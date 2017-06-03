/* This class creates and handles the first window that appears, asking 
 * the user what they would like to do
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class StartFrame extends JFrame implements ActionListener{
    JButton startFlashcardMakerFrame;
    JButton startPanel;
    JComboBox deckList;
    public static FlashcardReader fcr;
    public static FlashcardReader fcr2;
    public static FlashcardReader fcr3;

    public StartFrame(String title) throws IOException{
        super(title);
        setSize(400,400);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFlashcardMakerFrame = new JButton("Make flashcards");
        startFlashcardMakerFrame.setActionCommand("make");
        startFlashcardMakerFrame.addActionListener(this);

        deckList = new JComboBox(getDeckTitle());

        startPanel = new JButton("Start");
        startPanel.setActionCommand("start");
        startPanel.addActionListener(this);

        setLayout(new FlowLayout());
        add(startFlashcardMakerFrame);
        add(startPanel);
        add(deckList);

        
    }

    public void actionPerformed(ActionEvent event){

        if(event.getActionCommand().equals("make")){
            Tester obj = new Tester(deckList.getSelectedIndex()+1);
            obj.start();
            dispose();
        }
        else if(event.getActionCommand().equals("start")){
            if(deckList.getSelectedIndex() ==  0){
                System.out.println("Starting deck1");
                fcr = new FlashcardReader(Tester.deck1);
                Tester.fcr = fcr;
                Tester.panelInit();
            }
            else if(deckList.getSelectedIndex() ==  1){
                System.out.println("Starting deck2");
                fcr = new FlashcardReader(Tester.deck2);
                Tester.fcr = fcr;
                Tester.panelInit();
            }
            else if(deckList.getSelectedIndex() ==  2){
                System.out.println("Starting deck3");
                fcr = new FlashcardReader(Tester.deck3);
                Tester.fcr = fcr;
                Tester.panelInit();
            }
            dispose();
        }
    }

    /*
     * This method returns the titles of all the decks in a string array for the combobox to use
     */
    public String[] getDeckTitle(){
        String []deckTitles = new String[Tester.decks.size()];
        for(int i = 0; i < Tester.decks.size(); i++){
            System.out.println("Grabbing deck title from deck"+i);
            FlashcardReader fr = new FlashcardReader(Tester.decks.get(i));
            
            if(fr.deckName == null)
                deckTitles[i] = "Empty Deck";
            else
                deckTitles[i] = fr.deckName;
            fr = null;
            //System.out.println(deckTitles[i]);
        }
        return deckTitles;
    }

}
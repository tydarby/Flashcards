import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class FlashcardMakerFrame extends JFrame implements ActionListener {

    public static boolean isDone = false; //this boolean acts as an off switch
    public File selectedDeck;
    FileWriter fw = null;
    PrintWriter output = null;

    JTextField firstSide = new JTextField(10);
    JTextField secondSide = new JTextField(10);
    JButton addCard;
    JButton done; //this button will allow the user to finish adding 

    public FlashcardMakerFrame(String title, File deck) throws IOException{
        super(title);
        selectedDeck = deck;
        setSize(400,400);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fw = new FileWriter(deck);
        output = new PrintWriter(fw);
        
        done = new JButton("Done");

        addCard = new JButton("Add card");
        addCard.setActionCommand("add");

        setLayout(new FlowLayout());
        add(firstSide);
        add(secondSide);
        add(addCard);
        add(done);
        secondSide.setActionCommand("add");
        secondSide.addActionListener(this);
        done.setActionCommand("done");
        done.addActionListener(this);

        addCard.addActionListener(this);

        //FileWriter fw = new FileWriter("E:\\AP CS\\Programs and Labs 2016-17\\FlashcardsExperimental\\data.txt");

        //         boolean carryOn = true;
        //         int i = 1;
        //         while(carryOn){
        //             System.out.println("Card " + i + " : ");
        //             i++;
        //             String l = firstSide.getText();
        //             String l2 = secondSide.getText();
        //             String l3 = "stop";
        //             output.printf("%s\t%s\t", l,l2);
        //             if(l.equals(l2)){
        //                 carryOn=false;
        //             }
        //         }
    }

    public void actionPerformed(ActionEvent event){
        try{
            if(event.getActionCommand().equals("add")){
                String l = firstSide.getText();
                System.out.println(l);
                String l2 = secondSide.getText();

                output.printf("%s\t%s\t", l,l2);
                firstSide.setText("");
                secondSide.setText("");
                if(l.equals(l2)){
                    output.close();
                    fw.close();
                    dispose();
                    isDone = true;
                    //stops file input, kills thread, and notifies main of tester of completion
                }              
            }
            if(event.getActionCommand().equals("done")){
                output.printf("%s\t%s\t", "","");               
                output.close();
                fw.close();
                dispose();
                isDone =true;
            }
        }
        catch(IOException ioe){
            System.out.println("idk");
        }

    }

}

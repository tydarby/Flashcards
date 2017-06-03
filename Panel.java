import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//http://chortle.ccsu.edu/java5/Notes/chap57/ch57_13.html
public class Panel extends JFrame implements ActionListener{
    int index = 0;
    int FIRSTSIDE = 0;
    int SECONDSIDE = 1;
    int CURRENTSIDE = 0;

    JLabel enterGuess;

    JButton flipButton;
    JButton nextButton;
    JButton randomizeButton;
    JButton checkButton;
    
    public ArrayList<Flashcard> flashcards;
    
    JTextField firstSide = new JTextField(10);
    JTextField guess = new JTextField(10);

    public Panel(String title, ArrayList<Flashcard> fcards){
        super(title);
        setSize(400,400);     
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );        
        
        flashcards = fcards;
        
        //label = new JLabel("sup");  
        enterGuess = new JLabel("Enter your guess");

        flipButton = new JButton("Flip");
        flipButton.setActionCommand("flip");
        nextButton = new JButton("Next");
        nextButton.setActionCommand("next");
        randomizeButton = new JButton("Randomize");
        randomizeButton.setActionCommand("randomize");
        checkButton = new JButton("Check");
        checkButton.setActionCommand("check");
        //label = new JLabel(getLabel(index));
        setLayout(new FlowLayout());

        //buttons
        add(randomizeButton);
        add(flipButton); 
        add(nextButton);
        //text fields
        add(firstSide);
        add(enterGuess);
        add(guess);
        add(checkButton);
        guess.setActionCommand("check");
        flipButton.addActionListener(this);
        nextButton.addActionListener(this);
        randomizeButton.addActionListener(this);
        guess.addActionListener(this);
        checkButton.addActionListener(this);
        
        if(flashcards.size()>0){
            firstSide.setText(getLabel(index, CURRENTSIDE));
        }

    }

    public void actionPerformed(ActionEvent event){
        //increase the index, unless at the end of the list
        if(event.getActionCommand().equals("next")){
            index++;
            if(index > flashcards.size() - 1){
                index = 0;
            }
            firstSide.setText(getLabel(index, CURRENTSIDE));
            guess.setText("");
            System.out.println(getLabel(index, CURRENTSIDE));
            System.out.println("SIDE: " + CURRENTSIDE + "INDEX: " + index);
        }
        //Other side becomes visible, index not effected
        if(event.getActionCommand().equals("flip")){
            int i = CURRENTSIDE;

            System.out.println(i);
            if(CURRENTSIDE == FIRSTSIDE){

                firstSide.setText(getLabel(index, SECONDSIDE));
                i = SECONDSIDE;

            }
            else if(CURRENTSIDE == SECONDSIDE){

                firstSide.setText(getLabel(index, FIRSTSIDE));
                i = FIRSTSIDE;

            }
            guess.setText("");
            CURRENTSIDE = i;
            System.out.println(getLabel(index, CURRENTSIDE));
            System.out.println("SIDE: " + CURRENTSIDE + "INDEX: " + index);
        }

//         if(event.getActionCommand().equals("randomize")){
//             FlashcardReader.flashcards = Functions.randomizeOrder(FlashcardReader.flashcards);
//         }
        //will notify the user if their guess is right or not
        if(event.getActionCommand().equals("check")){
            if(CURRENTSIDE == FIRSTSIDE){
                if(guess.getText().equals(getLabel(index, SECONDSIDE)))
                    guess.setText("Correct");              
                else
                    guess.setText("Incorrect");
            }
            if(CURRENTSIDE == SECONDSIDE){
                if(guess.getText().equals(getLabel(index, FIRSTSIDE)))
                    guess.setText("Correct");              
                else
                    guess.setText("Incorrect");

            }
        }
    }

    //searches through the flashcard array, and returns the needed side
    public String getLabel(int index, int side){
        String flashcardText = "";
        if(side == FIRSTSIDE){
            flashcardText = flashcards.get(index).getSide1();

        }
        else if(side == SECONDSIDE){
            flashcardText = flashcards.get(index).getSide2();
        }
        return flashcardText;    
    }

}
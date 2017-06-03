import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class NameDialog extends JDialog implements ActionListener{

    FileWriter fw;
    PrintWriter output;
    private String deckName = "";
    public JTextField nameField = new JTextField(10);
    public JLabel nameLabel;
    public static boolean isDone = false;

    //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/CustomDialog.java
    public NameDialog(File deck) throws IOException{
        fw = new FileWriter(deck, true);
        output = new PrintWriter(fw);
        
        setTitle("Enter name");
        setSize(200, 100);
        nameLabel = new JLabel("Enter a name for this deck");
        nameField.setActionCommand("done");
        nameField.addActionListener(this);

        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);

    }

    public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("done")){
            deckName = nameField.getText();
            output.printf("\n%s", deckName);
            try{
                output.close();
                fw.close();
            }
            catch(Exception e){
                System.out.println(" ");
            }

            isDone = true;
            dispose();
        }
    }

    public String getDeckName(){
        return deckName;
    }

}
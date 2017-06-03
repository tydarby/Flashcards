import java.util.ArrayList;

public class Functions{
    //Returns a randomized order of a passed arraylist
    public static ArrayList<Flashcard> randomizeOrder(ArrayList<Flashcard> fCards){
        ArrayList<Flashcard> temp = new ArrayList<Flashcard>();
        while(fCards.size()>0){
            int random = (int)(Math.random()*fCards.size());
            temp.add(fCards.remove(random));
            
        }
        return temp;
    }
}
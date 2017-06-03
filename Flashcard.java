public class Flashcard{
    private String side1;
    private String side2;
    public Flashcard(String s1, String s2){
        side1 = s1;
        side2 = s2;
    }
    public String getSide1(){
        return side1;
    }
    
    public String getSide2(){
        return side2;
    }
}
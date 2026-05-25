import javax.swing.*;
import java.util.ArrayList;

public class GameSystem {
    private int score;
    private ArrayList<Fish> fishCollection=new ArrayList<>();

    public GameSystem() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Fish> getFishCollection() {
        return fishCollection;
    }

    public void setFishCollection(ArrayList<Fish> fishCollection) {
        this.fishCollection = fishCollection;
    }

    public void init(){
        score=0;
        ImageIcon fishIm1=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm2=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm3=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm4=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm5=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm6=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm7=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm8=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm9=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm10=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm11=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm12=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm13=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm14=new ImageIcon(getClass().getResource("fish1.png"));


        fishCollection.add(new Fish("Green Sunfish",5,Rarity.COMMON,fishIm1));
        fishCollection.add(new Fish("Fish2",7,Rarity.COMMON,fishIm2));
        fishCollection.add(new Fish("Fish3",8,Rarity.COMMON,fishIm3));
        fishCollection.add(new Fish("Fish4",10,Rarity.COMMON,fishIm4));
        fishCollection.add(new Fish("Fish5",13,Rarity.UNCOMMON,fishIm5));
        fishCollection.add(new Fish("Fish6",15,Rarity.UNCOMMON,fishIm6));
        fishCollection.add(new Fish("Fish7",19,Rarity.UNCOMMON,fishIm7));
        fishCollection.add(new Fish("Fish8",21,Rarity.RARE,fishIm8));
        fishCollection.add(new Fish("Fish9",25,Rarity.RARE,fishIm9));
        fishCollection.add(new Fish("Fish10",30,Rarity.RARE,fishIm10));
        fishCollection.add(new Fish("Fish11",75,Rarity.EPIC,fishIm11));
        fishCollection.add(new Fish("Fish12",80,Rarity.EPIC,fishIm12));
        fishCollection.add(new Fish("Fish13",150,Rarity.LEGENDARY,fishIm13));
        fishCollection.add(new Fish("Fish14",200,Rarity.LEGENDARY,fishIm14));

        //fishCollection.get(5).setInIndex(true);
        //fishCollection.get(12).setInIndex(true);
        //fishCollection.get(8).setInIndex(true);

    }
}

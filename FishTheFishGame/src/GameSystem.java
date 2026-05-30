import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class GameSystem implements Serializable {
    private int score;
    private ArrayList<Fish> fishCollection=new ArrayList<>();
    private String lastPlus = "";

    public File savingFile(){
        try {
            File location=new File(GameSystem.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            return new File(location.getParentFile(),"save.ftf");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

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

    public String getLastPlus() {
        return lastPlus;
    }

    public void setLastPlus(String lastPlus) {
        this.lastPlus = lastPlus;
    }


    public void save() throws IOException {
        FileOutputStream fos=new FileOutputStream(savingFile());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        fos.close();
    }



    public static GameSystem load() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(new GameSystem().savingFile());
        ObjectInputStream ois=new ObjectInputStream(fis);
        GameSystem loadingSystem= (GameSystem) ois.readObject();
        ois.close();
        fis.close();
        return loadingSystem;
    }



    public void init(){
        score=0;
        ImageIcon fishIm1=new ImageIcon(getClass().getResource("fish1.png"));
        ImageIcon fishIm2=new ImageIcon(getClass().getResource("fish2.png"));
        ImageIcon fishIm3=new ImageIcon(getClass().getResource("fish3.png"));
        ImageIcon fishIm4=new ImageIcon(getClass().getResource("fish4.png"));
        ImageIcon fishIm5=new ImageIcon(getClass().getResource("fish5.png"));
        ImageIcon fishIm6=new ImageIcon(getClass().getResource("fish6.png"));
        ImageIcon fishIm7=new ImageIcon(getClass().getResource("fish7.png"));
        ImageIcon fishIm8=new ImageIcon(getClass().getResource("fish8.png"));
        ImageIcon fishIm9=new ImageIcon(getClass().getResource("fish9.png"));
        ImageIcon fishIm10=new ImageIcon(getClass().getResource("fish10.png"));
        ImageIcon fishIm11=new ImageIcon(getClass().getResource("fish11.png"));
        ImageIcon fishIm12=new ImageIcon(getClass().getResource("fish12.png"));
        ImageIcon fishIm13=new ImageIcon(getClass().getResource("fish13.png"));
        ImageIcon fishIm14=new ImageIcon(getClass().getResource("fish14.png"));
        ImageIcon fishIm15=new ImageIcon(getClass().getResource("fish15.png"));



        ImageIcon miscatch1=new ImageIcon(getClass().getResource("fishDead.png"));
        ImageIcon miscatch2=new ImageIcon(getClass().getResource("mine.png"));




        fishCollection.add(new Fish("Dead fish",-10,Rarity.MISCATCH,miscatch1));
        fishCollection.add(new Fish("Mine",-45,Rarity.MISCATCH,miscatch2));
        fishCollection.add(new Fish("Green Sunfish",5,Rarity.COMMON,fishIm1));
        fishCollection.add(new Fish("Squarespot Anthias",7,Rarity.COMMON,fishIm2));
        fishCollection.add(new Fish("Pink Widow Tetra",8,Rarity.COMMON,fishIm7));
        fishCollection.add(new Fish("Bluefish",10,Rarity.COMMON,fishIm6));
        fishCollection.add(new Fish("Carp",13,Rarity.UNCOMMON,fishIm5));
        fishCollection.add(new Fish("Salmon",15,Rarity.UNCOMMON,fishIm11));
        fishCollection.add(new Fish("Bluegill",19,Rarity.UNCOMMON,fishIm3));
        fishCollection.add(new Fish("Cocky fish",21,Rarity.RARE,fishIm8));
        fishCollection.add(new Fish("Koi",25,Rarity.RARE,fishIm9));
        fishCollection.add(new Fish("Clown fish",30,Rarity.RARE,fishIm12));
        fishCollection.add(new Fish("Pseudanthias",75,Rarity.EPIC,fishIm4));
        fishCollection.add(new Fish("Koi with hat",80,Rarity.EPIC,fishIm10));
        fishCollection.add(new Fish("Clown Clown Fish",150,Rarity.LEGENDARY,fishIm13));
        fishCollection.add(new Fish("Tralalero Tralala",200,Rarity.LEGENDARY,fishIm14));
        fishCollection.add(new Fish("Cat Fih",250,Rarity.LEGENDARY,fishIm15));
    }
}

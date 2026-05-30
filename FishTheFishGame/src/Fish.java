import javax.swing.*;
import java.io.Serializable;

public class Fish implements Serializable {
    private String name;
    private int value;
    private Rarity rarity;
    private boolean inIndex;
    private Icon image;


    public Fish(String name, int value, Rarity rarity, Icon image) {
        this.name = name;
        this.value = value;
        this.rarity = rarity;
        this.inIndex = false;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public boolean isInIndex() {
        return inIndex;
    }

    public void setInIndex(boolean inIndex) {
        this.inIndex = inIndex;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }
}

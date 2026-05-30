import java.io.File;

public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem;
        File savingFile=new File("save.ftf");

        if (savingFile.exists()){
            try {
                gameSystem=GameSystem.load();
            } catch (Exception e) {
                gameSystem=new GameSystem();
                gameSystem.init();
            }
        } else {
            gameSystem=new GameSystem();
            gameSystem.init();
        }

        MainMenu mmenu = new MainMenu(gameSystem);
    }

}
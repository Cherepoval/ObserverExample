package app;

import editor.Editor;
import listeners.EmailNotificationListener;
import listeners.LogOpenListener;

public class Application {
    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.eventManager.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.eventManager.subscribe("save", new EmailNotificationListener("apostol.petr@hotmail.com"));

        try{
            editor.openFile("textFile.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

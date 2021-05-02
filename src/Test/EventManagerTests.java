package Test;

import editor.Editor;
import listeners.EmailNotificationListener;
import listeners.LogOpenListener;
import org.junit.jupiter.api.Test;


public class EventManagerTests {
    Editor editor = new Editor();

    @Test
    public void subscribeNewListenerTest() {

        editor.eventManager.subscribe("open", new LogOpenListener("/path/to/log/test_file.txt"));
        editor.eventManager.subscribe("save", new LogOpenListener("/path/to/log/test_file.txt"));
        editor.eventManager.subscribe("open", new EmailNotificationListener("email.test@hotmail.com"));
        editor.eventManager.subscribe("save", new EmailNotificationListener("email.test@hotmail.com"));

    }

    @Test
    public void openAndSaveFileTest() throws Exception {

        editor.openFile("testFile.txt");
        editor.saveFile();

    }
}

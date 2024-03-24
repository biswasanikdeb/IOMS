import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.io.*;
import com.common.*;
public class CheckFileTest {
   
    @Test
    public void fileTest(){
        File newfile = new File(".\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile(".\\main\\java\\com\\inventory\\inventory.json");
        assertFalse(file.checkFile(".\\main\\java\\com\\inventory\\inventory.json", newfile));
    }
    @Test
    public void fileCreateTest(){
        File newfile = new File(".\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile(".\\main\\java\\com\\inventory\\inventory.json");
        assertTrue(file.createFile(".\\main\\java\\com\\inventory\\inventory.json", newfile));
    }
}

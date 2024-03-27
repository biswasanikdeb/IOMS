import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.*;
import com.common.*;
public class CheckFileTest {
   
    @Test
    public void fileTest(){
        File newfile = new File("E:\\PS_project\\JAVA-PROJECT\\src\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile();
        assertTrue(file.checkFile(newfile));
    }
    @Test
    public void fileCreateTest(){
        File newfile = new File("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile();
        assertFalse(file.createFile(newfile));
    }
}

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.io.*;
import com.common.*;
public class CheckFileTest {
   
    @Test
    public void fileTest(){
        File newfile = new File("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json");
        assertTrue(file.checkFile("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json", newfile));
    }
    @Test
    public void fileCreateTest(){
        File newfile = new File("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json");
        CheckFile file = new CheckFile("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json");
        assertTrue(file.createFile("D:\\code\\PS_project\\ioms\\src\\main\\java\\com\\inventory\\inventory.json", newfile));
    }
}

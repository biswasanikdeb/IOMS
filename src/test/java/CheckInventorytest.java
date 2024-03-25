import com.inventory.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;

import org.junit.jupiter.api.Test;

public class CheckInventorytest {
    CheckInventory inventory = new CheckInventory();

    @Test
    void testing(){
        assertTrue(inventory.anyreturn());
    }
    
}

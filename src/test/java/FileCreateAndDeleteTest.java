import com.common.DataManagement;
import com.common.PathBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileCreateAndDeleteTest {
    PathBuilder pb  = new PathBuilder("iventory", "data", "name1", "id", "buying price", "selling price", "quantity", "online");
    DataManagement dtm = new DataManagement();
    File newfile = new File(pb.getPath());

    @Test
    public void filecreationtest(){
        assert(dtm.checkData(newfile));
    }
    
}

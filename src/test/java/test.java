import org.example.ArraySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySetTest {

    @Test
    public void TestContainsWithEmptyArraySet() {
        ArraySet as = new ArraySetTest(10);
        boolean b = as.contains(5);
        assertFalse(b);
    }

    @Test
    public void TestAdd(){

    }

}

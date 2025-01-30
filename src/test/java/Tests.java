import org.example.ArraySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySetTests {



    @Test
    public void testAdd() {
        ArraySet as = new ArraySet(10); //Arrange
        int oldSize = as.getSize();
        as.add(5);                      //Act
        assertEquals(as.getSize(), oldSize + 1);//Ass:ert
    }

    @Test
    public void TestContainsWithEmptyArraySet() {
        ArraySet as = new ArraySetTest(10);
        boolean b = as.contains(5);
        assertFalse(b);
    }
}


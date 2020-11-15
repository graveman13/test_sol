import com.company.Main;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ChunckArray {
    @Test
    public void checkChunk() {
        assertArrayEquals(Main.chunk(new int[]{1, 2, 3, 4}, 2), new int[][]{{1, 2}, {3, 4}});
        assertArrayEquals(Main.chunk(new int[]{1, 2, 3, 4}, 3), new int[][]{{1, 2, 3}, {4}});
        assertArrayEquals(Main.chunk(new int[]{1, 2, 3, 4}, 5), new int[][]{{1, 2, 3, 4}});
        assertArrayEquals(Main.chunk(new int[]{1, 2, 3, 4, 5, 6}, 2), new int[][]{{1, 2}, {3, 4}, {5, 6}});
    }
}

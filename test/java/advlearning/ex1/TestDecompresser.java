package advlearning.ex1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDecompresser {

    @Test
    public void testGeneral() {
        assertEquals("Simple check should be equals", "abcabcabcababababc", Decompresser.decompressString("3[abc]4[ab]c"));
    }

    @Test
    public void testInternalCompression() {
        assertEquals("Simple check should be equals", "abcabcabcababababc", Decompresser.decompressString("3[a2[k]bc]4[ab]c"));
    }
}

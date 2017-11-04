package advlearning.ex1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDecompresser {

    @Test
    public void testSimpleInput() {
        assertEquals("Simple check should be equals", "aadfadf", Decompresser.decompressString("aadfadf"));
    }

    @Test
    public void testGeneral() {
        assertEquals("General check should be equals", "abcabcabcababababc", Decompresser.decompressString("3[abc]4[ab]c"));
    }

    @Test
    public void testLongNumb() {
        assertEquals("Value should be equal",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Decompresser.decompressString("111[a]"));
    }

    @Test
    public void testInternalCompression() {
        assertEquals("Value should be equal", "akkbcakkbcakkbcababababc", Decompresser.decompressString("3[a2[k]bc]4[ab]c"));
    }

    @Test
    public void testEmptyBrackets() {
        assertEquals("Value should be equal", "abcabcabc", Decompresser.decompressString("3[a2[]bc]"));
    }

    @Test(expected = RuntimeException.class)
    public void testNullValue() {
        assertEquals("Value should be equal", "abcabcabc", Decompresser.decompressString(null));
    }
}

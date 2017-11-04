package androidcourse.ex1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask {

    @Test
    public void testGetCountry() {
        assertEquals("The country name was not found by the code.", "Afghanistan",
                Task.getCountryOrCode("AFG"));
    }

    @Test
    public void testGetCode() {
        assertEquals("The country name was not found by the code.", "AFG",
                Task.getCountryOrCode("Afghanistan"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalInput() {
        assertEquals("Test short code", "", Task.getCountryOrCode("AF"));
    }

    @Test(expected = RuntimeException.class)
    public void testCodeNotExist() {
        assertEquals("Test short code", "", Task.getCountryOrCode("AFF"));
    }

    @Test(expected = RuntimeException.class)
    public void testCountryNotExist() {
        assertEquals("Test short code", "", Task.getCountryOrCode("ffffffff"));
    }
}

package com.herbalife;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLibraryTest {
    private MyLibrary myLibrary;

    @BeforeEach
    public void setUp() {
        myLibrary = new MyLibrary();
    }

    @AfterEach
    public void tearDown() {
        myLibrary = null;
    }

    @Test
    public void testNotNull() {
        assertNotNull(myLibrary);
    }

    @Test
    public void testLibraryOfNumbersIsEmptyInTheBeginning() {
        assertEquals(0, myLibrary.getSize());
    }

    @Test
    public void testLibraryOfNumbersIsNotEmptyAfterAddingANumber() {
        myLibrary.addNumber(1);
        assertEquals(1, myLibrary.getSize());
    }

    @Test
    public void testAvoidDuplicationOfNumbers() {
        assertThrows(RuntimeException.class, () -> {
            myLibrary.addNumber(1);
            myLibrary.addNumber(1);
        });
    }

    @Test
    public void testRemoveNumber() {
        myLibrary.addNumber(1);
        myLibrary.addNumber(2);
        myLibrary.addNumber(3);
        myLibrary.removeNumber(2);
        assertEquals(2, myLibrary.getSize());
    }

    @Test
    public void testRemoveNumberThatDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            myLibrary.addNumber(1);
            myLibrary.removeNumber(2);
        });
    }

}

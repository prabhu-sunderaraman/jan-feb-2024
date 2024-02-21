package com.herbalife;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MyLibraryUsingMockitoTest {
    @Mock
    private List<Integer> numbers;

    @Mock
    private SomeDummyClass someDummyClass;

    @InjectMocks
    private MyLibrary myLibrary;

    @Test
    public void testNotNull() {
        assertNotNull(myLibrary);
        assertNotNull(numbers);
        assertNotNull(someDummyClass);
        assertNotNull(myLibrary.getSomeDummyClass());
    }

    @Test
    public void testLibraryOfNumbersIsEmptyInTheBeginning() {
        assertEquals(0, myLibrary.getSize());
        verify(numbers, times(1)).size();
    }

    @Test
    public void testLibraryOfNumbersIsNotEmptyAfterAddingANumber() {
        when(numbers.add(1)).thenReturn(true);
        when(numbers.size()).thenReturn(1);
        myLibrary.addNumber(1);
        assertEquals(1, myLibrary.getSize());
    }
}
package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author 1", "Title 1", 2000, "0001"));
        bookSet.add(new Book("Author 2", "Title 2", 1995, "0002"));
        bookSet.add(new Book("Author 3", "Title 3", 2010, "0003"));
        bookSet.add(new Book("Author 4", "Title 4", 1980, "0004"));
        bookSet.add(new Book("Author 5", "Title 5", 2005, "0005"));

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int median = medianAdapter.publicationYearMedian(bookSet);

        // Then
        assertEquals(2000, median);
    }
}
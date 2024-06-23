package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {
        // Given
        Library library = new Library("Main Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author " + n, LocalDate.of(2000 + n, 1, 1))));

        // When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(new Book("Title 1", "Author 1", LocalDate.of(2001, 1, 1)));

        // Then
        System.out.println("Original Library: \n" + library);
        System.out.println("Shallow Copied Library: \n" + clonedLibrary);
        System.out.println("Deep Copied Library: \n" + deepClonedLibrary);

        assertEquals(9, library.getBooks().size());
        assertEquals(9, clonedLibrary.getBooks().size());
        assertEquals(10, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}

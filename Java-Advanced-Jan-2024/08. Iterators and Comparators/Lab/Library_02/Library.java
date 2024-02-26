package iterators_and_comparators.Library_02;

import iterators_and_comparators.Library_02.Book;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private static Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    class LibIterator implements Iterator<Book> {

        private int pos = 0;
        @Override
        public boolean hasNext() {
            return pos < books.length;
        }

        @Override
        public Book next() {
            return books[pos++];
        }
    }
}
package iterators_and_comparators.BookComparator_04;

import iterators_and_comparators.BookComparator_04.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.compareTo(o2);
    }
}
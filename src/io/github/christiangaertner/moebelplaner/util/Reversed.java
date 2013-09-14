package io.github.christiangaertner.moebelplaner.util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Christian
 */
public final class Reversed<T> implements Iterable<T> {

    /**
     * Die Orginale Liste
     */ 
    private final List<T> org;
    
    public Reversed(List<T> original) {
        org = original;
    }
    
    
    @Override
    public Iterator<T> iterator() {
        final ListIterator<T> i = org.listIterator(org.size());
 
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return i.hasPrevious();
            }
 
            @Override
            public T next() {
                return i.previous();
            }
 
            @Override
            public void remove() {
                i.remove();
            }
        };
    }
    
    public static <T> Reversed<T> reversed(List<T> orginal) {
        return new Reversed<T>(orginal);
    }
    
}

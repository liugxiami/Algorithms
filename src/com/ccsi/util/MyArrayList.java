package com.ccsi.util;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by gxliu on 2016/10/30.
 */
public class MyArrayList<E> implements List<E> {

    Object[] core;
    private int end;

    public MyArrayList() {
        this.core = new Object[10];
        this.end = 0;
    }

    @Override
    public int size() {
        return this.end;
    }

    @Override
    public boolean isEmpty() {
        return this.end == 0;
    }

    private int containsCore(Object o) {
        if (!(o instanceof Object)) return -1;
        E temp = (E) (o);
        for (int i = 0; i < end; i++) {
            if (core[i].equals(temp)) return i;
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return containsCore(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.core, this.end);

    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        this.core[end++] = e;
        if (this.end == this.core.length) {
            this.core = Arrays.copyOf(this.core, this.end + this.end / 10);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int ti = containsCore(o);
        if (ti != -1) {
            for (int i = ti; i < end - 1; i++) {
                this.core[i] = this.core[i + 1];
            }
            this.end--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            E temp = (E) o;
            if (!contains(temp)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (Object o : c) {
            this.end++;
            if (this.end == this.core.length) {
                this.core = Arrays.copyOf(this.core, this.end + this.end / 10);
            }
            E temp = (E) o;
            this.core[end] = temp;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        this.end += c.size();
        if (this.end >= this.core.length) {
            this.core = Arrays.copyOf(this.core, this.end + this.end / 10);
        }
        for (int i = this.end - 1; i > index; i--) {
            this.core[i] = this.core[i - c.size()];
        }
        for (Object o : c) {
            E temp = (E) o;
            this.core[index++] = temp;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort(core, 0, this.end - 1);
    }

    @Override
    public void clear() {
        this.end = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.end) ;
        return (E) this.core[index];
    }

    @Override
    public E set(int index, E element) {
        this.core[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        this.end++;
        if (this.end == this.core.length) {
            this.core = Arrays.copyOf(this.core, this.end + this.end / 10);
        }
    }

    @Override
    public E remove(int index) {
        E temp = (E) this.core[index];
        for (int i = index; i < end; i++) {
            this.core[i] = this.core[i + 1];
        }
        this.end--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < end; i++) {
            if (this.core[i].equals((E) o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = end; i >= 0; i--) {
            if (this.core[i].equals((E) o)) return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }
}

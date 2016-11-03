package com.ccsi.util;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.HashSet;

/**
 * Created by gxliu on 2016/10/31.
 */
public class MyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        HashSet<E> set = new HashSet<>();
        for (Object o : c) {
            set.add((E) o);
        }

        Node<E> p = head;
        while (p != null) {
            set.remove(p.val);
        }

        return set.size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> p = head;
        int i = 0;
        while (p != null) {
            result[i++] = p.val;
            p = p.next;
        }

        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == 0) {
            head = new Node<>(e);
            tail = head;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }

        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (Object o : c) {
            add((E) o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0 || c.size() == 0) return false;

        Node<E> first = null;      //how to save the first temp node?
        Iterator iter = c.iterator();
        if (iter.hasNext()) {
            first = new Node<>((E) iter.next());
        }
        Node<E> last = first;
        while (iter.hasNext()) {
            E target = (E) iter.next();
            last.next = new Node<>(target);
            last = last.next;
        }

        if (index == 0) {
            last.next = head;
            head = first;
        } else if (index == size) {
            tail.next = first;
            tail = last;
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            last.next = p.next;
            p.next = first;
        }

        size += c.size();
        return true;
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

    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) return null;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val = element;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) return;
        if (index == 0) {
            Node<E> temp = new Node<>(element);
            temp.next = head;
            head = temp;
        } else if (index == size) {
            tail.next = new Node<>(element);
            tail = tail.next;
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            Node<E> temp = new Node<>(element);
            temp.next = p.next;
            p.next = temp;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;

        if (index == 0) {
            E val = head.val;
            head = head.next;
            size--;
            return val;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            E val = temp.next.val;
            temp.next = temp.next.next;
            size--;
            return val;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) return false;
        E target = (E) o;
        if (head.val.equals(target)) {
            head = head.next;
        } else {
            Node<E> p = head;
            while (p.next != null && !p.next.val.equals(target)) {
                p = p.next;
            }

            if (p.next != null) {
                p.next = p.next.next;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (size == 0) return false;

        Set<E> set = new HashSet<>();
        for (Object o : c) {
            E target = (E) o;
            set.add(target);
        }

        Node<E> dummyHead = new Node<>(null);
        dummyHead.next = head;
        Node<E> temp = dummyHead;
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                set.remove(temp.next.val);
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }

        return set.isEmpty();
    }

    @Override
    public int indexOf(Object o) {
        if (size == 0) return -1;
        E target = (E) o;
        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            if (p.val.equals(target)) return i;
            p = p.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (size == 0) return -1;
        E target = (E) o;
        Node<E> p = head;
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (p.val.equals(target)) result = i;
            p = p.next;
        }

        return result;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
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

    private class Node<E> {
        public E val;
        public Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }
}

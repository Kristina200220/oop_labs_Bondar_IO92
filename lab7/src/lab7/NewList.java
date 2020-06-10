package lab7;

import java.util.*;
import java.util.function.UnaryOperator;

public class NewList implements List<Car> {
    private Node head;
    private Node tail;
    private int size;

    public NewList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public NewList(Car car) {
        this.head = new Node(car);
        this.tail = this.head;
        size++;
    }

    public NewList(Collection<Car> car) {
        size = car.size();
        Iterator<Car> iter = car.iterator();
        head = new Node(iter.next());
        tail = new Node(iter.next());
        tail.setPrevious(head);
        head.setNext(tail);
        for (int i = 0; i < size-2; i++) {
            Node temp = tail.getPrevious();
            tail = new Node(iter.next());
            tail.setPrevious(temp);
            temp.setNext(tail);
        }
    }

    @Override
    public void replaceAll(UnaryOperator<Car> operator) {

    }

    @Override
    public void sort(Comparator<? super Car> c) {
    }

    @Override
    public Spliterator<Car> spliterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Car) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.equals(o)) return true;
                temp = temp.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Car next() {
                Node result = temp;
                if (temp != null) {
                    temp = temp.getNext();
                } else {
                    System.out.println("Error");
                }
                return result.getCar();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Car car) {
        if (isEmpty()) {
            head = new Node(car);
            tail = head;
        } else {
            Node temp = tail;
            tail = new Node(car);
            temp.setNext(tail);
            tail.setPrevious(temp);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Car) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.equals(o)) {
                    if (i == 0 && size == 1) {
                        head = null;
                        tail = null;
                        size = 0;
                        return true;
                    } else if (i == 0) {
                        head = head.getNext();
                        head.setPrevious(null);
                        size--;
                        System.gc();
                        return true;
                    } else if (i == size - 1) {
                        tail = tail.getPrevious();
                        tail.setNext(null);
                        size--;
                        System.gc();
                        return true;
                    } else {
                        if (temp.getPrevious() != null) temp.getPrevious().setNext(temp.getNext());
                        if (temp.getNext() != null) temp.getNext().setPrevious(temp.getPrevious());
                        size--;
                        System.gc();
                        return true;
                    }
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Car> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Car> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.gc();
    }

    @Override
    public Car get(int i) {
        try {
            if (i > 0 && i < size) {
                Node temp = head;
                for (int j = 0; j < size; j++) {
                    if (j == i) {
                        return temp.getCar();
                    }
                    temp = temp.getNext();
                }
            } else {
                throw new WrongIExceprion(i);
            }
        } catch (WrongIExceprion e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car set(int i, Car car) {
        Node temp = head;
        for (int j = 0; j < size; j++) {
            if (j == i) {
                temp.setCar(car);
                return temp.getCar();
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public void add(int i, Car car) {
        try {
            if (isEmpty() && i == 0) {
                head = new Node(car);
                tail = head;
                size++;
            } else if (i == size) {
                Node temp = tail;
                tail = new Node(car);
                temp.setNext(tail);
                tail.setPrevious(temp);
                size++;
            } else if (i > 0 && i < size) {
                Node temp = head;
                Node temp1;
                for (int j = 0; j < size; j++) {
                    if (j == i) {
                        temp1 = temp;
                        temp = new Node(car);
                        temp.setNext(temp1);
                        temp.setPrevious(temp1.getPrevious());
                        temp1.setPrevious(temp);
                        size++;
                    }
                    temp = temp.getNext();
                }
            } else {
                throw new WrongIExceprion(i);
            }
        } catch (WrongIExceprion e) {
            e.printStackTrace();
        }

    }

    @Override
    public Car remove(int i) {

        Node temp = head;
        for (int j = 0; j < size; j++) {
            if (j == i) {
                if (temp.getPrevious() != null) temp.getPrevious().setNext(temp.getNext());
                if (temp.getNext() != null) temp.getNext().setPrevious(temp.getPrevious());
                size--;
                System.gc();
                return null;
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o instanceof Car) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.equals(o)) {
                    return i;
                }
                temp = temp.getNext();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int j = -1;
        if (o instanceof Car) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.equals(o)) {
                    j = i;
                }
                temp = temp.getNext();
            }
        }
        return j;
    }

    @Override
    public ListIterator<Car> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Car> listIterator(int i) {
        return null;
    }

    @Override
    public List<Car> subList(int i, int i1) {
        return null;
    }
}

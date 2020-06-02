package lab7;

public class Node {
    private Node previous;
    private Node next;
    private Car car;

    public Node(Car car) {
        this.car = car;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public Car getCar() {
        return car;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Car && car.equals(obj);
    }

}

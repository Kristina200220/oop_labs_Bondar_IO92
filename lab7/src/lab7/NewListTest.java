package lab7;

import static org.junit.jupiter.api.Assertions.*;

class NewListTest {

    @org.junit.jupiter.api.Test
    void size() {
        System.out.println("Start size test!");
        NewList newList = new NewList();
        assertEquals(0, newList.size());
        System.out.println("Work successfully!");
    }

    @org.junit.jupiter.api.Test
    void isEmpty() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start isEmpty test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                assertFalse(newList.isEmpty());
                System.out.println("Work correctly");
    }

    @org.junit.jupiter.api.Test
    void contains() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start contains test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                assertFalse(newList.contains(new Car(100, 120, 500000, "MAN")));
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void add() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start add test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                assertEquals(1, newList.size());
                newList.add(new Car(100, 120, 500000, "MAN"));
                assertEquals(2, newList.size());
                assertTrue(newList.contains(new Car(20, 150, 250000, "Hummer")));
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void remove() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start remove test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                newList.remove(new Car(100, 120, 500000, "MAN"));
                assertFalse(newList.contains(new Car(100, 120, 500000, "MAN")));
                assertEquals(1, newList.size());
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void clear() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start clear test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                newList.clear();
                assertTrue(newList.isEmpty());
                assertEquals(0, newList.size());
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void get() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start get test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                Car car = newList.get(1);
                assertEquals(car, new Car(100, 120, 500000, "MAN"));
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void set() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start set test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                Car car = newList.set(1, new Car(20, 150, 250000, "Hummer"));
                assertEquals(car, newList.get(1));
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void indexOf() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start indexOf test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                int car = newList.indexOf(new Car(100, 120, 500000, "MAN"));
                assertEquals(1, car);
                System.out.println("Work correctly!");
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {
                System.out.println("Start lastIndexOf test!");
                NewList newList = new NewList();
                newList.add(new Car(20, 150, 250000, "Hummer"));
                newList.add(new Car(100, 120, 500000, "MAN"));
                newList.add(new Car(20, 150, 250000, "Hummer"));
                int car = newList.lastIndexOf(new Car(20, 150, 250000, "Hummer"));
                assertEquals(2, car);
                System.out.println("Work correctly!");
    }
}
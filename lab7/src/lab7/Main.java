package lab7;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws WrongSpeedException, WrongPriceException, WrongNameException,
            WrongFuelConsumptionException {

                NewList newList = new NewList();
                System.out.println(newList.size());
                newList.add(new Car(20, 150, 250000, "Hummer"));
                System.out.println(newList.size());
                System.out.println(newList.isEmpty());
                System.out.println(newList.get(2));
                newList.add(new Car(100, 120, 500000, "MAN"));
                Iterator<Car> iterator = newList.iterator();
                System.out.println(iterator.hasNext());
                System.out.println(iterator.next());
                System.out.println(newList.contains(new Car(20, 150, 250000,
                        "Hummer")));
                System.out.println(newList.size());
                newList.clear();
                System.out.println(newList.size());
                System.out.println(newList.isEmpty());
                newList.add(new Car(20, 150, 250000, "Hummer"));
                System.out.println(newList.isEmpty());

    }

}

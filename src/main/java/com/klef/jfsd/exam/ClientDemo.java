package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        // Insert Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Generic Vehicle");
        vehicle.setType("General");
        vehicle.setMaxSpeed(120);
        vehicle.setColor("White");

        // Insert Car
        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(180);
        car.setColor("Red");
        car.setNumberOfDoors(4);

        // Insert Truck
        Truck truck = new Truck();
        truck.setName("Freightliner");
        truck.setType("Truck");
        truck.setMaxSpeed(100);
        truck.setColor("Blue");
        truck.setLoadCapacity(15000);

        // Persist objects
        session.persist(vehicle);
        session.persist(car);
        session.persist(truck);

        transaction.commit();

        session.close();
        factory.close();

        System.out.println("Records inserted successfully!");
    }
}

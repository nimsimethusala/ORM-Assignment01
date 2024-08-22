package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GetData {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        FullName fullName = new FullName("Aruni", "Mendis");

        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Panadura");

        //open transaction
        Transaction transaction = session.beginTransaction();

        Student student1 = session.get(student.getClass(), 1);
        System.out.println(student1.getId());
        System.out.println(student1.getName().getFirstName());
        System.out.println(student1.getName().getLastName());
        System.out.println(student1.getAddress());

        transaction.commit();
        session.close();
    }
}

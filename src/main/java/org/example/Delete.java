package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Employee;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        FullName fullName = new FullName("Aruni", "Mendis");

        Student student = new Student();
        Employee employee = new Employee();
        student.setId(3);
        student.setName(fullName);
        student.setAddress("Panadura");

        employee.setId(3);
        employee.setName(fullName);
        employee.setAddress("Panadura");

        //open transaction
        Transaction transaction = session.beginTransaction();

        session.delete(student);
        session.delete(employee);

        transaction.commit();
        session.close();
    }
}

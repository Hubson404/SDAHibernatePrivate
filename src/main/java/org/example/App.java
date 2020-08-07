package org.example;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.sound.midi.Soundbank;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        LocationDao locationDao = new LocationDao();
        DepartmentDao departmentDao = new DepartmentDao();

        Location gdansk = new Location();
        gdansk.setCity("Gdańsk");
        gdansk.setPostalCode("80-800");
        gdansk.setStreetAdderss("Gdańsk");

        Department backendDev = new Department();
        backendDev.setDepartmentName("Backend developers");
        backendDev.setLocation(gdansk);

        Department frontendDev = new Department();
        frontendDev.setLocation(new Location());
        frontendDev.setDepartmentName("Frontend developers");
        frontendDev.setLocation(gdansk);

        List<Department> departments = Arrays.asList(frontendDev,backendDev);
        gdansk.setDepartments(departments);

        locationDao.save(gdansk);
        departmentDao.save(backendDev);
        departmentDao.save(frontendDev);


        locationDao.getAll().forEach(System.out::println);
        departmentDao.getAll().forEach(System.out::println);


//        locationDao.save(new Location(
//                "Gdanska",
//                "80-000",
//                "Gdansk",
//                "Pomorskie",
//                2
//        ));
//
//        locationDao.save(new Location(
//                "Gdynska",
//                "80-000",
//                "Gdynia",
//                "Pomorskie",
//                2
//        ));
//
//        System.out.println("******** ALL");
//        locationDao.getAll().forEach(System.out::println);
//
//        System.out.println("******** GET 1");
//        Location gdansk = locationDao.get(1);
//        System.out.println(gdansk);
//        gdansk.setCity("Jednak Sopot");
//        locationDao.update(gdansk);
//
//        System.out.println("********* GET ALL AFTER UPDATE");
//        locationDao.getAll().forEach(System.out::println);

//        locationDao.delete(1);
//
//        System.out.println("********* GET ALL AFTER DELETE");
//        locationDao.getAll().forEach(System.out::println);

    }

//    static public void init(String departmentName, int locationId){
//
//        DepartmentDao departmentDao = new DepartmentDao();
//        departmentDao.save(new Department(departmentName,locationId));
//    }

}

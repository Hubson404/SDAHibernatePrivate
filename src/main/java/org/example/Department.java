package org.example;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS",
        indexes = @Index(columnList = "DEPARTMENT_NAME", name = "DEPARTMENT_NAME_IDX")
       , uniqueConstraints = {@UniqueConstraint(columnNames = {"DEPARTMENT_NAME","LOCATION_LOCATION_ID"})})

public class Department {

    public Department() {
    }

    public Department(String departmentName, Location location) {
        this.departmentName = departmentName;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private int departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    //@Column(name = "LOCATION_ID")
    @ManyToOne
    private Location location;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location.getLocationId() +
                '}';
    }
}

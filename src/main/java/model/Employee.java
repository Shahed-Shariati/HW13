package model;

import javax.persistence.*;

@MappedSuperclass
@PrimaryKeyJoinColumn(name = "user_id")
@Inheritance(strategy = InheritanceType.JOINED)
 public class Employee extends Person{
    protected Double salary;


    public Employee()
    {

    }
    public Employee(Integer id, String firstName, String lastName, String address, String nationalCode, String userName, String passWord, Role role, Double salary) {
        super(id, firstName, lastName, address, nationalCode, userName, passWord, role);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

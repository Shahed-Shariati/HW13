package model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff extends Employee {

    public Staff() {
    }

    public Staff(Integer id, String firstName, String lastName, String address, String nationalCode, String userName, String passWord, Role role, Double salary) {
        super(id, firstName, lastName, address, nationalCode, userName, passWord, role, salary);
    }


}

package repository;

import database.SessionFactoryJunit;
import database.SessionFactorySingleton;


import model.Staff;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.StaffService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffRepositoryTest {
    private SessionFactory sessionFactory;
    private StaffRepository staffRepository;
    private PersonRepository personRepository;
    private Staff staff;
    @BeforeEach
    void sessionConnection(){
        sessionFactory = SessionFactoryJunit.getSessionFactory();
        personRepository = new PersonRepository(sessionFactory);
        staffRepository = new StaffRepository(sessionFactory);
        staff = new Staff();
        staff.setFirstName("shahed");
        staff.setPassWord("shahed");
        staff.setSalary(25.2);
    }


    @Test
    void connectionTest(){
        //Arrange

        //Act

        //Assert
        assertDoesNotThrow( () -> {

            SessionFactory sessionFactory = SessionFactoryJunit.getSessionFactory();
        });
    }
    @Test
    void save() {
        //Arrange

        //Act
        staffRepository.save(staff);
        //Assert
        assertNotNull(staffRepository.findById(staff.getId())); }
@Test
    void findById(){
    //Arrange
    staffRepository.save(staff);
    //Act
    Staff staffFind = staffRepository.findById(staff.getId());
    //Assert

    assertEquals("shahed",staffFind.getFirstName());
}

@Test
    void delete()
{
    //Arrange
    staffRepository.save(staff);
     //Act
      staffRepository.delete(staff);
    //Assert

    assertNull(staffRepository.findById(staff.getId()));
}

@Test
void findAll()
{
    //Arrange
    staffRepository.save(staff);
    staffRepository.save(staff);
    //Act
    List<Staff> staffList = staffRepository.findAll();
    //Assert
    assertEquals(2,staffList.size());
}
@AfterEach
    void truncate()
{
    staffRepository.truncateTable();
    personRepository.truncateTable();
}
    //Arrange

    //Act

    //Assert
}
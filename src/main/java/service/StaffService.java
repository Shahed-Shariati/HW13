package service;

import model.Staff;
import model.Student;
import repository.StaffRepository;

import java.util.List;

public class StaffService extends GenericServiceImpl<Staff,Integer>{
private StaffRepository staffRepository = new StaffRepository();

    public List<Staff> findAll(){
        return staffRepository.findAll();
    }



}

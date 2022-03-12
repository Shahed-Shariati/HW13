package service;

import exception.UserNotFound;
import model.Person;
import repository.PersonRepository;

public class PersonService extends GenericServiceImpl<Person,Integer> {
     private static PersonRepository personRepository = new PersonRepository();

    public Person findByUserName(String userName,String password){
           Person personFind =  personRepository.findByUserName(userName);
           if(personFind != null && personFind.getPassWord().equals(password)){
                 return personFind;
           }else {
               throw new UserNotFound();
           }

    }
    @Override
    public Person findById(Integer id){

        return  personRepository.findById(id);
    }

}

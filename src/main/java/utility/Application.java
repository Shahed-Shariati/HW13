package utility;

import exception.UnitValidation;
import exception.UserNotFound;
import exception.ValidationDigitNationalCode;
import exception.ValidationLengthNationalCode;

import model.*;
import service.*;


import java.util.*;

public class Application {
    private Scanner input = new Scanner(System.in);
    private PersonService personService = new PersonService();
    private StudentService studentService = new StudentService();
    private ProfessorService professorService = new ProfessorService();
    private StaffService staffService = new StaffService();
    private CourseService courseService = new CourseService();
    private StudentCourseService studentCourseService = new StudentCourseService();
    public void runApplication()  {
        while (true) {
            Menu.loginMenu();
            System.out.println("Choice");
            String input = getUserInput();
            if (input.equals("1")) {
                login();
            } else if (input.equals("2")) {

            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println();
            }
        }


    }
    private void login()  {
        System.out.println("Enter user name and password (admin admin)");
        String[] input = getUserInput().trim().split(" +");

        if(input[0].equalsIgnoreCase("back")){
            System.out.println();
        }else if(input.length == 2) {
            try {
                Person person = personService.findByUserName(input[0], input[1]);

                if (person.getRole().getId() == 1) {
                     staffMenu();
                } else if (person.getRole().getId() == 3) {
                      studentMenu(person);
                } else if (person.getRole().getId() == 2) {
                    professorMenu(person);


            }else{
                System.out.println();
            }
        } catch (UserNotFound e){
                System.out.println(e.getMessage());
            }catch (NullPointerException e){
                System.out.println("user not found!!!1");
            }
        }

    }

  private void staffMenu(){
        while (true) {
            Menu.staffMenu();
            String input = getUserInput().trim();
            if(input.equals("1")){
               enrolStudent();
            }else if(input.equals("2")){
                  editStudent();
            }else  if(input.equals("3")){
                   deleteStudent();
            }else if(input.equals("4")){
                   enrolProfessor();
            }else if(input.equals("5")){
                    editProfessor();
            }else if(input.equals("6")){
                   deleteProfessor();
            }else if(input.equals("7")){
                   enrolStaff();
            }else if(input.equals("8")){
                   editStaff();
            }else if(input.equals("9")){
                    deleteStaff();
            }else if(input.equals("10")){
                     saveCourse();
            }else if(input.equals("11")){
                     editCourse();
            }else if(input.equals("12")){
                    deleteCourse();
            }else if(input.equals("13")){
                    List<Student> students = studentService.findAll();
                    if(students.isEmpty()){
                        System.out.println("list is empty");
                    }else {
                        showList(students);
                    }
            }else if(input.equals("14")){
                   List<Professor> professors = professorService.findAll();
                   if(professors.isEmpty()){
                       System.out.println("list is empty");
                   }else {
                       showList(professors);
                   }

            }else if(input.equals("15")){
                   List<Staff> staffs = staffService.findAll();
                   if(staffs.isEmpty()){
                       System.out.println("list is empty");
                   }else {
                       showList(staffs);
                   }

            }else if(input.equals("16")){
                  List<Course> courses = courseService.findAll();
                  if(courses.isEmpty()){
                      System.out.println("list is empty");
                  }else {

                      showList(courses);
                  }
            }else if(input.equals("17")){
               return;
            }else{
                System.out.println(" Your choice is wrong");
            }

        }

  }
  private void professorMenu(Person person) {
      Professor professor = professorService.findById(person.getId());
      while (true) {
          Menu.professorMenu();
          String input = getUserInput();
          if (input.equalsIgnoreCase("1")) {
              List<Person> personList = new ArrayList<>(Arrays.asList(person));
              showList(personList);
          } else if (input.equalsIgnoreCase("2")) {
                   applyStudentScore();
          } else if (input.equalsIgnoreCase("3")) {
                  professorSalary(professor);
          } else if (input.equalsIgnoreCase("4")) {
                  getCourseProfessor(professor);
          } else if (input.equalsIgnoreCase("5")) {
                   return;

          }  else {
              System.out.println("input is wrong");
          }
      }
  }
  private void studentMenu(Person person){
        while (true){
            Menu.studentMenu();
            String input = getUserInput().trim();
            if(input.equals("1")){
              List<Person> personList = new ArrayList<>(Arrays.asList(person));
              showList(personList);
            }else if(input.equals("2")){
                List<Course> courses = courseService.findAll();
                showList(courses);
            }else  if(input.equals("3")){
                Student student = studentService.findById(person.getId());
                    getCourseStudent(student);
                    if(!student.getStudentCourses().isEmpty())
                    {

                        studentService.upDate(student);
                    }

            }else if(input.equals("4")){
                List<StudentCourse> studentCourses = studentCourseService.findByStudentId(person.getId());
                if(studentCourses.isEmpty()){
                    System.out.println("list not found");
                }else {
                    showList(studentCourses);
                }
            }else if(input.equals("5")){
                return;
            }
        }
  }
     private void saveCourse(){
        try {
            System.out.println("Enter course name");
            String name = getUserInput();
            System.out.println("enter unit course");
            Integer unit = Integer.parseInt(getUserInput());
            unitValidation(unit);
            Course course = new Course(null,name,unit,null);
            courseService.save(course);

        }catch (NumberFormatException e){
            System.out.println("Unit is wrong");
        }catch (UnitValidation e){
            System.out.println(e.getMessage());
        }
     }
    private void enrolStudent(){
          try {
             System.out.println("Enter your name");
             String firstName = getUserInput();
             System.out.println("Enter your Last Name");
             String LastName = getUserInput();
             System.out.println("enter your national code");
             String nationalCode = getUserInput();
             validationNationalCode(nationalCode);
             System.out.println("enter your address");
             String address = getUserInput();
             System.out.println("Enter your username: ");
             String username = getUserInput();
             System.out.println("Enter your password: ");
             String password = getUserInput();
              System.out.println("Enter Last term avarage");
             Double avarage = Double.parseDouble(getUserInput().trim());
             Role role = new Role(3,"STUDENT");

             Student student = new Student(null,firstName,LastName,address,nationalCode,username,password,role,null,avarage);
             studentService.save(student);
         }catch (ValidationDigitNationalCode e){
             System.out.println(e.getMessage());
         }catch (ValidationLengthNationalCode e){
             System.out.println(e.getMessage());
         }catch (NumberFormatException e){
              System.out.println("Your Avarage is wrong");
          }

    }

    private void enrolProfessor(){
        try {
            System.out.println("Enter your name");
            String firstName = getUserInput();
            System.out.println("Enter your Last Name");
            String LastName = getUserInput();
            System.out.println("enter your national code");
            String nationalCode = getUserInput();
            validationNationalCode(nationalCode);
            System.out.println("enter your address");
            String address = getUserInput();
            System.out.println("Enter your username: ");
            String username = getUserInput();
            System.out.println("Enter your password: ");
            String password = getUserInput();
            System.out.println("Is Employee T/F?");
            String isEmployee = getUserInput();
            Boolean isEmployeeBoolean= false ;
            if(isEmployee.equalsIgnoreCase("T")){
                isEmployeeBoolean = true;
            }
            Role role = new Role(2,"PROFESSOR");

            Professor professor = new Professor(null,firstName,LastName,address,nationalCode,username,password,role,null,isEmployeeBoolean,null);
            professorService.save(professor);
        }catch (ValidationDigitNationalCode e){
            System.out.println(e.getMessage());
        }catch (ValidationLengthNationalCode e){
            System.out.println(e.getMessage());
        }
    }
      private void enrolStaff()
      {
          try {
              System.out.println("Enter your name");
              String firstName = getUserInput();
              System.out.println("Enter your Last Name");
              String LastName = getUserInput();
              System.out.println("enter your national code");
              String nationalCode = getUserInput();
              validationNationalCode(nationalCode);
              System.out.println("enter your address");
              String address = getUserInput();
              System.out.println("Enter your username: ");
              String username = getUserInput();
              System.out.println("Enter your password: ");
              String password = getUserInput();

              Role role = new Role(1,"STAFF");

              Staff staff = new Staff(null,firstName,LastName,address,nationalCode,username,password,role,null);
              staffService.save(staff);

          }catch (ValidationDigitNationalCode e){
              System.out.println(e.getMessage());
          }catch (ValidationLengthNationalCode e){
              System.out.println(e.getMessage());
          }

      }

      private void editCourse(){
        List<Course> courses = courseService.findAll();
        showList(courses);
          System.out.println("Enter course id");
          try{
              Integer id = Integer.parseInt(getUserInput().trim());
              Optional<Course> courseOptional = courses.stream()
                                               .filter(course -> course.getId() == id)
                                              .findAny();
              Course course = courseOptional.get();
              System.out.println("Enter course name");
              String  name = getUserInput();
              System.out.println("Enter course unit");
              Integer unit = Integer.parseInt(getUserInput());
              course.setName(name);
              course.setUnit(unit);
              courseService.upDate(course);
          }catch (NumberFormatException e){
              System.out.println("id is wrong");
          }

      }
     private void editStudent(){
          List<Student> students = studentService.findAll();
          showList(students);
         System.out.println("Enter student Id");
         try {
             Integer id = Integer.parseInt(getUserInput().trim());
             Optional<Student> student = students.stream()
                                        .filter(student1 -> student1.getId() == id)
                                        .findAny();


              Student student1 =  student.get();
             System.out.println("Enter user name");
             String username = getUserInput().trim();
             System.out.println("Enter Password");
             String password = getUserInput().trim();
             student1.setUserName(username);
             student1.setPassWord(password);
             studentService.upDate(student1);


         }catch (NumberFormatException e){
             System.out.println("id is wrong");
         }

     }
       private void editStaff()
       {
           List<Staff> staffs = staffService.findAll();
           showList(staffs);
           System.out.println("Enter staff Id");
           try {
               Integer id = Integer.parseInt(getUserInput().trim());
               Optional<Staff> staffOptional = staffs.stream()
                                               .filter(staff -> staff.getId() == id)
                                               .findAny();
               Staff staff = staffOptional.get();

               System.out.println("Enter user name");
               String username = getUserInput().trim();
               System.out.println("Enter Password");
               String password = getUserInput().trim();
               staff.setUserName(username);
               staff.setPassWord(password);
               staffService.upDate(staff);


           }catch (NumberFormatException e)
           {
               System.out.println("id is wrong");
           }
       }
     private void editProfessor(){
        List<Professor> professors = professorService.findAll();
        showList(professors);
         System.out.println("Enter student Id");
         try {
             Integer id = Integer.parseInt(getUserInput().trim());
             Optional<Professor> professorOptional = professors.stream()
                     .filter(professor -> professor.getId() == id)
                     .findAny();



             Professor professor = professorOptional.get();
             System.out.println("Enter user name");
             String username = getUserInput().trim();
             System.out.println("Enter Password");
             String password = getUserInput().trim();
             professor.setUserName(username);
             professor.setPassWord(password);
             professorService.upDate(professor);

         }catch (NumberFormatException e){
             System.out.println("id is wrong");
         }


     }
    private void deleteCourse()
    {
        List<Course> courses = courseService.findAll();
        showList(courses);
        System.out.println("Enter course id");
        try{
            Integer id = Integer.parseInt(getUserInput().trim());
            Optional<Course> courseOptional = courses.stream()
                    .filter(course -> course.getId() == id)
                    .findAny();
            Course course = courseOptional.get();
             delete(course,course.getId());


        }catch (NumberFormatException e){
            System.out.println("id is wrong");
        }
    }
     private void deleteStaff()
     {
         List<Professor> professors = professorService.findAll();
         showList(professors);
         System.out.println("Enter student Id");
         try {
             Integer id = Integer.parseInt(getUserInput().trim());
             Optional<Professor> professorOptional = professors.stream()
                     .filter(professor -> professor.getId() == id)
                     .findAny();
             Professor professor = professorOptional.get();
             delete(professor,professor.getId());
         }catch (NumberFormatException e)
         {
             System.out.println("id is wrong");
         }
     }
     private void deleteStudent(){
         List<Student> students = studentService.findAll();
         showList(students);
         System.out.println("Enter student Id");
         try {
             Integer id = Integer.parseInt(getUserInput().trim());
             Optional<Student> student = students.stream()
                     .filter(student1 -> student1.getId() == id)
                     .findAny();


             Student student1 =  student.get();
             delete(student1,student1.getId());
         }catch (NumberFormatException e){
             System.out.println("id is wrong");
         }


     }
     private void deleteProfessor(){
        List<Professor> professors = professorService.findAll();
        showList(professors);
         System.out.println("Enter professor id");
         try {
             Integer id = Integer.parseInt(getUserInput().trim());
             Optional<Professor> professorOptional = professors.stream()
                                             .filter(professor1 -> professor1.getId() == id)
                                              .findAny();

             Professor professor = professorOptional.get();
             delete(professor,professor.getId());
         }catch (NumberFormatException e){
             System.out.println("id is wrong");
         }
     }
    private void getCourseProfessor(Professor professor){
        List<Course> courses = courseService.findAll();
        while (true){
            try {
                showList(courses);
                System.out.println("Enter id course");
                Integer id = Integer.parseInt(getUserInput());
                Optional<Course> course = courses.stream()
                        .filter(course1 -> course1.getId() == id)
                        .findAny();

               ProfessorCourse professorCourse = new ProfessorCourse(null,course.get(),professor,null);
               professor.getProfessorCourses().add(professorCourse);
               professorService.upDate(professor);
               System.out.println("Success");
                System.out.println("do you want continue? y/n");
                String input = getUserInput();
                if(input.equalsIgnoreCase("N")){
                    return;
                }
            }catch (NumberFormatException e){
                System.out.println("Id is wrong");
            }
        }
    }
     private void getCourseStudent(Student student){
         List<Course> courses = courseService.findAll();
         while (true){
             try {
                 showList(courses);
                 System.out.println("Enter id course");
                 Integer id = Integer.parseInt(getUserInput());
                 Optional<Course> course = courses.stream()
                         .filter(course1 -> course1.getId() == id)
                         .findAny();
                 if(checkStudentCourse(student,course.get())){
                     System.out.println("Success");
                     System.out.println("do you want continue? y/n");
                     String input = getUserInput();
                     if(input.equalsIgnoreCase("N")){
                         return;
                     }
                 }else {
                     System.out.println("you can't add course");
                 }


             }catch (NumberFormatException e)
             {
                 System.out.println("Id is wrong");
             }

         }



     }
     private boolean checkStudentCourse(Student student,Course course)
     {

                StudentCourse studentCourse = new StudentCourse(null,course,student,null,false);

                if(!student.getStudentCourses().isEmpty())
                {
                  if( !student.getStudentCourses().contains(studentCourse) && checkAvg(student)){
                      student.getStudentCourses().add(studentCourse);
                      return true;
                  }
                }else {
                    student.getStudentCourses().add(studentCourse);
                    return true;
                }
                return false;
      }


    private boolean checkAvg(Student student){
        Double avg = student.getAvarag();
        Double sum =  student.getStudentCourses().stream()
                .map(StudentCourse::getCourse)
                .mapToDouble(Course::getUnit)
                .sum();
        if(avg >= 18 ){
            if( sum < 24){
                return true;
            }else {
                return false;
            }
        }else if(avg < 18){
            if(sum < 20){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    private void professorSalary(Professor professor){
       Double salary =  professorService.salary(professor);
        System.out.printf( "%.2f", salary);
        System.out.println();

    }

    private void applyStudentScore(){
        List<Student> students = studentService.findAll();
        boolean isPassed = false;
        while (true){
            try {
                showList(students);
                System.out.println("Enter id student");
                Integer id = Integer.parseInt(getUserInput());
                Optional<Student> studentOptional = students.stream()
                                            .filter(student1 -> student1.getId() == id)
                                            .findAny();
                Student student = studentOptional.get();
                student.getStudentCourses().forEach(System.out::println);
                System.out.println("Enter Id student course");
                Integer idCourse = Integer.parseInt(getUserInput());
                System.out.println("Enter score");
                Double score = Double.parseDouble(getUserInput());
                if(score > 9 ){
                    isPassed = true;
                }
                student.getStudentCourses().stream()
                                 .filter(studentCourse ->studentCourse.getId() == idCourse)
                                  .findAny()
                                  .get()
                                  .setScore(score);
                student.getStudentCourses().stream()
                        .filter(studentCourse ->studentCourse.getId() == idCourse)
                        .findAny()
                        .get()
                        .setPassed(isPassed);
                studentService.upDate(student);
                System.out.println("do you want continue? y/n");
                String input = getUserInput();
                if(input.equalsIgnoreCase("N")){
                    return;
                }



            }catch (NumberFormatException e){
                System.out.println("Id is wrong");
            }
        }
    }
     private <T,ID> void delete(T t,ID id){
        GenericServiceImpl<T,ID> genericService = new GenericServiceImpl<>();
        genericService.delete(t);
     }

     private <T> void showList(List<T> list){
          list.stream().forEach(System.out::println);
     }



    private String getUserInput()
    {
        return input.nextLine().trim();
    }

    private void validationNationalCode(String nationalCode){
        char[] nationalCodeArray = nationalCode.toCharArray();
        if(nationalCodeArray.length == 10) {
            for (char c : nationalCodeArray) {
                if (!Character.isDigit(c)) {

                    throw new ValidationDigitNationalCode();
                }
            }
        }else {
            throw new ValidationLengthNationalCode();
        }
    }

    private void unitValidation(Integer uint){

        if(uint <= 0 || uint > 4){
            throw new UnitValidation();
        }
    }
}
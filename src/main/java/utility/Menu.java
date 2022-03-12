package utility;

public class Menu {

    private static String dotted = "---------------------------------------------------";
    public static void loginMenu(){
        System.out.println("1:Login");
        System.out.println("2:Sing up");
        System.out.println("3:Exit");
        System.out.println(dotted);

    }
    public static void staffMenu(){
        System.out.println();
        System.out.println("-------Student---------");
        System.out.println("1:Enroll Student:");
        System.out.println("2:Edit Student:");
        System.out.println("3:Delete Student:");
        System.out.println("-------Professor-------");
        System.out.println("4:Enroll Professor:");
        System.out.println("5:Edit Professor:");
        System.out.println("6:Delete Professor:");
        System.out.println("-------Staff----------");
        System.out.println("7:Enroll Staff:");
        System.out.println("8:Edit Staff:");
        System.out.println("9:Delete Staff:");
        System.out.println("-------Course---------");
        System.out.println("10:Enter Course:");
        System.out.println("11:Edit Course:");
        System.out.println("12:Delete Course:");
        System.out.println("------Lists-------------");
        System.out.println("13:Student List:");
        System.out.println("14:Professor List:");
        System.out.println("15:Staff List:");
        System.out.println("16:Course List:");
        System.out.println("17:Log out:");
        System.out.println(dotted);
    }

    public static void studentMenu(){
        System.out.println();
        System.out.println("1:Show Student Information: ");
        System.out.println("2:Show Course List :  ");
        System.out.println("3:take course:  ");
        System.out.println("4:Show Take Course:  ");
        System.out.println("5:Log out:  ");
        System.out.println(dotted);
    }

    public static void professorMenu()
    {
        System.out.println();
        System.out.println("1: Show Professor Information:  ");
        System.out.println("2: Apply student s score:  ");
        System.out.println("3: Show professor s  salary:  ");
        System.out.println("4: take course  ");
        System.out.println("5: Log Out:  ");
        System.out.println(dotted);
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student{
        int id;
        String name;
        double marks;
        public Student(int id,String name, double marks){
            this.id=id;
            this.name=name;
            this.marks=marks;
        }
        public String toString(){
            return "ID= " + id + ", Name= "+ name+ ", Marks= "+ marks;
        }
    }
public class task2 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> studentlist=new ArrayList<>();
        while (true){
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("enter the student id= ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter the name= ");
                    String name=sc.nextLine();
                    System.out.print("enter the marks= ");
                    double marks=sc.nextInt();
                    sc.nextLine();
                    studentlist.add(new Student(id,name,marks));
                    System.out.print("student add complete");
                    break;

                case 2:
                    for(Student s: studentlist){
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.print("enter the id ");
                    int Updateid=sc.nextInt();
                    boolean foundUpdate=false;
                    for(Student s: studentlist){
                        if(s.id==Updateid){
                            sc.nextLine();
                            System.out.print("enter the name= ");
                            s.name=sc.nextLine();
                            System.out.print("enter the marks= ");
                            s.marks=sc.nextInt();
                            foundUpdate=true;
                            break;
                        }
                    }
                    if(!foundUpdate){
                        System.out.print("student not found");
                        break;
                    }
                case 4:
                    System.out.print("enter the id");
                    int deleteid=sc.nextInt();
                    boolean foundDelete=false;
                    Iterator<Student> it = studentlist.iterator();
                    while (it.hasNext()){
                        Student s=it.next();
                        if(s.id==deleteid){
                            it.remove();
                            System.out.println("✅ Student deleted.");
                            break;
                        }
                    }
                    if(!foundDelete){
                        System.out.print("not found ");
                        break;
                    }
                case 5: // Exit
                    System.out.println("👋 Exiting program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid option! Try again.");


            }
        }

    }
}

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
class Student{
    String name;
    long registration_no;
    double cgpa;
    String course;
    String placement_status;
    double ecgpa;
    String ecourse;
    Student(String name,long registration_no,double cgpa,String course,String placement_status){                    // Constructor calling
        this.name = name;
        this.registration_no = registration_no;
        this.cgpa = cgpa;
        this.course = course;
        this.placement_status = placement_status;
    }
    void display(){                         
        System.out.println("Student Name::"+ name+",,"+" Registration Number::"+ registration_no+",,"+"CGPA::"+ cgpa+",,"+" Course Name::"+ course+" Placement Status::"+placement_status+"...."); //Display to display all the students detail
    }
    void displayEligible(double ecgpa,String ecourse){
        if(placement_status.equals("False") || placement_status.equals("false") || placement_status.equals("FALSE")){
            if(cgpa >= ecgpa && ecourse.equals(course)){      
                System.out.println("Student Name::"+ name +",,"+" Registration Number::"+ registration_no +",,"+" CGPA::"+ cgpa+",,"+" Couse Name::"+ course+",,"+" Placement Status::"+ placement_status+"..."); //displayEligible to display eligible students only..
                }
        }
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> al=new ArrayList<Student>();                // Arraylist
        System.out.print("How Many Students U Want to Input : ");
        int n=sc.nextInt();
        Student[] obj=new Student[n];
        Student[] obj2=new Student[n];
        for(int i=0;i<n;i++){
            System.out.println("\nEnter Details Of The Student "+ (i+1)+"...");      //Student's Details...
            System.out.println("Enter Student name:");
            String na = sc.next();
            System.out.println("Enter Registration number of the Student:");
            long rgno = sc.nextLong();
            System.out.println("Enter CGPA of the student:");
            double cgpa = sc.nextDouble();
            System.out.println("Enter Course Name either (B.tech/M.tech/MBA):");
            String course = sc.next();
            System.out.println("Enter Placement status either true/false (if already Placed-->True or if Not_Placed-->False):");
            String pl = sc.next();
            obj[i] =new Student(na,rgno,cgpa,course,pl);            // Object1
            obj2[i] =new Student(na,rgno,cgpa,course,pl);           // Objeect2
            
        }
        System.out.print("\nList of all the Students..\n");
        for(int i=0;i<n;i++){
            obj[i].display();
            al.add(obj[i]);                            //al.add() to add in the arraylist...
        }
        System.out.println("Total Number of Students are "+al.size());
        int ch;
        do{
            System.out.println("\n\nType 1.To Check Eligible Student..\nType 2.To Exit..\n");
            System.out.println("Ur Choice :");
            ch=sc.nextInt();
        switch(ch){
        case 1:
        System.out.println("Enter the Minimum CGPA or Eligible CGPA For The Students::");   // Taking eligibility criteria from the user...
        double ecgpa =  sc.nextDouble();
        System.out.println("Enter the Eligible Course For The Students::");
        String ecourse = sc.next();
        System.out.println("Eligiblity criteria for CGPA is "+ecgpa+" and Studets Eligible For Course is "+ecourse+"...");
        System.out.println("Eligible Students are::");
        for(int i=0;i<n;i++){
            obj2[i].displayEligible(ecgpa,ecourse);                  // to call displayEligible() 
        }
        int sum = 0;                                                // sum is used to display number of students
        for(Student s:obj){
         if(s.placement_status.equals("False") || s.placement_status.equals("false") || s.placement_status.equals("FALSE")){
            if(s.cgpa >= ecgpa && ecourse.equals(s.course)){
                sum = sum+1;      
                }
        }
            }
        System.out.println("Total Number of Students Eligible are "+sum);
            break;
        }
    }while(ch != 2);
    }

}

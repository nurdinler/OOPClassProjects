
package student_project;
import java.util.Scanner; 

public class Anasayfa {
    public static void Sirala(Student[] listt){
        Student student,student2,tempStudent;
        for(int i=0;i<listt.length;i++){
            student=listt[i];
            student2=listt[i+1];
            if(student.getGecme_notu()>student2.getGecme_notu()){
                tempStudent=student;
                student=student2;
                student2=tempStudent;
            }            
        }
    }
    public static void main(String[] args) {         
        int i; 
        Scanner scanner = new Scanner(System.in); //scanf
        System.out.print("How many students in the class? : ");
        i=scanner.nextInt();
        Student[] students = new Student[i]; //Student tipinde bir dizim var
        // ismi students
        // Student veri tipinde dizi [i] büyüklüğünde
        // veri tipi[] isim = new veritipi[büyüklük]
        /*
            Dizinin içini doldurabilmek için for döngüsü açıldı.
            Setter methodlarıyla objelerin bilgileri girildi
        */
        for(int j=0;j<i;j++){
            Student student = new Student();            
            //bilgileri al                       
            System.out.print("Please set the name of student: ");
            scanner.nextLine(); //dummy
            student.setName(scanner.nextLine());            
            System.out.print("Please set the lastname of student: ");
            student.setLastname(scanner.nextLine());
            System.out.print("Please set the midterm of student: ");
            student.setMidterm(scanner.nextInt());
            System.out.print("Please set the final of student: ");
            student.setFinal(scanner.nextInt());
            student.setId();
            students[j]=student;
            
        }
       // Sirala(students);
        for(int j=0;j<i;j++){
            students[j].bilgileriYazdir();
        }
        
        
    }
    
}

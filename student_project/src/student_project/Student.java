package student_project;
public class Student {
    private int Id;
    private String name;
    private String lastname;
    private int midterm;
    private int _final;
    private double gecme_notu=0;
    private static int count=0;
    
    public Student(){ 
        /* Eğer bunu yazmasaydım nesneyi ilk yarattığımda direkt bilgileri atamam gerekecekti
        ama ben bu bilgileri henüz kullanıcıdan okumamıştım
        */
    }
    // constructor
    public Student(String name,String lastname,int midterm,int _final){
        this.name=name;
        this.lastname=lastname;
        this.midterm=midterm;
        this._final=_final;
        this.Id=count++;
        gecme_notu=((midterm*0.4)+(_final*0.6));
    }
    public void bilgileriYazdir(){
        System.out.println("***********STUDENT INFOS ***********");
        System.out.print("Name Surname : "+name);
        System.out.println(" "+lastname);
        System.out.println("Midterm: "+midterm);
        System.out.println("Final: "+_final);
        System.out.println("************************************");
        gecmeNotuHesapla();
    }
    public void gecmeNotuHesapla(){
        if( gecme_notu >= 50){
            System.out.println("PASSED THE CLASS");
        }
        else{
            System.out.println("FAILED");
        }
    
    }
    public int getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }

    public int getFinal() {
        return _final;
    }

    public void setFinal(int _final) {
        this._final = _final;
    }   
    
    public void setId(){
        this.Id = count++;
    }

    public double getGecme_notu() {
        return gecme_notu;
    }

    public void setGecme_notu(int gecme_notu) {
        this.gecme_notu = gecme_notu;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }
    
    
    
}

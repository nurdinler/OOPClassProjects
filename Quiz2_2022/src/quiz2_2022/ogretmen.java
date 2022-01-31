
package quiz2_2022;

public abstract class ogretmen {
    public int ID;
    public static int counter=998; //ilk ogretmenin ID'sinin 1000 olabilmesi icin
    public String ad;
    public String soyad;
    public int yas;
    public int cs; //cocuk sayisi
 
    
    public  ogretmen(String ad,String soyad,int yas,int cs){
        counter+=2;
        ID=counter;
        this.ad=ad;
        this.soyad=soyad;
        this.yas=yas;
        this.cs=cs;
    }   

    public abstract double puanHesapla();
    
}

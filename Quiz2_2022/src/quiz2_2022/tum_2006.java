
package quiz2_2022;

import java.text.DecimalFormat;
import java.util.Scanner;

public class tum_2006 {
    
//20010011506 İrem Nur Dinler
package quiz2_2006;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Anasayfa {
    public static void main(String[] args) {
        int ogretmensayisi;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Lutfen ogretmen sayisini giriniz: ");
        ogretmensayisi=scanner.nextInt();
        matematikOgretmeni[] matOgretmeni=new matematikOgretmeni[ogretmensayisi];
        //ogretmen bilgilerinin alinmasi
        for(int i=0;i<ogretmensayisi;i++){
            scanner.nextLine();//dummy
            String ad,soyad;
            int yas,cs;
            System.out.print("Lutfen ogretmenin adini giriniz: ");
            ad=scanner.nextLine();          
            System.out.print("Lutfen ogretmenin soyadini giriniz: ");
            soyad=scanner.nextLine();
            System.out.print("Lutfen ogretmenin yasini giriniz: ");
            yas=scanner.nextInt();
            System.out.print("Lutfen ogretmenin cocuk sayisini giriniz: ");
            cs=scanner.nextInt();
            matematikOgretmeni ogretmen=new matematikOgretmeni(ad, soyad, yas, cs);
            matOgretmeni[i]=ogretmen; 
            System.out.println("**************************************************");
            
        }
        //ogretmen bilgilerinin yazdirilmasi
        for(int i=0;i<ogretmensayisi;i++){
            System.out.println(""+(i+1)+". "+matOgretmeni[i].ID+" "+matOgretmeni[i].ad+" "+matOgretmeni[i].soyad+" "
                            +new DecimalFormat("##.##").format(matOgretmeni[i].maasHesapla())+" "+matOgretmeni[i].brans);
        }
        //swap
        int swapno1,swapno2; 
        matematikOgretmeni temp;
        boolean flag=true;
        while(flag){
            System.out.println("Lutfen degistirmek istediginiz ogretmenlerin sira numarasini giriniz");
            System.out.print("sira no 1: ");
            swapno1=scanner.nextInt();
            System.out.print("sira no 2: ");
            swapno2=scanner.nextInt();
            if((swapno1-1)<ogretmensayisi && (swapno2-1)<ogretmensayisi){
                temp=matOgretmeni[swapno1-1];
                matOgretmeni[swapno1-1]=matOgretmeni[swapno2-1];
                matOgretmeni[swapno2-1]=temp;
                //ogretmen bilgilerinin yazdirilmasi
                for(int i=0;i<ogretmensayisi;i++){
                    System.out.println(""+(i+1)+". "+matOgretmeni[i].ID+" "+matOgretmeni[i].ad+" "+matOgretmeni[i].soyad+" "
                            +new DecimalFormat("##.##").format(matOgretmeni[i].maasHesapla())+" "+matOgretmeni[i].brans);
        }
                flag=false;
            }
            else{
                System.out.println("Lutfen indisler sinirinda deger giriniz");
            }            
        }
        
        
        
    }
    
}

package quiz2_2006;

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

package quiz2_2006;

public interface Maas {

    double maasHesapla();
    
}

package quiz2_2006;


public class matematikOgretmeni extends quiz2_2022.ogretmen implements quiz2_2022.Maas{
    String brans;

    public matematikOgretmeni(String ad, String soyad, int yas, int cs) {
        super(ad, soyad, yas, cs);
        brans="Matematik";        
    }
    
    @Override
    public double puanHesapla() {
        return ((cs*100)+((2*yas)/3));
    }

    @Override
    public double maasHesapla() {
       double maas;
       maas=((5*puanHesapla())/7)+5000;
       return maas;
    }
    
}

}

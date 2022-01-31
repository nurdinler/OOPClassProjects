
package artcenter_automation.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Kurs {
    private int kursId;
    private String kursAd;

    public Kurs() {        
    }

    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    public String getKursAd() {
        return kursAd;
    }

    public void setKursAd(String kursAd) {
        this.kursAd = kursAd;
    }
    
    public Kurs KursEkle(ArrayList<Kurs> kurslar) {
        boolean flag=true;
        int input;  
        Kurs kurs = new Kurs();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kursun IDsini giriniz: ");
        input=scanner.nextInt();           
        for(int i=0;i<kurslar.size();i++){
            if(kurslar.get(i).getKursId()==input){
                System.out.println("Zaten bu IDde bir kurs var");  
                return null;
            }                
        }           
        kurs.setKursId(input);
        scanner.nextLine();
        System.out.print("Kursun adini giriniz: ");
        kurs.setKursAd(scanner.nextLine());
        return kurs;    
             
     
   
            
        
             
    }
    public void KursListele(ArrayList<Kurs> kurslar) {
       System.out.println("Kurs Id         Kurs Adi");
       for(int i=0;i<kurslar.size();i++){
           System.out.println(""+kurslar.get(i).getKursId()+"      "+kurslar.get(i).getKursAd());
        }
    }
}
    
   
    
    


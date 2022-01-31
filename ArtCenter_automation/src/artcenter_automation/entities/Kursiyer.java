
package artcenter_automation.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Kursiyer {
    private int kursiyerId;
    private String kursiyerAdSoyad;
    private int yas;
    public ArrayList<Kurs> alinanKurslar = new ArrayList<>();

    public Kursiyer() {        
    }
    
    public int getKursiyerId() {
        return kursiyerId;
    }

    public void setKursiyerId(int kursiyerId) {
        this.kursiyerId = kursiyerId;
    }

    public String getKursiyerAdSoyad() {
        return kursiyerAdSoyad;
    }

    public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
        this.kursiyerAdSoyad = kursiyerAdSoyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
    
    public Kursiyer KursiyerEkle(ArrayList<Kursiyer> kursiyerler,ArrayList<Kurs> kurslar){
        boolean flag=true;
        Kursiyer kursiyer = new Kursiyer();
        Scanner scanner = new Scanner(System.in);         
        int input;            
        System.out.print("Kursiyerin IDsini giriniz: ");
        input=scanner.nextInt();
        for(int i=0;i<kursiyerler.size();i++){
            if(kursiyerler.get(i).getKursiyerId()==input){
                System.out.print("Zaten bu IDde bir kursiyer var");
                return null;                  
            }                
        }  
        kursiyer.setKursiyerId(input);
        scanner.nextLine();
        System.out.print("Kursiyerin adini ve soyadini giriniz: ");
        kursiyer.setKursiyerAdSoyad(scanner.nextLine());
        System.out.print("Kursiyerin yasini giriniz: ");
        kursiyer.setYas(scanner.nextInt());
        for(int i=0;i<kurslar.size();i++){
            System.out.println(""+(i+1)+" "+kurslar.get(i).getKursId()+" "+kurslar.get(i).getKursAd());
        }
        System.out.println("Lutfen kursiyerin alacagi kurslarin sira numarasini giriniz"
                + "(cikmak icin: -1): ");
        int index=0;
        while(true){
            index=scanner.nextInt();
            if(index==-1){
                break;
            }
            kursiyer.alinanKurslar.add(kurslar.get(index-1));            
        }
        return kursiyer;       
        
    }
    public void KursiyerAra(ArrayList<Kursiyer> kursiyerler,String Ad_soyad){
        boolean flag=false;
        for(int i=0;i<kursiyerler.size();i++){
            if(kursiyerler.get(i).getKursiyerAdSoyad().equals(Ad_soyad)){
                System.out.println("Kursiyer bulundu");
                System.out.println(""+kursiyerler.get(i).getKursiyerId()+" "
                        +kursiyerler.get(i).getKursiyerAdSoyad()+" "
                        +kursiyerler.get(i).getYas());
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Kursiyer bulunamadi");
        }
    }
    
    public void KursiyerSil(ArrayList<Kursiyer> kursiyerler,int ID){
        boolean flag=false;
        for(int i=0;i<kursiyerler.size();i++){
            if(kursiyerler.get(i).getKursiyerId()==ID){
                kursiyerler.remove(i);
                System.out.println("Kursiyer silindi");
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Kursiyer bulunamadi");
        }
    }
    
    public void KursiyerListele(ArrayList<Kursiyer> kursiyerler){
        System.out.println("Tum Kursiyerler");
        for(int i=0;i<kursiyerler.size();i++){
            System.out.println(""+kursiyerler.get(i).getKursiyerId()+" "+kursiyerler.get(i).getKursiyerAdSoyad()
            +" "+kursiyerler.get(i).getYas());
        }
    }
    
    public void AyrintiliList(ArrayList<Kursiyer> kursiyerler){
        System.out.println("Tum Kursiyerler ve Aldiklari Kurslar");
        for(int i=0;i<kursiyerler.size();i++){
            System.out.println(""+kursiyerler.get(i).getKursiyerId()+" "+kursiyerler.get(i).getKursiyerAdSoyad()
            +" "+kursiyerler.get(i).getYas());
            for(int j=0;j<kursiyerler.get(i).alinanKurslar.size();j++){
                Kurs kursinfo=kursiyerler.get(i).alinanKurslar.get(j);
                System.out.println("\t"+kursinfo.getKursId()+" "+kursinfo.getKursAd());
            }
        }
    }
    
    public void UcretHesapla(Kursiyer kursiyer){  
        double ucret=0;
        //kampanyasiz
        if(kursiyer.alinanKurslar.size()==1){
            ucret=100*4;
            System.out.println("Ucret: "+new DecimalFormat("##.##").format(ucret));
            System.out.println("Kursiyer tek kurs aldigindan hicbir kampanyadan yararlanmamistir.");
        }
        //kampanya1: ikinci kurs %15 indirimli
        if(kursiyer.alinanKurslar.size()==2){
            ucret=(100*4)+((100*4)*0.15);
            System.out.println("Ucret: "+new DecimalFormat("##.##").format(ucret));
            System.out.println("Kampanya 1: Bu kampanya 2 kurs alan kursiyerler içindir. "
                    + "Bu kursiyerlere ikinci kurs %15 indirimlidir.");
            
        }
        //kampanya2: ucuncu kurs /25 indirimli
        else if(kursiyer.alinanKurslar.size()==3){
            ucret=(100*4)*2+((100*4)*0.25);
            System.out.println("Ucret: "+new DecimalFormat("##.##").format(ucret));
            System.out.println("Kampanya 2: Bu kampanya 3 kurs alan kursiyerler içindir. "
                    + "Bu kursiyerlere 3.kurs %25 indirimlidir.");
            
        }
        //kampanya3: her kurs %10 indirimli
        else if(kursiyer.alinanKurslar.size()>3){
            for(int i=0;i<kursiyer.alinanKurslar.size();i++){
                ucret+=(100*4)*0.1;
            }    
            System.out.println("Ucret: "+new DecimalFormat("##.##").format(ucret));
            System.out.println("Kampanya 3: Bu kampanya 3 kurs üstü alan kursiyerler içindir. "
                    + "Bu kursiyerlere her kurs %10 indirimlidir.");
        }
        
        
        
    }
    
}

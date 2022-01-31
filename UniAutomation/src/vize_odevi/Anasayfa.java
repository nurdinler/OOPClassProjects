
package vize_odevi;

import java.util.Scanner;

public class Anasayfa {
    public static void main(String[] args) {
        int bolumSayisi;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lutfen bolum sayisini giriniz: ");
        bolumSayisi=scanner.nextInt();
        Bolum bolumler[] = new Bolum[bolumSayisi];
        for(int i=0;i<bolumSayisi;i++){
            Bolum bolum = new Bolum();
            int ogrenciSayisi;
            int dersSayisi;
            System.out.print("Lutfen bolumun numarasini giriniz: ");
            bolum.setBolNo(scanner.nextInt());
            scanner.nextLine(); //dummy
            System.out.print("Lutfen bolumun adini giriniz: ");
            bolum.setBolAd(scanner.nextLine());
            System.out.print("Lutfen bolumde bulunan ogrencilerin sayisini giriniz: ");
            ogrenciSayisi=scanner.nextInt(); 
            bolum.setOgrenciler(ogrenciSayisi);
            for(int j=0;j<ogrenciSayisi;j++){
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.setBolNo(bolum.getBolNo());                
                System.out.print("Lutfen ogrencinin adini giriniz: ");
                ogrenci.setOgrAd(scanner.nextLine());
                scanner.nextLine(); //dummy
                System.out.print("Lutfen ogrencinin soyadini giriniz: ");
                ogrenci.setOgrSoyad(scanner.nextLine());
                System.out.print("Lutfen ogrencinin sinifini giriniz: ");
                ogrenci.setOgrSinif(scanner.nextInt());          
                bolum.ogrenciler[j]=ogrenci;    
                scanner.nextLine();
                System.out.println("***************************************************");
                scanner.nextLine(); //dummy
            }
            //ders bilgileri
            System.out.print("Lutfen bolumde bulunan ders sayisini giriniz: ");
            dersSayisi=scanner.nextInt();
            bolum.setDersler(dersSayisi);
            for(int j=0;j<dersSayisi;j++){
                Ders ders = new Ders();
                ders.setBolNo(bolum.getBolNo());
                scanner.nextLine(); //dummy
                System.out.print("Lutfen dersin adini giriniz: ");
                ders.setDersAd(scanner.nextLine());
                scanner.nextLine(); //dummy
                System.out.print("Lutfen dersin kredisini giriniz: ");
                ders.setDersKredi(scanner.nextInt());
                bolum.dersler[j]=ders;      
            }
            bolumler[i]=bolum;           
        }
        //Menu
        boolean flag_=true;
        while(flag_){
            int secim;
            boolean flag=true;
            System.out.println("***************************MENU***************************");
            System.out.println("1- Tum Bolumlerin Bilgilerini Listele");
            System.out.println("2- Bolum Adina Gore Arama Yap ");
            System.out.println("3- Ogrenci Adina Gore Arama Yap ");
            System.out.println("4- Ders Adina Gore Arama Yap ");
            System.out.println("5- Sinif Bilgisine Gore Ogrencileri Bul ");
            System.out.println("6- Ders Kredisine Gore Dersleri Bul ");
            System.out.println("7- Cikis ");
            System.out.print("Lutfen seciminizi giriniz: ");
            secim=scanner.nextInt();
            if(secim==1){
                for(int i=0;i<bolumler.length;i++){
                    System.out.println("Bolum No: "+bolumler[i].getBolNo()+" Bolum Ad: "+bolumler[i].getBolAd());
                    System.out.println("Ogrenciler: ");
                    for(int j=0;j<bolumler[i].ogrenciler.length;j++){
                        System.out.println(""+(j+1)+". Ogrenci: "+bolumler[i].ogrenciler[j].getOgrID()
                        +" "+bolumler[i].ogrenciler[j].getOgrAd()+" "+bolumler[i].ogrenciler[j].getOgrSoyad()
                        +" "+bolumler[i].ogrenciler[j].getOgrSinif());
                    }
                    System.out.println("Dersler: ");
                    for(int j=0;j<bolumler[i].dersler.length;j++){
                        System.out.println(""+(j+1)+". Ders: "+bolumler[i].dersler[j].getDersId()
                        +" "+bolumler[i].dersler[j].getDersAd()+" "+bolumler[i].dersler[j].getDersKredi());
                    }                        
                }
            }
            else if(secim==2){
                String search_it; 
                scanner.nextLine(); //dummy
                System.out.print("Lutfen aradiginiz bolumun adini giriniz: ");
                search_it=scanner.nextLine();
                for(int i=0;i<bolumler.length;i++){
                    if(search_it.equals(bolumler[i].getBolAd())){
                        System.out.println("Bolum No: "+bolumler[i].getBolNo()+" Bolum Ad: "+bolumler[i].getBolAd());
                        System.out.println("Ogrenciler: ");
                        for(int j=0;j<bolumler[i].ogrenciler.length;j++){
                            System.out.println(""+(j+1)+". Ogrenci: "+bolumler[i].ogrenciler[j].getOgrID()
                            +" "+bolumler[i].ogrenciler[j].getOgrAd()+" "+bolumler[i].ogrenciler[j].getOgrSoyad()
                            +" "+bolumler[i].ogrenciler[j].getOgrSinif()); }
                        System.out.println("Dersler: ");
                        for(int j=0;j<bolumler[i].dersler.length;j++){
                            System.out.println(""+(j+1)+". Ders: "+bolumler[i].dersler[j].getDersId()
                            +" "+bolumler[i].dersler[j].getDersAd()+" "+bolumler[i].dersler[j].getDersKredi());
                        } 
                        flag=false;
                        break;
                    }
                    }
                if(flag){
                    System.out.println("BOLUM BULUNAMADI");
                    flag=true;
                }
            }
            else if(secim==3){
                String search_name;
                scanner.nextLine(); //dummy
                System.out.print("Lutfen aradiğiniz ogrencinin ismini giriniz: ");
                search_name=scanner.nextLine();
                for(int i=0;i<bolumler.length;i++){
                    for(int j=0;j<bolumler[i].ogrenciler.length;j++){
                        if(search_name.equals(bolumler[i].ogrenciler[j].getOgrAd()) || 
                                search_name.equals(bolumler[i].ogrenciler[j].getOgrSoyad())){
                            System.out.println(""+bolumler[i].getBolAd()+" " 
                                    + bolumler[i].ogrenciler[j].getOgrID()+" "
                                    +bolumler[i].ogrenciler[j].getOgrAd()+" "
                                    +bolumler[i].ogrenciler[j].getOgrSoyad());
                            flag=false;
                        }
                    }
                }
                if(flag){
                    System.out.println("OGRENCI BULUNAMADI");
                    flag=true;
                }
            }
            else if(secim==4){
                String search_class;
                scanner.nextLine(); //dummy
                System.out.print("Lutfen aradiginiz dersi giriniz: ");
                search_class=scanner.nextLine();
                for(int i=0;i<bolumler.length;i++){
                    for(int j=0;j<bolumler[i].dersler.length;j++){
                        if(search_class.equals(bolumler[i].dersler[j].getDersAd())){
                            System.out.println(""+bolumler[i].getBolAd()+" "
                                                +bolumler[i].dersler[j].getDersId()+" "
                                               +bolumler[i].dersler[j].getDersAd()+" "+
                                                bolumler[i].dersler[j].getDersKredi());
                            flag=false;
                        }
                    }
                }
                if(flag){
                    System.out.println("DERS BULUNAMADI");
                    flag=true;
                }
            }
            else if(secim==5){
                int search_year;
                System.out.print("Lutfen aradiginiz ogrencinin sinif bilgisini giriniz: ");
                search_year=scanner.nextInt();
                for(int i=0;i<bolumler.length;i++){
                    for(int j=0;j<bolumler[i].ogrenciler.length;j++){
                        if(search_year==bolumler[i].ogrenciler[j].getOgrSinif())
                            System.out.println(""+bolumler[i].getBolAd()+" " 
                                    + bolumler[i].ogrenciler[j].getOgrID()+" "
                                    +bolumler[i].ogrenciler[j].getOgrAd()+" "
                                    +bolumler[i].ogrenciler[j].getOgrSoyad());
                            flag=false;
                        }
                    
                    }
                 if(flag){
                    System.out.println("OGRENCI BULUNAMADI");
                    flag=true;
                }
            }   
            else if(secim==6){
                int search_credit;
                System.out.print("Lutfen aradiginiz dersin kredisini giriniz: ");
                search_credit=scanner.nextInt();
                for(int i=0;i<bolumler.length;i++){
                    for(int j=0;j<bolumler[i].dersler.length;j++){
                        if(search_credit==bolumler[i].dersler[j].getDersKredi()){
                            System.out.println(""+bolumler[i].getBolAd()+" "
                                                +bolumler[i].dersler[j].getDersId()+" "
                                                +bolumler[i].dersler[j].getDersAd()+" "
                                                +bolumler[i].dersler[j].getDersKredi());
                            flag=false;
                        }
                    }
                }
                if(flag){
                    System.out.println("DERS BULUNAMADI");
                    flag=true;
                }                
            }
                
            else if(secim==7){
                flag_=false;
            }
            else{
                System.out.println("Hatali bir giris yaptiniz,tekrar deneyin ");
            }
        }
        
    }
    
}

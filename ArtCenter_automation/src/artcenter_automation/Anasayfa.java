
package artcenter_automation;

import artcenter_automation.entities.Kurs;
import artcenter_automation.entities.Kursiyer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean flag=true;
        String line;
        ArrayList<Kursiyer> kursiyerler = new ArrayList<>();
        ArrayList <Kurs> kurslar = new ArrayList<>();
        File kurstxt = new File("kurs.txt");            
        File kursiyertxt= new File("kursiyer.txt");
        Scanner scankurs=new Scanner(kurstxt);   
        Scanner scankursiyer = new Scanner(kursiyertxt);
        //kurslarin listeye eklenmesi
        while(scankurs.hasNextLine()){
            line=scankurs.nextLine();
            Kurs kurs = new Kurs();
            String[] parts = line.split("-");
            kurs.setKursId(Integer.parseInt(parts[0]));
            kurs.setKursAd(parts[1]);    
            kurslar.add(kurs);                
        }
        scankurs.close();  
        int counter=0;
        //kursiyerlerin listeye eklenmesi
        while(scankursiyer.hasNext()){  
            line=scankursiyer.nextLine();
            Kursiyer kursiyer = new Kursiyer();
            if(line.startsWith("*")){
                line=line.replace("*", "");
                String[] parts = line.split("-");
                kursiyer.setKursiyerId(Integer.parseInt(parts[0]));
                kursiyer.setKursiyerAdSoyad(parts[1]);
                kursiyer.setYas(Integer.parseInt(parts[2])); 
                kursiyerler.add(kursiyer); 
                counter++;
            }
            if(line.startsWith("%")){
                line=line.replace("%","");
                String[] parts=line.split("-");
                for(int i=0;i<kurslar.size();i++){                       
                        if(kurslar.get(i).getKursAd().equals(parts[1]) &&
                                kurslar.get(i).getKursId()==Integer.parseInt(parts[0])) 
                        {
                            kursiyerler.get(counter-1).alinanKurslar.add(kurslar.get(i)); 
                        }     
                
                }
            }
        }
        scankursiyer.close();
        String Menu="""
                    1- Kurs Ekle
                    2-Kurs Listele
                    3-Kursiyer Ekle
                    4-Kursiyer Ara
                    5-Kursiyer Sil
                    6-Kursiyerleri Listele
                    7-Kursiyerleri Ayrıntılı Listele
                    8-Kursiyerlerin Odeyecegi Tutari Hesapla
                    9-Cikis                    
                    """;
        flag=true;
        while(flag){            
            int secim;
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n"+Menu);
            System.out.print("Lutfen seciminizi giriniz: ");            
            secim=scanner.nextInt();
            switch (secim) {
                case 1 -> {
                    //kurs ekle
                    //kurs tipinde veri tutan kurslar listesinden sinif metotlarina erisildi
                    Kurs kurs = new Kurs();
                    kurs=kurslar.get(0).KursEkle(kurslar);
                    if(kurs!=null){
                        kurslar.add(kurs);
                        System.out.println("Kurs eklendi");
                    }
                   
                    
                }
                case 2 -> //kursiyer listele
                    kurslar.get(1).KursListele(kurslar);
                case 3 -> {
                    //kursiyer ekle
                    //kursiyer tipinde veri tutan kursiyerler listesinden sinif metotlarina erisildi
                    Kursiyer kursiyer = new Kursiyer();
                    kursiyer=kursiyer.KursiyerEkle(kursiyerler, kurslar);
                    if(kursiyer!=null){
                        kursiyerler.add(kursiyer);
                        System.out.println("Kursiyer eklendi");                        
                    }
                    
                }
                case 4 -> {
                    //kursiyer ara
                    String input;
                    System.out.print("Lutfen aradiginiz kursiyerin adini soyadini giriniz: ");
                    scanner.nextLine();
                    input=scanner.nextLine();
                    kursiyerler.get(1).KursiyerAra(kursiyerler, input);
                }
                case 5 -> {
                    //kursiyer sil
                    int inputId;
                    System.out.print("Lutfen silmek istediginiz kursiyerin IDsini giriniz: ");
                    inputId=scanner.nextInt();
                    kursiyerler.get(1).KursiyerSil(kursiyerler, inputId);
                }
                case 6 -> //kursiyer listele
                    kursiyerler.get(1).KursiyerListele(kursiyerler);
                case 7 -> //ayrintili kursiyer listele
                    kursiyerler.get(1).AyrintiliList(kursiyerler);
                case 8 -> {
                    //kursiyerin odeyecegi tutari hesaplama
                    int ID;
                    System.out.print("Lutfen ucretini hesaplamak istediginiz kursiyerin"
                            + " IDsini giriniz: ");
                    ID=scanner.nextInt();
                    for(int i=0;i<kursiyerler.size();i++){
                        if(kursiyerler.get(i).getKursiyerId()==ID){
                            kursiyerler.get(1).UcretHesapla(kursiyerler.get(i));
                        break;
                        }
                    }
                }
                case 9 -> {
                    FileWriter fileWriter = new FileWriter(kurstxt);
                    fileWriter.write("");
                    fileWriter.flush();
                    for(int i=0;i<kurslar.size();i++){
                        fileWriter.write(""+kurslar.get(i).getKursId()+
                                "-"+kurslar.get(i).getKursAd()+"\n");
                    }
                    fileWriter.close();
                    fileWriter=new FileWriter(kursiyertxt);
                    fileWriter.write("");
                    fileWriter.flush();
                    for(int i=0;i<kursiyerler.size();i++){
                        fileWriter.write("*"+kursiyerler.get(i).getKursiyerId()
                                +"-"+kursiyerler.get(i).getKursiyerAdSoyad()
                                +"-"+kursiyerler.get(i).getYas()+"\n");
                    }
                    fileWriter.close();           
                            
                    System.out.println("Menuden cikiliyor...");
                    flag=false;
                }
                default -> throw new AssertionError();
            }
        }
            
        }
    }


           
            
            
         


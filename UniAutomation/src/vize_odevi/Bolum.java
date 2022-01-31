/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vize_odevi;
// Bolum bilgilerini tutacak olan class
public class Bolum {
    private int bolNo;
    private String bolAd;
    Ogrenci ogrenciler[];
    Ders dersler[];
    
     public Bolum(){
        System.out.println("Yeni bolum olusturuldu");
    }

    public void setOgrenciler(int sayi){
        ogrenciler = new Ogrenci[sayi];
        
    }
    public void setDersler(int sayi){
        dersler= new Ders[sayi];
    }
  
    
   

    public int getBolNo() {
        return bolNo;
    }

    public void setBolNo(int bolNo) {
        this.bolNo = bolNo;
    }

    public String getBolAd() {
        return bolAd;
    }

    public void setBolAd(String bolAd) {
        this.bolAd = bolAd;
    }
  
            
    
            
    
}


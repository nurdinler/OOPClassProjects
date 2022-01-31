
package vize_odevi;

// Ogrenci bilgilerini tutacak olan class
public class Ogrenci {
    private int bolNo; //bilgisi bolumden alinacak
    private static int ogrID; // her yeni ogrenci olusturuldugunda arttirilacak
    private String ogrAd;
    private String ogrSoyad;
    private int ogrSinif;
    
    public Ogrenci(){
        ogrID=ogrID++;
    }
    public int getBolNo() {
        return bolNo;
    }

    public void setBolNo(int bolNo) {
        this.bolNo = bolNo;
    }

    public int getOgrID() {
        return ogrID;
    }

    public static void setOgrID(int ogrID) {
        Ogrenci.ogrID = ogrID;
    }

    public String getOgrAd() {
        return ogrAd;
    }

    public void setOgrAd(String ogrAd) {
        this.ogrAd = ogrAd;
    }

    public String getOgrSoyad() {
        return ogrSoyad;
    }

    public void setOgrSoyad(String ogrSoyad) {
        this.ogrSoyad = ogrSoyad;
    }

    public int getOgrSinif() {
        return ogrSinif;
    }

    public void setOgrSinif(int ogrSinif) {
        this.ogrSinif = ogrSinif;
    }
    
    
    
           
}


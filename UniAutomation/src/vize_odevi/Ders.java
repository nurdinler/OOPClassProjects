
package vize_odevi;

// Ders bilgilerini tutacak class

public class Ders {
    private int bolNo;
    private int dersId;// otomatik olarak arttirilacak
    private String dersAd;
    private int dersKredi;
    
    public Ders(){
        dersId=dersId++;
    }

    public int getBolNo() {
        return bolNo;
    }

    public void setBolNo(int bolNo) {
        this.bolNo = bolNo;
    }

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public int getDersKredi() {
        return dersKredi;
    }

    public void setDersKredi(int dersKredi) {
        this.dersKredi = dersKredi;
    }
    
           
    
}

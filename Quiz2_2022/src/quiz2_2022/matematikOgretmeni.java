
package quiz2_2022;


public class matematikOgretmeni extends ogretmen implements Maas{
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

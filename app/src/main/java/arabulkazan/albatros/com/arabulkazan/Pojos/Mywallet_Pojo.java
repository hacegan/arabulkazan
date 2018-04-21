package arabulkazan.albatros.com.arabulkazan.Pojos;

public class Mywallet_Pojo {

    private String tur;
    private String tutar;
    private String tarih;


    public Mywallet_Pojo(String tur, String tutar, String tarih) {
        this.tur = tur;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getTutar() {
        return tutar;
    }

    public void setTutar(String tutar) {
        this.tutar = tutar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}

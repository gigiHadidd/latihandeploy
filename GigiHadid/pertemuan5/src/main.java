abstract class Bentuk { //abstract adlah pewarisan metode" nya
    //statement nya : proses nya
    public abstract double hitungluas(); //inisialisasi metode (pewarisannya)

    //Tampilkan hasil dari hitung luas();

    public void TampilanInfo(){
        System.out.println("Ini adalah sebuah bentuk");
    }
}

class lingkaran extends Bentuk {
    public double jarijari;
    public lingkaran(double jarijari){
        this.jarijari = jarijari;
    }

    @Override
    public double hitungluas() {
        return Math.PI * jarijari * jarijari;
    }
}

class persegi extends Bentuk{
    private double sisi;
    public persegi(double sisi){
        this.sisi = sisi;

    }

    @Override
    public double hitungluas() {
        return sisi * sisi;
    }
}

public class main {
    public static void main (String[] args) {
        lingkaran Lingkaran = new lingkaran( 5.8);
        persegi Persegi = new persegi( 12.2);
        Lingkaran.TampilanInfo();
        System.out.println("Luas lingkaran : " + Lingkaran.hitungluas());
        Persegi.TampilanInfo();
        System.out.println("Luas persegi : " + Persegi.hitungluas());
    }

}

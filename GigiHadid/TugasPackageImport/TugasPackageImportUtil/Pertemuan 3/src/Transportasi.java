
//superclass
class Transportasi {
    String namaTransp;

    public Transportasi(String namaTransp) {
        this.namaTransp = namaTransp;
    }

    public void menggunakan() {
        System.out.println("Transportasi di Jakarta");
    }
}


//subclass
class Mobil extends Transportasi {
    public Mobil(String namaTransp) {
        super(namaTransp);
    }

    @Override
    public void menggunakan() {
        super.menggunakan();
        System.out.println("Saya menggunakan transportasi " + namaTransp);
    }
}

class Motor extends Transportasi {
    public Motor(String namaTransp) {
        super(namaTransp);
    }

    @Override
    public void menggunakan() {
        super.menggunakan();
        System.out.println("Saya menggunakan transportasi " + namaTransp);
    }
}

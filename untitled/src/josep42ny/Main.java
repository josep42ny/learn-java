package josep42ny;

public class Main {

    public static void pagaAlTreballador(Asalariat asalariat) {
        double ccc = asalariat.getCcc();
        System.out.println(ccc * 100);
    }

    public static void main(String[] args) {
        Asalariat pere = new Becari();
        Docent marga = new Primaria();

        pagaAlTreballador(pere);
        pagaAlTreballador(marga);
    }
}
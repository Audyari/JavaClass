import java.util.Locale;

public class JavaStringClass {

    public static void main(String[] args) {

        String nama = "AUDYARI WIYONO";

        String HurufKecil = nama.toLowerCase();
        int PanjangHuruf = nama.length();


        System.out.println(HurufKecil);
        System.out.println(PanjangHuruf);

        String[] Pisahkan = nama.split(" ");
        for (String Pisah: Pisahkan){
            System.out.println(Pisah);
        }

        char[] KarakterKeArray = nama.toCharArray();
        System.out.println(KarakterKeArray[0]);

    }

}

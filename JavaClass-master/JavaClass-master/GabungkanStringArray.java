import java.util.StringJoiner;

public class GabungkanStringArray {

    public static void main(String[] args) {

        StringJoiner GabungKata = new StringJoiner(" ");
        GabungKata.add("Nama");
        GabungKata.add("Saya");
        GabungKata.add("Audyari");
        GabungKata.add("Wiyono");

        String SudahDigabung = GabungKata.toString();
        System.out.println(SudahDigabung);


        String[] KataArray = {"Nama", "Saya", "Audyari", "Wiyono"};
        StringJoiner GabungKataArray = new StringJoiner(" ");

        for(String InputAray : KataArray){
            GabungKataArray.add(InputAray);
        }

        System.out.println(GabungKataArray.toString());





    }

}

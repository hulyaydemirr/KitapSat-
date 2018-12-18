
// HÜLYA AYDEMİR 1306160216


package KitapSatis;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc= new Scanner(System.in);
        int choise;
        System.out.println("Ne işlem yapmak istiyorsunuz?");
        System.out.println("Üyelik için 1'e" +
                           "Alıcı girişi için 2'ye" +
                           "Satıcı girişi için 3'e" +
                           "Çıkış için 0'a basınız");
        choise=sc.nextInt();


        switch (choise) {
            case 1:
                Admin admin = new Admin();
                System.out.println("Satıcı olmak istiyorsanız 1'e Alıcı olmak istiyorsanız 2'ye basınız");
                int secim = sc.nextInt();
                switch (secim) {
                    case 1:
                        admin.saticidosyaAç();
                        admin.saticiOluştur();
                        System.out.println("Üyeliğiniz oluşturuldu");
                        System.out.println(admin.st.adi + " " + admin.st.soyadi + "" + admin.st.kullaniciAdi + "" + admin.st.adresi + "" + admin.st.magazaAdi);
                        Secim();
                        break;
                    case 2:
                        admin.alicidosyaAç();
                        admin.aliciOluştur();
                        System.out.println("Üyeliğiniz oluşturuldu");
                        secim2();
                        break;
                    default:
                        System.out.println("Üyeliğiniz oluşturulamadı");
                        break;
                }
                break;
            case 2:
                secim2();
                break;

            case 3:
                Secim();
                break;

                default:
                    break;


        }
    }
    private static void secim2() throws FileNotFoundException, UnsupportedEncodingException {

        int choise;
        Scanner sc= new Scanner(System.in);
        Alici alici = new Alici();
        System.out.println(
                "Kitapların listesini görmek için 1'e" +
                "Kitap seçmek için 2ye" +
                "Sepeti  görüntülemek için 3'e+" +
                "Ödeme yapmak için 4'e basınız " +
                "Çıkış için 0'a basınız ");
        choise = sc.nextInt();
        switch (choise) {
            case 1:
                alici.kitaplarıListele();
                secim2();
                break;
            case 2:
                alici.kitapSec();
                secim2();
                break;
            case 3:
                try {
                    alici.sepetiGörüntüle();
                    secim2();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                Odeme odeme= new Odeme();
                odeme.kartNoAl();

                break;
            default:
                break;
        }
    }

    private static void Secim(){
    int choise;
    Scanner sc= new Scanner(System.in);
        Satici satici = new Satici();
        System.out.println("Kitap Eklemek için 1'e" +
                "Kitap Silmek için 2'ye basınız"+"Çıkış için 0'a basınız");
        choise = sc.nextInt();
        switch (choise) {
            case 1:
                satici.kt.kitapEkle();
                Secim();
                break;
            case 2:
                satici.kt.kitapSil();
                Secim();
                break;
            default:
                break;
        }
    }
}
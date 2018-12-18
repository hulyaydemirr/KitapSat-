package KitapSatis;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Satici extends Kullanici {

    protected String magazaAdi;
    public void setMagazaAdi(String magazaAdi) {
        this.magazaAdi = magazaAdi;
    }

    private static void p(String s) {
        System.out.println(s);
    }

    private Scanner girilen = new Scanner(System.in);
    Kitap kt = new Kitap() {
        @Override
        public void kitapEkle() {

            {
                try {
                    FileInputStream fi = new FileInputStream("kitaplar.txt");
                    new BufferedReader(new InputStreamReader(fi));
                } catch (FileNotFoundException f) {
                    System.out.println("Dosya yok,Olusturuluyor!");
                }

                p("Kitabın adını gir :");
                kt.adi = girilen.nextLine();
                p("yazar adi giriniz:");
                kt.yazar = girilen.nextLine();
                p("sayfasayısı giriniz:");
                kt.sayfaSayisi = girilen.nextInt();
                p("fiyati giriniz:");
                kt.fiyat = girilen.nextInt();

                try {
                    File dosya = new File("kitaplar.txt");
                    FileWriter yazici = new FileWriter(dosya, true);
                    BufferedWriter yaz = new BufferedWriter(yazici);

                    yaz.write(kt.adi + " " + kt.yazar + " " + kt.fiyat + " " + kt.sayfaSayisi);
                    yaz.write("\n");
                    yaz.close();
                    System.out.println("Kitap başarı ile eklendi");
                } catch (FileNotFoundException ex) {
                    System.out.println("Dosya Yok!");
                } catch (IOException ex) {
                    System.out.println("Hata!");
                }
            }
        }

        @Override
        public void kitapSil() {

            p("Silmek istediginiz kitabın adını giriniz :");
            String sil = girilen.nextLine();
            ArrayList<String> list = new ArrayList<>();

            try {
                File file = new File("kitaplar.txt");
                FileReader fileReader = new FileReader(file);
                String line;
                BufferedReader br = new BufferedReader(fileReader);
                try {
                    line = br.readLine();
                    while (line != null) {
                        if ((line = br.readLine()).startsWith(sil)) {
                            continue;
                        } else {
                            list.add(line);
                        }
                    }
                }
                catch (Exception e){
                    p("Kitap silindi");
                }

            } catch (Exception e) {
                p("Ardığınız kitap yok");
            }
            try {

                File f = new File("kitaplar.txt");
                FileWriter outFile = new FileWriter(f);
                PrintWriter out = new PrintWriter(outFile, true);
                for (String d : list) {
                    out.println(d);
                }
                out.close();
            } catch (Exception e) {
                System.err.println("Hata: " + e.getMessage());
            }

    }
};
}




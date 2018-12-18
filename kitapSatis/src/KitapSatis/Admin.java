package KitapSatis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin extends Kullanici implements Uyelik  {
    static void p(String s) {
        System.out.println(s);
    }

    Scanner girilen = new Scanner(System.in);
    public void alicidosyaAç() {
        try {
            PrintWriter alicidosya = new PrintWriter("alicilar.txt");
        } catch (FileNotFoundException istisna) {
            System.err.println("Dosya olusturulamadi.");
            System.exit(1);
        }

    }

    public void saticidosyaAç() {
        try {
            PrintWriter saticidosya = new PrintWriter("saticilar.txt");
        } catch (FileNotFoundException istisna) {
            System.err.println("Dosya olusturulamadi.");
            System.exit(1);
        }

    }

    Alici al = new Alici();
    Satici st = new Satici();


    public void aliciOluştur() {
        try {
            FileInputStream fi = new FileInputStream("alicilar.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
        } catch (FileNotFoundException f) {
            System.out.println("Dosya yok,Olusturuluyor!");
        } catch (IOException ioex) {
            System.out.println("Başka bir hata oldu!");
        }

        p("Tc gir :");
        al.tc = girilen.nextDouble();

        p("İsim giriniz:");
        al.adi = girilen.next();

        p("Soyisim giriniz:");
        al.soyadi = girilen.next();

        p("Kullancı adi giriniz:");
        al.kullaniciAdi = girilen.next();

        p("Ev telefonu giriniz:");
        al.tel = girilen.nextInt();

        p("Adresi giriniz:");
        al.adresi = girilen.next();

        p("Şifre giriniz:");
        al.sifre = girilen.next();

        try {
            File dosya = new File("alicilar.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);

            yaz.write(al.tc + " " + al.adi + " " + al.soyadi + " " + al.tel + " "
                    + al.kullaniciAdi + " " + al.adresi + " " + al.sifre);
            yaz.write("\n");
            yaz.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Yok!");
        } catch (IOException ex) {
            System.out.println("Hata!");
        }

        try {
            File dosya = new File("Sifreler.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);

            yaz.write(al.sifre + " " + al.kullaniciAdi + " \n ");
            yaz.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Yok!");
        } catch (IOException ex) {
            System.out.println("Hata!");
        }
    }

    public void saticiOluştur() {
        try {
            FileInputStream fi = new FileInputStream("saticilar.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
        } catch (FileNotFoundException f) {
            System.out.println("Dosya yok,Olusturuluyor!");
        } catch (IOException ioex) {
            System.out.println("Başka bir hata oldu!");
        }

        p("Tc gir :");
        st.tc = girilen.nextInt();
        p("İsim giriniz:");
        st.adi = girilen.nextLine();
        p("Soyisim giriniz:");
        st.soyadi = girilen.nextLine();
        p("Kullancı adi giriniz:");
        st.kullaniciAdi = girilen.nextLine();
        p("Ev telefonu giriniz:");
        st.tel = girilen.nextInt();
        p("Adresi giriniz:");
        st.adresi = girilen.nextLine();
        p("Şifre giriniz:");
        st.sifre = girilen.nextLine();
        p("Magaza adi giriniz:");
        st.setMagazaAdi(girilen.next());

        try {
            File dosya = new File("saticilar.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);

            yaz.write(st.tc + " " + st.adi + " " + st.soyadi + " " + st.magazaAdi + " " + st.tel + " "
                    + st.kullaniciAdi + " " + st.adresi + " " + st.sifre);
            yaz.write("\n");
            yaz.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Yok!");
        } catch (IOException ex) {
            System.out.println("Hata!");
        }

        try {
            File dosya = new File("Sifreler.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);

            yaz.write(st.kullaniciAdi + " " + st.sifre + " \n ");
            yaz.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Yok!");
        } catch (IOException ex) {
            System.out.println("Hata!");
        }
    }
}

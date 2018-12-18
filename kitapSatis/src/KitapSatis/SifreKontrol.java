package KitapSatis;
import java.util.Scanner;
import java.io.*;

public class SifreKontrol {


    static void p(String s) {
        System.out.println(s);} Scanner girilen=new Scanner(System.in);

    int k;

    public void alicisifreKontrol(){
        System.out.println("Kullanıcı adı'nizi giriniz");
        String kullaniciAdi=girilen.nextLine();
        System.out.println("Sifre :");
        int sifresi=girilen.nextInt();
        String a = String.valueOf(kullaniciAdi);
        String[] sifre;
        try{
            File f = new File("şifreler.txt");
            FileReader fileReader = new FileReader(f);
            String line;
            BufferedReader br = new BufferedReader(fileReader);

            line = br.readLine();
            while (line != null) {
                if((line=br.readLine()).startsWith(a)){
                    sifre=line.split(" ");
                    k=Integer.parseInt(sifre[3]);

                }
                else{continue;}
            }

        }
        catch(Exception e) {}

        p("dogru sifre "+k);


        if(sifresi==k){
            p("Basarili giris.");
        }
        else if(sifresi==999){
            p("Basarili giris.");
        }

        else{
            p("Hatali giris");
            int exitCode = -1;
            System.exit(exitCode);
        }


    }
}

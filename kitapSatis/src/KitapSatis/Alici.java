package KitapSatis;
import java.io.*;
import java.util.Scanner;

public class Alici extends Kullanici {

public void kitaplarıListele() throws FileNotFoundException, UnsupportedEncodingException {

    String dosyaYolu = "kitaplar.txt";

    /*DOSYA OKUMA*/
    try {
        File dosya = new File(dosyaYolu);

        BufferedReader oku = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(dosya), "UTF8"));
        String str;
        while ((str = oku.readLine()) != null) {
            System.out.println(str);
        }

        oku.close();
    } catch (UnsupportedEncodingException e) {
        System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}


public void kitapSec(){

    System.out.println("Aradığınız kitabın ismini giriniz");
    Scanner sc=new Scanner(System.in);
    String aranan=sc.nextLine();

            try{
                FileReader okuyucu=new FileReader("kitaplar.txt");
                BufferedReader tamponNesne=new BufferedReader(okuyucu);

                String satir=tamponNesne.readLine();
                while(satir!=null){
                    if(satir.equals(aranan)){
                        System.out.println("Kitap bulundu");
                    }
                    System.out.println(satir);
                    String dosyaYolu = "seçilenKitap.txt";
                    try
                    {
                        FileOutputStream fos = new FileOutputStream(dosyaYolu);
                        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
                        osw.write(satir);
                        osw.close();
                    }
                    catch (UnsupportedEncodingException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch(FileNotFoundException ex)
                    {
                        System.out.println("Hata : " + ex);
                    }
                    catch (IOException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    satir=tamponNesne.readLine();

                }
            }catch(FileNotFoundException excep){
                System.err.println("Böyle bir kitap bulunamadı...");

            }catch(IOException ex){
                System.err.println("hata olustu...");
            }
}

public void sepetiGörüntüle()  throws FileNotFoundException{

    String dosyaYolu = "seçilenKitap.txt";
        try {
            File dosya = new File(dosyaYolu);

            BufferedReader oku = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(dosya), "UTF8"));
            String str;
            while ((str = oku.readLine()) != null) {
                System.out.println(str);
            }

            oku.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}


package KitapSatis;
import java.util.Scanner;

public class Odeme implements Kart {
protected int kartNo;
private Scanner sc=new Scanner(System.in);
    @Override
    public void kartNoAl() {
        System.out.println(
                "Kredi kartı numarası giriniz"
        );
         kartNo=sc.nextInt();
         System.out.println("Ödeme işlemi tamamlandı");
         }
}



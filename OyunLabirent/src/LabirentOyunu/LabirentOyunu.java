/*
 * 
 * 
 * @author:byofficial
 * Burak Yýldýz
 */


package LabirentOyunu;
import java.util.Scanner;//Scanner paketi import edildi

public class LabirentOyunu {

	public static void main(String[] args) {
            
            /**
             * Labirent class ýnda kullanýlan int türünde deðikenler için iki boyutlu dizi oluþturuluyor.
             * Dizinin elemanlarý bu class ta elle seçiliyor ve LabirentOyunu isimli class ta string deðerleri atanýyor.
             */
		int[][] labirent={

				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,1,3,2,2,1,5,1,2,1,2,1,2,2,2,1,2,1,1,2},
				{2,1,6,6,6,6,6,1,2,2,2,1,1,6,6,6,6,6,1,2,2},
				{2,5,1,1,6,1,1,1,1,2,1,2,2,2,5,6,2,1,2,1,2},
				{2,1,2,1,1,2,2,5,6,6,6,6,1,1,1,1,1,2,1,1,2},
				{2,2,2,2,6,2,1,5,2,1,1,2,2,2,2,6,2,1,2,2,2},
				{2,2,2,6,1,1,6,1,1,1,1,1,1,6,6,6,1,2,1,1,2},
				{2,2,1,1,6,1,1,1,2,6,6,1,2,1,1,1,2,1,1,2,2},
				{2,2,2,1,5,2,1,1,1,1,2,1,2,1,2,1,2,1,1,1,2},
				{2,1,6,6,6,1,2,1,6,1,1,6,1,1,1,6,6,6,1,2,2},
				{2,2,1,1,1,1,2,1,6,2,1,1,2,1,1,1,1,5,2,1,2},
				{2,1,2,1,6,1,1,2,2,1,1,2,1,1,1,6,2,2,1,2,2},
				{2,2,2,6,6,6,6,1,1,2,2,2,1,6,6,6,6,6,1,1,2},
				{2,1,2,4,2,1,2,1,1,1,1,6,5,2,1,2,1,2,2,1,2},
				{2,1,1,1,1,1,6,5,1,2,1,5,2,1,1,6,2,1,1,1,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};

		Oyun Oyun = new Oyun(labirent);//Oyun class'ýnda oyun adýnda nesne oluþturuluyor ve içine labirent matrisi gönderiliyor.
		
                    // Oyun bilgisi kullanýcýya veriliyor.
			System.out.println("-------------------------------------------------");
			System.out.println("*****************LABÝRENT OYUNU******************");
			System.out.println("-------------------------------------------------\n");
		
			System.out.println("-------------------------------------------------");
			System.out.println("        HARFLER VE SEMBOLLERÝN ANLAMLARI        ");
			System.out.println("-------------------------------------------------");
			System.out.println("* "+"'K'" +" harfi kutularý temsil eder,");
			System.out.println("* "+"'E'" +" harfi deðerli eþyalarý temsil eder.");
			System.out.println("* "+"'O'" +" harfi oyuncuyu temsil eder.");
			System.out.println("* "+"'H'" +" harfi Çýkýþ noktasýný temsil eder.");
			System.out.println("* "+"'#'" +" sembolü duvarlarý temsil eder.");
			System.out.println("* "+"'-'" +" sembolü yeri temsil eder.");
			System.out.println("-------------------------------------------------\n");
			
			System.out.println("\n-------------------------------------------------");
			System.out.println("        OYUNUN AMACI VE ÝÞLEYÝÞ KURALLARI         ");
			System.out.println("-------------------------------------------------");
			System.out.println("* Oyunun amacý eþyalarý toplayýp çýkýþa ulaþmaktýr.");
			System.out.println("* Eþyalarýn tamamý toplanmadan oyunu kazanmýþ sayýlmazsýnýz.");
			System.out.println("* Oyuna baþlarken önünüzde kutular vardýr.");
			System.out.println("* Kutularý boþluða iteleyip yolunuzu açabilirsiniz.");
			System.out.println("* Kutular itilebilir ancak geri çekildemez.");
			System.out.println("-------------------------------------------------\n");
			
			System.out.println("\n-------------------------------------------------");
			System.out.println("                   PUANLANDIRMA                  ");
			System.out.println("-------------------------------------------------");
			System.out.println("* Baþlangýçta: 600 puanýnýz vardýr.");
			System.out.println("* Oyunda adým attýkça puanýnýz düþer.");
			System.out.println("* 0-10 adým arasý her adýmda 1 puan düþer.");
			System.out.println("* 11-40 adým arasý her adýmda 2 puan düþer.");
			System.out.println("* 41-60 adým arasý her adýmda 3 puan düþer.");
			System.out.println("* 61-200 adým arasý her adýmda 4 puan düþer.");
			System.out.println("* 201-300 adým arasý her adýmda 1 puan düþer.");
			System.out.println("* 300' den fazla adýmda ise puan alamazsýnýz");
			System.out.println("-------------------------------------------------\n");
			System.out.println("Ýyi Eðlenceler Dilerim! Oyuna baþlamak için herhangi bir tuþa basýn...");
			
	Scanner sc = new Scanner(System.in);
			String Sor = sc.next();// kullanýcýdan her hangi bir deðer istenerek oyun talimatlarý kapatýlýyor.
			
		Oyun.baslat();//oyun nesnesine baþlat metodu çaðýrýlýyor ve oyun baþlatýlýyor.

	}

}





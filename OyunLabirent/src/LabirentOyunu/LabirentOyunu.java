/*
 * 
 * 
 * @author:byofficial
 * Burak Y�ld�z
 */


package LabirentOyunu;
import java.util.Scanner;//Scanner paketi import edildi

public class LabirentOyunu {

	public static void main(String[] args) {
            
            /**
             * Labirent class �nda kullan�lan int t�r�nde de�ikenler i�in iki boyutlu dizi olu�turuluyor.
             * Dizinin elemanlar� bu class ta elle se�iliyor ve LabirentOyunu isimli class ta string de�erleri atan�yor.
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

		Oyun Oyun = new Oyun(labirent);//Oyun class'�nda oyun ad�nda nesne olu�turuluyor ve i�ine labirent matrisi g�nderiliyor.
		
                    // Oyun bilgisi kullan�c�ya veriliyor.
			System.out.println("-------------------------------------------------");
			System.out.println("*****************LAB�RENT OYUNU******************");
			System.out.println("-------------------------------------------------\n");
		
			System.out.println("-------------------------------------------------");
			System.out.println("        HARFLER VE SEMBOLLER�N ANLAMLARI        ");
			System.out.println("-------------------------------------------------");
			System.out.println("* "+"'K'" +" harfi kutular� temsil eder,");
			System.out.println("* "+"'E'" +" harfi de�erli e�yalar� temsil eder.");
			System.out.println("* "+"'O'" +" harfi oyuncuyu temsil eder.");
			System.out.println("* "+"'H'" +" harfi ��k�� noktas�n� temsil eder.");
			System.out.println("* "+"'#'" +" sembol� duvarlar� temsil eder.");
			System.out.println("* "+"'-'" +" sembol� yeri temsil eder.");
			System.out.println("-------------------------------------------------\n");
			
			System.out.println("\n-------------------------------------------------");
			System.out.println("        OYUNUN AMACI VE ��LEY�� KURALLARI         ");
			System.out.println("-------------------------------------------------");
			System.out.println("* Oyunun amac� e�yalar� toplay�p ��k��a ula�makt�r.");
			System.out.println("* E�yalar�n tamam� toplanmadan oyunu kazanm�� say�lmazs�n�z.");
			System.out.println("* Oyuna ba�larken �n�n�zde kutular vard�r.");
			System.out.println("* Kutular� bo�lu�a iteleyip yolunuzu a�abilirsiniz.");
			System.out.println("* Kutular itilebilir ancak geri �ekildemez.");
			System.out.println("-------------------------------------------------\n");
			
			System.out.println("\n-------------------------------------------------");
			System.out.println("                   PUANLANDIRMA                  ");
			System.out.println("-------------------------------------------------");
			System.out.println("* Ba�lang��ta: 600 puan�n�z vard�r.");
			System.out.println("* Oyunda ad�m att�k�a puan�n�z d��er.");
			System.out.println("* 0-10 ad�m aras� her ad�mda 1 puan d��er.");
			System.out.println("* 11-40 ad�m aras� her ad�mda 2 puan d��er.");
			System.out.println("* 41-60 ad�m aras� her ad�mda 3 puan d��er.");
			System.out.println("* 61-200 ad�m aras� her ad�mda 4 puan d��er.");
			System.out.println("* 201-300 ad�m aras� her ad�mda 1 puan d��er.");
			System.out.println("* 300' den fazla ad�mda ise puan alamazs�n�z");
			System.out.println("-------------------------------------------------\n");
			System.out.println("�yi E�lenceler Dilerim! Oyuna ba�lamak i�in herhangi bir tu�a bas�n...");
			
	Scanner sc = new Scanner(System.in);
			String Sor = sc.next();// kullan�c�dan her hangi bir de�er istenerek oyun talimatlar� kapat�l�yor.
			
		Oyun.baslat();//oyun nesnesine ba�lat metodu �a��r�l�yor ve oyun ba�lat�l�yor.

	}

}





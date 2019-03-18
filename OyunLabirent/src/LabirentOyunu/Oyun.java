/*
 * 
 * 
 * @author:byofficial
 * Burak Y�ld�z
 */

package LabirentOyunu;

import java.util.Scanner;

public class Oyun {

	private Labirent labirent;

	/**
	 * int t�r�nde Y�n de�i�kenleri olu�turulup de�erler verildi.
	 */
	public static final int YUKARI = 1;
	public static final int SOLA = 2;
	public static final int ASAGI = 3;
	public static final int SAGA = 4;
	public static final int HATALI = 0;

	/**
	 * Ad�m say�s�n� hesaplayan saya� olu�turuld�
	 */
	private static int ToplamAdim;
	private static int puan = 1500;// puan sayac� olu�turudu

	/**
	 * Oyun metodunun i�erisine matris y�klendi. Toplam ad�m 0 a e�itlendi.
	 * Yukle metodu olu�turulup, bu metoda matris yazd�r�ld�
	 */
	public Oyun(int[][] matris) {
		ToplamAdim = 0;
		puan = 600;
		yukle(matris);
	}

	// Yukle metodunun i�erisie labirent nesnesi olu�turuldu

	public void yukle(int[][] matris) {

		labirent = new Labirent(matris);
	}

	/**
	 * ba�lat metodu olu�turuldu ve oyun ba�lama komutu burada tan�mland�. D�ng�
	 * eklenerek her seferinde s�rayla ad�mlar� takip etmesi sa�land�.
	 */
	public void baslat() {
		while (true) {

			OyunuYaz();// Labirent ekrana yaz�l�yor

			int yon = YonBilgisiAl();// kullan�c� y�n tu�una bas�yor ve bilgi
										// al�n�yor.
			OyuncuyuHareketEttir(yon);// al�nan bilgi parametre olarak metodda
										// yerine konuluyor
			Puan();// Puan metdou �a��r�l�p puan hesaplan�yor
			if (BitisKontrol())// Oyunun "BitisKontrol" metodunun sa�lay�p
								// sa�lamad��� kabul ediiliyor ve sa�layana
								// kadar oyun devam ediyor.
				break;
		}
	}

	/**
	 * "BitisKontrol" metodu burada olu�turuluyor boolean t�r�nde de�i�ken
	 * tan�mlan�yor ve ilk de�er atamas� false oluyor. e�er labirentte bulunan
	 * oyuncunun konumlar� hedefin konumuna e�it ise boolean de�i�keni true
	 * olacak ve de�er d�nd�recek.
	 *
	 */
	private boolean BitisKontrol() {
		boolean OyunuBitir = false;

		if (labirent.getOyuncuX() == labirent.getHedefX()
				&& labirent.getOyuncuY() == labirent.getHedefY()) {
			System.out
					.println("Tebrikler! T�m E�yalar� Bulup ��k��a Ula�t�n�z!");
			OyunuBitir = true;
		}
		return OyunuBitir;
	}

	/**
	 * Oyuncuyu hareket ettirmek i�in 1 paremetreli olan bir metod
	 * olu�turuluyor. Labirent class'�ndan al�nan oyuncunun yerini de�i�tir
	 * metodu �a��r�l�yor. �A��r�lan metdodda x paremetresi yerine oyuncunun x
	 * 'i; y yerine ise oyuncunun y'si yaz�l�yor. E�er yukar� yada a�a��
	 * gidecekse de�i�im y ekseninde oluyor. E�er sa�a yada sola gidecekse
	 * de�i�im X ekseninde oluyor. Oyuncun kontrol� Labirent class'�nda
	 * yap�ld���ndan burada sadece oyuncunun hareketini g�ncellemesi kal�yor Ve
	 * en sonunda ilerledi�inde de toplam ad�m de�i�keni 1 art�yor.
	 */
	private void OyuncuyuHareketEttir(int yon) {

		switch (yon) {

		case YUKARI:
			if (labirent.OyuncuYeriniDegistir(labirent.getOyuncuX(),
					labirent.getOyuncuY() - 1, YUKARI))
				ToplamAdim++;
			break;

		case SOLA:
			if (labirent.OyuncuYeriniDegistir(labirent.getOyuncuX() - 1,
					labirent.getOyuncuY(), SOLA))
				ToplamAdim++;
			break;

		case ASAGI:
			if (labirent.OyuncuYeriniDegistir(labirent.getOyuncuX(),
					labirent.getOyuncuY() + 1, ASAGI))
				ToplamAdim++;
			break;

		case SAGA:
			if (labirent.OyuncuYeriniDegistir(labirent.getOyuncuX() + 1,
					labirent.getOyuncuY(), SAGA))
				ToplamAdim++;
			break;
		}
	}

	/**
	 * yukar�larda an�mlanan y�n de�i�keninin bilgisi kullan�c�dan al�n�yor.
	 * basit bir switch-case yap�s� kullan�larak gerekli de�erler �retiliyor ve
	 * bu bilgiler �st class ve metodlarda kullan�l�yor.
	 */

	private int YonBilgisiAl() {

		Scanner sc = new Scanner(System.in);

		System.out
				.print(" Y�n Tu�lar�yla Oynay�n�z: (w:Yukar�, a:Sol, s:A�a��, d:Sa�) ");
		String secimSor = sc.next();

		char secim = secimSor.charAt(0);
		int yon = HATALI;

		switch (secim) {
		case 'w':
		case 'W':
			yon = YUKARI;
			break;
		case 's':
		case 'S':
			yon = ASAGI;
			break;

		case 'd':
		case 'D':
			yon = SAGA;
			break;

		case 'a':
		case 'A':
			yon = SOLA;
			break;
		}

		return yon;

	}

	// Oyun yazd�rma metdo. Oyun devam etti�i s�rece her zaman ilk yaz�l�yor.
	public void OyunuYaz() {
		System.out.println("-------------------------\n");

		System.out.println(labirent);// labirent yazd�r�l�yor

		System.out.println("Toplam Ad�m Say�s�: " + ToplamAdim);
		System.out.println("Kalan Esya : " + labirent.kalanEsya);
		System.out.println("Puan�n�z : " + puan);
		System.out.println("\n-------------------------\n");

	}

	// Puan metodu ile puan aral��� olu�turuluyor. Ve s�n�rlar belirtilip puan�n
	// ne kadar d���lece�i yaz�l�yor.
	public static void Puan() {

		if (ToplamAdim < 10)
			puan -= 1;
		else if (ToplamAdim < 40)
			puan -= 2;
		else if (ToplamAdim < 60)
			puan -= 3;
		else if (ToplamAdim < 200)
			puan -= 4;
		else if (ToplamAdim < 300)
			puan -= 5;
		else
			puan = 0;

	}
}

/*
 * 
 * 
 * @author:byofficial
 * Burak Yýldýz
 */

package LabirentOyunu;

import java.util.Scanner;

public class Oyun {

	private Labirent labirent;

	/**
	 * int türünde Yön deðiþkenleri oluþturulup deðerler verildi.
	 */
	public static final int YUKARI = 1;
	public static final int SOLA = 2;
	public static final int ASAGI = 3;
	public static final int SAGA = 4;
	public static final int HATALI = 0;

	/**
	 * Adým sayýsýný hesaplayan sayaç oluþturuldý
	 */
	private static int ToplamAdim;
	private static int puan = 1500;// puan sayacý oluþturudu

	/**
	 * Oyun metodunun içerisine matris yüklendi. Toplam adým 0 a eþitlendi.
	 * Yukle metodu oluþturulup, bu metoda matris yazdýrýldý
	 */
	public Oyun(int[][] matris) {
		ToplamAdim = 0;
		puan = 600;
		yukle(matris);
	}

	// Yukle metodunun içerisie labirent nesnesi oluþturuldu

	public void yukle(int[][] matris) {

		labirent = new Labirent(matris);
	}

	/**
	 * baþlat metodu oluþturuldu ve oyun baþlama komutu burada tanýmlandý. Döngü
	 * eklenerek her seferinde sýrayla adýmlarý takip etmesi saðlandý.
	 */
	public void baslat() {
		while (true) {

			OyunuYaz();// Labirent ekrana yazýlýyor

			int yon = YonBilgisiAl();// kullanýcý yön tuþuna basýyor ve bilgi
										// alýnýyor.
			OyuncuyuHareketEttir(yon);// alýnan bilgi parametre olarak metodda
										// yerine konuluyor
			Puan();// Puan metdou çaðýrýlýp puan hesaplanýyor
			if (BitisKontrol())// Oyunun "BitisKontrol" metodunun saðlayýp
								// saðlamadýðý kabul ediiliyor ve saðlayana
								// kadar oyun devam ediyor.
				break;
		}
	}

	/**
	 * "BitisKontrol" metodu burada oluþturuluyor boolean türünde deðiþken
	 * tanýmlanýyor ve ilk deðer atamasý false oluyor. eðer labirentte bulunan
	 * oyuncunun konumlarý hedefin konumuna eþit ise boolean deðiþkeni true
	 * olacak ve deðer döndürecek.
	 *
	 */
	private boolean BitisKontrol() {
		boolean OyunuBitir = false;

		if (labirent.getOyuncuX() == labirent.getHedefX()
				&& labirent.getOyuncuY() == labirent.getHedefY()) {
			System.out
					.println("Tebrikler! Tüm Eþyalarý Bulup Çýkýþa Ulaþtýnýz!");
			OyunuBitir = true;
		}
		return OyunuBitir;
	}

	/**
	 * Oyuncuyu hareket ettirmek için 1 paremetreli olan bir metod
	 * oluþturuluyor. Labirent class'ýndan alýnan oyuncunun yerini deðiþtir
	 * metodu çaðýrýlýyor. ÇAðýrýlan metdodda x paremetresi yerine oyuncunun x
	 * 'i; y yerine ise oyuncunun y'si yazýlýyor. Eðer yukarý yada aþaðý
	 * gidecekse deðiþim y ekseninde oluyor. Eðer saða yada sola gidecekse
	 * deðiþim X ekseninde oluyor. Oyuncun kontrolü Labirent class'ýnda
	 * yapýldýðýndan burada sadece oyuncunun hareketini güncellemesi kalýyor Ve
	 * en sonunda ilerlediðinde de toplam adým deðiþkeni 1 artýyor.
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
	 * yukarýlarda anýmlanan yön deðiþkeninin bilgisi kullanýcýdan alýnýyor.
	 * basit bir switch-case yapýsý kullanýlarak gerekli deðerler üretiliyor ve
	 * bu bilgiler üst class ve metodlarda kullanýlýyor.
	 */

	private int YonBilgisiAl() {

		Scanner sc = new Scanner(System.in);

		System.out
				.print(" Yön Tuþlarýyla Oynayýnýz: (w:Yukarý, a:Sol, s:Aþaðý, d:Sað) ");
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

	// Oyun yazdýrma metdo. Oyun devam ettiði sürece her zaman ilk yazýlýyor.
	public void OyunuYaz() {
		System.out.println("-------------------------\n");

		System.out.println(labirent);// labirent yazdýrýlýyor

		System.out.println("Toplam Adým Sayýsý: " + ToplamAdim);
		System.out.println("Kalan Esya : " + labirent.kalanEsya);
		System.out.println("Puanýnýz : " + puan);
		System.out.println("\n-------------------------\n");

	}

	// Puan metodu ile puan aralýðý oluþturuluyor. Ve sýnýrlar belirtilip puanýn
	// ne kadar düþüleceði yazýlýyor.
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

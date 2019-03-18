/*
 * 
 * 
 * @author:byofficial
 * Burak Y�ld�z
 */


package LabirentOyunu;

public class Labirent {

	private int oyuncuX, oyuncuY;// oyuncux ve oyuncuy ad�nda de�i�ken
									// olu�turuldu.
	private int hedefX, hedefY;// ��k�� hedefi de�i�keni olu�turuldu.
	/**
	 * String dizisiyle ili�kilendirilerek bu class ta; yer isimli de�iken
	 * olu�turulup; LabirentOyunu class �ndaki String dizisindeki "1" de�erine
	 * e�itlendi. Ayn� �ekilde; Duvar,Oyuncu,��k��, E�ya,Kutu gibi sabit
	 * de�i�kenler de String dizisinde de�erlerine e�itlendi.
	 */
	private static final int YER = 1;//
	private static final int DUVAR = 2;
	private static final int OYUNCU = 3;
	private static final int CIKIS = 4;
	private static final int ESYA = 5;
	private static final int KUTU = 6;

	// Kalan e�ya ad�nda saya� de�i�keni olu�turuluyor.
	protected int kalanEsya;

	// matris dizisi olu�turuluyor
	private int matris[][];

	// Labirent metodu olu�turulup i�ine kalan e�ya, oyuncu ve hedef
	// de�i�kenleri atan�p ilk de�erleri 0 yap�l�yor.
	// Matris de labirent metoduna null olarak yazd�r�l�yor.
	public Labirent() {
		kalanEsya = oyuncuX = oyuncuY = hedefX = hedefY = 0;
		matris = null;
	}

	// Labirent metoduna matris parametresi at�l�yor.
	public Labirent(int[][] grid) {
		kalanEsya = oyuncuX = oyuncuY = hedefX = hedefY = 0;
		yukle(grid);

	}

	/**
	 * Bu a�amada matris yazd�r�l�yor ve oyuncu, hedef ve e�yalar�n konumlar�
	 * tespit ediliyor. E�ya sayac� 1 artt�r�l�yor.
	 * 
	 */
	public void yukle(int[][] grid) {

		matris = new int[grid.length][grid[0].length];

		for (int y = 0; y < grid.length; y++) {

			for (int x = 0; x < grid[0].length; x++) {

				int hucre = grid[y][x];

				if (hucre == OYUNCU) {
					oyuncuX = x;
					oyuncuY = y;
				}

				if (hucre == CIKIS) {
					hedefX = x;
					hedefY = y;
				}

				if (hucre == ESYA) {
					kalanEsya++;
				}
				matris[y][x] = grid[y][x];
			}
		}
	}

	/**
	 * Get set metodlar� yap�l�yor. B�ylece di�er class larda kullan�labilecek
	 * hale getiriliyor.
	 */
	public int getOyuncuX() {
		return oyuncuX;
	}

	public int getOyuncuY() {
		return oyuncuY;
	}

	public int getHedefX() {
		return hedefX;
	}

	public int getHedefY() {
		return hedefY;
	}

	/**
	 * Bu a�amada yukle metoduna atanan matris yazd�r�l�yor. Oyun bu a�amada tek
	 * tek String dizisindeki int say�lara kar��l�k gelen ifadeleri yazd�r�p
	 * matrisi olu�turuyor.
	 */
	@Override
	public String toString() {

		String s = "";

		for (int y = 0; y < matris.length; y++) {

			for (int x = 0; x < matris[0].length; x++) {

				int hucre = matris[y][x];

				switch (hucre) {

				case YER:
					s += "-";
					break;
				case DUVAR:
					s += "#";
					break;
				case OYUNCU:
					s += "O";
					break;
				case CIKIS:
					s += "H";
					break;
				case ESYA:
					s += "E";
					break;
				case KUTU:
					s += "K";
					break;

				}
			}
			s += "\n";

		}
		return s;
	}

	/**
	 * 3 parametreli Oyuncu yeri de�i�tirme metodu olu�turuluyor.
	 *
	 */
	public boolean OyuncuYeriniDegistir(int x, int y, int yon) {

		boolean basarili = false;
		/**
		 * (1.sat�r)Yer; X ve Y konum parametreleri al�n�yor. Matriste yerin
		 * konumu tespit ediliyor. E�er X Y kooridnatlar� yer d�zlemine e�it
		 * ise, (2.sat�r)Oyuncunun koordinatlar� ilk �nce yer kabul ediliyor.
		 * (3.sat�r)Daha sonra matristeki (Yerin konumu) X Y koordinatlar�,
		 * oyuncunun koordinatlar� kabul ediliyor. (3.sat�r)Art�k matristeki X Y
		 * (Yerin konumu) koordinatlar�, Oyuncunun koordinatlar�na e�itken; (4.
		 * ve 5.sat�r)Oyuncunun koordinatlar� ise Yer olmu� oluyor. B�ylece
		 * oyuncu ve Yer , yer de�i�tirmi� oluyor.
		 */
		if (matris[y][x] == YER) {
			matris[oyuncuY][oyuncuX] = YER;
			matris[y][x] = OYUNCU;
			oyuncuX = x;
			oyuncuY = y;

			basarili = true;
		}

		/**
		 * Kutu; X ve Y konum parametreleri al�n�yor. MAtristeki kutunun konumu
		 * tespit ediliyor. switch-case yap�s�yla y�n bilgisi tan�mlan�yor. E�er
		 * kutuyu yukar� do�ru hareket ettireceksek; Matris sadece Y ekseninde
		 * hareket etmelidir. Dolay�s�yla X ekseni sabit kalmal�. Ve yukar�
		 * do�ru harekette Y nin koordinat� Y-1 olmal�. E�er "y�n"
		 * de�i�kenimiz(Y�n de�i�keni Oyun class'�ndan �a��r�ld�) 1 ise;
		 * (1.durumdaysa) matris in y-1 ve x koordinat� Yer e e�it mi diye
		 * kontrol edilecek. Yani kurunun �st� yere e�it mi? kutu yukar�ya do�ru
		 * hareket edebilir mi? E�er yukar�s�nda yer'den ba�ka bir cisim varsa
		 * kutu bu if blogunun i�ine girmeyecek ve hareket etmeyecek. �imdi
		 * yukar�s�n�n bo� oldu�unu var sayarak devam edelim; matriste kutunun
		 * konumunu al�p, yukar�s� Yer' e e�itse; Kutunun Yukar�s�n� (Yer) Kutu
		 * kabul ediyoruz. B�ylece kutu yukar�ya hareket etti. Ve �imdi Yer kutu
		 * olurken; Kutu ise yer oldu. Oyuncunun koordinatlar� ise yeni Yer'in
		 * koordinatlar�na e�itlendi. B�ylece Kutu yukar�ya ��kt� ve hemen
		 * arkas�nda da oyuncu yukar�ya ��kt�.
		 * 
		 */

		/**
		 * Yukar�da if-else yap�s�yla kutunun bir �n�n�n yer e e�it olup
		 * olmamas�n�n kontrol� yap�ld�. Yer harici ba�ka bir nesneye e�it ise
		 * kutu hareket edemeyecek dolay�s�yla ayn� if blogunun i�inde olan
		 * oyuncu da hareket edemeyecek. B�ylelilkle kutu ile oyuncu �st �ste
		 * gelemeyecek. Ayn� kontrol sa�a�� y�n i�inde gerekli. Hareket yine Y
		 * ekseninde olacak fakat yukar�ya Y-1 dedi�imizden bu sefer yine X
		 * sabit klacak ve Y ise y+1 olacak. Yine sol ve sa�a hareketi de ayn�
		 * mant�kla d���nebiliriz. Bu sefer Y ekseninde hareket olmad���ndan Y
		 * sabit kalacak. X e�er sola gidiyorsa; x-1, sa�a gidiyorsa x+1 olacak.
		 */

		else if (matris[y][x] == KUTU) {

			switch (yon) {

			case 1:// YUKARI
				if (matris[y - 1][x] == YER) {
					matris[y - 1][x] = KUTU;
					matris[oyuncuY][oyuncuX] = YER;
					matris[y][x] = OYUNCU;
					oyuncuX = x;
					oyuncuY = y;

					basarili = true;
				}
				break;

			case 2:// SOL
				if (matris[y][x - 1] == YER) {
					matris[y][x - 1] = KUTU;
					matris[oyuncuY][oyuncuX] = YER;
					matris[y][x] = OYUNCU;
					oyuncuX = x;
					oyuncuY = y;

					basarili = true;
				}
				break;

			case 3:// ASAGI

				if (matris[y + 1][x] == YER) {
					matris[y + 1][x] = KUTU;
					matris[oyuncuY][oyuncuX] = YER;
					matris[y][x] = OYUNCU;
					oyuncuX = x;
					oyuncuY = y;

					basarili = true;
				}
				break;

			case 4:// SAG

				if (matris[y][x + 1] == YER) {
					matris[y][x + 1] = KUTU;
					matris[oyuncuY][oyuncuX] = YER;
					matris[y][x] = OYUNCU;
					oyuncuX = x;
					oyuncuY = y;

					basarili = true;
				}
				break;

			}
		}

		/**
		 * (1.sat�r)E�ya; X ve Y konum parametreleri al�n�yor. Matriste
		 * oyuncunun konumu tespit ediliyor. E�er oyuncunun X Y kooridnatlar�
		 * yer d�zlemine e�it ise, (2.sat�r)matrisin koordinatlar� �nce oyuncu
		 * kabul ediliyor. (3.sat�r.)Art�k oyuncunun koordinatlar� matristeki
		 * sat�r ve sutun a e�itleniyor ve b�ylece e�ya konumu art�k oyuncunun
		 * konumu oluyor. (4.sat�r)Oyuncu e�yay� yiyince e�ya tekrar Yer'e
		 * e�itleniyor ve e�ya sayac� 1 azal�yor.
		 */
		else if (matris[y][x] == ESYA) {
			matris[oyuncuY][oyuncuX] = YER;
			matris[y][x] = OYUNCU;
			oyuncuX = x;
			oyuncuY = y;
			kalanEsya--;

			basarili = true;
		}

		/**
		 * (1.sat�r)Hedef; X ve Y konum parametreleri al�n�yor. Matriste ��k��
		 * �n koordinatlar� X ve Y ye e�it ise ve kalan e�ya 0 olmu�sa i�lemler
		 * ger�ekle�iyor; (2.sat�r)matrisin koordinatlar� �nce oyuncu kabul
		 * ediliyor. Ve oyuncu da Yer e e�itleniyor (3.sat�r.)Art�k oyuncunun
		 * koordinatlar� matristeki sat�r ve sutun a e�itleniyor ve b�ylece
		 * ��k�� konumu art�k oyuncunun konumu oluyor. (4.sat�r)Oyuncu ��k��a
		 * gelince ve e�er kalan e�ya sayac� 0 olduysa oyun sonaln�yor.
		 */
		else if (matris[y][x] == CIKIS && kalanEsya == 0) {
			matris[oyuncuY][oyuncuX] = YER;
			matris[y][x] = OYUNCU;
			oyuncuX = x;
			oyuncuY = y;

			basarili = true;
		}
		return basarili;
	}

}

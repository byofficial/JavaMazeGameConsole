/*
 * 
 * 
 * @author:byofficial
 * Burak Yýldýz
 */


package LabirentOyunu;

public class Labirent {

	private int oyuncuX, oyuncuY;// oyuncux ve oyuncuy adýnda deðiþken
									// oluþturuldu.
	private int hedefX, hedefY;// çýkýþ hedefi deðiþkeni oluþturuldu.
	/**
	 * String dizisiyle iliþkilendirilerek bu class ta; yer isimli deðiken
	 * oluþturulup; LabirentOyunu class ýndaki String dizisindeki "1" deðerine
	 * eþitlendi. Ayný þekilde; Duvar,Oyuncu,Çýkýþ, Eþya,Kutu gibi sabit
	 * deðiþkenler de String dizisinde deðerlerine eþitlendi.
	 */
	private static final int YER = 1;//
	private static final int DUVAR = 2;
	private static final int OYUNCU = 3;
	private static final int CIKIS = 4;
	private static final int ESYA = 5;
	private static final int KUTU = 6;

	// Kalan eþya adýnda sayaç deðiþkeni oluþturuluyor.
	protected int kalanEsya;

	// matris dizisi oluþturuluyor
	private int matris[][];

	// Labirent metodu oluþturulup içine kalan eþya, oyuncu ve hedef
	// deðiþkenleri atanýp ilk deðerleri 0 yapýlýyor.
	// Matris de labirent metoduna null olarak yazdýrýlýyor.
	public Labirent() {
		kalanEsya = oyuncuX = oyuncuY = hedefX = hedefY = 0;
		matris = null;
	}

	// Labirent metoduna matris parametresi atýlýyor.
	public Labirent(int[][] grid) {
		kalanEsya = oyuncuX = oyuncuY = hedefX = hedefY = 0;
		yukle(grid);

	}

	/**
	 * Bu aþamada matris yazdýrýlýyor ve oyuncu, hedef ve eþyalarýn konumlarý
	 * tespit ediliyor. Eþya sayacý 1 arttýrýlýyor.
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
	 * Get set metodlarý yapýlýyor. Böylece diðer class larda kullanýlabilecek
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
	 * Bu aþamada yukle metoduna atanan matris yazdýrýlýyor. Oyun bu aþamada tek
	 * tek String dizisindeki int sayýlara karþýlýk gelen ifadeleri yazdýrýp
	 * matrisi oluþturuyor.
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
	 * 3 parametreli Oyuncu yeri deðiþtirme metodu oluþturuluyor.
	 *
	 */
	public boolean OyuncuYeriniDegistir(int x, int y, int yon) {

		boolean basarili = false;
		/**
		 * (1.satýr)Yer; X ve Y konum parametreleri alýnýyor. Matriste yerin
		 * konumu tespit ediliyor. Eðer X Y kooridnatlarý yer düzlemine eþit
		 * ise, (2.satýr)Oyuncunun koordinatlarý ilk önce yer kabul ediliyor.
		 * (3.satýr)Daha sonra matristeki (Yerin konumu) X Y koordinatlarý,
		 * oyuncunun koordinatlarý kabul ediliyor. (3.satýr)Artýk matristeki X Y
		 * (Yerin konumu) koordinatlarý, Oyuncunun koordinatlarýna eþitken; (4.
		 * ve 5.satýr)Oyuncunun koordinatlarý ise Yer olmuþ oluyor. Böylece
		 * oyuncu ve Yer , yer deðiþtirmiþ oluyor.
		 */
		if (matris[y][x] == YER) {
			matris[oyuncuY][oyuncuX] = YER;
			matris[y][x] = OYUNCU;
			oyuncuX = x;
			oyuncuY = y;

			basarili = true;
		}

		/**
		 * Kutu; X ve Y konum parametreleri alýnýyor. MAtristeki kutunun konumu
		 * tespit ediliyor. switch-case yapýsýyla yön bilgisi tanýmlanýyor. Eðer
		 * kutuyu yukarý doðru hareket ettireceksek; Matris sadece Y ekseninde
		 * hareket etmelidir. Dolayýsýyla X ekseni sabit kalmalý. Ve yukarý
		 * doðru harekette Y nin koordinatý Y-1 olmalý. Eðer "yön"
		 * deðiþkenimiz(Yön deðiþkeni Oyun class'ýndan çaðýrýldý) 1 ise;
		 * (1.durumdaysa) matris in y-1 ve x koordinatý Yer e eþit mi diye
		 * kontrol edilecek. Yani kurunun üstü yere eþit mi? kutu yukarýya doðru
		 * hareket edebilir mi? Eðer yukarýsýnda yer'den baþka bir cisim varsa
		 * kutu bu if blogunun içine girmeyecek ve hareket etmeyecek. Þimdi
		 * yukarýsýnýn boþ olduðunu var sayarak devam edelim; matriste kutunun
		 * konumunu alýp, yukarýsý Yer' e eþitse; Kutunun Yukarýsýný (Yer) Kutu
		 * kabul ediyoruz. Böylece kutu yukarýya hareket etti. Ve þimdi Yer kutu
		 * olurken; Kutu ise yer oldu. Oyuncunun koordinatlarý ise yeni Yer'in
		 * koordinatlarýna eþitlendi. Böylece Kutu yukarýya çýktý ve hemen
		 * arkasýnda da oyuncu yukarýya çýktý.
		 * 
		 */

		/**
		 * Yukarýda if-else yapýsýyla kutunun bir önünün yer e eþit olup
		 * olmamasýnýn kontrolü yapýldý. Yer harici baþka bir nesneye eþit ise
		 * kutu hareket edemeyecek dolayýsýyla ayný if blogunun içinde olan
		 * oyuncu da hareket edemeyecek. Böylelilkle kutu ile oyuncu üst üste
		 * gelemeyecek. Ayný kontrol saþaðý yön içinde gerekli. Hareket yine Y
		 * ekseninde olacak fakat yukarýya Y-1 dediðimizden bu sefer yine X
		 * sabit klacak ve Y ise y+1 olacak. Yine sol ve saða hareketi de ayný
		 * mantýkla düþünebiliriz. Bu sefer Y ekseninde hareket olmadýðýndan Y
		 * sabit kalacak. X eðer sola gidiyorsa; x-1, saða gidiyorsa x+1 olacak.
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
		 * (1.satýr)Eþya; X ve Y konum parametreleri alýnýyor. Matriste
		 * oyuncunun konumu tespit ediliyor. Eðer oyuncunun X Y kooridnatlarý
		 * yer düzlemine eþit ise, (2.satýr)matrisin koordinatlarý önce oyuncu
		 * kabul ediliyor. (3.satýr.)Artýk oyuncunun koordinatlarý matristeki
		 * satýr ve sutun a eþitleniyor ve böylece eþya konumu artýk oyuncunun
		 * konumu oluyor. (4.satýr)Oyuncu eþyayý yiyince eþya tekrar Yer'e
		 * eþitleniyor ve eþya sayacý 1 azalýyor.
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
		 * (1.satýr)Hedef; X ve Y konum parametreleri alýnýyor. Matriste Çýkýþ
		 * ýn koordinatlarý X ve Y ye eþit ise ve kalan eþya 0 olmuþsa iþlemler
		 * gerçekleþiyor; (2.satýr)matrisin koordinatlarý önce oyuncu kabul
		 * ediliyor. Ve oyuncu da Yer e eþitleniyor (3.satýr.)Artýk oyuncunun
		 * koordinatlarý matristeki satýr ve sutun a eþitleniyor ve böylece
		 * Çýkýþ konumu artýk oyuncunun konumu oluyor. (4.satýr)Oyuncu çýkýþa
		 * gelince ve eðer kalan eþya sayacý 0 olduysa oyun sonalnýyor.
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

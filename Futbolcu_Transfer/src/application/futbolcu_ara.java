package application;

public class futbolcu_ara {
	private int id;
	private int ya��,fiyat;
	private String tak�m,futbolcuad�,tak�m�,mevki;
	
	
	
	futbolcu_ara() {
		
	}
	
    futbolcu_ara(int id , String tak�m , String futbolcuad� , String tak�m� ,String mevki  ,int ya��,int fiyat){
		this.id=id;
		this.tak�m=tak�m;
		this.futbolcuad�=futbolcuad�;
		this.tak�m�=tak�m�;
		this.mevki=mevki;
		this.ya��=ya��;
		this.fiyat=fiyat;
		
	}
	
	
	
	public String getTak�m() {
		return tak�m;
	}
	public void setTak�m(String tak�m) {
		this.tak�m = tak�m;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFutbolcu_ad�() {
		return futbolcuad�;
	}
	public void setFutbolcu_ad�(String futbolcu_ad�) {
		this.futbolcuad� = futbolcu_ad�;
	}
	public String getTak�m�() {
		return tak�m�;
	}
	public void setTak�m�(String tak�m�) {
		this.tak�m� = tak�m�;
	}
	public String getMevki() {
		return mevki;
	}
	public void setMevki(String mevki) {
		this.mevki = mevki;
	}
	public int getYa��() {
		return ya��;
	}
	public void setYa��(int ya��) {
		this.ya�� = ya��;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	

}

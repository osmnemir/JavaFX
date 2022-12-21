package application;

public class futbolcu_ara {
	private int id;
	private int yaþý,fiyat;
	private String takým,futbolcuadý,takýmý,mevki;
	
	
	
	futbolcu_ara() {
		
	}
	
    futbolcu_ara(int id , String takým , String futbolcuadý , String takýmý ,String mevki  ,int yaþý,int fiyat){
		this.id=id;
		this.takým=takým;
		this.futbolcuadý=futbolcuadý;
		this.takýmý=takýmý;
		this.mevki=mevki;
		this.yaþý=yaþý;
		this.fiyat=fiyat;
		
	}
	
	
	
	public String getTakým() {
		return takým;
	}
	public void setTakým(String takým) {
		this.takým = takým;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFutbolcu_adý() {
		return futbolcuadý;
	}
	public void setFutbolcu_adý(String futbolcu_adý) {
		this.futbolcuadý = futbolcu_adý;
	}
	public String getTakýmý() {
		return takýmý;
	}
	public void setTakýmý(String takýmý) {
		this.takýmý = takýmý;
	}
	public String getMevki() {
		return mevki;
	}
	public void setMevki(String mevki) {
		this.mevki = mevki;
	}
	public int getYaþý() {
		return yaþý;
	}
	public void setYaþý(int yaþý) {
		this.yaþý = yaþý;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	

}

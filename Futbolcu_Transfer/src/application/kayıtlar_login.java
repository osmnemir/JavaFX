package application;

public class kay�tlar_login {
	private int id;
	private String kullan�c�_ad�;
	private String sifre;
	private int yetki;
	
	
	kay�tlar_login() {
		this.yetki=0;
		
	}
	
	kay�tlar_login(int id , String kullan�c�_ad� , String sifre , int yetki){
		this.id=id;
		
		this.kullan�c�_ad�=kullan�c�_ad�;
		this.sifre=sifre;
		this.yetki=yetki;
		
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getkullan�c�_ad�() {
		return kullan�c�_ad�;
	}


	public void setkullan�c�_ad�(String kullan�c�_ad�) {
		this.kullan�c�_ad� = kullan�c�_ad�;
	}


	public String getSifre() {
		return sifre;
	}


	public void setSifre(String sifre) {
		this.sifre = sifre;
	}


	public int getYetki() {
		return yetki;
	}


	public void setYetki(Integer yetki) {
		this.yetki = yetki;
	}


	

}

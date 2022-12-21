package application;

public class kayýtlar_login {
	private int id;
	private String kullanýcý_adý;
	private String sifre;
	private int yetki;
	
	
	kayýtlar_login() {
		this.yetki=0;
		
	}
	
	kayýtlar_login(int id , String kullanýcý_adý , String sifre , int yetki){
		this.id=id;
		
		this.kullanýcý_adý=kullanýcý_adý;
		this.sifre=sifre;
		this.yetki=yetki;
		
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getkullanýcý_adý() {
		return kullanýcý_adý;
	}


	public void setkullanýcý_adý(String kullanýcý_adý) {
		this.kullanýcý_adý = kullanýcý_adý;
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

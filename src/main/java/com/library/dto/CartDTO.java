package com.library.dto;

public class CartDTO {
	private int cartno, mno, bisbn;
	private String bname, bimg, blink, bautor, bpub, cartdate;
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getBisbn() {
		return bisbn;
	}
	public void setBisbn(int bisbn) {
		this.bisbn = bisbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getBlink() {
		return blink;
	}
	public void setBlink(String blink) {
		this.blink = blink;
	}
	public String getBautor() {
		return bautor;
	}
	public void setBautor(String bautor) {
		this.bautor = bautor;
	}
	public String getBpub() {
		return bpub;
	}
	public void setBpub(String bpub) {
		this.bpub = bpub;
	}
	public String getCartdate() {
		return cartdate;
	}
	public void setCartdate(String cartdate) {
		this.cartdate = cartdate;
	}
	
}

package com.library.dto;

public class CartDTO {
	private int cno, mno;
	private String bisbn,cdate,cdel;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCdel() {
		return cdel;
	}
	public void setCdel(String cdel) {
		this.cdel = cdel;
	}
	
}
package com.library.dto;

import java.sql.Date;

public class ReviewDTO {

	private String rtitle, rauthor, rcontent, mid, mname, rdel;
	private Date rdate;	
	private int mno , rno;
	
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRauthor() {
		return rauthor;
	}
	public void setRauthor(String rauthor) {
		this.rauthor = rauthor;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
  public String getRdel() {
    return rdel;
  }
  public void setRdel(String rdel) {
    this.rdel = rdel;
  }
}

package com.library.dto;

public class BookrentDTO {
  private int rtno, mno;
  private String bisbn, rtdate, rtdateadd, rtenum, btitle, mid;

  public String getRtdateadd() {
    return rtdateadd;
  }

  public void setRtdateadd(String rtdateadd) {
    this.rtdateadd = rtdateadd;
  }

  public String getBtitle() {
    return btitle;
  }

  public void setBtitle(String btitle) {
    this.btitle = btitle;
  }

  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public int getRtno() {
    return rtno;
  }

  public void setRtno(int rtno) {
    this.rtno = rtno;
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

  public String getRtdate() {
    return rtdate;
  }

  public void setRtdate(String rtdate) {
    this.rtdate = rtdate;
  }

  public String getRtenum() {
    return rtenum;
  }

  public void setRtenum(String rtenum) {
    this.rtenum = rtenum;
  }

}

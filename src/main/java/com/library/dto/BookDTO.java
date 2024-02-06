package com.library.dto;

public class BookDTO {
  private String btitle, bauthor, bpublisher, bimage, blink, bisbn, rtdate, rtenum, mid;

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

  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  private int mno;

  public String getBtitle() {
    return btitle;
  }

  public void setBtitle(String btitle) {
    this.btitle = btitle;
  }

  public String getBauthor() {
    return bauthor;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public String getBpublisher() {
    return bpublisher;
  }

  public void setBpublisher(String bpublisher) {
    this.bpublisher = bpublisher;
  }

  public String getBimage() {
    return bimage;
  }

  public void setBimage(String bimage) {
    this.bimage = bimage;
  }

  public String getBlink() {
    return blink;
  }

  public void setBlink(String blink) {
    this.blink = blink;
  }

  public String getBisbn() {
    return bisbn;
  }

  public void setBisbn(String bisbn) {
    this.bisbn = bisbn;
  }
}

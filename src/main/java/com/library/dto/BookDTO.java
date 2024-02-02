package com.library.dto;

public class BookDTO {
  private String title, image, author, publisher, isbn;
  private String bisbn ,bname, bpub, bwrite, brent, link, mid;
  private int bno;
  
  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }

  public String getBpub() {
    return bpub;
  }

  public void setBpub(String bpub) {
    this.bpub = bpub;
  }

  public String getBwrite() {
    return bwrite;
  }

  public void setBwrite(String bwrite) {
    this.bwrite = bwrite;
  }

  public String getBrent() {
    return brent;
  }

  public void setBrent(String brent) {
    this.brent = brent;
  }

  public int getBno() {
    return bno;
  }

  public void setBno(int bno) {
    this.bno = bno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public String getBisbn() {
    return bisbn;
  }

  public void setBisbn(String bisbn) {
    this.bisbn = bisbn;
  }
}

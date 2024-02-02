package com.library.dto;

import java.util.List;

public class NaverDTO {
  private String lastBuildDate;
  private int total, start, display;
  private List<BookDTO> items;
  
  public String getLastBuildDate() {
    return lastBuildDate;
  }
  public void setLastBuildDate(String lastBuildDate) {
    this.lastBuildDate = lastBuildDate;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public int getStart() {
    return start;
  }
  public void setStart(int start) {
    this.start = start;
  }
  public int getDisplay() {
    return display;
  }
  public void setDisplay(int display) {
    this.display = display;
  }
  public List<BookDTO> getItems() {
    return items;
  }
  public void setItems(List<BookDTO> items) {
    this.items = items;
  }
}

package com.kh.example.collection1;

import java.util.Objects;

public class Music implements Comparable {
	private String title;
	private String singer;
	
	public Music() {
		super();
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer + " - " + title;
	}

	@Override //객체간 비교를 위해서 해시코드랑 equals는 오버라이딩해준다.
	public int hashCode() {
		return Objects.hash(title,singer);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
			Music m = (Music)obj; //다운캐스팅
			return this.title.equals(m.getTitle()) && this.singer == m.getSinger();
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}

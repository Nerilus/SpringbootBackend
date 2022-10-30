package com.contentfilter.contentfilter.model;

// import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contents")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "word")
	private String word;

public Content(){

}
	public Content(Long id, String url, String word){
		super();
		this.id = id;
		this.url = url;
		this.word = word;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word){
		this.word = word;
	}


}
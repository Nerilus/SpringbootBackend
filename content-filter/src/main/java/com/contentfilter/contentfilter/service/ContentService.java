package com.contentfilter.contentfilter.service;

import java.util.List;

import com.contentfilter.contentfilter.model.Content;



public interface ContentService {
	Content createWord(Content content);
	List<Content> getAllContents();
	// Content getContentById(long id);
	Content updateContent(Content content, long id);
	void deleteContentById(long id);
    long deleteContent(String url);

}
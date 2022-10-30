package com.contentfilter.contentfilter.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.contentfilter.contentfilter.exception.ResourceNotFoundException;
import com.contentfilter.contentfilter.model.Content;
import com.contentfilter.contentfilter.repository.ContentRepository;
import com.contentfilter.contentfilter.service.ContentService;
 

@Service
@Transactional
public class ContentServiceImpl implements ContentService{

	private ContentRepository contentRepository;
	
	public ContentServiceImpl(ContentRepository contentRepository) {
		super();
		this.contentRepository = contentRepository;
	}

	@Override
	public Content createWord(Content content){
		if (contentRepository.findByWord((String) content.getWord()) != null){
			throw new RuntimeException("word already exist");
		}
		return contentRepository.save(content);

	}

	@Override
	public List<Content> getAllContents() {
		return contentRepository.findAll();
	}

	

	@Override
	public Content updateContent(Content content, long id) {
		
		Content existingContent = contentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Content", "Id", id)); 
		
		existingContent.setUrl((String) content.getUrl());
		existingContent.setWord((String) content.getWord());
		contentRepository.save(existingContent);
		return existingContent;
	}

	// @Override
	// public void deleteContentById(long id) {
	// 	// TODO Auto-generated method stub
		
	// }

	// @Override
	// public Content deleteAll(Content content, String url) {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }


	@Override
	public void deleteContentById(long id) {
		contentRepository.deleteById(id);	
	}
	@Override
	public long deleteContent(String url) {
		return contentRepository.deleteByUrl(url);

		
	}
	
}

package com.contentfilter.contentfilter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contentfilter.contentfilter.model.Content;
import com.contentfilter.contentfilter.service.ContentService;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ContentController {
	
	private ContentService contentService;

	public ContentController(ContentService contentService) {
		super();
		this.contentService = contentService;
	}
	@PostMapping("/content/check")
	public ResponseEntity<Object> ReadFromUrl(@RequestBody Content content, String url) throws IOException{
		url = content.getUrl();
		//  StringBuilder contents = new StringBuilder();

		try{
			URL ulr = new URL(url);
			URLConnection urlConnection = ulr.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
	
			while ((line = bufferedReader.readLine()) != null){
				if(line.contains(content.getWord())){
					return ResponseHandler.Response("reject",HttpStatus.OK,content.getUrl());
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
	
		}
		return  ResponseHandler.Response("acccepted",HttpStatus.OK,contentService.createWord(content));
		}
	
	@GetMapping("/content")
	public ResponseEntity< List<Content> >getAllContents(){
		List<Content> e = contentService.getAllContents();
		if( e.isEmpty()){
			return new ResponseEntity< List<Content> >(HttpStatus.NO_CONTENT);
		}	
			return new ResponseEntity< List<Content> >(e,HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Content> updateContent(@PathVariable("id") long id
												  ,@RequestBody Content content){
		return new ResponseEntity<Content>(contentService.updateContent(content, id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContent(@PathVariable("id") long id) {
		contentService.deleteContentById(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

	@DeleteMapping("/content")
	public ResponseEntity<String> deleteContent(@RequestBody Content content) {
		
		try{
			String url = content.getUrl();
			System.out.println("url delete" + url);
			long id =  contentService.deleteContent(url);
			System.out.println("id de url delete " + id);
			return new ResponseEntity<String>("content",HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("no",HttpStatus.BAD_REQUEST);
			
		}
	}	
}	

	
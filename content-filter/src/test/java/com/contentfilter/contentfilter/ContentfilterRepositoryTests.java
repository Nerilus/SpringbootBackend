package com.contentfilter.contentfilter;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.contentfilter.contentfilter.model.Content;
import com.contentfilter.contentfilter.repository.ContentRepository;

// import antlr.collections.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContentfilterRepositoryTests {

    @Autowired
	private ContentRepository contentRepository;
    
    @Test
	@Order(1)
	@Rollback(value = false)
	public void createWordTest(){

		Content content = new Content();
			  content.setUrl("https://dzone.com/articles/how-to-validate-names-using-java");
			  content.setWord("What Is");

		contentRepository.save(content);
	}

    @Test
	@Order(3)
	public void getListOfContentsTest() {

		List<Content> employees = contentRepository.findAll();
		
		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}


	
}

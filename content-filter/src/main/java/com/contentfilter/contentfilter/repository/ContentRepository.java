package com.contentfilter.contentfilter.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contentfilter.contentfilter.model.Content;



public interface ContentRepository extends JpaRepository<Content, Long>{
	Content findByWord(String word);

    // static Optional<Content> findAll(String url) {
    //     return null;
    // }
    long deleteByUrl(String url);

    // Content deleteAll(String url);

}
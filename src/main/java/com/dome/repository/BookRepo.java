package com.dome.repository;

import com.dome.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepo extends ElasticsearchRepository<Book,String> {

    List<Book> findByNameLike(String name);
}

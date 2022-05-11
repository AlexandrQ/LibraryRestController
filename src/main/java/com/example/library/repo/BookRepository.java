package com.example.library.repo;

import com.example.library.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT id, name, author_name, publish_date, public_catalog FROM public.book WHERE public_catalog = true", nativeQuery = true)
    List<Book> getAllFromPublicCatalog();

    @Query(value = "SELECT id, name, author_name, publish_date, public_catalog FROM public.book WHERE public_catalog = false", nativeQuery = true)
    List<Book> getAllFromPrivateCatalog();

}

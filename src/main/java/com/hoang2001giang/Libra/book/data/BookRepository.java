package com.hoang2001giang.Libra.book.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String>,
        JpaSpecificationExecutor<Book> {
}

package com.hoang2001giang.Libra.book.service;

import com.hoang2001giang.Libra.book.dto.BookDto;
import com.hoang2001giang.Libra.book.dto.CreateBookInVO;
import com.hoang2001giang.Libra.book.dto.GetBooksInVO;
import com.hoang2001giang.Libra.book.dto.GetBooksOutVO;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks(GetBooksInVO inVO);
    BookDto createBook(CreateBookInVO inVO);
    BookDto getOneBook(String id);
}

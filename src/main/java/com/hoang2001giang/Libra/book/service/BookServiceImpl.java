package com.hoang2001giang.Libra.book.service;

import com.hoang2001giang.Libra.book.data.Book;
import com.hoang2001giang.Libra.book.data.BookRepository;
import com.hoang2001giang.Libra.book.dto.BookDto;
import com.hoang2001giang.Libra.book.dto.CreateBookInVO;
import com.hoang2001giang.Libra.book.dto.GetBooksInVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks(GetBooksInVO inDto) {
        return listEntityToListDto(bookRepository.findAll());
    }

    @Override
    public BookDto createBook(CreateBookInVO inVO) {
        Book createdBook = new Book();
        BeanUtils.copyProperties(inVO, createdBook);
        createdBook.setId(UUID.randomUUID().toString());
        createdBook = bookRepository.save(createdBook);

        return entityToDto(createdBook);
    }

    @Override
    public BookDto getOneBook(String id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return entityToDto(book);
    }

    private BookDto entityToDto(Book entity) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private List<BookDto> listEntityToListDto(List<Book> entities) {
        List<BookDto> dtos = new ArrayList<>();
        for (Book entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}

package com.hoang2001giang.Libra.book.service;

import com.hoang2001giang.Libra.auth.data.User;
import com.hoang2001giang.Libra.auth.security.UserDetailsImpl;
import com.hoang2001giang.Libra.book.data.Book;
import com.hoang2001giang.Libra.book.data.BookRepository;
import com.hoang2001giang.Libra.book.data.BookSpecification;
import com.hoang2001giang.Libra.book.dto.BookDto;
import com.hoang2001giang.Libra.book.dto.CreateBookInVO;
import com.hoang2001giang.Libra.book.dto.GetBooksInVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        BookSpecification spec = new BookSpecification(inDto);
        return listEntityToListDto(bookRepository.findAll(spec));
    }

    @Override
    public BookDto createBook(CreateBookInVO inVO) {
        User user = ((UserDetailsImpl) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal())
                .getUser();
        Book createdBook = new Book();
        BeanUtils.copyProperties(inVO, createdBook);
        createdBook.setId(UUID.randomUUID().toString());
        createdBook.setUser(user);
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
        dto.setUserId(entity.getUser().getId());
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

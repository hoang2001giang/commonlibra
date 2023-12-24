package com.hoang2001giang.Libra.book.controller;

import com.hoang2001giang.Libra.book.dto.BookDto;
import com.hoang2001giang.Libra.book.dto.CreateBookInVO;
import com.hoang2001giang.Libra.book.dto.GetBooksInVO;
import com.hoang2001giang.Libra.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAll(GetBooksInVO vo) {
        return new ResponseEntity<>(bookService.getAllBooks(vo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getOne(@PathVariable(name = "id") String bookId) {
        return new ResponseEntity<>(bookService.getOneBook(bookId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody CreateBookInVO inVO) {

        return new ResponseEntity<>(bookService.createBook(inVO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public String editBook() {
        return "Book updated";
    }

    @DeleteMapping("/{id}")
    public String deleteBook() {
        return "Book removed";
    }
}

package io.github.bzdgn.apidesign.openapi.controller;

import io.github.bzdgn.apidesign.openapi.api.BookApi;
import io.github.bzdgn.apidesign.openapi.dto.BookDTO;
import io.github.bzdgn.apidesign.openapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookApiImpl implements BookApi {

    private final BookService bookService;


    @Override
    public ResponseEntity<BookDTO> getBookById(Long id) {
        BookDTO book = bookService.getBookById(id);

        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<List<BookDTO>> listBooks() {
        List<BookDTO> response = bookService.getBooks();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookDTO> updateBook(Long id, BookDTO bookDTO) {
        BookDTO response = bookService.updateBookById(id, bookDTO);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) {
        BookDTO response = bookService.addBook(bookDTO);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookDTO> deleteBook(Long id) {
        BookDTO response = bookService.deleteBook(id);

        return ResponseEntity.ok(response);
    }

}


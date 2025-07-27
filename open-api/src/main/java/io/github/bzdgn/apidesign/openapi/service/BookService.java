package io.github.bzdgn.apidesign.openapi.service;

import io.github.bzdgn.apidesign.openapi.dto.BookDTO;
import io.github.bzdgn.apidesign.openapi.exceptionhandling.GenericResponseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static Long counter = 6L;

    private final List<BookDTO> books;

    public BookService() {
        this.books = new ArrayList<>(List.of(
                new BookDTO()
                        .id(1L)
                        .name("The Time Machine")
                        .type("Science Fiction")
                        .author("H. G. Wells")
                        .isbn("111-1111111111"),
                new BookDTO()
                        .id(2L)
                        .name("1984")
                        .type("Dystopian")
                        .author("George Orwell")
                        .isbn("222-2222222222"),
                new BookDTO()
                        .id(3L)
                        .name("Clean Code")
                        .type("Programming")
                        .author("Robert C. Martin")
                        .isbn("333-3333333333"),
                new BookDTO()
                        .id(4L)
                        .name("Brave New World")
                        .type("Science Fiction")
                        .author("Aldous Huxley")
                        .isbn("444-4444444444"),
                new BookDTO()
                        .id(5L)
                        .name("The Pragmatic Programmer")
                        .type("Programming")
                        .author("Andy Hunt")
                        .isbn("555-5555555555")
        ));
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public BookDTO getBookById(Long id) {
        return findBookById(id);
    }

    private BookDTO findBookById(Long id) {
        return books.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst()
                .orElseThrow(() -> new GenericResponseException(Long.toString(id)));
    }

    public BookDTO updateBookById(Long id, BookDTO updateBookRequestDTO) {
        BookDTO bookEntry = findBookById(id);

        bookEntry
            .author(updateBookRequestDTO.getAuthor())
            .name(updateBookRequestDTO.getName())
            .type(updateBookRequestDTO.getType())
            .isbn(updateBookRequestDTO.getIsbn());

        return bookEntry;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        books.add(bookDTO.id(counter++));

        return bookDTO;
    }

    public BookDTO deleteBook(Long id) {
        BookDTO book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new GenericResponseException(Long.toString(id)));

        if (book != null) {
            books.remove(book);
        }

        return book;
    }

}

package br.com.erudio.unitetests.mapper.mocks;


import br.com.erudio.data.dto.BookDTO;
import br.com.erudio.model.Book;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO(){
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }

        return books;
    }

    public List<BookDTO> mockDTOList(){
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        for (int i = 0; i < 14; i++) {
            bookDTOs.add(mockDTO(i));
        }
        return bookDTOs;
    }

    public Book mockEntity(Integer number){
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Author " + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        book.setTitle("Title " + number);

        return book;
    }

    public BookDTO mockDTO(Integer number){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(number.longValue());
        bookDTO.setAuthor("Author " + number);
        bookDTO.setLaunchDate(new Date());
        bookDTO.setPrice(25D);
        bookDTO.setTitle("Title " + number);

        return bookDTO;
    }
}

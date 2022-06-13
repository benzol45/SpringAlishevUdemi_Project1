package springbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbase.entity.Book;
import springbase.entity.People;
import springbase.repository.LibraryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Book> getBooksByPeopleId(int id) {
        return libraryRepository.getBooksByPeopleId(id);
    }

    public Optional<People> getPeopleByBookId(int id) {
        return libraryRepository.getPeopleByBookId(id);
    }

    public void makeBookFree(int book_id) {
        libraryRepository.makeFreeBookById(book_id);
    }

    public void giveoutBookToPerson(int book_id, int person_id) {
        libraryRepository.giveoutBookByIdToPersonById(book_id,person_id);
    }

}

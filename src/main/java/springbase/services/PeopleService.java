package springbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbase.entity.People;
import springbase.repository.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> getAll() {
        return peopleRepository.getAll();
    }

    public Optional<People> getById(int id) {
        return peopleRepository.getById(id);
    }

    public void add(People people) {
        peopleRepository.save(people);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public void update(int id, People people) {
        peopleRepository.update(id, people);
    }
}

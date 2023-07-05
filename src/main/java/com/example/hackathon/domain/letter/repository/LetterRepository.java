package com.example.hackathon.domain.letter.repository;

import com.example.hackathon.domain.letter.Letter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends CrudRepository<Letter, Long> {
    @Query(value = "SELECT * FROM tbl_letter order by RAND() limit 1", nativeQuery = true)
    Optional<Letter> findRandom();
}

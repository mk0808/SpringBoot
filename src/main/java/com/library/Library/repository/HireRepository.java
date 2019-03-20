package com.library.Library.repository;

import com.library.Library.domain.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {

    List<Hire> findAll();

    Optional<Hire> findById(Long aLong);

    List<Hire> findByHiredBook_Id(int id);

}

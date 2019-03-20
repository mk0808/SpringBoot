package com.library.Library.service;

import com.library.Library.domain.Hire;
import com.library.Library.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireService {
    @Autowired
    HireRepository hireRepository;

    public List<Hire> getHireByBookId(int id){
        return hireRepository.findByHiredBook_Id(id);
    }
}

package com.gym.dao;

import com.gym.model.Cliente;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}

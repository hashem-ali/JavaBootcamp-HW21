package com.example.schoolms.Repositries;

import com.example.schoolms.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositry extends JpaRepository<Address,Long> {
}

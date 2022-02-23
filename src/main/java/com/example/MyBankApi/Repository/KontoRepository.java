package com.example.MyBankApi.Repository;

import com.example.MyBankApi.Entity.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepository extends JpaRepository<Konto,Long> {
}

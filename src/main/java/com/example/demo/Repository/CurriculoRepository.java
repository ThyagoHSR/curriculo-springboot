package com.example.demo.Repository;

import com.example.demo.Model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    // Adicione métodos personalizados se necessário
}

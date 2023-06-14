package com.uspEsalq.mba.ahp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uspEsalq.mba.ahp.entities.CarteiraItens;

public interface CarteiraItemRepository extends JpaRepository<CarteiraItens, Long> {
}

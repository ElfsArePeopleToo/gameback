package com.app.repository;

import com.app.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findById(Integer id);

    List<Player> findAll();
}

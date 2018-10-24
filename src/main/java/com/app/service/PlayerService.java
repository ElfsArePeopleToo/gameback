package com.app.service;

import com.app.entity.Player;
import com.app.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player getPlayer(Integer id){
        return  playerRepository.findById(id);
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }
}

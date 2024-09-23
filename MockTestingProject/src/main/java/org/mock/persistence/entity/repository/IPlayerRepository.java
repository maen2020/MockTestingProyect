package org.mock.persistence.entity.repository;

import org.mock.persistence.entity.Player;

import java.util.List;

//Interface que contiene los metodos del CRUD
public interface IPlayerRepository {

    //Metodos del CRUD
    List<Player> findAll();
    Player findById(Long id);
    void save(Player player);
    void deleteById(Long id);
}

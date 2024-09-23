package org.mock.service;

import org.mock.persistence.entity.Player;

import java.util.List;

//Capa de servicio.
public interface IPlayerService {

    List<Player> findAll();
    Player findById(Long id);
    void save(Player player);
    void deleteById(Long id);
}

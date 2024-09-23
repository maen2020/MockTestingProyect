package org.mock;

import org.mock.persistence.entity.Player;

import java.util.List;

public class DataProvider {

    public static List<Player> playerListMock(){
        System.out.println(" --> Obteniendo el listado de Player / Mock");
        return List.of(
                new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
                new Player(2L, "Cristinano Ronaldo", "Al Nassr", "Delantero"),
                new Player(3L, "Neymar Jr", "Paris Saint-Germani", "DElantero"),
                new Player(4L, "Kylian Mbappé", "Paris Saint-Germani", "DElantero"),
                new Player(5L, "Kevin De Bruyne", "Manchester City", "Volante"),
                new Player(6L, "Virgil van Dijk", "Liverpool", "Defensa")
        );
    }

    public static Player playerMock(){
        return new Player(1L, "Lionel Messi", "Inter Miami", "Delantero");
    }

    public static Player newPlayerMock(){
        return new Player(7L, "Miguel Angel", "America", "Delantero");
    }
}
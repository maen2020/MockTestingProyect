package org.mock.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
* Habilita el uso de anotaciones de Mockito.
*/
@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    //Dependencia.
    @Mock
    private PlayerRepositoryImpl playerRepository;

    //Clase.
    @InjectMocks
    private PlayerServiceImpl playerService;

    /* Habilita las anotaciones de Mockito.
    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }*/

    @Test
    public void testFindAll(){

        //When - Cuando
        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());
        List<Player> result = playerService.findAll();

        //Then - Entonces
        assertNotNull(result); //Validar que no sea nulo.
        assertFalse(result.isEmpty()); //Validar que no este vacio.
        assertEquals("Lionel Messi", result.get(0).getName());
        assertEquals("Inter Miami", result.get(0).getTeam());
        assertEquals("Delantero", result.get(0).getPosition());
    }

    @Test
    public void testFindById(){

        // Given
        Long id = 1L;

        // When
        when(this.playerRepository.findById( anyLong() )).thenReturn(DataProvider.playerMock());
        Player player = this.playerService.findById(id);

        // Then
        assertNotNull(player);
        assertEquals("Lionel Messi", player.getName());
        assertEquals("Inter Miami", player.getTeam());
        assertEquals("Delantero", player.getPosition());

        // Opcional para saber cuantas veces se llamo al metodo.
        verify(this.playerRepository).findById( anyLong() );
    }

    @Test
    public void testSave(){

        // Given
        Player player = DataProvider.newPlayerMock();

        // When
        this.playerService.save(player);

        // Then
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save(playerArgumentCaptor.capture());
        assertEquals(7L, playerArgumentCaptor.getValue().getId());
        assertEquals("Miguel Angel", playerArgumentCaptor.getValue().getName());
        assertEquals("America", playerArgumentCaptor.getValue().getTeam());
        assertEquals("Delantero", playerArgumentCaptor.getValue().getPosition());
    }

    @Test
    public void testDeleteById(){

        // Given
        Long id = 1L;

        // When
        this.playerService.deleteById(id);

        // Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById( anyLong() );
        verify(this.playerRepository).deleteById( longArgumentCaptor.capture() );
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}
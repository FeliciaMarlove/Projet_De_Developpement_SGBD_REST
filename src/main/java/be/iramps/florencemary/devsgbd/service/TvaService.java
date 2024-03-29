package be.iramps.florencemary.devsgbd.service;

import be.iramps.florencemary.devsgbd.dto.TvaDto;
import be.iramps.florencemary.devsgbd.model.Tva;

import java.util.List;

/**
 * Interface non documentee : Ref Classe Implementee
 */
public interface TvaService {
    List<Tva> read();
    Tva readOne(Long id);
    Tva create(TvaDto newItem);
    Tva update(Long id, TvaDto update);
    Tva delete(Long id);
    List<Tva> readActive();
}

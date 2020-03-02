package be.iramps.florencemary.devsgbd.service;

import be.iramps.florencemary.devsgbd.dto.DepartementDto;
import be.iramps.florencemary.devsgbd.model.Departement;
import be.iramps.florencemary.devsgbd.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementServiceImplemented implements DepartementService {
    private DepartementRepository repository;

    @Autowired
    public DepartementServiceImplemented(DepartementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Departement> read() {
        return (List<Departement>) repository.findAll();
    }

    @Override
    public Departement readOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Departement create(DepartementDto newItem) {
        Departement newDepartement = new Departement(newItem.getNomDepartement());
        if (equalsAny(newDepartement) == null) repository.save(newDepartement);
        return newDepartement;
    }

    @Override
    public Departement update(Long id, DepartementDto update) {
        Departement toUpdate = repository.findById(id).get();
        if (toUpdate != null) {
            toUpdate.setNomDepartement(update.getNomDepartement());
            if (equalsAny(toUpdate) == null) repository.save(toUpdate);
        }
        return toUpdate;
    }

    @Override
    public Departement delete(Long id) {
        if (exists(id)) {
            repository.findById(id).get().setActifDepartement(false);
            return readOne(id);
        }
        return null;
    }

    @Override
    public List<Departement> readActive() {
        List<Departement> actifs = new ArrayList<>();
        for (Departement departement : read()) {
            if (departement.isActifDepartement()) actifs.add(departement);
        }
        return actifs;
    }

    private boolean exists(Long id) {
        boolean exists = false;
        for (Departement departement : read()) {
            if ((departement.isActifDepartement() == true) && (departement.getIdDepartement() == id)) exists = true;
        }
        return exists;
    }

    private Departement equalsAny(Departement departement) {
        for (Departement departementCompared : read()) {
            if (departement.equals(departementCompared)) return repository.findById(departementCompared.getIdDepartement()).get();
        }
        return null;
    }
}

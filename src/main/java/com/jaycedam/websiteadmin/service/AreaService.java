package com.jaycedam.websiteadmin.service;

import com.jaycedam.websiteadmin.domain.Area;
import com.jaycedam.websiteadmin.repo.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    // CRUD
    public List<Area> getAreas() {
        return areaRepository.findAll();
    }

    public void createArea(Area area) {
        areaRepository.save(area);
    }

    @Transactional
    public void updateArea(Long id,
                           Area newArea) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Area with id " + id + " doesn't exist."
        ));

        if(newArea.getName() != null && newArea.getName().length() > 0 &&
                !Objects.equals(area.getName(), newArea.getName())) {
            area.setName(newArea.getName());
        }
    }

    public void deleteArea(Long id) {
        if(!areaRepository.existsById(id)) {
            throw new IllegalStateException("Area with id " + id + " doesn't exist");
        }
        areaRepository.deleteById(id);
    }
}

package com.jaycedam.websiteadmin.controller;

import com.jaycedam.websiteadmin.domain.Area;
import com.jaycedam.websiteadmin.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin("*")
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(path = "areas")
    public List<Area> getAreas() {
        return areaService.getAreas();
    }

    @PostMapping(path = "area/save")
    public void createArea(@RequestBody Area area) {
        areaService.createArea(area);
    }

    @PutMapping(path = "area/update/{id}")
    public void updateArea(@PathVariable("id") Long id,
                           @RequestBody Area area) {
        areaService.updateArea(id, area);
    }

    @DeleteMapping(path = "area/delete/{id}")
    public void deleteArea(@PathVariable("id") Long id) {
        areaService.deleteArea(id);
    }
}

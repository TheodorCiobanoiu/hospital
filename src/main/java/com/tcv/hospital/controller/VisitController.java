package com.tcv.hospital.controller;

import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.model.Visit;
import com.tcv.hospital.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("visits")
public class VisitController {

    private final VisitService visitService;

    @GetMapping("all")
    public List<Visit> getAllVisits(){
        return visitService.getAllVisits();
    }

    @GetMapping("cnp/{cnp}")
    public List<Visit> getAllVisitsByCnp(@PathVariable String cnp){
        return visitService.getVisitsByCnp(cnp);
    }

    @GetMapping("specialty/{specialty}")
    public List<Visit> getAlVisitsBySpecialty(@PathVariable Specialty specialty){
        return visitService.getVisitBySpecialty(specialty);
    }

    @PostMapping("save")
    public void saveVisit(@RequestBody Visit visit){
        visitService.saveVisit(visit);
    }
}

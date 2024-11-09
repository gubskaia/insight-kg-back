package kg.iuca.InsightKgBackendApplication.controllers;

import kg.iuca.InsightKgBackendApplication.entities.Initiative;
import kg.iuca.InsightKgBackendApplication.services.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/initiatives")
public class InitiativeController {

    @Autowired
    private InitiativeService initiativeService;

    @GetMapping
    public List<Initiative> getAllInitiatives() {
        return initiativeService.getAllInitiatives();
    }

    @GetMapping("/{id}")
    public Initiative getInitiativeById(@PathVariable Long id) {
        return initiativeService.getInitiativeById(id);
    }

    @PostMapping
    public Initiative createInitiative(@RequestBody Initiative initiative) {
        return initiativeService.createInitiative(initiative);
    }
}
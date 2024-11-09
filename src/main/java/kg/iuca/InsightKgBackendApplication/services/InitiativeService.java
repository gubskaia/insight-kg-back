package kg.iuca.InsightKgBackendApplication.services;

import kg.iuca.InsightKgBackendApplication.entities.Initiative;
import kg.iuca.InsightKgBackendApplication.repositories.InitiativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiativeService {

    @Autowired
    private InitiativeRepository initiativeRepository;

    public Page<Initiative> getAllInitiatives(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size).withSort(org.springframework.data.domain.Sort.by(sortBy));
        return initiativeRepository.findAll(pageable);
    }

    public Initiative getInitiativeById(Long id) {
        return initiativeRepository.findById(id).orElse(null);
    }

    public Initiative createInitiative(Initiative initiative) {
        return initiativeRepository.save(initiative);
    }

    public Initiative updateInitiative(Long id, Initiative initiativeDetails) {
        Initiative initiative = initiativeRepository.findById(id).orElseThrow(() -> new RuntimeException("Initiative not found"));
        initiative.setTitle(initiativeDetails.getTitle());
        initiative.setDescription(initiativeDetails.getDescription());
        initiative.setDeadline(initiativeDetails.getDeadline());
        initiative.setAmount(initiativeDetails.getAmount());
        initiative.setStatus(initiativeDetails.getStatus());
        return initiativeRepository.save(initiative);
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById(id);
    }
}

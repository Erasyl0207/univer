package kz.kaz.univer.service.impl;

import kz.kaz.univer.entity.Degree;
import kz.kaz.univer.repository.DegreeRepository;
import kz.kaz.univer.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;

    @Override
    public Degree save(Degree degree) {
        return degreeRepository.save(degree);
    }

    @Override
    public Degree findById(Long id) {
        return degreeRepository.findById(id).orElseThrow(() -> new RuntimeException("Degree not found"));
    }

    @Override
    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        degreeRepository.deleteById(id);
    }
}

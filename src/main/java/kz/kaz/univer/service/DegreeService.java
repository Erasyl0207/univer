package kz.kaz.univer.service;

import kz.kaz.univer.entity.Degree;

import java.util.List;

public interface DegreeService {
    Degree save(Degree degree);
    Degree findById(Long id);
    List<Degree> findAll();
    void deleteById(Long id);
}

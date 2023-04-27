package kz.kaz.univer.controller;

import kz.kaz.univer.entity.Degree;
import kz.kaz.univer.service.DegreeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degrees")
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService degreeService;

    @PostMapping
    public ResponseEntity<Degree> createDegree(@RequestBody Degree degree) {
        return ResponseEntity.ok(degreeService.save(degree));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable Long id) {
        return ResponseEntity.ok(degreeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Degree>> getAllDegrees() {
        return ResponseEntity.ok(degreeService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deleteDegreeById(@PathVariable Long id) {
        degreeService.deleteById(id);
    }
}

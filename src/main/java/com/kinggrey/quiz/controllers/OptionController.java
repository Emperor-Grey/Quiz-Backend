package com.kinggrey.quiz.controllers;

import com.kinggrey.quiz.models.Option;
import com.kinggrey.quiz.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long id) {
        Option option = optionService.getOptionById(id);
        if (option != null) {
            return ResponseEntity.ok(option);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.createOption(option);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id, @RequestBody Option optionDetails) {
        Option updatedOption = optionService.updateOption(id, optionDetails);
        if (updatedOption != null) {
            return ResponseEntity.ok(updatedOption);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
}

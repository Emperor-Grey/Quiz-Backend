package com.kinggrey.quiz.services;

import com.kinggrey.quiz.models.Option;
import com.kinggrey.quiz.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OptionService
 */

@Service
public class OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }

    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    public Option updateOption(Long id, Option optionDetails) {
        Option option = optionRepository.findById(id).orElse(null);
        if (option != null) {
            option.setOptionText(optionDetails.getOptionText());
            option.setCorrect(optionDetails.isCorrect());
            option.setQuestion(optionDetails.getQuestion());
            return optionRepository.save(option);
        }
        return null;
    }

    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }

}

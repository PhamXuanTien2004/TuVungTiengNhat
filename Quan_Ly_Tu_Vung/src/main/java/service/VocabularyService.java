package service;

import entity.Vocabulary;
import repository.VocabularyRepository;

import java.util.List;

public class VocabularyService implements IVocabularyService{
    VocabularyRepository vocabularyRepository = new VocabularyRepository();
    @Override
    public List<Vocabulary> getAllVocabulary() {
        return vocabularyRepository.getAllVocabulary();
    }

    @Override
    public boolean createVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.createVocabulary(vocabulary);
    }
}

package controller;

import entity.Vocabulary;
import service.VocabularyService;

import java.util.List;

public class VocabularyController {
    private VocabularyService vocabularyService = new VocabularyService();
    public List<Vocabulary> getAllVocabulary(){
        return vocabularyService.getAllVocabulary();
    }
    public boolean createVocabulary(Vocabulary vocabulary){
        return vocabularyService.createVocabulary(vocabulary);
    }
}

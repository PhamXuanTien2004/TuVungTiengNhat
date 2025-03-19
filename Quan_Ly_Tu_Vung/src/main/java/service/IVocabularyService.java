package service;

import entity.Vocabulary;

import java.util.List;

public interface IVocabularyService {
    List<Vocabulary> getAllVocabulary();
    boolean createVocabulary (Vocabulary vocabulary);
}

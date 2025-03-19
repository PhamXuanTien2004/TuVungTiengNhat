package repository;

import entity.Vocabulary;

import java.util.List;

public interface IVocabularyRepository {
    List<Vocabulary> getAllVocabulary();
    boolean createVocabulary(Vocabulary vocabulary);
}

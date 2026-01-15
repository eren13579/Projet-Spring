package teda.patrick.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teda.patrick.sa.entity.Sentiment;
import teda.patrick.sa.enums.TypeSentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}

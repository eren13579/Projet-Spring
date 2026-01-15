package teda.patrick.sa.services;

import org.springframework.stereotype.Service;
import teda.patrick.sa.entity.*;
import teda.patrick.sa.enums.TypeSentiment;
import teda.patrick.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {
    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        sentiment.setType(TypeSentiment.POSITIF);
        if (sentiment.getText().contains("pas")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}

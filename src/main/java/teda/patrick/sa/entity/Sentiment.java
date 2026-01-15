package teda.patrick.sa.entity;

import jakarta.persistence.*;
import teda.patrick.sa.enums.TypeSentiment;
import teda.patrick.sa.entity.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "Sentiment")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private TypeSentiment type;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String text, TypeSentiment type, Client client) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public teda.patrick.sa.entity.Client getClient() {
        return client;
    }

    public void setClient(teda.patrick.sa.entity.Client client) {
        this.client = client;
    }
}

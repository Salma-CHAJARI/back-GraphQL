package com.example.JPA.banque_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
public class TransactionInput {
    private double montant;
    private String date;
    private String type;
    private Long compteId;

}
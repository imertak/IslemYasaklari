package com.pokemonrewiev.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class PayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pay;
    private String payKodu;

    @OneToMany(targetEntity = IslemYasaklari.class, mappedBy = "payEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IslemYasaklari> islemYasaklariList = new ArrayList<>();

}


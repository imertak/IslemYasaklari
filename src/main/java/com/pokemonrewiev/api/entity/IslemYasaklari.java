package com.pokemonrewiev.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IslemYasaklari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String unvan;
    private String mkkSicilNo;
    private String pay;
    private String payKodu;
    private String kurulKararTarihi;
    private String kurulKararNo;
}

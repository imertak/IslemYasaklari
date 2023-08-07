package com.pokemonrewiev.api.dto;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class IslemYasaklariDto {
    private String unvan;
    private String mkkSicilNo;
    private String pay;
    private String payKodu;
    private String kurulKararTarihi;
    private String kurulKararNo;
}

package com.pokemonrewiev.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.mapper.IslemYasaklariMapper;
import com.pokemonrewiev.api.repository.IslemYasaklariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class IslemYasaklariService {
    IslemYasaklariRepository islemYasaklariRepository;
    IslemYasaklariMapper islemYasaklariMapper;
    

    @Autowired
    public IslemYasaklariService(IslemYasaklariRepository islemYasaklariRepository, IslemYasaklariMapper islemYasaklariMapper) {
        this.islemYasaklariRepository = islemYasaklariRepository;
        this.islemYasaklariMapper = islemYasaklariMapper;
    }

    
    
    public List<IslemYasaklari> createIslemYasaklari(List<IslemYasaklari> yasaklar){
        return islemYasaklariRepository.saveAll(yasaklar);
    }

    public List<IslemYasaklariDto> getIslemYasaklari(){
        List<IslemYasaklari> islemYasaklariList = islemYasaklariRepository.findAll();
        return islemYasaklariList.stream().map(y -> islemYasaklariMapper.maptoDto(y)).collect(Collectors.toList());
    }

    public IslemYasaklari saveIslemYasaklari(IslemYasaklari islemYasaklari) {
        return islemYasaklariRepository.save(islemYasaklari);
    }

    public void updateIslemYasaklari(String unvan ,int id){
        IslemYasaklari islemYasaklari = islemYasaklariRepository.getById(id);
        islemYasaklari.setUnvan(unvan);
        islemYasaklariRepository.save(islemYasaklari);
    }

    public void deleteIslemYasaklari(String onay, int id){
        //Postman'den "onay" text'i gelmeden silmez
        if(onay.equals("onay")){
            IslemYasaklari islemYasaklari = islemYasaklariRepository.getById(id);
            islemYasaklariRepository.delete(islemYasaklari);
        }
    }

    public IslemYasaklariDto getDetail(int id){
        IslemYasaklari islemYasaklari = islemYasaklariRepository.getById(id);
        IslemYasaklariDto islemYasaklariDto = new IslemYasaklariDto();
        islemYasaklariDto=islemYasaklariMapper.maptoDto(islemYasaklari);
        return islemYasaklariDto;
    }

}

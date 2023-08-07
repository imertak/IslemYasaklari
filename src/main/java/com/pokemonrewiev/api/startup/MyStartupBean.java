package com.pokemonrewiev.api.startup;

import com.pokemonrewiev.api.client.IslemYasaklariClient;
import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.mapper.IslemYasaklariMapper;
import com.pokemonrewiev.api.repository.IslemYasaklariRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyStartupBean {
    IslemYasaklariRepository islemYasaklariRepository;
    IslemYasaklariClient islemYasaklariClient;
    IslemYasaklariMapper islemYasaklariMapper;

    @Autowired
    public MyStartupBean(IslemYasaklariRepository islemYasaklariRepository, IslemYasaklariClient islemYasaklariClient, IslemYasaklariMapper islemYasaklariMapper) {
        this.islemYasaklariRepository = islemYasaklariRepository;
        this.islemYasaklariClient = islemYasaklariClient;
        this.islemYasaklariMapper = islemYasaklariMapper;
    }

    @PostConstruct
    public void createIslemYasaklari(){
        List<IslemYasaklariDto> islemYasaklariDtoList = islemYasaklariClient.getWebIslemYasaklari();
        List<IslemYasaklari> islemYasaklariList;
        islemYasaklariList = islemYasaklariDtoList.stream().map(y -> islemYasaklariMapper.mapToEntity(y)).collect(Collectors.toList());
        islemYasaklariRepository.saveAll(islemYasaklariList);
    }
}

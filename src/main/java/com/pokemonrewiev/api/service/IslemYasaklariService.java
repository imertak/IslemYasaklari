package com.pokemonrewiev.api.service;

import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.mapper.IslemYasaklariMapper;
import com.pokemonrewiev.api.repository.IslemYasaklariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

}

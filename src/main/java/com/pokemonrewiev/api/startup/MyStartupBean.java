package com.pokemonrewiev.api.startup;

import com.pokemonrewiev.api.client.IslemYasaklariClient;
import com.pokemonrewiev.api.client.PayClient;
import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.dto.PayDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.entity.PayEntity;
import com.pokemonrewiev.api.mapper.IslemYasaklariMapper;
import com.pokemonrewiev.api.mapper.PayMapper;
import com.pokemonrewiev.api.repository.IslemYasaklariRepository;
import com.pokemonrewiev.api.repository.PayRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyStartupBean {
    @Autowired
    IslemYasaklariRepository islemYasaklariRepository;
    @Autowired
    IslemYasaklariClient islemYasaklariClient;
    @Autowired
    IslemYasaklariMapper islemYasaklariMapper;
    @Autowired
    PayClient payClient;
    @Autowired
    PayMapper payMapper;
    @Autowired
    PayRepository payRepository;


    @PostConstruct
    public void createIslemYasaklari(){
        List<PayDto> payDtoList = payClient.getWebPay();
        List<PayEntity> payList;
        payList = payDtoList.stream().map(payDto -> payMapper.mapToEntity(payDto)).collect(Collectors.toList());

        for(PayEntity payEntity: payList){
            List<PayEntity> newPay = payRepository.findListByPayKodu(payEntity.getPayKodu());
            if(newPay.isEmpty()){
                payRepository.save(payEntity);
            }
        }


        List<IslemYasaklariDto> islemYasaklariDtoList = islemYasaklariClient.getWebIslemYasaklari();
        List<IslemYasaklari> islemYasaklariList;
        islemYasaklariList = islemYasaklariDtoList.stream().map(y -> islemYasaklariMapper.mapToEntity(y)).collect(Collectors.toList());


        for (IslemYasaklari islemYasaklari: islemYasaklariList) {
            PayEntity payEntity = payRepository.findByPayKodu(islemYasaklari.getPayKodu());
            islemYasaklari.setPayEntity(payEntity);

        }

        islemYasaklariRepository.saveAll(islemYasaklariList);

    }

}

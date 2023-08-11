package com.pokemonrewiev.api.mapper;

import com.pokemonrewiev.api.dto.PayDto;
import com.pokemonrewiev.api.entity.PayEntity;
import org.springframework.stereotype.Component;

@Component
public class PayMapper {

    public PayDto mapToDto(PayEntity pay){
        PayDto payDto = new PayDto();
        payDto.setPayKodu(pay.getPayKodu());
        payDto.setPay(pay.getPay());
        return payDto;
    }

    public PayEntity mapToEntity(PayDto payDto){
        PayEntity pay = new PayEntity();
        pay.setPay(payDto.getPay());
        pay.setPayKodu(payDto.getPayKodu());
        return pay;
    }
}

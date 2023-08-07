package com.pokemonrewiev.api.mapper;

import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import org.springframework.stereotype.Component;

@Component
public class IslemYasaklariMapper {


    public IslemYasaklariDto maptoDto(IslemYasaklari islemYasaklari){
        IslemYasaklariDto islemYasaklariDto = new IslemYasaklariDto();
        islemYasaklariDto.setUnvan(islemYasaklari.getUnvan());
        islemYasaklariDto.setMkkSicilNo(islemYasaklari.getMkkSicilNo());
        islemYasaklariDto.setPay(islemYasaklari.getPay());
        islemYasaklariDto.setPayKodu(islemYasaklari.getPayKodu());
        islemYasaklariDto.setKurulKararTarihi(islemYasaklari.getKurulKararTarihi());
        islemYasaklariDto.setKurulKararNo(islemYasaklari.getKurulKararNo());
        return islemYasaklariDto;
    }

    public IslemYasaklari mapToEntity(IslemYasaklariDto islemYasaklariDto){
        IslemYasaklari islemYasaklari = new IslemYasaklari();
        islemYasaklari.setUnvan(islemYasaklariDto.getUnvan());
        islemYasaklari.setMkkSicilNo(islemYasaklariDto.getMkkSicilNo());
        islemYasaklari.setPay(islemYasaklariDto.getPay());
        islemYasaklari.setPayKodu(islemYasaklariDto.getPayKodu());
        islemYasaklari.setKurulKararTarihi(islemYasaklariDto.getKurulKararTarihi());
        islemYasaklari.setKurulKararNo(islemYasaklariDto.getKurulKararNo());
        return islemYasaklari;
    }
}

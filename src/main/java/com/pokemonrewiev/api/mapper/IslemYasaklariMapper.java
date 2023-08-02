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
        islemYasaklari.setUnvan(islemYasaklari.getUnvan());
        islemYasaklari.setMkkSicilNo(islemYasaklari.getMkkSicilNo());
        islemYasaklari.setPay(islemYasaklari.getPay());
        islemYasaklari.setPayKodu(islemYasaklari.getPayKodu());
        islemYasaklari.setKurulKararTarihi(islemYasaklari.getKurulKararTarihi());
        islemYasaklari.setKurulKararNo(islemYasaklari.getKurulKararNo());
        return islemYasaklari;
    }
}

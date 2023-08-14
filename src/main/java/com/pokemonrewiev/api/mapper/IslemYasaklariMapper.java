package com.pokemonrewiev.api.mapper;

import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper
public interface IslemYasaklariMapper {

    IslemYasaklariMapper INSTANCE = Mappers.getMapper(IslemYasaklariMapper.class);

    @Mapping(source = "unvan", target = "unvan")
    @Mapping(source = "mkkSicilNo", target = "mkkSicilNo")
    @Mapping(source = "payKodu", target = "payKodu")
    @Mapping(source = "kurulKararTarihi", target = "kurulKararTarihi")
    @Mapping(source = "kurulKararNo", target = "kurulKararNo")
    IslemYasaklariDto mapToDto(IslemYasaklari islemYasaklari);

    @Mapping(source = "unvan", target = "unvan")
    @Mapping(source = "mkkSicilNo", target = "mkkSicilNo")
    @Mapping(source = "payKodu", target = "payKodu")
    @Mapping(source = "kurulKararTarihi", target = "kurulKararTarihi")
    @Mapping(source = "kurulKararNo", target = "kurulKararNo")
    IslemYasaklari mapToEntity(IslemYasaklariDto islemYasaklariDto);


    /*public IslemYasaklariDto maptoDto(IslemYasaklari islemYasaklari){
        IslemYasaklariDto islemYasaklariDto = new IslemYasaklariDto();
        islemYasaklariDto.setUnvan(islemYasaklari.getUnvan());
        islemYasaklariDto.setMkkSicilNo(islemYasaklari.getMkkSicilNo());
        islemYasaklariDto.setPayKodu(islemYasaklari.getPayKodu());
        islemYasaklariDto.setKurulKararTarihi(islemYasaklari.getKurulKararTarihi());
        islemYasaklariDto.setKurulKararNo(islemYasaklari.getKurulKararNo());
        return islemYasaklariDto;
    }

    public IslemYasaklari mapToEntity(IslemYasaklariDto islemYasaklariDto){
        IslemYasaklari islemYasaklari = new IslemYasaklari();
        islemYasaklari.setUnvan(islemYasaklariDto.getUnvan());
        islemYasaklari.setMkkSicilNo(islemYasaklariDto.getMkkSicilNo());
        islemYasaklari.setPayKodu(islemYasaklariDto.getPayKodu());
        islemYasaklari.setKurulKararTarihi(islemYasaklariDto.getKurulKararTarihi());
        islemYasaklari.setKurulKararNo(islemYasaklariDto.getKurulKararNo());
        return islemYasaklari;
    }*/
}

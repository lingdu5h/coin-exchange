package com.lingdu.mappers;

import com.lingdu.domain.Market;
import com.lingdu.dto.MarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarketDtoMappers {

    MarketDtoMappers INSTANCE = Mappers.getMapper(MarketDtoMappers.class) ;

    Market toConvertEntity(MarketDto source) ;


    MarketDto toConvertDto(Market source) ;


    List<Market> toConvertEntity(List<MarketDto> source) ;


    List<MarketDto> toConvertDto(List<Market> source) ;
}

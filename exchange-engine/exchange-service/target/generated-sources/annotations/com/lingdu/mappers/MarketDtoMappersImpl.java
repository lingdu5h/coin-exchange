package com.lingdu.mappers;

import com.lingdu.domain.Market;
import com.lingdu.dto.MarketDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-31T14:25:51+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class MarketDtoMappersImpl implements MarketDtoMappers {

    @Override
    public Market toConvertEntity(MarketDto source) {
        if ( source == null ) {
            return null;
        }

        Market market = new Market();

        market.setId( source.getId() );
        market.setType( source.getType() );
        market.setTradeAreaId( source.getTradeAreaId() );
        market.setSellCoinId( source.getSellCoinId() );
        market.setBuyCoinId( source.getBuyCoinId() );
        market.setSymbol( source.getSymbol() );
        market.setName( source.getName() );
        market.setTitle( source.getTitle() );
        market.setImg( source.getImg() );
        market.setOpenPrice( source.getOpenPrice() );
        market.setFeeBuy( source.getFeeBuy() );
        market.setFeeSell( source.getFeeSell() );
        market.setMarginRate( source.getMarginRate() );
        market.setNumMin( source.getNumMin() );
        market.setNumMax( source.getNumMax() );
        market.setTradeMin( source.getTradeMin() );
        market.setTradeMax( source.getTradeMax() );
        market.setPriceScale( source.getPriceScale() );
        market.setNumScale( source.getNumScale() );
        market.setContractUnit( source.getContractUnit() );
        market.setPointValue( source.getPointValue() );
        market.setMergeDepth( source.getMergeDepth() );
        market.setTradeTime( source.getTradeTime() );
        market.setTradeWeek( source.getTradeWeek() );
        market.setSort( source.getSort() );
        market.setStatus( source.getStatus() );

        return market;
    }

    @Override
    public MarketDto toConvertDto(Market source) {
        if ( source == null ) {
            return null;
        }

        MarketDto marketDto = new MarketDto();

        marketDto.setId( source.getId() );
        marketDto.setType( source.getType() );
        marketDto.setTradeAreaId( source.getTradeAreaId() );
        marketDto.setSellCoinId( source.getSellCoinId() );
        marketDto.setBuyCoinId( source.getBuyCoinId() );
        marketDto.setSymbol( source.getSymbol() );
        marketDto.setName( source.getName() );
        marketDto.setTitle( source.getTitle() );
        marketDto.setImg( source.getImg() );
        marketDto.setOpenPrice( source.getOpenPrice() );
        marketDto.setFeeBuy( source.getFeeBuy() );
        marketDto.setFeeSell( source.getFeeSell() );
        marketDto.setMarginRate( source.getMarginRate() );
        marketDto.setNumMin( source.getNumMin() );
        marketDto.setNumMax( source.getNumMax() );
        marketDto.setTradeMin( source.getTradeMin() );
        marketDto.setTradeMax( source.getTradeMax() );
        marketDto.setPriceScale( source.getPriceScale() );
        marketDto.setNumScale( source.getNumScale() );
        marketDto.setContractUnit( source.getContractUnit() );
        marketDto.setPointValue( source.getPointValue() );
        marketDto.setMergeDepth( source.getMergeDepth() );
        marketDto.setTradeTime( source.getTradeTime() );
        marketDto.setTradeWeek( source.getTradeWeek() );
        marketDto.setSort( source.getSort() );
        marketDto.setStatus( source.getStatus() );

        return marketDto;
    }

    @Override
    public List<Market> toConvertEntity(List<MarketDto> source) {
        if ( source == null ) {
            return null;
        }

        List<Market> list = new ArrayList<Market>( source.size() );
        for ( MarketDto marketDto : source ) {
            list.add( toConvertEntity( marketDto ) );
        }

        return list;
    }

    @Override
    public List<MarketDto> toConvertDto(List<Market> source) {
        if ( source == null ) {
            return null;
        }

        List<MarketDto> list = new ArrayList<MarketDto>( source.size() );
        for ( Market market : source ) {
            list.add( toConvertDto( market ) );
        }

        return list;
    }
}

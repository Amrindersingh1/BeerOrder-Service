package com.amrindersingh.beer.order.service.web.mappers;

import com.amrindersingh.beer.order.service.domain.BeerOrderLine;
import com.brewery.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}

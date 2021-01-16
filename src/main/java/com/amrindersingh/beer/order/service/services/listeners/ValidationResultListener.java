package com.amrindersingh.beer.order.service.services.listeners;

import com.amrindersingh.beer.order.service.config.JmsConfig;
import com.amrindersingh.beer.order.service.services.beer.BeerOrderManager;
import com.brewery.events.ValidateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class ValidationResultListener {

    private final BeerOrderManager beerOrderManager;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE)
    public void listen(ValidateOrderResult result){
        final UUID beerOrderId = result.getOrderId();

        log.debug("Validation Result for Order Id: " + beerOrderId);
        beerOrderManager.processValidationResult(beerOrderId, result.getIsValid());

    }
}
package com.amitgoswami.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url= "localhost:9000")
//@FeignClient(name="currency-exchange-service")

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{

    @GetMapping("/currency-exchange-service/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("From") String from,
                                                        @PathVariable("to") String to);

}

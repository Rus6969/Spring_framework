package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpertPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetTX implements Carpet {
    private static final Map<City, BigDecimal> sqPriceForCity = new HashMap<>();


    static {
        sqPriceForCity.put(City.AUSTIN, new BigDecimal("3.3"));
        sqPriceForCity.put(City.DALLAS, new BigDecimal("4.5"));
        sqPriceForCity.put(City.SAN_ANTONIO, new BigDecimal("4.75"));
    }


    @Override
    public BigDecimal sqfFtPrice(City city) {

        BigDecimal defaultVlaue = BigDecimal.ZERO;

        Optional<Map.Entry<City, BigDecimal>> collect = sqPriceForCity.entrySet().stream().filter(x -> x.getKey() == city).findFirst();

        return collect.isPresent() ? collect.get().getValue() : defaultVlaue;
    }
}

package com.cybertek.interfaces.carpertPrices;

import com.cybertek.enums.City;

import java.math.BigDecimal;

public interface Carpet {
    BigDecimal sqfFtPrice(City city);
}

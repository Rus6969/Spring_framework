package com.cybertek.services;

import com.cybertek.interfaces.Extrasessions;
import org.springframework.stereotype.Component;

@Component
public class OfficeHourse implements Extrasessions {
    @Override
    public int getHours() {
        return 6;
    }
}

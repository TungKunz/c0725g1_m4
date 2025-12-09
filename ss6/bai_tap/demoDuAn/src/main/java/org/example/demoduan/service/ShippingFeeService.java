package org.example.demoduan.service;

import org.springframework.stereotype.Service;

@Service
public class ShippingFeeService implements IShippingFeeService{

    public int calculateFee(double distanceKm) {
        int base = 15000;

        if (distanceKm <= 3) {
            return base;
        }

        double extraKm = distanceKm - 3;
        int extra = (int)(extraKm * 3000);

        int total = base + extra;
        return Math.min(total, 50000);
    }
}


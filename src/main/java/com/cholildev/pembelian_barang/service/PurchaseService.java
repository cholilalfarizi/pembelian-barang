package com.cholildev.pembelian_barang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cholildev.pembelian_barang.dto.PurchaseResponseDTO;
import com.cholildev.pembelian_barang.model.Product;

@Service
public class PurchaseService {

    private List<Product> availableProducts = new ArrayList<>();

    public PurchaseService() {
        availableProducts.add(new Product("Mouse", 12000));
        availableProducts.add(new Product("Mouse", 20000));
        availableProducts.add(new Product("Mouse", 35000));
        availableProducts.add(new Product("Keyboard", 38000));
        availableProducts.add(new Product("Keyboard", 50000));
        availableProducts.add(new Product("Keyboard", 55000));
    }

    public PurchaseResponseDTO purchaseItems(int availableMoney) {
        List<Product> bestCombination = new ArrayList<>();
        int bestSpent = 0;

        for (int i = 0; i < (1 << availableProducts.size()); i++) {
            List<Product> currentCombination = new ArrayList<>();
            int currentSpent = 0;

            for (int j = 0; j < availableProducts.size(); j++) {
                if ((i & (1 << j)) > 0) {
                    Product product = availableProducts.get(j);
                    if (currentSpent + product.getPrice() <= availableMoney) {
                        currentCombination.add(product);
                        currentSpent += product.getPrice();
                    }
                }
            }

            if (currentSpent > bestSpent && currentSpent <= availableMoney) {
                bestCombination = currentCombination;
                bestSpent = currentSpent;
            }
        }

        int remainingMoney = availableMoney - bestSpent;

        return new PurchaseResponseDTO(bestCombination, bestSpent, remainingMoney);
    }
}

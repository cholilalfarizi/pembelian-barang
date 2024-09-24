package com.cholildev.pembelian_barang.dto;

import java.util.List;

import com.cholildev.pembelian_barang.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResponseDTO {
    private List<Product> purchasedProducts;
    private Integer totalSpent;
    private Integer remainingMoney;

}

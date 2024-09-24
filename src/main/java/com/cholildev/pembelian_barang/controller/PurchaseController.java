package com.cholildev.pembelian_barang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cholildev.pembelian_barang.dto.PurchaseResponseDTO;
import com.cholildev.pembelian_barang.service.PurchaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> purchaseItems(@RequestParam("money") int money) {
        PurchaseResponseDTO response = purchaseService.purchaseItems(money);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.coder.house.ventas.online.ventasonline.exception;

public class NoStockException extends RuntimeException {
    public NoStockException(String message) {
        super(message);
    }
}
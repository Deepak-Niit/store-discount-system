package com.store.exception;

public class PriceException extends RuntimeException {

    /**
     * Price Exception if price <=0
     */
    private static final long serialVersionUID = 102154;

    public PriceException(String msg) {
	super(msg);
    }

}

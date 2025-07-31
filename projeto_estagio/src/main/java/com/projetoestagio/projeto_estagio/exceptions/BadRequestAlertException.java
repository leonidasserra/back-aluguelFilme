package com.projetoestagio.projeto_estagio.exceptions;

public class BadRequestAlertException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String entityName;
    private final String errorKey;

    public BadRequestAlertException(String message, String entityName, String errorKey) {
        super(message);
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }
}
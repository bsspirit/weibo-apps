package org.conan.fans.exception;


abstract public class BizException extends Exception {

    private static final long serialVersionUID = 3781796963379814647L;

    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String NOT_MATCH = "NOT_MATCH";
    public static final String CANT_INSERT = "CANT_INSERT";
    public static final String CANT_UPDATE = "CANT_UPDATE";
    public static final String INVALID_INPUT = "INVALID_INPUT";
    public static final String INVALID_DOCUMENT = "INVALID_DOCUMENT";
    public static final String INVALID_TEMPLATE = "INVALID_TEMPLATE";

    protected ErrorMessage errorMessage;

    public BizException() {
        super();
    }

    public BizException(ErrorMessage em) {
        this.errorMessage = em;
    }

    /**
     * Class name
     */
    abstract protected String getName();

}

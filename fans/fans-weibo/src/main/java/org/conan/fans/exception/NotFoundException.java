package org.conan.fans.exception;


public class NotFoundException extends BizException {

    private static final long serialVersionUID = -8811686633880694661L;

    public NotFoundException() {}

    public NotFoundException(ErrorMessage em) {
        this.errorMessage = em;
        em.setException(getName());
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    @Override
    protected String getName() {
        return "NotFoundException";
    }

}

package org.conan.fans.exception;

/**
 * Service Exception for Input Validation
 * 
 * @author conan
 * 
 */
public class ValidateException extends BizException {
    
    private static final long serialVersionUID = -8811686633880694661L;
    
    public ValidateException() {
        super();
    }
    
    public ValidateException(ErrorMessage em) {
        this.errorMessage = em;
        em.setException(getName());
    }
    
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    protected String getName() {
        return "ValidateException";
    }
    
}

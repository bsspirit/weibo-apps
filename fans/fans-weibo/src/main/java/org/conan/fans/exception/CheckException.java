package org.conan.fans.exception;


/**
 * Service Exception for Checking
 * 
 * @author conan
 * 
 */
public class CheckException extends BizException {
    
    private static final long serialVersionUID = -8818986633880694661L;
    
    public CheckException(ErrorMessage em) {
        this.errorMessage = em;
        em.setException(getName());
    }
    
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    protected String getName() {
        return "CheckException";
    }
    
}

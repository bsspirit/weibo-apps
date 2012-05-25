package org.conan.fans.exception;


public class ServerException extends BizException {
    
    private static final long serialVersionUID = -8811686633880694661L;
    
    public ServerException(ErrorMessage em) {
        this.errorMessage = em;
        em.setException(getName());
    }
    
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    protected String getName() {
        return "ServerException";
    }
    
}

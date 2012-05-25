package org.conan.fans.exception;

import java.util.ArrayList;
import java.util.List;

import org.conan.base.BaseObject;

/**
 * Return the Error Message to Client(JSON) ;
 * 
 * { "exception": "ValidationException", "errors": [ { "detail": "Issue", "field": "title", "code": "missing_field" } ]
 * }
 * 
 * @author conan
 * 
 */
public class ErrorMessage extends BaseObject {
    private static final long serialVersionUID = 9166118856143184998L;
    
    private String exception;
    private List<Error> errors = new ArrayList<Error>();
    
    public ErrorMessage() {
    }
    
    public ErrorMessage(Error error) {
        this.errors.add(error);
    }
    
    public ErrorMessage(String code, String field) {
        this(code, field, null);
    }
    
    public ErrorMessage(String code, String field, String detail) {
        this.errors.add(this.new Error(code, field, detail));
    }
    
    public ErrorMessage(List<ErrorMessage.Error> errors) {
        this.errors.addAll(errors);
    }
    
    public String getException() {
        return exception;
    }
    
    public void setException(String exception) {
        this.exception = exception;
    }
    
    public List<Error> getErrors() {
        return errors;
    }
    
    public class Error extends BaseObject {
        private static final long serialVersionUID = 8026725060287622079L;
        
        public Error() {
        }
        
        public Error(String code, String field) {
            this(code, field, null);
        }
        
        public Error(String code, String field, String detail) {
            super();
            this.detail = detail;
            this.field = field;
            this.code = code;
        }
        
        private String detail;
        private String field;
        private String code;
        
        public String getDetail() {
            return detail;
        }
        
        public void setDetail(String detail) {
            this.detail = detail;
        }
        
        public String getField() {
            return field;
        }
        
        public void setField(String field) {
            this.field = field;
        }
        
        public String getCode() {
            return code;
        }
        
        public void setCode(String code) {
            this.code = code;
        }
        
    }
    
}

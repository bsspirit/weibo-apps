package org.conan.fans.web;

abstract public class WebController {
    
    // @ExceptionHandler(BindException.class)
    // public ResponseEntity<ErrorMessage> handleBindException(BindException error) {
    // BindingResult result = error.getBindingResult();
    // ErrorMessage em = new ErrorMessage();
    // for (FieldError e : result.getFieldErrors()) {
    // em.getErrors().add(em.new Error(e.getCode(), e.getField()));
    // }
    // return new ResponseEntity<ErrorMessage>(new ValidateException(em).getErrorMessage(),
    // HttpStatus.UNPROCESSABLE_ENTITY);
    // }
    
}

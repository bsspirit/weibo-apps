package org.conan.fans.weibo.web.form;

public class SocialNodeForm extends RestForm {
    
    private static final long serialVersionUID = -722199959999238694L;
    
    private int apply;// 是否申请0，未申请，1:已申请
    private int status;// 0:未生成,1:已生成，未过期,2:已生成，已过期
    
    public int getApply() {
        return apply;
    }
    
    public void setApply(int apply) {
        this.apply = apply;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
}

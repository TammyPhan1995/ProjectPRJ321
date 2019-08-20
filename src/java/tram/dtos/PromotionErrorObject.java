/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.dtos;

import java.io.Serializable;

/**
 *
 * @author Tammy Phan
 */
public class PromotionErrorObject implements Serializable{
    private String codeError, contentError;

    public PromotionErrorObject() {
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public String getContentError() {
        return contentError;
    }

    public void setContentError(String contentError) {
        this.contentError = contentError;
    }
    
}

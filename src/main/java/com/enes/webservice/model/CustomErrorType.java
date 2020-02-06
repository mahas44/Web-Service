package com.enes.webservice.model;

import com.enes.webservice.IResponsableObject;

public class CustomErrorType implements IResponsableObject {

    private boolean status;
    private String errorMessage;

    public CustomErrorType(boolean status,String errorMessage){
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean getStatus(){
        return status;
    }

}

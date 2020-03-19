package com.easytest.rest.response;

import com.easytest.Exception.EasyException;

import java.util.ArrayList;
import java.util.List;

public class ProjectSaveResponse {

    private EasyException.Code code;


    public EasyException.Code getCode() {
        return code;
    }

    public void setCode(EasyException.Code code) {
        this.code = code;
    }
}

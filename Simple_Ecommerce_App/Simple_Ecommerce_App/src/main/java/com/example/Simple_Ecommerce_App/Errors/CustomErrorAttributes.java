package com.example.Simple_Ecommerce_App.Errors;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String,Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("success",Boolean.FALSE);
        errorAttributes.put("status",errorAttributes.get("error"));
        errorAttributes.remove("error");
        return errorAttributes;

    }

}

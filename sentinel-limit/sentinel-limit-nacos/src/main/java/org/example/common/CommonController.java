package org.example.common;

import java.util.UUID;

public class CommonController {
    public String getTenantId(){
        return  "tenantId:"+ UUID.randomUUID().toString();
    }
}

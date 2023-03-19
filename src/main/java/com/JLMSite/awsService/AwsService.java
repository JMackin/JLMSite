package com.JLMSite.awsService;

import software.amazon.awssdk.core.SdkClient;

public interface AwsService<T extends SdkClient>{

    T getClient();

    void setClient(T client);

    String getSname();

    void setSname(String sname);

    String getIid();

    void setIid(String iid);

    T buildClient();
}

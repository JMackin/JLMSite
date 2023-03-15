package com.JLMthingsNstuff.JLMSite.awsService.ec2;
import com.JLMthingsNstuff.JLMSite.awsService.AwsService;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;


public class Ec2 implements AwsService<Ec2Client> {

    private String sname;
    private String iid;
    private String amzmi;
    private Ec2Client client;

    public Ec2()
    {
        this.client = buildClient();
    }

    public Ec2(String sname, String iid)
    {
        this.sname = sname;
        this.iid = iid;
        this.client = buildClient();

    }

    public Ec2(String sname, String iid, String amzmi)
    {
        this.sname = sname;
        this.iid = iid;
        this.amzmi = amzmi;
        this.client = client;
    }

    public Ec2Client getClient() {
        return client;
    }

    public void setClient(Ec2Client ec2client) {
        this.client = ec2client;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getAmzmi() {
        return amzmi;
    }

    public void setAmzmi(String amzmi) {
        this.amzmi = amzmi;
    }

    public Ec2Client buildClient(){

        return buildEc2Client();
    }

    private Ec2Client buildEc2Client(){

        Ec2Client ec2client = Ec2Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider( ProfileCredentialsProvider.create())
                .build();

        return ec2client;
    }
}

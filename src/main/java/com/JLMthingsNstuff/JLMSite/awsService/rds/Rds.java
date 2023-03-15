package com.JLMthingsNstuff.JLMSite.awsService.rds;
import com.JLMthingsNstuff.JLMSite.awsService.AwsService;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsClient;



public class Rds implements AwsService<RdsClient> {

    private String sname;
    private String iid;
    private String dbName;
    private RdsClient client;

    public Rds()
    {
        this.client = buildClient();
    }
    public Rds(String sname, String iid)
    {
        this.sname = sname;
        this.iid = iid;
        this.client = buildClient();
    }
    public Rds(String sname, String iid, String dbName)
    {
        this.sname = sname;
        this.iid = iid;
        this.client = buildClient();
        this.dbName = dbName;
    }

    public RdsClient getClient(){
        return this.client;
    }

    public void setClient(RdsClient client) {
        this.client = client;
    }

    public String getSname(){
        return sname;}

    public void setSname(String sname){
        this.sname = sname;
    }

    public String getIid(){
        return iid;
    }

    public void setIid(String iid){
        this.iid = iid;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public RdsClient buildClient(){

        return buildRdsClient();
    }

    private RdsClient buildRdsClient(){

        RdsClient rdsclient = RdsClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        return rdsclient;
    }
}

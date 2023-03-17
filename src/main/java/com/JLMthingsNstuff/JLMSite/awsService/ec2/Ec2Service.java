package com.JLMthingsNstuff.JLMSite.awsService.ec2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.RebootInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;

@Service
public class Ec2Service {

    @Autowired
    Ec2 ec2;

    public static void startInstance(Ec2 ec2){
        String iid = ec2.getIid();

        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(iid)
                .build();

        ec2.getClient().startInstances(request);
        System.out.printf("Successfully started instance %s", iid);
    }

    public void stopInstance(Ec2 ec2){
        String iid = ec2.getIid();

        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(iid)
                .build();

        ec2.getClient().stopInstances(request);
        System.out.printf("Successfully stopped instance %s", iid);

        ec2.getClient().close();
    }

    public void rebootInstance(Ec2 ec2){

        String iid = ec2.getIid();

        try {
            RebootInstancesRequest request = RebootInstancesRequest.builder()
                    .instanceIds(iid)
                    .build();

            ec2.getClient().rebootInstances(request);
            System.out.printf(
                    "Successfully rebooted instance %s", iid);
        } catch (Ec2Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

}

package com.JLMSite.awsService.rds;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.rds.model.StartDbInstanceRequest;
import software.amazon.awssdk.services.rds.model.StopDbInstanceRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class RdsService {

    private RdsDBInst rdbInst = new RdsDBInst("DBNAME","1");

    class RdsDBInst{

        private String dbId;
        private String dbName;

        public String getDbId() {
            return dbId;
        }

        public void setDbId(String dbId) {
            this.dbId = dbId;
        }

        public String getDbName() {
            return dbName;
        }

        public void setDbName(String dbName) {
            this.dbName = dbName;
        }

        private Connection conn;
        private Rds rds = new Rds();

        RdsDBInst(String dbName, String dbId) {
            this.dbName = dbName;
            this.dbId = dbId;
            this.conn = getDBConn();
        }

        private BufferedReader makeBR(FileReader fr){
            return new BufferedReader(fr);
        }

        private Connection getDBConn(){

            Connection c = null;

            try (FileReader endpoint = new FileReader("~/JLMSite/Conf/endpoint");
                 FileReader uname = new FileReader("~/JLMSite/Conf/uname");
                 FileReader passwd = new FileReader("~/JLMSite/Conf/passwd"))
            {
                try {
                    BufferedReader[] brList = new BufferedReader[3];
                    int x = 0;
                    for (FileReader fr : new FileReader[]{endpoint, uname, passwd}) {
                        brList[x] = makeBR(fr);
                        x++;
                    }
                    x = 0;
                    try {
                        char[][] carr = new char[100][3];
                        for (BufferedReader br : brList) {
                            br.read(carr[x]);
                        }
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager
                                .getConnection(
                                        brList[0].toString(),
                                        brList[1].toString(),
                                        brList[2].toString());
                    }catch (Exception e){
                        System.out.print(e.getClass().getName()+": "+e.getMessage());
                        System.exit(0);
                    }finally {
                        endpoint.close();
                        uname.close();
                        passwd.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }catch (Exception e){
                System.out.print(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }

            return c;
        }

        public void accessDB(Rds rds)
        {
            startInstance(rds);

        }

        public void startInstance(Rds rds){
            String iid = rds.getIid();

            StartDbInstanceRequest request = StartDbInstanceRequest.builder()
                    .dbInstanceIdentifier(iid)
                    .build();

            rds.getClient().startDBInstance(request);
            System.out.printf("Successfully started instance %s", iid);
        }

        public void stopInstance(Rds rds) {
            String iid = rds.getIid();

            StopDbInstanceRequest request = StopDbInstanceRequest.builder()
                    .dbInstanceIdentifier(iid)
                    .build();

            rds.getClient().stopDBInstance(request);
            System.out.printf("Successfully stopped DB instance %s", iid);

        }

    }

}

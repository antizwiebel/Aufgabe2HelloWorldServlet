package fh.hagenberg.PenederMauler;

import java.rmi.Naming;

/**
 * Created by Felix on 21.12.2016.
 */
public class EnvDataClientRMI {
    private IEnvironmentData envData;

    public EnvDataClientRMI(IEnvironmentData envData) {
        this.envData = envData;
    }

    public static void main (String[] _argv) {
        try {

            String adr = "EnvDataServer";
            IEnvironmentData environmentData= (IEnvironmentData) Naming.lookup(adr);

            String[] dataTypes = envData.requestEnvironmentDataTypes();
            EnvData[] allEnvData;
            System.out.println("All sensortypes: ");
            for (String type : dataTypes) {
                System.out.print(", " + type);
            }
            System.out.println();
            allEnvData = envData.requestAll();
            System.out.println("Requesting air pressure: ");
            EnvData airData = envData.requestEnvironmentData("air");

            System.out.println("TimeStamp" + airData.getTimeStamp().toString() + ", Value " + airData.getAirPressure());
            System.out.println("Requesting all data: ");

            for (EnvData e : allEnvData) {
                System.out.print("TimeStamp" + e.getTimeStamp().toString() + ", Value " + e.getAirPressure());
            }


        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }
}

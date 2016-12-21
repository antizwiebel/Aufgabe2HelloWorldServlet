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

    public IEnvironmentData getEnvData() {
        return envData;
    }

    public void setEnvData(IEnvironmentData envData) {
        this.envData = envData;
    }

    public static void main (String[] _argv) {
        try {

            String adr = "EnvDataServer";
            IEnvironmentData environmentData= (IEnvironmentData) Naming.lookup(adr);

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

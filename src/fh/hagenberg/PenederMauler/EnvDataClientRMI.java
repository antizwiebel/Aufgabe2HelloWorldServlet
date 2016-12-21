package fh.hagenberg.PenederMauler;

import java.rmi.Naming;

/**
 * Created by Felix on 21.12.2016.
 */

public class EnvDataClientRMI {

    private IEnvironmentData envData;

    public EnvDataClientRMI() {
    }

    public IEnvironmentData getEnvData() {
        return envData;
    }

    public void setEnvData(IEnvironmentData envData) {
        this.envData = envData;
    }

    public EnvData getPressure () {
        try {
            String adr = "EnvDataServer";
            envData = (IEnvironmentData) Naming.lookup(adr);
            return envData.requestEnvironmentData("air");

        } catch (Exception _e) {
            _e.printStackTrace();
            return null;
        }
    }
}

package fh.hagenberg.PenederMauler;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Felix on 07.12.2016.
 */
public interface IEnvironmentData extends Remote{
    /**
     * Liefert die Typen der zur Verfügung stehenden Umweltsensoren
     *
     * @return Ein String-Array mit den Typen der Umweltsensoren
     * @throws RemoteException Ein Fehler trat bei der Kommunikation auf
     * @see String
     * @see RemoteException
     */
    public String[] requestEnvironmentDataTypes()throws RemoteException;
    /**
     * Liefert die Messwerte für einen speziellen Sensor in Form eines * Environment Data (EnvData) Objektes zurück
     *
     * @param _type der betreffende Umweltsensor
     * @return EnvData Die aktuellen Messwerte des entsprechenden Sensors
     * null, falls der Sensor nicht existiert
     * @throws RemoteException Ein Fehler trat bei der Kommunikation auf
     * @see String
     * @see RemoteException
     */
    public EnvData requestEnvironmentData(String _type) throws RemoteException;
    /**
     * Liefert die Messwerte aller verfügbarer Sensoren zurück
     *
     * @return EnvData[] alle verfügbaren Messwerte
     * @throws RemoteException Ein Fehler trat bei der Kommunikation auf
     * @see String
     * @see RemoteException
     */
    public EnvData[] requestAll()throws RemoteException;
}

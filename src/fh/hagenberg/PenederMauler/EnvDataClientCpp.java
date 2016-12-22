package fh.hagenberg.PenederMauler;

import fh.hagenberg.PenederMauler.EnvData;
import fh.hagenberg.PenederMauler.IEnvironmentData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnvDataClientCpp implements IEnvironmentData {

    /**
     * Member variables of class JavaClient
     * mSock: Server Socket
     * mOut: OutputStream for communication with server
     * mIn: InputStream for communication with server
     * mReader: Reader to get data from server as string
     */
    public static Socket mSock;
    public static OutputStream mOut;
    public static InputStream mIn;
    public static BufferedReader mReader;


    /**
     *
     */
    @Override
    public String[] requestEnvironmentDataTypes() {
        String msg = "sensortypes#";
        StringBuilder outString = new StringBuilder();
        int i = -1;

        try {
            mOut.write(msg.getBytes());

            while (i != 0) {

                i = mReader.read();
                outString.append((char) i);
            }
        } catch (

                IOException e)

        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[]s=new String [3];
        s[0]=outString.substring(0, outString.indexOf(";"));
        s[1]=outString.substring(outString.indexOf(";")+1,
                outString.indexOf(";", outString.indexOf(";")+1));
        s[2]=outString.substring(outString.indexOf(";", outString.indexOf(";")+1)+1,
                outString.indexOf("#"));

        System.out.println(outString.toString());
        return s;

    }

    public static void main (String [] _args){
        try {
            mSock = new Socket("10.29.17.177", 4949);
            mOut = mSock.getOutputStream();
            mIn = mSock.getInputStream();
            mReader = new BufferedReader(new InputStreamReader(mIn));
        } catch(Exception _e){
            _e.printStackTrace();
        }

    }

    @Override
    public EnvData requestEnvironmentData(String _type) {
        try {
            mSock = new Socket("10.29.17.177", 4949);
            mOut = mSock.getOutputStream();
            mIn = mSock.getInputStream();
            mReader = new BufferedReader(new InputStreamReader(mIn));
        } catch (Exception e){
            return new EnvData();
        }
        String msg ="sensor;"+_type;
        StringBuilder outString=new StringBuilder();
        int i = -1;
        EnvData env = new EnvData();
        try {
            mOut.write(msg.getBytes());

            while (i != 0) {

                i = mReader.read();
                outString.append((char) i);
            }
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (_type.equals("light")){
            env.setmLight(Float.parseFloat(outString.subSequence(outString.indexOf("|")+1, outString.indexOf("#")).toString()));
        }
        else if (_type.equals("noise")) {
            env.setmSound(Float.parseFloat(outString.subSequence(outString.indexOf("|") + 1, outString.indexOf("#")).toString()));
        }
        System.out.println(outString.toString());
        return env;
    }

    @Override
    public EnvData[] requestAll() {
        String msg = "sensor;ALL#";
        StringBuilder outString = new StringBuilder();
        EnvData [] envD;
        int i = -1;
        try {
            mOut.write(msg.getBytes());

            while (i != 0) {

                i = mReader.read();
                outString.append((char) i);
            }
        } catch (IOException e)

        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(outString.toString());
        String [] sensors=outString.toString().split("\\|");
        String [] lvalues=sensors[1].split(";");
        String [] nvalues=sensors[2].split(";");
        String [] avalues=sensors[3].split(";");
        float [] airD = new float [3];
        airD[0]=Float.parseFloat(avalues[1]);
        airD[1]=Float.parseFloat(avalues[2]);
        avalues[3]=avalues[3].split("\\#")[0];
        airD[2]=Float.parseFloat(avalues[3]);
        envD=new EnvData[2];
        return envD;
    }

}

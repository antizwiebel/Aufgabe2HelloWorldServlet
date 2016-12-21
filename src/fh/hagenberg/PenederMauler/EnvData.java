package fh.hagenberg.PenederMauler;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mark on 07.12.2016.
 */
public class EnvData implements Serializable{
    private Date mTimeStamp;
    private float mAirPressure;

    public EnvData() {
    }

    public EnvData(Date mTimeStamp, float mAirPressure) {

        this.mTimeStamp = mTimeStamp;
        this.mAirPressure = mAirPressure;
    }

    public Date getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(Date mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    public float getAirPressure() {
        return mAirPressure;
    }

    public void setAirPressure(float mAirPressure) {
        this.mAirPressure = mAirPressure;
    }


}

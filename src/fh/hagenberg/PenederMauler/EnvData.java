package fh.hagenberg.PenederMauler;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mark on 07.12.2016.
 */
public class EnvData implements Serializable{
    private Date mTimeStamp;
    private float mAirPressure;
    private float  mLight;
    private float  mSound;

    public Date getmTimeStamp() {
        return mTimeStamp;
    }

    public void setmTimeStamp(Date mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    public float getmAirPressure() {
        return mAirPressure;
    }

    public void setmAirPressure(float mAirPressure) {
        this.mAirPressure = mAirPressure;
    }

    public float getmLight() {
        return mLight;
    }

    public void setmLight(float mLight) {
        this.mLight = mLight;
    }

    public float getmSound() {
        return mSound;
    }

    public void setmSound(float mSound) {
        this.mSound = mSound;
    }

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

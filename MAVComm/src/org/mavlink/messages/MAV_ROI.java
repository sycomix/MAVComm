/**
 * Generated class : MAV_ROI
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;
/**
 * Interface MAV_ROI
 * THIS INTERFACE IS DEPRECATED AS OF JANUARY 2018. Please use MAV_CMD_DO_SET_ROI_* messages instead. The ROI (region of interest) for the vehicle. This can be
                be used by the vehicle for camera/vehicle attitude alignment (see
                MAV_CMD_NAV_ROI).
 **/
public interface MAV_ROI {
    /**
     * No region of interest.
     */
    public final static int MAV_ROI_NONE = 0;
    /**
     * Point toward next waypoint, with optional pitch/roll/yaw offset.
     */
    public final static int MAV_ROI_WPNEXT = 1;
    /**
     * Point toward given waypoint.
     */
    public final static int MAV_ROI_WPINDEX = 2;
    /**
     * Point toward fixed location.
     */
    public final static int MAV_ROI_LOCATION = 3;
    /**
     * Point toward of given id.
     */
    public final static int MAV_ROI_TARGET = 4;
}

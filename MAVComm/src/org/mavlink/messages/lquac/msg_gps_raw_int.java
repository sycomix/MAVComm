/**
 * Generated class : msg_gps_raw_int
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.lquac;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import org.mavlink.io.LittleEndianDataInputStream;
import org.mavlink.io.LittleEndianDataOutputStream;
import org.mavlink.messages.MAVLinkMessage;
/**
 * Class msg_gps_raw_int
 * The global position, as returned by the Global Positioning System (GPS). This is
                NOT the global position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame).
 **/
public class msg_gps_raw_int extends MAVLinkMessage {
  public static final int MAVLINK_MSG_ID_GPS_RAW_INT = 24;
  private static final long serialVersionUID = MAVLINK_MSG_ID_GPS_RAW_INT;
  public msg_gps_raw_int() {
    this(1,1);
}
  public msg_gps_raw_int(int sysId, int componentId) {
    messageType = MAVLINK_MSG_ID_GPS_RAW_INT;
    this.sysId = sysId;
    this.componentId = componentId;
    payload_length = 30;
}

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot)
   */
  public long time_usec;
  /**
   * Latitude (WGS84), in degrees * 1E7
   */
  public long lat;
  /**
   * Longitude (WGS84), in degrees * 1E7
   */
  public long lon;
  /**
   * Altitude (AMSL, NOT WGS84), in meters * 1000 (positive for up). Note that virtually all GPS modules provide the AMSL altitude in addition to the WGS84 altitude.
   */
  public long alt;
  /**
   * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  public int eph;
  /**
   * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  public int epv;
  /**
   * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX
   */
  public int vel;
  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
   */
  public int cog;
  /**
   * See the GPS_FIX_TYPE enum.
   */
  public int fix_type;
  /**
   * Number of satellites visible. If unknown, set to 255
   */
  public int satellites_visible;
/**
 * Decode message with raw data
 */
public void decode(LittleEndianDataInputStream dis) throws IOException {
  time_usec = (long)dis.readLong();
  lat = (int)dis.readInt();
  lon = (int)dis.readInt();
  alt = (int)dis.readInt();
  eph = (int)dis.readUnsignedShort()&0x00FFFF;
  epv = (int)dis.readUnsignedShort()&0x00FFFF;
  vel = (int)dis.readUnsignedShort()&0x00FFFF;
  cog = (int)dis.readUnsignedShort()&0x00FFFF;
  fix_type = (int)dis.readUnsignedByte()&0x00FF;
  satellites_visible = (int)dis.readUnsignedByte()&0x00FF;
}
/**
 * Encode message with raw data and other informations
 */
public byte[] encode() throws IOException {
  byte[] buffer = new byte[12+30];
   LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
  dos.writeByte((byte)0xFD);
  dos.writeByte(payload_length & 0x00FF);
  dos.writeByte(incompat & 0x00FF);
  dos.writeByte(compat & 0x00FF);
  dos.writeByte(packet & 0x00FF);
  dos.writeByte(sysId & 0x00FF);
  dos.writeByte(componentId & 0x00FF);
  dos.writeByte(messageType & 0x00FF);
  dos.writeByte((messageType >> 8) & 0x00FF);
  dos.writeByte((messageType >> 16) & 0x00FF);
  dos.writeLong(time_usec);
  dos.writeInt((int)(lat&0x00FFFFFFFF));
  dos.writeInt((int)(lon&0x00FFFFFFFF));
  dos.writeInt((int)(alt&0x00FFFFFFFF));
  dos.writeShort(eph&0x00FFFF);
  dos.writeShort(epv&0x00FFFF);
  dos.writeShort(vel&0x00FFFF);
  dos.writeShort(cog&0x00FFFF);
  dos.writeByte(fix_type&0x00FF);
  dos.writeByte(satellites_visible&0x00FF);
  dos.flush();
  byte[] tmp = dos.toByteArray();
  for (int b=0; b<tmp.length; b++) buffer[b]=tmp[b];
  int crc = MAVLinkCRC.crc_calculate_encode(buffer, 30);
  crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
  byte crcl = (byte) (crc & 0x00FF);
  byte crch = (byte) ((crc >> 8) & 0x00FF);
  buffer[40] = crcl;
  buffer[41] = crch;
  dos.close();
  return buffer;
}
public String toString() {
return "MAVLINK_MSG_ID_GPS_RAW_INT : " +   "  time_usec="+time_usec+  "  lat="+lat+  "  lon="+lon+  "  alt="+alt+  "  eph="+eph+  "  epv="+epv+  "  vel="+vel+  "  cog="+cog+  "  fix_type="+fix_type+  "  satellites_visible="+satellites_visible;}
}

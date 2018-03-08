A virtual sensor provides state information about the Robot or one of its sub-components. 
The state information can be derived from any source, often including physical sensors.

Common use cases:
  1. Provide an easy-to-use interface around a raw sensor. This is especially useful if multiple
     commands or subsystems need the interpreted data. For example, if multiple commands need to make decisions based 
     on whether an Arm is in its full-upright position, an ArmPositionSensor can interpret raw potentiometer data 
     and provide a simple `isFullyRaised()` method for other each command to use. This is much better than each 
     command individually interpreting the raw data.
     
  2. Use multiple sensors to derive state information. For example, read from two encoders and agyro to figure out
     the current position of the robot.
     
  3. Read network tables information to report state information fed from the driver station.

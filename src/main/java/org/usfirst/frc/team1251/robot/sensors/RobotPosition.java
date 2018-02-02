package org.usfirst.frc.team1251.robot.sensors;

/**
 * Represents the bot's coordinates.
 *
 * Coordinates are relative to ???? (TODO: what are they relative to? starting position? center of field?)
 *
 * The value of `x` changes as the Robot moves to the rightwards (increases) or leftwards (decreases) on the field.
 * The value of `y` changes as the Robot moves backwards (decreases) or forwards(increases) on the field.
 *
 * Note, the terms "rightwards", "leftwards", "forwards", and "backwards" are from the perspective of the Robot's
 * starting side on the field. For reference, in the following diagrams "R" marks the starting side of the robot on
 * the field: (TODO: is this accurate?)
 *
 *                          ▲                           ¦                         ▲
 *                          |                           ¦                         |
 *                     forward (+y)                     ¦                    backward (-y)
 *                          |                           ¦                         |
 *                    -------------                     ¦                   -------------
 *                   |             |                    ¦                  |      R      |
 *                   |             |                    ¦                  |             |
 *    ◀- leftward -- | ----------- | -- rightward -▶    ¦  ◀- rightward -- | ----------- | -- leftward -▶
 *          (-x)     |             |        (+x)        ¦        (+x)      |             |      (-x)
 *                   |      R      |                    ¦                  |             |
 *                    -------------                     ¦                   -------------
 *                          |                           ¦                         |
 *                      backward (-y)                   ¦                    forward (+y)
 *                          |                           ¦                         |
 *                          ▼                           ¦                         ▼
 *
 *
 * As the robot moves towards the right side of the field, x increases. As the robot moves forward on the field, y
 * increases. The terms "right" and "forward"
 */
public class RobotPosition
{
    private double x;
    private double y;

    /**
     * Creates an instance to represent the current position of the robot.
     *
     * @param x The current x coordinate of the robot.
     * @param y The current y coordinate of the robot.
     */
    RobotPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

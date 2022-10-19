// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class Swerve {
        public static final int FRONT_LEFT_ANGLE_MOTOR = -1;
        public static final int FRONT_LEFT_SPEED_MOTOR = -1;
        public static final int FRONT_LEFT_ANGLE_ENCODER = -1;

        public static final int FRONT_RIGHT_ANGLE_MOTOR = -1;
        public static final int FRONT_RIGHT_SPEED_MOTOR = -1;
        public static final int FRONT_RIGHT_ANGLE_ENCODER = -1;

        public static final int BACK_LEFT_ANGLE_MOTOR = -1;
        public static final int BACK_LEFT_SPEED_MOTOR = -1;
        public static final int BACK_LEFT_ANGLE_ENCODER = -1;

        public static final int BACK_RIGHT_ANGLE_MOTOR = -1;
        public static final int BACK_RIGHT_SPEED_MOTOR = -1;
        public static final int BACK_RIGHT_ANGLE_ENCODER = -1;

        public static final double ANGLE_KP = -1;
        
        public static final double SPEED_KS = -1;
        public static final double SPEED_KV = -1;
        public static final double SPEED_KP = -1;

        public static final double WHEEL_DIAMETER = -1;
        public static final double GEAR_RATIO_SPEED = -1;
        public static final double TICKS_PER_REVOLUTION_SPEED = -1;
        public static final double TICKS_PER_METER = WHEEL_DIAMETER * Math.PI * GEAR_RATIO_SPEED * TICKS_PER_REVOLUTION_SPEED;
        public static final double TICKS_PER_MS_TO_MPS = 10 / TICKS_PER_METER;
        public static final double GEAR_RATIO_ANGLE_TO_SPEED = -1;
        public static final double GEAR_RATIO_ANGLE = -1;
    }
}

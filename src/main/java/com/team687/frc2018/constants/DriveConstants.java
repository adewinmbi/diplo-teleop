package com.team687.frc2018.constants;

public class DriveConstants {

//	TalonSRX Constants- Carpet
	// public static final double kLeftP = 0.254;
	// // public static final double kLeftI = 0;
	// // public static final double kLeftD = 0.619;
	// public static final double kLeftI = 0;
	// public static final double kLeftD = 0;
	// public static final double kLeftF = 0.26913425;
	
	
	// public static final double kRightP = 0.254;
	// // public static final double kRightI = 0;
	// // public static final double kRightD = 0.619;
	// public static final double kRightI = 0;
	// public static final double kRightD = 0;
	// public static final double kRightF = 0.269616;
	
	// public static final double kLeftStatic = 1.598/12;

	// public static final double kRightStatic = 1.615/12;

	/* Concrete constants
	public static final double kLeftP = 0.1;
	// public static final double kLeftI = 0;
	// public static final double kLeftD = 0.619;
	public static final double kLeftI = 0;
	public static final double kLeftD = 0;
	public static final double kLeftF = 0.27032775;
	*/

	//Test robotpy-characterization
	public static final double kTestP = 0.429;
	// public static final double kLeftI = 0;
	// public static final double kLeftD = 0.619;
	public static final double kTestI = 0;
	public static final double kTestD = 0;
	public static final double kTestS = 0.887;
	public static final double kTestV = 0.0705;
	public static final double kTestA = 0.0135;
	
	/* Concrete constants continued
	public static final double kRightP = 0.1;
	// public static final double kRightI = 0;
	// public static final double kRightD = 0.619;
	public static final double kRightI = 0;
	public static final double kRightD = 0;
	public static final double kRightF = 0.27424925;
	*/
	public static final double kLeftStatic = 1.135;

	public static final double kRightStatic = 1.102;

	// max accel/cruise velocity
	public static final int kLeftAcceleration = 1000;
	public static final int kLeftCruiseVelocity = 3000;
	
	public static final int kRightAcceleration = 1000;
	public static final int kRightCruiseVelocity = 3000;

//	Rot PID Constants
	public static final double kDriveRotationTolerance = 0;
	public static final double kMaxRotPower = 0.8;
	public static final double kMinRotPower = 0;
	public static final double kRotationalEncoderTolerance = 200;
	
//	Drive Constants, for driving straight
	public static final double kDriveP = 0;
	public static final double kDriveTolerance = 200;
	
//	Physical Robot Constants
	public static final double kWheelDiameter = 6;
	public static final double kDrivetrainWidth = 2.108211152;
	public static final double kTicksPerFootLeft = 2455.8;
	public static final double kTicksPerFootRight = 2188.2;
	
//	Other Constants 
	public static final double kJoystickDeadband = 0.1;
	
	public static final double kMinDistToBezierPoint = 100; //distance to target point at bezier curve where robot changes target to nect point
//	public static BezierCurve kTestCurveStraight = new BezierCurve()
	public static final double kMaximumTurnRadius = 50;
	
	public static final double kRotD = 0;
	public static final double kRotMinPower = 0;
	public static final double kRotPMaxPower = 1;
	
	public static final double kLeftAdjustment = 1;
	public static final double kRightAdjustment = 1;

	public static final double kRotP = 0;

	public static final double kVelocityPIDPeriod = 0.01;

	public static final double kDistP = 0.0001;
	public static final double kDistMaxPower = 1;
	public static final double kDistMinPower = 0;

	// Pathfinder Constants
	public static final double kLeftVelocityP = 0;
	public static final double kLeftVelocityD = 0;
	public static final double kLeftV = 0;

	public static final double kRightVelocityP = 0;
	public static final double kRightVelocityD = 0;
	public static final double kRightV = 0;


}

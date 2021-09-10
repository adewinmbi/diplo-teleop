package com.team687.frc2018.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.team687.frc2018.Robot;
import com.team687.frc2018.RobotMap;
import com.team687.frc2018.constants.DriveConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Drive extends Drivetrain {

	public Drive() {
		super(new NerdyTalon(RobotMap.kLeftMasterTalonID), new NerdyTalon(RobotMap.kRightMasterTalonID),
		 new NerdyTalon[] {new NerdyTalon(RobotMap.kLeftSlaveVictorID)},
		 new NerdyTalon[] {new NerdyTalon(RobotMap.kRightSlaveVictorID)},
		 false, true, 30);
		 super.configAutoChooser(new AutoChooser());
		 super.configMaxVelocity(DriveConstants.kLeftCruiseVelocity);
		 super.configSensorPhase(true, true);
		 super.configTicksPerFoot(DriveConstants.kTicksPerFootLeft, DriveConstants.kTicksPerFootRight);
		 super.configLeftPIDF(DriveConstants.kTestP, DriveConstants.kTestI, DriveConstants.kTestD, 0);
		 super.configRightPIDF(DriveConstants.kTestP, DriveConstants.kTestI, DriveConstants.kTestD, 0);
		//  super.configStaticFeedforward(DriveConstants.kTestV, DriveConstants.kRightStatic);
		super.configFeedforwardLeft(DriveConstants.kTestV, DriveConstants.kTestS, DriveConstants.kTestA);
		super.configFeedforwardRight(DriveConstants.kTestV, DriveConstants.kTestS, DriveConstants.kTestA);
		
		 super.configDate("2019_2_8_");
	}
}
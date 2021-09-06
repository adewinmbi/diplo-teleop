// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import frc.robot.RobotMap;
import com.nerdherd.lib.misc.AutoChooser;
import frc.robot.constants.DriveConstants;

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
		 super.configFeedforwardLeft(DriveConstants.kTestV, DriveConstants.kTestS, DriveConstants.kTestA);
		 super.configFeedforwardRight(DriveConstants.kTestV, DriveConstants.kTestS, DriveConstants.kTestA);
	}

}

package com.team687.frc2018;


import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.misc.AutoChooser;
// import com.nerdherd.lib.motor.single.SingleMotorTalonSRX;
// Talon SRX CAN has been removed from wpilib.
import com.nerdherd.lib.pneumatics.Piston;
import com.team687.frc2018.constants.SuperstructureConstants;
// import com.team687.frc2018.subsystems.Arm;
import com.team687.frc2018.subsystems.Drive;
// import com.team687.frc2018.subsystems.Wrist;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.command.Command;
// Change to wpilibj2
import edu.wpi.first.wpilibj2.command.Command;


// import edu.wpi.first.wpilibj.command.Scheduler;
// Change to CommandScheduler
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;

public class Robot extends TimedRobot {

    public static final String kDate = "2019_01_11_";

    public static Drive drive;
    // public static Arm arm;
    // public static Wrist wrist;

	public static Piston claw;
	// public static SingleMotorTalonSRX intake;
	// No longer supported

    public static DriverStation ds;
    public static PowerDistributionPanel pdp;
	public static Compressor compressor;
	
	public static AutoChooser chooser;

    public static OI oi;

    SendableChooser<String> sideChooser;
    public static Command autonomousCommand;
    public static String startingPosition;
    public static boolean switchOnLeft, scaleOnLeft;
    SendableChooser<String> typeChooser;
    public static String autoType;

    @Override
    public void robotInit() {
	compressor = new Compressor();
	compressor.start();

	// arm = new Arm();
	// arm.setVoltage(0);
	// arm.resetEncoder();

	// wrist = new Wrist();
	// wrist.setPercentOutput(0);
	// wrist.resetEncoder();

	// intake = new Intake();
	// intake.setRollerPower(0);

	drive = new Drive();
	drive.resetEncoders();

	// intake = new SingleMotorTalonSRX(RobotMap.kIntakeRollers1ID, "intake", false, true);
	// No longer supported
	
	claw = new Piston(RobotMap.kIntakeClawID1, RobotMap.kIntakeClawID2);
	oi = new OI();

	
	ds = DriverStation.getInstance();

	// CameraServer.getInstance().startAutomaticCapture();
	}



    @Override
    public void disabledInit() {
	// CommandScheduler.getInstance().removeAll();
	// No longer exists

	drive.reportToSmartDashboard();
	// arm.reportToSmartDashboard();
	// wrist.reportToSmartDashboard();

	// SmartDashboard.putBoolean("HEALTHY SUPERSTRUCTURE CURRENT",
		// !(arm.getCurrent() > SuperstructureConstants.kArmSafeCurrent
		// 	|| wrist.getCurrent() > SuperstructureConstants.kWristSafeCurrent));

	drive.stopLog();
	// arm.stopLog();
    // wrist.stopLog();
    }

    @Override
    public void disabledPeriodic() {

	drive.reportToSmartDashboard();
	// arm.reportToSmartDashboard();
	// wrist.reportToSmartDashboard();
	
	}
	@Override
    public void autonomousInit() {
	// Scheduler.getInstance().removeAll();

	

	 drive.startLog();
	//  arm.startLog();
    //  wrist.startLog();
    }

    @Override
    public void autonomousPeriodic() {
	CommandScheduler.getInstance().run();

	drive.reportToSmartDashboard();
	// arm.reportToSmartDashboard();
	// wrist.reportToSmartDashboard();

	// SmartDashboard.putBoolean("HEALTHY SUPERSTRUCTURE CURRENT",
	// 	!(arm.getCurrent() > SuperstructureConstants.kArmSafeCurrent
	// 		|| wrist.getCurrent() > SuperstructureConstants.kWristSafeCurrent));

	 drive.logToCSV();
	//  arm.logToCSV();
	//  wrist.logToCSV();
	 
	drive.setVelocityFPS(5, 5, 0, 0);
    }

    @Override
    public void teleopInit() {
	drive.reportToSmartDashboard();
	// arm.reportToSmartDashboard();
	// wrist.reportToSmartDashboard();

	// SmartDashboard.putBoolean("HEALTHY SUPERSTRUCTURE CURRENT",
		// !(arm.getCurrent() > SuperstructureConstants.kArmSafeCurrent
		// 	|| wrist.getCurrent() > SuperstructureConstants.kWristSafeCurrent));
	compressor.start();
	drive.startLog();
	// arm.startLog();
	// wrist.startLog();
	CommandScheduler.getInstance().schedule(new ArcadeDrive(drive, oi));
    }

    @Override
    public void teleopPeriodic() {
		CommandScheduler.getInstance().run();
	CommandScheduler.getInstance().run();
	compressor.start();
	drive.reportToSmartDashboard();
	// arm.reportToSmartDashboard();
	// wrist.reportToSmartDashboard();
	// SmartDashboard.putBoolean("HEALTHY SUPERSTRUCTURE CURRENT",
	// 	!(arm.getCurrent() > SuperstructureConstants.kArmSafeCurrent
	// 		|| wrist.getCurrent() > SuperstructureConstants.kWristSafeCurrent));

	drive.logToCSV();
	// arm.logToCSV();
    // wrist.logToCSV();
    }

    @Override
    public void testPeriodic() {
    }
}

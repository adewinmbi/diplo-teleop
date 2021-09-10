package com.team687.frc2018.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team687.frc2018.Robot;
import com.team687.frc2018.RobotMap;
import com.team687.frc2018.constants.SuperstructureConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Intake subsystem
 */

public class Intake extends SubsystemBase {

    private final TalonSRX m_rollers1;
    private final DoubleSolenoid m_claw;

    private String m_filePath1 = "/media/sda1/logs/";
    private String m_filePath2 = "/home/lvuser/logs/";
    private File m_file;
    public FileWriter m_writer;
    private boolean writeException = false;
    private double m_logStartTime = 0;

    public Intake() {
        // Puts the number for setting power from the dashboard
        SmartDashboard.putNumber("Intake voltage to set", 0);

        m_rollers1 = new TalonSRX(RobotMap.kIntakeRollers1ID);
        m_rollers1.setNeutralMode(NeutralMode.Coast);
        m_rollers1.setStatusFramePeriod(StatusFrame.Status_1_General, 20, 0);
    
        m_rollers1.setInverted(true);
        m_rollers1.configPeakCurrentLimit(SuperstructureConstants.kRollerPeakCurrent, 0);
        m_rollers1.configContinuousCurrentLimit(SuperstructureConstants.kRollerMaxCurrent, 0);
     
        m_rollers1.configPeakOutputForward(1, 0);
        m_rollers1.configPeakOutputReverse(-1, 0);
        m_rollers1.enableCurrentLimit(false);

	m_claw = new DoubleSolenoid(RobotMap.kIntakeClawID2, RobotMap.kIntakeClawID1);
    }

    public void openClaw() {
	m_claw.set(DoubleSolenoid.Value.kForward);
    }

    public void closeClaw() {
	m_claw.set(DoubleSolenoid.Value.kReverse);
    }

    public boolean isClawOpen() {
	    return m_claw.get() == DoubleSolenoid.Value.kReverse;
    }

    public boolean hasCube() {
	// return !m_switch.get();
	    return isMaxCurrent();
    }

    public boolean isMaxCurrent() {
	    return getRoller1Current() > SuperstructureConstants.kRollerMaxCurrent;
    }

    public void setRollerPower(double power) {
        m_rollers1.set(ControlMode.PercentOutput, power);
    }

    public double getRoller1Voltage() {
	return m_rollers1.getMotorOutputVoltage();
    }

    public double getRoller1Current() {
	return m_rollers1.getOutputCurrent();
    }

    public void reportToSmartDashboard() {
	// ----- COMMENT THESE OUT WHEN GOING TO FIELD ----- //
//	SmartDashboard.putNumber("Roller Voltage", getRoller1Voltage());
//	SmartDashboard.putNumber("Roller Current", getRoller1Current());
//	SmartDashboard.putBoolean("Has Cube", hasCube());
//	SmartDashboard.putBoolean("Reached Max Current", isMaxCurrent());
	// ----- COMMENT THESE OUT WHEN GOING TO FIELD ----- //

	SmartDashboard.putBoolean("Claw Open", isClawOpen());
    }

    public void startLog() {
        writeException = false;
        // Check to see if flash drive is mounted.
        File logFolder1 = new File(m_filePath1);
        File logFolder2 = new File(m_filePath2);
        Path filePrefix = Paths.get("");
        if (logFolder1.exists() && logFolder1.isDirectory()) {
            filePrefix = Paths.get(logFolder1.toString(),
                Robot.kDate + Robot.ds.getMatchType().toString() + Robot.ds.getMatchNumber() + "Intake");
        } else if (logFolder2.exists() && logFolder2.isDirectory()) {
            filePrefix = Paths.get(logFolder1.toString(),
                Robot.kDate + Robot.ds.getMatchType().toString() + Robot.ds.getMatchNumber() + "Intake");
        } else {
            writeException = true;
        }
    
        if (!writeException) {
            int counter = 0;
            while (counter <= 99) {
            m_file = new File(filePrefix.toString() + String.format("%02d", counter) + ".csv");
            if (m_file.exists()) {
                counter++;
            } else {
                break;
            }
            if (counter == 99) {
                System.out.println("file creation counter at 99!");
            }
            }
            try {
            m_writer = new FileWriter(m_file);
            m_writer.append("Time,Roller 1 Voltage,Roller 1 Current,Current Intake Command\n");
            m_writer.flush();
            m_logStartTime = Timer.getFPGATimestamp();
            } catch (IOException e) {
            e.printStackTrace();
            writeException = true;
            }
        }
        }
    
        public void stopLog() {
        try {
            if (null != m_writer)
            m_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            writeException = true;
        }
        }
    
        public void logToCSV() {
        if (!writeException) {
            try {
            double timestamp = Timer.getFPGATimestamp() - m_logStartTime;
            m_writer.append(String.valueOf(timestamp) + ","
                + String.valueOf(getRoller1Voltage()) + "," + String.valueOf(getRoller1Current()) + ","
                + String.valueOf(SmartDashboard.getString("Current Intake Command", "None")) + "\n");
    //		m_writer.flush();
            } catch (IOException e) {
            e.printStackTrace();
            writeException = true;
            }
        }
        }

}

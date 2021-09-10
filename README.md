# diplo-teleop
Teleoperated tank drive joystick control

## What I Did

* Created new 2021 WPIlib project with old 2018 Diplo source code
* Updated or removed dependencies which caused errors with the new WPIlib

## Important Changes

* Removed (commented) any code which used the Talon SRX CAN motors as they are [no longer supported by WPIlib](https://docs.wpilib.org/en/latest/docs/software/labview/resources/talon-srx-can.html)
* Changed Command import to [CommandScheduler](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-scheduler.html) class which is supported by newer versions of WPIlib
* Removed (commented) any Arm or Wrist code as it was not necessary for a tank drive
    *  This removed the need to update dependencies in those classes
* Deleted "playingwithfusion2020.json" vendordep as some of the included urls no longer existed
* Fixed typo error in NerdyLib which was not commit with this repository
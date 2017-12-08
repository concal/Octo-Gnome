package gnome.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import gnome.RobotMap;
import gnome.loops.Navigation;

/**
 *
 */
public class Drive extends Subsystem {

    private static Drive instance = new Drive();
    private static Navigation mNavigation;
  
    RobotDrive mDrive;
    Talon mLeftDriveMotor, mRightDriveMotor;
    TalonSRX mFrontLeftMotor, mFrontRightMotor, mRearLeftMotor, mRearRightMotor;
    DoubleSolenoid mLeftShifter, mRightShifter;
  
    
    
  
    public static Drive getInstance() {
      return instance;
    }

    private Drive() {
      mNavigation = Navigation.getInstance();
      
      mLeftDriveMotor = new Talon(RobotMap.PWMs.DRIVE_LEFT_MOTOR);
      mRightDriveMotor = new Talon(RobotMap.PWMs.DRIVE_RIGHT_MOTOR);
      mRightDriveMotor.setInverted(true);
      
      mFrontLeftMotor = new TalonSRX(RobotMap.CAN_IDs.LEFT_FRONT_MOTOR);
      mFrontRightMotor = new TalonSRX(RobotMap.CAN_IDs.LEFT_BACK_MOTOR);
      mRearLeftMotor = new TalonSRX(RobotMap.CAN_IDs.RIGHT_FRONT_MOTOR);
      mRearRightMotor = new TalonSRX(RobotMap.CAN_IDs.RIGHT_BACK_MOTOR);
      
      mLeftShifter = new DoubleSolenoid(RobotMap.Solenoids.LEFT_POD_SHIFTER_A, RobotMap.Solenoids.LEFT_POD_SHIFTER_B);
      mRightShifter = new DoubleSolenoid(RobotMap.Solenoids.RIGHT_POD_SHIFTER_A, RobotMap.Solenoids.RIGHT_POD_SHIFTER_B);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


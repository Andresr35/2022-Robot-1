
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.cascadeCommand;
import frc.robot.commands.indexerCommand;
import frc.robot.commands.rotaryArmsCommand;
import frc.robot.commands.shooterCommand;
import frc.robot.subsystems.cascade;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.indexer;
import frc.robot.subsystems.rotaryArms;
import frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer 
{

  private final shooter shooterSub = new shooter();
  private final drive driveSub = new drive();
  private final cascade cascadeSub = new cascade();
  private final indexer indexerSub = new indexer();
  private final rotaryArms rotarySub = new rotaryArms();

  private final shooterCommand shooterMove = new shooterCommand(shooterSub, Constants.shooterSpeed);
  private final shooterCommand shooter90 = new shooterCommand(shooterSub, .9 *Constants.shooterSpeed);
  private final shooterCommand shooter80 = new shooterCommand(shooterSub, .8 *Constants.shooterSpeed);
  private final shooterCommand shooter70 = new shooterCommand(shooterSub, .7 *Constants.shooterSpeed);
  private final shooterCommand shooter60 = new shooterCommand(shooterSub, .5 *Constants.shooterSpeed);


  private final cascadeCommand cascadeMoveUp = new cascadeCommand( cascadeSub, Constants.cascadeSpeed);
  private final cascadeCommand cascadeMoveDown = new cascadeCommand(cascadeSub, -1 * Constants.cascadeSpeed);
  private final indexerCommand indexerIn = new indexerCommand(indexerSub, Constants.indexerSpeed);
  private final indexerCommand indexerOut = new indexerCommand(indexerSub, -.5 * Constants.indexerSpeed);
  private final rotaryArmsCommand rotateForward = new rotaryArmsCommand(rotarySub, Constants.rotaryArmSpeed);
  private final rotaryArmsCommand rotateBackward = new rotaryArmsCommand(rotarySub, -1 * Constants.rotaryArmSpeed);

  Joystick jasmine = new Joystick(0);
  Joystick ish = new Joystick(Constants.ish);

  RunCommand move = new RunCommand(() -> driveSub.move(Constants.driveSpeed*jasmine.getRawAxis(1),
  Constants.driveSpeed*jasmine.getRawAxis(5)),driveSub);

  RunCommand move2 = new RunCommand(() -> driveSub.move(Constants.driveSpeed*ish.getRawAxis(1),
  Constants.driveSpeed*ish.getRawAxis(5)),driveSub);
  
  /*
  RunCommand moverotateFoward = new RunCommand(() -> rotarySub.rotateArms(Constants.rotaryArmSpeed*jasmine.getRawAxis(3)));
  RunCommand moverotateBackward = new RunCommand(() -> rotarySub.rotateArms(-1 * Constants.rotaryArmSpeed*jasmine.getRawAxis(2)));*/

  public RobotContainer() 
  {
    driveSub.setDefaultCommand(move);
    driveSub.setDefaultCommand(move2);
    
    JoystickButton shooter = new JoystickButton(jasmine, Constants.shooterButton);
    shooter.whileHeld(shooterMove);

    JoystickButton shooter9 = new JoystickButton(ish, Constants.shooter9);
    shooter9.whileHeld(shooter90);

    JoystickButton shooter8 = new JoystickButton(ish, Constants.shooter8);
    shooter8.whileHeld(shooter80);

    JoystickButton shooter7 = new JoystickButton(ish, Constants.shooter7);
    shooter7.whileHeld(shooter70);

    JoystickButton shooter6 = new JoystickButton(ish, Constants.shooter6);
    shooter6.whileHeld(shooter60);


    JoystickButton cascadeUp = new JoystickButton(jasmine, Constants.cascadeUpButton);
    cascadeUp.whileHeld(cascadeMoveUp);
    JoystickButton cascadeDown = new JoystickButton(jasmine,Constants.cascadeDownButton);
    cascadeDown.whileHeld(cascadeMoveDown);

    JoystickButton indexerI = new JoystickButton(jasmine, Constants.IndexerInButton);
    indexerI.whileHeld(indexerIn);
    JoystickButton indexerI2 = new JoystickButton(ish, Constants.IndexerInButton);
    indexerI2.whileHeld(indexerIn);

    
    JoystickButton indexerO = new JoystickButton(jasmine, Constants.IndexerOutButton);
    indexerO.whileHeld(indexerOut);
    JoystickButton indexer2O = new JoystickButton(ish, Constants.IndexerOut2Button);
    indexer2O.whileHeld(indexerOut);
    
    JoystickButton rotaryForward = new JoystickButton(jasmine, Constants.rotaryForwardButton);
    rotaryForward.whileHeld(rotateForward);

    JoystickButton rotaryBackward = new JoystickButton(jasmine, Constants.rotaryBackwardButton);
    rotaryBackward.whileHeld(rotateBackward);
    configureButtonBindings();

  }

 
  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    return null;
  }
}

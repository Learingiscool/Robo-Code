package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.time.Duration;


public class BotMovement {
  private DcMotor topLeft; //Motor out 0
  private DcMotor topRight; //Motor out 1
  private DcMotor bottomLeft; //Motor out 2
  private DcMotor bottomRight; //Motor out 3

  public BotMovement(DcMotor topLeft, DcMotor topRight, DcMotor bottomLeft, DcMotor bottomRight) {
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.bottomLeft = bottomLeft;  
    this.bottomRight = bottomRight;

  }

  public void BotMove(Gamepad gamepad1) {

    double tgtPowerX = gamepad1.left_stick_x; 
    double tgtPowerY = -gamepad1.left_stick_y;
    double turn = gamepad1.right_stick_x;
    double theta = Math.atan2(tgtPowerY, tgtPowerX);
    double power = Math.hypot(tgtPowerX*tgtPowerX, tgtPowerY*tgtPowerY);
    
    topLeft.setDirection(DcMotor.Direction.FORWARD); //is actually bottomLeft
    topRight.setDirection(DcMotor.Direction.REVERSE); //actually topRight
    bottomLeft.setDirection(DcMotor.Direction.REVERSE); //is actually topLeft
    bottomRight.setDirection(DcMotor.Direction.FORWARD); // is actually bottomRight
    
    
    double sin = Math.sin(theta - Math.PI/4);
    double cos = Math.cos(theta - Math.PI/4);
    double max = Math.max(Math.abs(sin), Math.abs(cos));
    double topLeftPower = power * cos/max + turn; 
    double topRightPower = power * sin/max - turn;
    double bottomLeftPower = power * sin/max + turn;
    double bottomRightPower = power * cos/max - turn; 
    
    if ((power + Math.abs(turn)) > 1){
      topLeftPower /= power + turn;
      topRightPower /= power + turn;
      bottomLeftPower /= power + turn;
      bottomRightPower /= power + turn;
    }

    topLeft.setPower(topLeftPower);
    topRight.setPower(topRightPower);
    bottomLeft.setPower(bottomLeftPower);
    bottomRight.setPower(bottomRightPower);
  }
}
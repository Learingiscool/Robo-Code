/*
Copyright 2024 FIRST Tech Challenge Team FTC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
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

/**
 * This file contains a minimal example of a Linear "OpMode". An OpMode is a 'program' that runs
 * in either the autonomous or the TeleOp period of an FTC match. The names of OpModes appear on
 * the menu of the FTC Driver Station. When an selection is made from the menu, the corresponding
 * OpMode class is instantiated on the Robot Controller and executed.
 *
 * Remove the @Disabled annotation on the next line or two (if present) to add this OpMode to the
 * Driver Station OpMode list, or add a @Disabled annotation to prevent this OpMode from being
 * added to the Driver Station.
 */
@TeleOp

public class Manual extends LinearOpMode {
    private DcMotorSimple servoElevator; //Servo out 0
    private CRServo servoClawPivot; // Servo out 1
    private Servo servoArmRight; // Servo out 2
    private DcMotorSimple armPivot;//servo out 3
    private Servo clawServo; // Servo out 4
    private DcMotor topLeft; // Motor out 0
    private DcMotor topRight; // Motor out 1
    private DcMotor bottomLeft; // Motor out 2
    private DcMotor bottomRight; // Motor out 3
    private DigitalChannel highBinTouch;
    private DigitalChannel intakeTouch;

    @Override
    public void runOpMode() {
        
         // Hardware Initialization
        servoElevator = hardwareMap.get(DcMotorSimple.class, "servoElevator");
        servoClawPivot = hardwareMap.get(CRServo.class, "servoClawPivot");
        //servoArmRight = hardwareMap.get(Servo.class, "servoArmRight");
        armPivot = hardwareMap.get(DcMotorSimple.class, "armPivot");
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        intakeTouch = hardwareMap.get(DigitalChannel.class, "intakeTouch");
        highBinTouch = hardwareMap.get(DigitalChannel.class, "highBinTouch");
        
        BotMovement botMovement = new BotMovement(topLeft, topRight, bottomLeft, bottomRight);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            // Movement
            botMovement.BotMove(gamepad1);
            
            
            if (gamepad1.y) {
            clawServo.setPosition(0.4);
           }
           else if (gamepad1.x) {
              clawServo.setPosition(0);
           }
           
           
           
           armPivot.setPower(-gamepad2.left_stick_y * 0.7);
           servoElevator.setPower(gamepad1.right_trigger);
           servoElevator.setPower(-gamepad1.left_trigger);
           servoClawPivot.setPower(gamepad2.right_stick_y);
           
            
            telemetry.addData("Status", "Running");
            telemetry.update();
            

        }
    }
}

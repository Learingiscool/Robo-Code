// /*
// Copyright 2024 FIRST Tech Challenge Team FTC
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
// associated documentation files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge, publish, distribute,
// sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in all copies or substantial
// portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
// NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
// package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.DcMotorSimple;
// import com.qualcomm.robotcore.util.ElapsedTime;
// 
// /**
//  * This file contains a minimal example of a Linear "OpMode". An OpMode is a 'program' that runs
//  * in either the autonomous or the TeleOp period of an FTC match. The names of OpModes appear on
//  * the menu of the FTC Driver Station. When an selection is made from the menu, the corresponding
//  * OpMode class is instantiated on the Robot Controller and executed.
//  *
//  * Remove the @Disabled annotation on the next line or two (if present) to add this OpMode to the
//  * Driver Station OpMode list, or add a @Disabled annotation to prevent this OpMode from being
//  * added to the Driver Station.
//  */
// @Autonomous
// 
// public class AutoMode extends LinearOpMode {
//     private DcMotor topLeft; //Motor out 0
//     private DcMotor topRight; //Motor out 1
//     private DcMotor bottomLeft; //Motor out 2
//     private DcMotor bottomRight; //Motor out 3
//     private DcMotorSimple servoElevator;
//     private CRServo servoClawPivot;
//     //private Servo servoArmRight;
//     private DcMotorSimple armPivot;
//     private LinearOpMode opMode;
//     private Servo clawServo;
//     
// /**
//     public AutoMode(DcMotor topLeft, DcMotor topRight, DcMotor bottomLeft, DcMotor bottomRight, CRServo servoElevator, Servo servoClawPivot,  Servo servoArmRight, DcMotorSimple armPivot, Servo clawServo, LinearOpMode opMode) {
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;  
//         this.bottomRight = bottomRight;
//         this.servoElevator = servoElevator; // Servo out 0
//         this.servoClawPivot = servoClawPivot; // Servo out 1
//         this.servoArmRight = servoArmRight;// Servo out 2
//         this.armPivot = armPivot;//Servo out 3
//         this.clawServo = clawServo;
//         this.opMode = opMode;
//         
// 
//   }
// 
// **/
//     @Override
//     public void runOpMode() {
//         
//         servoElevator = hardwareMap.get(CRServo.class, "servoElevator");
//         servoClawPivot = hardwareMap.get(CRServo.class, "servoClawPivot");
//         //servoArmRight = hardwareMap.get(Servo.class, "servoArmRight");
//         armPivot = hardwareMap.get(DcMotorSimple.class, "armPivot");
//         clawServo = hardwareMap.get(Servo.class, "clawServo");
//         topLeft = hardwareMap.get(DcMotor.class, "topLeft");
//         topRight = hardwareMap.get(DcMotor.class, "topRight");
//         bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
//         bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
// 
//         telemetry.addData("Status", "Initialized");
//         telemetry.update();
//         topLeft.setDirection(DcMotor.Direction.FORWARD); //is actually bottomLeft
//         topRight.setDirection(DcMotor.Direction.REVERSE); //actually topRight
//         bottomLeft.setDirection(DcMotor.Direction.REVERSE); //is actually topLeft
//         bottomRight.setDirection(DcMotor.Direction.FORWARD); // is actually bottomRight
//         int timeForOneTile = 2000;
//         // Wait for the game to start (driver presses PLAY)
//         waitForStart();
// 
//         // run until the end of the match (driver presses STOP)
//         while (opModeIsActive()) {
//             // tiles are 2x2x2 inch 
//             
//             
//             // move backwards to begin 
//             topLeft.setPower(-1);
//             topRight.setPower(-1);
//             bottomLeft.setPower(-1);
//             bottomRight.setPower(-1);
//             opMode.sleep(100);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             
//             
//             // drop off and bring back down
//             servoArmRight.setPosition(1);
//             armPivot.setPower(0);
//             servoElevator.setPower(-1);
//             servoClawPivot.setPosition(1);
//             opMode.sleep(2950);
//             clawServo.setPosition(1);
//             servoElevator.setPower(0);
//             opMode.sleep(250);
//             servoElevator.setPower(1);
//             opMode.sleep(1950);
//             servoArmRight.setPosition(0);
//             armPivot.setPower(1);
//             servoClawPivot.setPosition(0);
//             servoClawPivot.setPosition(0.5);
//             
//             // Bring back Forward
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             opMode.sleep(timeForOneTile);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             
//             /**
//             for (int i = 0; i <=1; i ++) {
//               //Move left
//                 topLeft.setPower(1);
//                 topRight.setPower(-1);
//                 bottomLeft.setPower(-1);
//                 bottomRight.setPower(1);
//                 opMode.sleep((int)2.25*timeForOneTile);
//                 
//                 // move up
//                 topLeft.setPower(-1);
//                 topRight.setPower(-1);
//                 bottomLeft.setPower(-1);
//                 bottomRight.setPower(-1);
//                 opMode.sleep((int)0.45*timeForOneTile);
//                 
//                 //Move right
//                 topLeft.setPower(-1);
//                 topRight.setPower(1);
//                 bottomLeft.setPower(1);
//                 bottomRight.setPower(-1);
//                 opMode.sleep((int)2.25*timeForOneTile);  
//             }
//             
//             // move towards observation mode
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             opMode.sleep((int)5*timeForOneTile);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             **/
//             
//             // move towards observation mode
//             
//             
//             //Drop a game piece into high basket
//             servoClawPivot.setPower(1);
//             sleep(1300);
//             servoClawPivot.setPower(0);
//             armPivot.setPower(0.8);
//             sleep(1650);
//             armPivot.setPower(0);
//             servoElevator.setPower(1);
//             sleep(1500);
//             servoElevator.setPower(0);
//             topRight.setPower(-1);
//             topLeft.setPower(-1);
//             bottomLeft.setPower(-1);
//             bottomRight.setPower(-1);
//             sleep(220);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             sleep(400);
//             clawServo.setPosition(0.3);
//             sleep(500);
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             sleep(550);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             clawServo.setPosition(0);
//             servoClawPivot.setPower(-1);
//             sleep(1250);
//             servoClawPivot.setPower(0);
//             servoElevator.setPower(-1);
//             sleep(1500);
//             servoElevator.setPower(0);
//             armPivot.setPower(-0.8);
//             sleep(1200);
//             armPivot.setPower(0);
//             
//             /**
//             topLeft.setPower(-1);
//             topRight.setPower(1);
//             bottomLeft.setPower(-1);
//             bottomRight.setPower(1);
//             sleep(1000);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             sleep(100);
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             sleep(300);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             sleep(50);
//             topLeft.setPower(1);
//             topRight.setPower(-1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(-1);
//             sleep(350);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             clawServo.setPosition(0.3);
//             sleep(400);
//             clawServo.setPosition(0);
//             sleep(100);
//             topLeft.setPower(-1);
//             topRight.setPower(-1);
//             bottomLeft.setPower(-1);
//             bottomRight.setPower(-1);
//             sleep(1000);
//             topLeft.setPower(1);
//             topRight.setPower(-1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(-1);
//             
//             
//             
//             
//             
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             sleep(3000);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             servoClawPivot.setPower(1);
//             sleep(1500);
//             servoClawPivot.setPower(0);
//             armPivot.setPower(0.8);
//             sleep(1650);
//             armPivot.setPower(0);
//             servoElevator.setPower(1);
//             sleep(1500);
//             servoElevator.setPower(0);
//             topRight.setPower(-1);
//             topLeft.setPower(-1);
//             bottomLeft.setPower(-1);
//             bottomRight.setPower(-1);
//             sleep(205);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             //servoClawPivot.setPosition(0.2);
//             sleep(400);
//             clawServo.setPosition(0.3);
//             sleep(500);
//             topLeft.setPower(1);
//             topRight.setPower(1);
//             bottomLeft.setPower(1);
//             bottomRight.setPower(1);
//             sleep(500);
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             clawServo.setPosition(0);
//             **/
//             
//             
//             /**
//             topLeft.setPower(0);
//             topRight.setPower(0);
//             bottomLeft.setPower(0);
//             bottomRight.setPower(0);
//             **/
//             telemetry.addData("Status", "Running");
//             telemetry.update();
//             
//             
//             
//             
//             
//           
// 
//         }
//     }
// }
// 
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//hello, i am test. dont remove me pls - ok, now u can
/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="DriverControlled13475", group="LinearOpMode")
//@Disabled
public class DriverControlled13475 extends LinearOpMode {

    // Declare OpMode members.
    //private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor landerRiser = null;

    private DcMotor spinnyArmExt = null;
    private DcMotor spinnyArmTilt1 = null;
    private DcMotor spinnyArmTilt2 = null;


    //following is tbt:
    private CRServo spinner1 = null;
    private CRServo spinner2 = null;


    @Override
    public void runOpMode() {
        setUp();
        int spinnerCount==0;
        boolean flipperCount=false;



        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //motors

            float driveLeft = gamepad1.left_stick_y;
            float driveRight  =  gamepad1.right_stick_y;
            float landerRiserpwr = gamepad1.left_trigger-gamepad1.right_trigger;

            float spinnyArmExtpwr=gamepad2.right_trigger-gamepad2.left_trigger;

            while(gamepad2.dpad_down){
                spinnyArmTilt1.setPower(-.3);
                spinnyArmTilt2.setPower(-.3);
            }
            while (gamepad2.dpad_up){
                spinnyArmTilt1.setPower(.3);
                spinnyArmTilt2.setPower(.3);
            }
            if(!(gamepad2.dpad_up || gamepad2.dpad_down))
            {
                spinnyArmTilt1.setPower(0);
                spinnyArmTilt2.setPower(0);
            }


            leftDrive.setPower(driveLeft);
            rightDrive.setPower(driveRight);
            landerRiser.setPower(landerRiserpwr);

            spinnyArmExt.setPower(spinnyArmExtpwr);


           //servos code


            //spinner (i realized this isn't what tager wants but ill fix later)
            if(gamepad2.right_bumper){//spin in

                    spinner2.setPower(0);
                    spinner1.setPower(1);

            }
            if(gamepad2.left_bumper)
            {
                spinner2.setPower(1);
                spinner1.setPower(0);
            }
            
            if(gamepad2.x){//remember to  set spinnerCount. This setup assumes setting power keeps power set 
while(gamepad1.a);//this keeps number from increasing more than one
spinnerCount++;
if(spinnerCount==0){//spin in
spinner2.setPower(0);
spinner1.setPower(1);
spinnerCount=1;
}
else if(spinnerCount==1){//spin stop
spinner2.setPower(.5);
spinner1.setPower(.5);
spinnerCount=2;
}
else if(spinnerCount==2){//spin out
spinner2.setPower(1);
spinner1.setPower(0);
spinnerCount=0;
}











            //feedback();
        }
    }
    private void setUp(){
        //telemetry.addData("Status", "Initializing. Or is it?");
        //telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        landerRiser = hardwareMap.get(DcMotor.class, "lander_riser");

        spinnyArmExt = hardwareMap.get(DcMotor.class, "spinny_arm_ext");
        spinnyArmTilt1 = hardwareMap.get(DcMotor.class, "spinny_arm_tilt1");
        spinnyArmTilt2 = hardwareMap.get(DcMotor.class, "spinny_arm_tilt2");


        spinner1 = hardwareMap.get(CRServo.class, "spinner1");
        spinner2 = hardwareMap.get(CRServo.class, "spinner2");




        spinnyArmExt.setDirection(DcMotor.Direction.REVERSE);
        spinnyArmTilt1.setDirection(DcMotor.Direction.FORWARD);
        spinnyArmTilt2.setDirection(DcMotor.Direction.FORWARD);
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //runtime.reset();
    }
    private void feedback(){            // Show the elapsed game time and wheel power.
        //telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftDrive, rightDrive);
        //telemetry.update();
    }
}

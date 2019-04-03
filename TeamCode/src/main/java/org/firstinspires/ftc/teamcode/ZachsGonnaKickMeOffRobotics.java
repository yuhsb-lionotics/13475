package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="DriverControlled13475", group="LinearOpMode")

public class ZachsGonnaKickMeOffRobotics extends LinearOpMode {

    private DcMotor rightDrive = null;
    private DcMotor leftDrive = null;
    private DcMotor landerRiserA = null;
    private DcMotor landerRiserB = null;
    private DcMotor spinnyArmExt = null;
    private DcMotor spinnyArmTiltA = null;
    private DcMotor spinnyArmTiltB = null;
    private CRServo spinnerA = null;
    private CRServo spinnerB = null;
    private Servo dumperA = null;
    private Servo dumperB = null;
    private Servo flippy = null;


}
    @Override
    public void runOpMode() {
        setUp();
        boolean flipperCount= false;
        int spinnerCount = 0;

        while(opModeIsActive()) {

            float driveLeft = gamepad1.left_stick_y;
            float driveRight = gamepad1.right_stick_y;
            float landerRiserpwr = gamepad1.left_trigger - gamepad1.right_trigger;
            float spinnyArmExtpwr = gamepad2.right_trigger - gamepad2.left_trigger;

            while (gamepad2.dpad_down) {
                spinnyArmTiltA.setPower(-.5);
                spinnyArmTiltB.setPower(-.5);
                spinnyArmExt.setPower(-.11);
            }
            while (gamepad2.dpad_up) {
                spinnyArmTiltA.setPower(.5);
                spinnyArmTiltB.setPower(.5);
                spinnyArmExt.setPower(.11);

            }
            if (!(gamepad2.dpad_up || gamepad2.dpad_down)) {
                spinnyArmTiltA.setPower(0);
                spinnyArmTiltB.setPower(0);
                spinnyArmExt.setPower(0);

            }

            leftDrive.setPower(driveLeft);
            rightDrive.setPower(driveRight);
            landerRiserA.setPower(landerRiserpwr);
            landerRiserB.setPower(landerRiserpwr);
            spinnyArmExt.setPower(spinnyArmExtpwr);
            
            
            if (gamepad2.x) {
                    spinnerB.setPower(-1);
                    spinnerA.setPower(1);
                    spinnerCount = 1;
                } else if (gamepad2.a) {
                    spinnerB.setPower(0);
                    spinnerA.setPower(0);
                    spinnerCount = 2;
                } else if (gamepad2.b) {
                    spinnerA.setPower(1);
                    spinnerB.setPower(-1);
                    spinnerCount = 0;
                }
            
             if (gamepad2.right_bumper) {
                dumperA.setPosition(.5);
                dumperB.setPosition(.5);
            }
            if (gamepad2.left_bumper) {
                dumperA.setPosition(.002);
                dumperB.setPosition(.002);
            }
            
             if (gamepad2.y) {

                if (flipperCount == false) {
                    flippy.setPosition(0);
                    flipperCount = true;
                } else if (flipperCount == true) {
                    flippy.setPosition(1);
                    flipperCount = false;
                }
            }
            
        }
    }

    private void setUp(){


        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        landerRiserA = hardwareMap.get(DcMotor.class, "landerRiserA");
        landerRiserB = hardwareMap.get(DcMotor.class, "landerRiserB");

        spinnyArmExt = hardwareMap.get(DcMotor.class, "spinnyArmExt");
        spinnyArmTiltA = hardwareMap.get(DcMotor.class, "spinnyArmTileA");
        spinnyArmTiltB = hardwareMap.get(DcMotor.class, "spinnyArmTIleB");

        spinnerA = hardwareMap.crservo.get("spinnerA");
        spinnerB = hardwareMap.crservo.get("spinnerB");
        dumperA = hardwareMap.servo.get("dumperA");
        dumperB = hardwareMap.servo.get("dumperB");
        flippy = hardwareMap.servo.get("flippity_flip_flip");

        spinnyArmExt.setDirection(DcMotor.Direction.REVERSE);
        spinnyArmTiltA.setDirection(DcMotor.Direction.FORWARD);
        spinnyArmTiltB.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
    }

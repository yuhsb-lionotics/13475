package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="DriverControlled13475", group="LinearOpMode")

public class ZachsGonnaKickMeOffRobotics {

    private DcMotor rightDrive = null;
    private DcMotor leftDrive = null;
    private DcMotor landerRiserA = null;
    private DcMotor landerRiserB = null;
    private DcMotor spinnyArmExt= null;
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

        while (opModeIsActive)
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
        dumperA = hardwareMap.crservo.get("dumperA");
        dumperB = hardwareMap.crservo.get("dumperB");
        flippy = hardwareMap.crservo.get("flippity_flip_flip");
    }
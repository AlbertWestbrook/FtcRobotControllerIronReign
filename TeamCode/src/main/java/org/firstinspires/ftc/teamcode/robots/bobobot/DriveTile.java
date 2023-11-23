package org.firstinspires.ftc.teamcode.robots.bobobot;

import org.firstinspires.ftc.robotcore.external.Telemetry;

class DriveTile extends Assign {
    private Autobot autobot;

    private double tiles;
    private double delta;

    // negative tiles means going backwards
    public DriveTile(Autobot autobot, double tiles){

        this.autobot = autobot;
        this.tiles = tiles;
        delta = autobot.drive.getMotorAvgPosition() + Math.abs(tiles*TICKSPERTILE);
    }
    @Override
    public boolean run(){
        if(autobot.drive.getMotorAvgPosition() < delta){
            autobot.drive.mecanumAuto(tiles/Math.abs(tiles)*MAXMOTORSPEED, 0, 0);
            return true;
        }
        else{
            autobot.drive.turnOffMotors();
            return false;
        }
    }

}
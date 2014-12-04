package sk.gpm.robotika.blackline;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class Robot {
	int lines = 0;
	EV3LargeRegulatedMotor lMotor, rMotor;
	EV3ColorSensor sensor;
	public Robot(Port lMotorPort, Port rMotorPort, Port sensorPort) {
		lMotor = new EV3LargeRegulatedMotor(lMotorPort);
		rMotor = new EV3LargeRegulatedMotor(rMotorPort);
		lMotor.setSpeed(2000);
		rMotor.setSpeed(2000);
		sensor = new EV3ColorSensor(sensorPort);
	}
	
	void run() {
		while (Button.ESCAPE.isUp()) {
			goWhite();
			lines++;
			LCD.drawString(new Integer(lines).toString(), 0, 0);
			goBlack();
		}
		lMotor.close();
		rMotor.close();
		sensor.close();
	}
	
	void goWhite() {
		goWhile(Color.WHITE);
	}
	void goBlack() {
		goWhile(Color.BLACK);
	}
	
	void goWhile(int c) {
		for (int surfaceColor = sensor.getColorID(); surfaceColor == c; surfaceColor = sensor.getColorID()) {
			lMotor.forward();
			rMotor.forward();
		}
	 }
}

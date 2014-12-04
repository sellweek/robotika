package sk.gpm.robotika.blackline;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class BlackLine {
	
	public static void main(String[] args) {
		Robot r = new Robot(MotorPort.B, MotorPort.C, SensorPort.S4);
		r.run();
	}
}

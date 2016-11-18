public class Odometry {
	private static final double turnTimeMSecs = 400;
	public static void setLeftMotor(int power) {
		//magic
	}
	public static void setRightMotor(int power) {
		//magic
	}
	public static void setMotorsForTime(int leftPow, int rightPow, int msecs) {
		long time0 = System.currentTimeMillis();
		while ((System.currentTimeMillis() - time0) < msecs) {
			setLeftMotor(leftPow);
			setRightMotor(rightPow);
		}
		//stop both motors
		setLeftMotor(0);
		setRightMotor(0);
	}
	public static void turnLeft90() {
		setMotorsForTime(-100, 100, 400);
	}
	public static void turnRight90() {
		setMotorsForTime(100, -100, 400);
	}
    // Correct
	public static void driveCircle() {
		//let it go for 10s
		setMotorsForTime(20, 100, 10000);
	}
    // Correct
	public static void driveSquare() {
		for (int i = 0; i < 4; i++) {
			setMotorsForTime(100, 100, 2000);
			turnLeft90();
		}
	}
    
    // Please put a space between your "//"'s and your words
	public static void driveSineWave() {
		//d/dt sint = cost
		//so velocity(t) = acos(bt)
		//let the period of the cos wave be 5 seconds (5000 msecs)
		//--> b = 2π / 5000
		//let the amplitude of cos wave (top speed) be 100 motor power
		//--> a = 100
		//--> v(t) = 100cos((2π/5000)t), where t is msecs elapsed
		long time0 = System.currentTimeMillis();
		while (true) {
			long currTime = System.currentTimeMillis();
			int pow = (int)(100 * Math.cos(currTime * 2*Math.PI / 5000));
			setLeftMotor(pow);
			setRightMotor(pow);
		}
	}
}

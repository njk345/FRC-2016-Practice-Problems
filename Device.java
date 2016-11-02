public class Device {
	private double current, voltage, power;
	public Device(double current, double voltage) {
		this.current = current;
		this.voltage = voltage;
		this.power = this.current * this.voltage;
	}
	public double getCurrent() {
		return current;
	}
	public double getVoltage() {
		return voltage;
	}
	public double getPower() {
		return power;
	}
}
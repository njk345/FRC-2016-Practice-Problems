// Battery should only have charge and voltage.
public class Battery {
	private double capacity, voltage, charge; // Nice privacy control
	public Battery(double capacity, double voltage) {
		this.capacity = capacity;
		this.voltage = voltage;
		this.charge = this.capacity * this.voltage;
	}
	public double getCapacity() {
		return capacity;
	}
	public double getVoltage() {
		return voltage;
	}
	public double getCharge() {
		return charge;
	}
}

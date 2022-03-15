package org.allvehicle;

import org.twowheeler.TwoWheller;
import org.threewheeler.ThreeWheeler;
import org.fourwheeler.FourWheeler;
public class Vehicle {

	public void VehicleNecessery() {
		System.out.println("VehicleNecessery");
	}
	public static void main(String args[]) {
		Vehicle a = new Vehicle();
		a.VehicleNecessery();
		TwoWheller b = new TwoWheller();
		b.bike();
		b.cycle();
		ThreeWheeler c = new ThreeWheeler();
		c.Auto();
		FourWheeler d = new FourWheeler();
		d.car();
		d.bus();
		d.lorry();				
	}

}

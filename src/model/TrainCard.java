/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */
package model;

public class TrainCard{
	private TrainColor color;
	private TrainType type;

	public TrainCard(int pos){
		this.color = TrainColor.values()[pos];
		this.type = TrainType.values()[pos];
	}
	public TrainColor getColor() { return this.color; }
	public TrainType getType() {return this.type; }

	@Override
	public boolean equals(Object x){
		if(!(x instanceof TrainCard))
		{ return false; }
		TrainCard y = (TrainCard) x;
		if(this.color == y.color)
		{ return true; }
		return false;
	}
}
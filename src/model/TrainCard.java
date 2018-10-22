package model;
//
	public class TrainCard{
	private TrainColor color;
	private TrainType type;

	TrainCard(int pos){
		this.color = TrainColor.values()[pos];
		this.type = TrainType.values()[pos];
	}
	public TrainColor getColor() { return this.color; }
	public TrainType getType() {return this.type; }
}
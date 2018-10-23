package model;

	public class TrainCard{
	private TrainColor color;
	private TrainType type;

	TrainCard(int pos){
		this.color = TrainColor.values()[pos];
		this.type = TrainType.values()[pos];
	}
	public TrainColor getColor() { return this.color; }
	public TrainType getType() {return this.type; }

	@override
	public Boolean equals(Object x){
		if(!(x instanceof TrainCard))
			return false;
		TrainCard y = (TrainCard) x;
		if(this.color == y.color)
			return true;
		return false;
	}
}
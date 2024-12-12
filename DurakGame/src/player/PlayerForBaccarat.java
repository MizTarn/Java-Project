package player;

public class PlayerForBaccarat extends BasePlayer{
	public PlayerForBaccarat() {
		super();
	}
	
	
	public int getScore(){
        return this.getHand().getCardsInHand().score();
    }
}

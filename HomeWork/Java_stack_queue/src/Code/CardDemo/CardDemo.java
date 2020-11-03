package Code.CardDemo;

import javax.smartcardio.Card;
import java.util.List;

class card{
    protected  int rank;  //牌数
    protected String suit;  //花色
    public card(int rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
public class CardDemo {

    public void buyCard(){  //买牌,四种花色，每种13张

    }

    public void shuffle(List<card> cards) {  //打乱顺序，交换

    }

    public static void main(String[] args) {

    }
}

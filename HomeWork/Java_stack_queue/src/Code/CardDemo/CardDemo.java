package Code.CardDemo;

import javax.smartcardio.Card;
import java.util.ArrayList;
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
        return String.format("[%s,%d]",suit,rank);
    }
}
public class CardDemo {
    public static final String[] SUITS = {"♥","♦","♣","♠"};

    public static List<card> buyCard(){  //买牌,四种花色，每种13个
        List<card> cards = new ArrayList<>(52);
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                int rank = j;
                card card = new card(rank,suit);
                cards.add(card);
            }
        }
       return cards;
    }

    public static void shuffle(List<card> cards) {  //打乱顺序，交换  洗牌
       long random = System.currentTimeMillis();   //产生随机数
        for (int i = cards.size() - 1; i > 0; i--) {
            int ran = Math.abs((int)random % (52 - 1) + 1);    //随机数
            swap(cards,i,ran);
        }
    }

    private static void swap(List<card> cards, int i, int ran) {
        card temp = cards.get(i);
        cards.set(i,cards.get(ran));
        cards.set(ran,temp);
    }


    public static void main(String[] args) {
        List<card> cardList = buyCard();  //买一副牌
        System.out.println("买回来的牌");
        System.out.println(cardList);
        shuffle(cardList);  //洗牌
        System.out.println("洗好的牌");
        System.out.println(cardList);
        //三个人，给每个人五张牌
        List<List<card>> hands = new ArrayList<>();
        List<card> card1 = new ArrayList<>();
        List<card> card2 = new ArrayList<>();
        List<card> card3 = new ArrayList<>();
        //添加到hands中
        hands.add(card1);
        hands.add(card2);
        hands.add(card3);
        //每人摸一张，轮流摸五次
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
              hands.get(j).add(cardList.remove(0));  //每次都取牌堆的牌
            }
        }
        System.out.println("剩余的牌");
        System.out.println(cardList);
        System.out.println("第一个人手上的牌");
        System.out.println(hands.get(0));
        System.out.println("第二个人手上的牌");
        System.out.println(hands.get(1));
        System.out.println("第三个人手上的牌");
        System.out.println(hands.get(2));
    }
}

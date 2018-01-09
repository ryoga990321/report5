package jp.ac.uryukyu.ie.e175749;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing{
    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    public void wounded(int damage){
        int instead=getHitPoint();
        instead -= damage;
        if( instead <= 0 ) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
        setHitPoint(instead);
    }

    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        double critical=Math.random();
        if (isDead() == false) {
            if (damage==0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }else if (critical<=0.4){
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage*2);
                opponent.wounded(damage*2);
            }else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }
        }
    }
}

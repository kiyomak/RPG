/* Lesson2_Chapter17 提出課題：オブジェクト指向 
 ・Libingクラスを継承した抽象クラス Human  
 ・クラスBrave, Fighter, Wizardのスーパークラス  
 
 --仕様--
 1. basesパッケージ内に作成。
2. 引数をname, weapon の 2つとするコンストラクタを作成。その際、Livingクラスで定義したコンストラクタを利用すること。
3. attackメソッドをオーバーライドする。その際、コメント文の内容を実装する。
  3-1. 引数でもらった Living型のtargetインスタンスを攻撃する相手のインスタンスとする。
  3-2. Diceクラスを利用して1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージ値（整数）とする。
  3-3. 攻撃されたtargetの持つHPをダメージ分だけ減らす。
  3-4. 人間の場合は、攻撃を仕掛けた際に　自分の攻撃力も1だけ減るとする。
  3-5. コンソールに、以下のようにステータス文字列（〇〇は人間の名前、✕✕は人間の武器の名前、△△はtargetの名前、▲▲はダメージ値）を表示する。
　　　　「〇〇」が「✕✕」で攻撃！「△△」に▲▲のダメージを与えた。
　　　　　しかし自分の攻撃力も1減少した。
 */

package bases;
//サイコロを乱数で出す。
import utils.Dice;

// Livingクラスを継承した、人間を表現する抽象クラスを作成
public abstract class Human extends Living {
	
	//　コンストラクタを定義
	public Human(String name, String weapon) {
		// Livingクラスで定義したコンストラクタを利用する
		// スーパークラスのコンストラクタ呼び出し⇒ super();
		super(name, weapon);
		
	}
	
	//　attackメソッドのオーバーライド
	@Override
	public void attack( Living target ) {
		//引数targetをMonsterのインスタンスとする
		// 1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージとする
		//Diceクラスのgetメソッドを使う
		int num = Dice.get(1, 10);
		int damage = num * super.offensive;  //Livingクラスの攻撃力(offensive)フィールドを利用
		// 相手のHPをダメージ値だけ減らす
		target.hp = target.hp - damage;
		// 自分の攻撃力を1だけ減らす
	
		//なんか違う気がする！！！
		super.offensive = super.offensive - 1;
		
		// コンソールにステータスを表示
		System.out.println( "「" + this.name + "」が「" + this.weapon + "」で攻撃！「" + target.name +"」に" +  damage + "のダメージを与えた。" );
		System.out.println( "しかし自分の攻撃力も1減少した。" );
		
	}

}

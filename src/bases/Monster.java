/* Lesson2_Chapter17 提出課題：オブジェクト指向 
 ・Libingクラスを継承した抽象クラス  Monster
  ・Monsterクラスのスーパークラス：Livingクラス
 ・クラスSlime, Oak, Dragonのスーパークラス  
 --仕様--
1. basesパッケージ内に作成。
2. 引数をname, weapon の 2つとするコンストラクタを作成。その際、Livingクラスで定義したコンストラクタを利用。
3. attackメソッドをオーバーライドします。その際、コメント文の内容を実装。
  3-1. 引数でもらった Living型のtargetインスタンスを攻撃する相手のインスタンスとする。
  3-2. Diceクラスを利用して1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージ値（整数）とする。
  3-3. 攻撃されたtargetの持つHPをダメージ分だけ減らす
  3-4. コンソールに、以下のようにステータス文字列（〇〇はモンスターの名前、✕✕はモンスターの武器の名前、△△はtargetの名前、▲▲はダメージ値）を表示する
　　　　「〇〇」が「✕✕」で攻撃！「△△」に▲▲のダメージを与えた。 */

package bases;

import utils.Dice;

// モンスターを表現する抽象クラス
public abstract class Monster extends Living {

	// コンストラクタ
	public Monster(String name, String weapon) {
		// Livingクラスで定義したコンストラクタを利用する
		// スーパークラスのコンストラクタ呼び出し⇒ super();
		super(name, weapon);
	}

	// attackメソッドのオーバーライド
	@Override
	public void attack(Living target) {
		//引数targetをHumanのインスタンスとする
		// 1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージとする
		//Diceクラスのgetメソッドを使う
			int num = Dice.get(1, 10);
			int damage = num * super.offensive;  //Livingクラスの攻撃力(offensive)フィールドを利用
		// 相手のHPをダメージ値だけ減らす
			target.hp = target.hp - damage;
		// コンソールにステータスを表示
			System.out.println( "\n「" + this.name + "」が「" + this.weapon + "」で攻撃！「" + target.name +"」に" +  damage + "のダメージを与えた。" );
		
	}
}
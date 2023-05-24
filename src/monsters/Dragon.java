/* Lesson2_Chapter17 提出課題：オブジェクト指向 
 ・Monsterクラスを継承した抽象クラス  Dragon(ドラゴン)  
 ・Dragonクラスのスーパークラス：LivingクラスとMonsterクラス
--仕様--
1. monstersパッケージ内に作成する。
2. Monsterクラスを継承する。
3. 引数にname, weaponの2つだけを持つコンストラクタを定義する。
4. コンストラクタの中で、name, weaponの値を設定するために、Monsterクラスに定義したコンストラクタを利用する。
5. コンストラクタの中で、ヒットポイントの値は乱数を振って決定。
6. コンストラクタの中で、攻撃力の値は乱数を振って決定。 */

package monsters;

import bases.Monster;
import utils.Dice;
// Monsterクラスを継承
public class Dragon extends Monster {
	//コンストラクタを定義（name、weaponの2つだけ）
	public Dragon( String name, String weapon ) {
		//　Monsterクラスのコンストラクタを利用する
		super(name, weapon);
	
	//ヒットポイントの値を乱数で決定。270～330
	//スーパークラスLivingのフィールド変数hpに代入
	super.hp = Dice.get(270, 330);
	
	//攻撃力の値を乱数で決定。12～18
	//スーパークラスLivingのフィールド変数offensiveに代入
	super.offensive = Dice.get(12, 18);
	
	}

}

/* Lesson2_Chapter17 提出課題：オブジェクト指向 
 ・Monsterクラスを継承した抽象クラス  Slime(スライム)  
  ・Slimeクラスのスーパークラス：LivingクラスとMonsterクラス
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
// Monsterクラスを継承するのを忘れない
public class Slime extends Monster {
	//コンストラクタ定義する
	public Slime(String name, String weapon) {
		// Monsterクラスのコンストラクタを利用
		super(name, weapon);
	
		//ヒットポイントの値を乱数で決定する。70～130
		//スーパークラスLivingのフィールド変数hpに代入する
		super.hp = Dice.get(70, 130);
		
		//攻撃力の値を乱数で決定する。5～11
		//スーパークラスLivingのフィールド変数offensiveに代入する
		super.offensive = Dice.get(5, 11);
	}
}

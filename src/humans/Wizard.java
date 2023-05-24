/* Lesson2_Chapter17 提出課題：オブジェクト指向
・Humanクラスを継承した抽象クラス  Wizard(魔法使い)  
 ・Wizardクラスのスーパークラス：LivingクラスとHumanクラス
--仕様--
1. humansパッケージ内に作成。
2. Humanクラスを継承する。
3. 引数にname, weaponの2つだけを持つコンストラクタを定義する。
4. コンストラクタの中で、name, weaponの値を設定するために、Humanクラスに定義したコンストラクタを利用する。
5. コンストラクタの中で、ヒットポイントの値は乱数を振って決定する。
6. コンストラクタの中で、攻撃力の値は乱数を振って決定する。*/

package humans;

import bases.Human;
import utils.Dice;
//Humanクラスを継承する
public class Wizard extends Human {
	//コンストラクタ(初期化設定)
	public Wizard(String name, String weapon) {
		//Humanクラスのコンストラクタを利用する
		super(name, weapon);
		
		//ヒットポイントの値は乱数を振って決定する。120~180
		// スーパークラスLivingのフィールド変数hpに代入
		super.hp = Dice.get(120, 180);
		
		//攻撃力の値は乱数を振って決定する。12~18
		// スーパークラスLivingのフィールド変数offensiveに代入
		super.offensive = Dice.get(12, 18);
		
	}
	
}

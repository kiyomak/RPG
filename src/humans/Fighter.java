/* Lesson2_Chapter17 提出課題：オブジェクト指向
・Humanクラスを継承した抽象クラス  Fighter(戦士)  
 ・Fighterクラスのスーパークラス：LivingクラスとHumanクラス
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
//Humanクラスを継承
public class Fighter extends Human {
	//コンストラクタ(初期化設定)
	public Fighter(String name, String weapon) {
		//Humanクラスのコンストラクタを利用する
		super(name, weapon);
		
		//ヒットポイントの値は乱数を振って決定する。240～300
		// スーパークラスLivingのフィールド変数hpに代入
		super.hp = Dice.get(240, 300);
		
		//攻撃力の値は乱数を振って決定する。17～23
		// スーパークラスLivingのフィールド変数offensiveに代入
		super.offensive = Dice.get(17, 23);
	}
}

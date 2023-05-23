/* Lesson2_Chapter17 提出課題：オブジェクト指向
・Humanクラスを継承した抽象クラス  Brave(勇者)  

--仕様--
1. humansパッケージ内に作成。
2. Humanクラスを継承する。
3. 引数にname, weaponの2つだけを持つコンストラクタを定義する。
4. コンストラクタの中で、name, weaponの値を設定するために、Humanクラスに定義したコンストラクタを利用する。
5. コンストラクタの中で、ヒットポイントの値は乱数を振って決定する。
6. コンストラクタの中で、攻撃力の値は乱数を振って決定する。

*/

package humans;

import bases.Human;
//乱数用
import utils.Dice;
//Humanクラスを継承
public class Brave extends Human {

	//コンストラクタ
	public Brave(String name, String weapon) {
		//Humanクラスのコンストラクタを利用する
		super(name, weapon);
		
		//ヒットポイントの値は乱数を振って決定する。170~230
		int hitpoint = Dice.get(170, 230);
		
		//攻撃力の値は乱数を振って決定する。7~13
		int offensive = Dice.get(7, 13);
		
	}
	
}

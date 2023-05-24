/* Lesson2_Chapter17 提出課題：オブジェクト指向
 固定コード。書き換え不可 */

package utils;

import java.util.Random;

// 乱数を作成する便利なクラス
public class Dice {
	// 乱数インスタンスの生成
	private static Random r = new Random();

	// minからmaxまでの間で整数値のサイコロを振り、その値を戻り値とするメソッド
	public static int get(int min, int max) {
		/* .nextInt(引数)メソッドは、0から引数に指定した値【未満】の整数をかえす。
		 * (例)Humanクラスの1～10までのサイコロの場合、
		 * 		Dice.get(1, 10); ⇒　nextInt( 10 - 1 + 1 )なのでnextInt(10)→　0～9までの整数を取得する。
		 * 		0以外で始める場合は、「nextInt() + 始めたい値;」という形で加算するため、サイコロの場合はmin=1 がプラスされて、nextInt(10)→ 1~10までの整数を取得する。
		 * 		ランダムクラスがインスタンス化された変数rのnextInt()メソッドであるため、1～10までの中のどれか1つがランダムで返される。
		 * 「nextInt() + min;」で最小値から始めるので、攻撃力やhpなどでも最小値から指定できる。		*/
		return r.nextInt(max - min + 1) + min;
	}
}
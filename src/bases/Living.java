/* Lesson2_Chapter17 提出課題：オブジェクト指向
 固定コード。書き換え不可
 ・全ての生物全般を表現するスーパークラス（抽象クラス）
 
 [仕様]
 1. basesパッケージ内に作成します。
2. フィールド変数には name（名前）, weapon（武器名）, hp（ヒットポイント）, offensive（攻撃力） の4つを用意し、すべてprotected 宣言します。
3. 各フィールド変数に対してセッターゲッターを作ります。
4. nameとweaponの2つのフィールド変数のみ値を初期セットするコンストラクタを作成します。
5. ターゲットに攻撃する attackという名前の抽象メソッドを定義します。継承したクラスでオーバーライドします。
6. Java APIで用意されているすべてのクラスのスーパークラスである Object クラスに定義された toStringメソッドをオーバーライドし、
	自分自身の内容を適切に表現する文字列を戻り値とするようにカスタマイズします。ヒットポイントが50以下の場合は、警告分も含みます。
 
  */

package bases;

// 生物を表現する抽象クラス
public abstract class Living {
	// フィールド
	//現在のクラスと子クラスからアクセス可能
	protected String name; // キャラクターの名前
	protected String weapon; // 武器名
	protected int hp; // ヒットポイント（生命力）
	protected int offensive; // 攻撃力

	// コンストラクタ
	public Living(String name, String weapon) {
		this.name = name;
		this.weapon = weapon;
	}

	// ゲッター、セッター
	//name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//weapon
	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	//hp
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	//offensive
	public int getOffensive() {
		return offensive;
	}

	public void setOffensive(int offensive) {
		this.offensive = offensive;
	}

    // ターゲットに攻撃する抽象メソッド
	public abstract void attack(Living target); 

	// 自分自身を表現する文字列のオーバーライド
	// publicなのでどこからでもアクセスできる。
	@Override
	public String toString() {
		String alert = "";
		if (this.hp <= 50) {
			alert = "★ HP残りわずか！アブナイ";
		}
		return String.format("[名前]: %s, [ヒットポイント]: %d, [攻撃力]: %d %s", this.name, this.hp, this.offensive, alert);
	}

}

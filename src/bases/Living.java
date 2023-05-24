/* Lesson2_Chapter17 提出課題：オブジェクト指向
 固定コード。書き換え不可
 ・全ての生物全般を表現するスーパークラス（抽象クラス） */

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
	@Override
	public String toString() {
		String alert = "";
		if (this.hp <= 50) {
			alert = "★ HP残りわずか！アブナイ";
		}
		return String.format("[名前]: %s, [ヒットポイント]: %d, [攻撃力]: %d %s", this.name, this.hp, this.offensive, alert);
	}

}

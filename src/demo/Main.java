/* Lesson2_Chapter17 提出課題：オブジェクト指向 
・Humanのサブクラス（Brave,Fighter,Wizard）とMonsterのサブクラス（Slime,Oak,Dragon）をインポートする
・補佐的に3つのメゾッドを作り、利用する。
choiceHuman ... 引数でもらった人間グループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
choiceMonster ... 引数でもらったモンスターグループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
showGroupInfos ... 引数でもらった人間グループリストとモンスターグループリストのそれぞれの情報一覧を表示するメソッド */

package demo;
// ArrayListクラスをインポートする
import java.util.ArrayList;
// Listインターフェースをインポートする
import java.util.List;

//Humanクラスとそのサブクラスをインポートする。HumanクラスはListで必要
import bases.Human;
//Monsterクラスとそのサブクラスをインポートする。MonsterクラスはListで必要
import bases.Monster;
import humans.Brave;
import humans.Fighter;
import humans.Wizard;
import monsters.Dragon;
import monsters.Oak;
import monsters.Slime;
import utils.Dice;

//出力するメインクラス
public class Main {
	public static void main(String[] args) {
		
		System.out.println( "★★ ==== 戦いの開始だ！！ ==== ★★" );

		// Brave（勇者）, Fighter（戦士）, Wizard（魔法使い）クラスの各インスタンスを生成
		//引数に名前、武器名を入れるのを忘れない
		Brave brave = new Brave( "沖田総司", "剣" );
		Fighter fighter = new Fighter( "金太郎", "斧" );
		Wizard wizard = new Wizard( "安倍晴明", "魔法" );
		
		// 人間グループのリストを空で生成
		// リスト型オブジェクト「List<データ型名> オブジェクト名 = new ArrayList<データ型名>();」
		List<Human> humans = new ArrayList<>();
        
		// 勇者、戦士、魔法使いを人間グループのリストに追加
		// オブジェクト名.add(値); 
		humans.add(brave);
		humans.add(fighter);
		humans.add(wizard);

		// Slime（スライム）, Oak（オーク）, Dragon（ドラゴン）クラスの各インスタンスを生成
		//引数に名前、武器名を入れるのを忘れない
		Slime slime = new Slime( "キングスライム", "体当たり" );
		Oak oak = new Oak( "オークキング", "槍" );
		Dragon dragon = new Dragon( "紅龍", "炎" );

		// モンスターグループのリストを空で生成
		List<Monster> monsters = new ArrayList<>();
		
        // スライム、オーク、ドラゴンをモンスターグループのリストに追加
		// オブジェクト名.add(値); 
		monsters.add(slime);
		monsters.add(oak);
		monsters.add(dragon);
		
		// 現在の各グループの状態を一覧表示
		showGroupInfos(humans, monsters);

		// 第何回戦かを示すカウンター変数
		int count = 1;
		
		// 勝敗がつくまで無限ループ
		while (true) {
				// エスケープシーケンス　\n :改行
				// printfメソッドで出力する変数の書式指定子　%d：整数countが入る
			System.out.printf("\n★ 第%d回戦 ==========\n", count);

			System.out.println("\n[人間のターン！]\n");
			// 人間グループから1人選択
			// リストhumansを引数にする。⇒リスト3人が入る。
			Human attackHuman = choiceHuman(humans);
			
			// モンスターグループから1人選択
			// リストmonstersを引数にする。⇒リスト3人が入る。
			Monster defenseMonster =  choiceMonster(monsters);
            
			// 選ばれた人間が、選ばれたモンスターを攻撃
			// Humanクラスを継承していないので、ダウンキャストは出来ない注意
			attackHuman.attack( defenseMonster );
			
			// モンスターのHPが0以下になれば、モンスターは倒れ、そのモンスターをモンスターグループから削除
			if(defenseMonster.getHp() <= 0 ) {
				//「モンスターは倒れた」文言いれる
				System.out.println( "\n★「" + defenseMonster.getName() + "」は倒れた。" );
				//モンスターグループから選ばれていたモンスター（defenseMonsters変数）を削除する。
				// monstersリストのremoveメソッドで（）内の要素を削除
				monsters.remove(defenseMonster);
	
			}
			
			// モンスターグループに誰もいなくなれば、人間グループの勝利
			//リストの要素が0（空）かはsizeメソッドで確認する。size数が0＝要素数0で空
			if(monsters.size() == 0 ) {
				System.out.println( "\n★★ ==== 決着がついた！！ ==== ★★\n" );
				System.out.println("#### 人間達は勝利した！！ ####");
				//while内の処理をここで終了
				break;
				
			}
			
			System.out.println("\n[モンスターのターン！]\n");
			// 人間グループから1人選択
			// リストhumansを引数にする。⇒リスト3人が入る。
			Human defenseHuman = choiceHuman(humans);
			
			// モンスターグループから1人選択
			// リストmonstersを引数にする。⇒リスト3人が入る。
			Monster attackMonster = choiceMonster(monsters);
			
			// 選ばれたモンスターが、選ばれた人間を攻撃
			// Monsterクラスを継承していないので、ダウンキャストは出来ない注意
			attackMonster.attack( defenseHuman );

			// 人間のHPが0以下になれば、人間は倒れ、その人間を人間グループから削除
			if( defenseHuman.getHp() <= 0 ) {
				//「人間は倒れた」文言いれる
				System.out.println("\n★「" + defenseHuman.getName() + "」は倒れた。" );
				//人間グループから選ばれていたdefenseHumanを削除する。
				// humansリストのremoveメソッドで（）内の要素を削除
				humans.remove(defenseHuman);
			}
			
			// 人間グループに誰もいなくなれば、人間グループの敗北
			if( humans.size() == 0 ) {
				System.out.println("★★ ==== 決着がついた！！ ==== ★★\n");
				System.out.println("#### 人間達は負けてしまった！####");
				//while内の処理をここで終了
				break;
			}
			
			// 現在の各グループの状態を一覧表示
			showGroupInfos(humans, monsters);
			
			// ループ変数を1増やす
			count++;
		}

		// 最後に各グループの状態を一覧表示してプログラム終了
		showGroupInfos(humans, monsters);

	}	//mainメソッド終了

	// 引数でもらった人間グループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	// 静的メソッド(static)で、Humanクラス型のメソッドchoiceHuman(引数はhumansリスト)
	public static Human choiceHuman(List<Human> humans) {
		//型はHumanクラス型(初期化で変数nameを継承している)。Listインターフェースにある .get()メソッドを使用
		/* .get()内で、Diceのget(int min, int max)メソッドを呼び出す。  .size()メソッドはListインターフェースのメソッド。リスト内の要素数を返す。
		 * 最小値：0、最大値：2⇒返り値は「 r.nextInt(2 - 0 + 1) + 0;」で要素数3のうち、要素「0，1，2」のどれか1つが返される 		*/
			Human human = humans.get(Dice.get(0, humans.size() - 1));
		//Livingのname変数のgetterメソッドにhumans.get()のランダムで選ばれた要素数が（）に入る。
		System.out.printf("人間グループから 「%s」 のお出ましだ！\n", human.getName());
		//リストから選ばれた要素が返される	
		return human;
	}

	// 引数でもらったモンスターグループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	public static Monster choiceMonster(List<Monster> monsters) {
		Monster monster = monsters.get(Dice.get(0, monsters.size() - 1));
		System.out.printf("モンスターグループから 「%s」 のお出ましだ！\n", monster.getName());
		return monster;
	}

	// 引数でもらった人間グループリストとモンスターグループリストのそれぞれの情報一覧を表示するメソッド
	public static void showGroupInfos(List<Human> humans, List<Monster> monsters) {

		System.out.println("\n## === グループ情報 === ##");
		System.out.printf("# [人間グループ]: %d人\n", humans.size());
		for (Human human : humans) {
			System.out.println(human);
		}

		System.out.printf("\n# [モンスターグループ]: %d人\n", monsters.size());
		for (Monster monster : monsters) {
			System.out.println(monster);
		}
	}
	
	
}

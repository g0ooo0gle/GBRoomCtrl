package gbRoomControl.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * iniファイル操作クラス
 */
public class IniFileUtil {

	/**
	 * デフォルトパス
	 * （カレントディレクトリ
	 */
	private static final String DEFAULT_INIT_FILE_PATH = System.getProperty("user.dir");

	/**
	 * default file name
	 */
	private static final String DEFAULT_INIT_FILE_NAME = "Settings.ini";

	/**
	* プロパティ
	*/
	private static Properties properties = new Properties();

	/**
	 * ファイル名
	 */
	private String fileName;

	/**
	 * path名
	 */
	private String path;

	//	/**
	//	 * ファイル
	//	 */
	//	private  Files files;
	/**
	 * パス
	 */
	Path paths;

	/**
	 * ファイルエンコード
	 */
	private Charset charset = StandardCharsets.UTF_8;

	/**
	 * work
	 */
	File file;

	/**
	 * デフォルト設定ファイル読み込み
	 */
	public IniFileUtil() {
		this(DEFAULT_INIT_FILE_NAME);
	}

	/**
	 * デフォルト設定ファイル読み込み
	 * @param fileName　設定ファイル名
	 */
	public IniFileUtil(String fileName) {
		this(fileName, DEFAULT_INIT_FILE_PATH);
	}

	/**
	 * @param fileName	設定ファイル名
	 * @param path	読み込み先ディレクトリパス
	 */
	public IniFileUtil(String fileName, String path) {
		this.fileName = fileName;
		this.path = path;

		initialize(this.fileName, this.path);
	}

	// 初期処理
	private void initialize(String fileName, String path) {
		StringBuilder buf = new StringBuilder();
		// TODO iniファイル読み込み
		try {
			buf.append(path);
			buf.append(fileName);
			// path生成
			this.paths = Paths.get(buf.toString());
			// load
			properties.load(Files.newBufferedReader(this.paths, charset));

		} catch (Exception e) {
			// 読み込み失敗時
			System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", fileName));
			// 新規作成作る
			try {
				makeFiles(fileName, path);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * プロパティ値を取得する
	 *キーが存在しない場合、空白を返す
	 * @param key キー
	 * @return 値
	 */
	public String getProperty(String key) {
		return getProperty(key, "");
	}

	/**
	 * 設定値を取得する
	 *
	 * @param	key キー
	 * @param	defaultValue デフォルト値
	 * @return	キーが存在しない場合、デフォルト値 / 存在する場合、値
	 */
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	/**
	 * プロパティ値を書き込む
	 * @param key キー
	 * @param value 書き込み値
	 */
	public void setProperty(String key, String value,String comments) {
		properties.setProperty(key, value);
		try {
			properties.store(new FileOutputStream(paths.toString()), comments);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("書き込み失敗");
			e.printStackTrace();
		}
	}

	/**
	 * 空ファイルを作成します
	 * @param fileName
	 * @param path
	 * @throws Exception
	 */
	public void makeFiles(String fileName, String path) throws Exception {
		StringBuilder buf = new StringBuilder();
		buf.append(path);
		buf.append(fileName);

		file = new File(buf.toString());
		//新規ファイル作成
		try {
			if (file.createNewFile()) {
				System.out.println("ファイル新規作成成功");
			} else {
				System.out.println("ファイル新規作成失敗");
			}
		} catch (IOException e) {
			System.out.println("ファイル新規作成例外発生");
			e.printStackTrace();
		}
	}

}

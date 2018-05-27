package gbRoomControl.common;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * iniファイル読み込み
 */
public class IniFileUtil {

	/**
	 * デフォルトパス
	 */
	private static final String DEFAULT_INIT_FILE_PATH = "./";

	/**
	 * default file name
	 */
	private static final String DEFAULT_INIT_FILE_NAME = "Settings.ini";

	private static Properties properties;

	/**
	 * ファイル名
	 */
	private String fileName;

	private String path;

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
			// load
			properties.load(Files.newBufferedReader(Paths.get(buf.toString()), StandardCharsets.UTF_8));

		} catch (Exception e) {
			// 読み込み失敗時
			System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", fileName));
			// TODO あとで新規作成作る
		}

	}

    /**
     * プロパティ値を取得する
     *キーが存在しない場合、空白を返す
     * @param key キー
     * @return 値
     */
    public static String getProperty(String key) {
        return getProperty(key, "");
    }

    /**
     * 設定値を取得する
     *
     * @param	key キー
     * @param	defaultValue デフォルト値
     * @return	キーが存在しない場合、デフォルト値 / 存在する場合、値
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}

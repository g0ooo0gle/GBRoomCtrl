package gbRoomControl.test;

import gbRoomControl.common.IniFileUtil;

public class Loadtest {

	public Loadtest() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			IniFileUtil  iniFileUtil = new IniFileUtil();
			String message;
			message = iniFileUtil.getProperty("marimo");
			if(message == null || message.isEmpty()) {
				System.out.println("新規作成");
				iniFileUtil.setProperty("marimo", "test","mario");
				System.out.println(iniFileUtil.getProperty("marimo"));
			}else {
				System.out.println(message);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

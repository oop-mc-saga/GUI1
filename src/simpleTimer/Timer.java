package simpleTimer;

import java.util.Calendar;
import javax.swing.JLabel;

/**
 * 開始からの時間を表示するJLabel
 *
 * @author tadaki
 */
public final class Timer extends JLabel {

    private Calendar now = null;
    private int max = 80;

    /**
     * コンストラクタ
     */
    public Timer() {
        setMax(max);
    }

    /**
     * スタート
     */
    public void start() {
        now = Calendar.getInstance();//開始時刻を保持
        setVisible(true);
    }

    /**
     * ストップ
     */
    public void stop() {
        setVisible(true);
    }

    /**
     * タイマーの上限設定
     * @param max 
     */
    public void setMax(int max) {
        this.max = max;
        setTimeString(0);
    }

    /**
     * 秒を文字列に変換
     * @param d
     * @return 
     */
    private String mkTimeStr(int d) {
        int m = d / 60;
        int s = d % 60;
        StringBuilder b = new StringBuilder();
        if (m > 0) {
            b.append(m).append(" 分 ");
        }
        b.append(s).append(" 秒");
        return b.toString();
    }

    /**
     * 文字列に変換してラベルへ設定
     * @param d 
     */
    private void setTimeString(int d) {
        StringBuilder b = new StringBuilder();
        b.append(mkTimeStr(d));
        b.append("(max:").append(mkTimeStr(max)).append(")");
        setText(b.toString());
    }

    /**
     * 時刻設定
     * @return 終了時間を過ぎるとfalase
     */
    public boolean setTime() {
        Calendar c = Calendar.getInstance();
        //開始時刻から現在までの秒数
        int d = (int) (c.getTimeInMillis() - now.getTimeInMillis()) / 1000;
        setTimeString(d);
        if (d >= max) {//終了を過ぎている
            return false;
        }
        setVisible(true);
        return true;
    }

}

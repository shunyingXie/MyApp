package timecountUtils;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 计时器
 */
public class TimeCount extends CountDownTimer {

    private Button button;

    public TimeCount(Button btn,long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        button = btn;
    }

    @Override
    public void onTick(long l) {
        button.setClickable(false);
//        button.setBackgroundColor(Color.GRAY);
//            validateCode_btn.setBackgroundResource(R.drawable.buttonstyle);
        button.setText(l/1000 + "秒后重新获取");
    }

    @Override
    public void onFinish() {
        button.setClickable(true);
        button.setText("获取验证码");
    }
}

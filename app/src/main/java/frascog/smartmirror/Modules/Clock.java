package frascog.smartmirror.Modules;

import frascog.smartmirror.MainActivity;

/**
 * Created by frascog on 3/27/16.
 */
public class Clock {

    private MainActivity mainActivity;

    public Clock(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        mainActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Clock.this.mainActivity.updateTime();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
    }
}

package model.algorithm.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created with IntelliJ IDEA.
 * User: chengsiyuan
 * Date: 14-3-20
 * Time: 下午2:33
 * To change this template use File | Settings | File Templates.
 */
public class ProcessKill {

    public static int pid = 0;

    static class TestThread implements Runnable {
        @Override
        public void run() {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            String name = runtime.getName();
            int index = name.indexOf("@");
            if (index != -1) {
                pid = Integer.parseInt(name.substring(0, index));
            }
            int count = 0;
            for (int i = 0; ; i++) {
                count++;
                System.out.println(pid);
                if (count == 10) {
                    KillPro(pid);
                }
            }

        }
    }

    public static void KillPro(int pid) {
        try {
            String cmd = "kill " + String.valueOf(pid);
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        int index = name.indexOf("@");
        if (index != -1) {
            int pppid = Integer.parseInt(name.substring(0, index));
            System.out.print(pppid+"-------------------------");
        }
        Thread thread = new Thread(new TestThread());
        thread.run();


    }
}


package operating_system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RoundRobin extends CPUSchedulingSimulator {
    public RoundRobin(int[] pid, int[] at, int[] bt) {
        super(pid, at, bt);
    }

    public int[][] readyQueue(int quantum) {
//        ShortestJobFirst sjf = new ShortestJobFirst(this.getPid(), this.getAt(), this.getBt());
//        int[][] arr = sjf.readyQueue();

//        ArrayList<Integer> pid = toList(arr[0]);
//        ArrayList<Integer> at = toList(arr[1]);
//        ArrayList<Integer> bt = toList(arr[2]);

        ArrayList<Integer> pidList = toList(this.getPid());
        ArrayList<Integer> atList = toList(this.getAt());
        ArrayList<Integer> btList = toList(this.getBt());

        ArrayList<ArrayList<Integer>> waitingQueue = new ArrayList<>();

        int i = 0, j = 0, size = pidList.size(); boolean running = true;

        while (running) {
            if (btList.get(i) > quantum) {
                int bt_rem = btList.get(i) - quantum; // remaining time for completion

                ArrayList<Integer> process = new ArrayList<>();
                process.add(pidList.get(i));
                process.add(atList.get(i));
                process.add(bt_rem);

                waitingQueue.add(process); // record unfinished processes.
                btList.set(i, quantum);
            } else {
                if (waitingQueue.size() != 0 && j < waitingQueue.size()) {
                    pidList.add(i + 1, waitingQueue.get(j).get(0));
                    atList.add(i + 1, waitingQueue.get(j).get(1));
                    btList.add(i + 1, waitingQueue.get(j).get(2));
                    pln("i: "+i+" | j: "+j);
                    j++;
                }
            }
            if(i == size + waitingQueue.size()) running = false;
            i++;
        }


        return new int[][]{toArray(pidList), toArray(atList), toArray(btList)};
    }

    private ArrayList<Integer> toList(int[] arr) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int item : arr) {
            integers.add(item);
        }
        return integers;
    }

    private int[] toArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    @Override
    public int getNumProcess() {
        return super.getNumProcess();
    }

    @Override
    public int[] getPid() {
        return super.getPid();
    }

    @Override
    public int[] getAt() {
        return super.getAt();
    }

    @Override
    public int[] getBt() {
        return super.getBt();
    }

    @Override
    public int[] waitingTime(int[][] arr) {
        return super.waitingTime(arr);
    }

    @Override
    public double averageWaitingTime(int[] wt) {
        return super.averageWaitingTime(wt);
    }

    @Override
    public int[] turnAroundTime(int[][] arr, int[] wt) {
        return super.turnAroundTime(arr, wt);
    }

    @Override
    public double averageTurnAroundTime(int[] tat) {
        return super.averageTurnAroundTime(tat);
    }

    @Override
    public int[] responseTime(int[][] arr, int[] wt) {
        return super.responseTime(arr, wt);
    }

    @Override
    public double averageResponseTime(int[] rt) {
        return super.averageResponseTime(rt);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}

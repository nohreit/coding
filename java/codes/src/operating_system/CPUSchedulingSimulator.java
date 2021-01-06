package operating_system;


public class CPUSchedulingSimulator implements CPUSchedulingSimulatorInterface {

    private int[] pid;
    private int[] at; // arrival time;
    private int[] bt; // burst time;
    private final int numProcess;

    public CPUSchedulingSimulator(int[] pid, int[] at, int[] bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
        this.numProcess = pid.length;
    }

    public int getNumProcess() {
        return numProcess;
    }

    public int[] getPid() {
        return pid;
    }

    public int[] getAt() {
        return at;
    }

    public int[] getBt() {
        return bt;
    }

    // readyQueue() depends on the type of scheduling

    @Override
    // Wait Time (Current Process) = Wait Time (Previous Process) + Burst Time (Previous Process)
    public int[] waitingTime(int[][] arr) {
        this.at = arr[1]; // Just not to be lost xD
        this.bt = arr[2];
        int[] wt = new int[this.pid.length];

//        wt[0] = 0; // first process waiting time is 0

        for (int i = 1; i < wt.length; i++) {
            wt[i] = this.bt[i - 1] + wt[i - 1];
        }

        return wt;
    }

    private int totalWaitingTime(int[] wt) {
        int sum = 0;
        for (int i : wt) sum += i;
        return sum;
    }

    @Override
    public double averageWaitingTime(int[] wt) {
        return (double) this.totalWaitingTime(wt) / this.numProcess;
    }

    private int totalBurstTime(int[] bt) {
        int sum = 0;
        for (int i : bt) sum += i;
        return sum;
    }

    @Override
    // Turn Around Time () = Burst Time + Waiting Time = Exit Time - Arrival Time
    public int[] turnAroundTime(int[][] arr, int[] wt) {
        this.bt = arr[2];
        int[] tat = new int[this.pid.length];

        for (int i = 0; i < wt.length; i++) {
            tat[i] = this.bt[i] + wt[i];
        }

        return tat;
    }

    private int totalTurnAroundTime(int[] tat) {
        int sum = 0;
        for (int i : tat) sum += i;
        return sum;
    }

    @Override
    public double averageTurnAroundTime(int[] tat) {
        return (double) totalTurnAroundTime(tat) / this.numProcess;
    }

    @Override
    // Response Time = Wait Time - Arrival Time
    public int[] responseTime(int[][] arr, int[] wt) {
        this.at = arr[1];
        int[] rt = new int[this.pid.length];

        for (int i = 0; i < wt.length; i++) {
            rt[i] = wt[i] - this.at[i]; // FIX THIS
        }
        return rt;
    }

    private int totalResponseTime(int[] rt) {
        int sum = 0;
        for (int i : rt) sum += i;
        return sum;
    }

    @Override
    public double averageResponseTime(int[] rt) {
        return (double) totalResponseTime(rt) / this.numProcess;
    }
}

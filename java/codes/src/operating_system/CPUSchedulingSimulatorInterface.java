package operating_system;

public interface CPUSchedulingSimulatorInterface {
//    public int[][] readyQueue();
    public int[] waitingTime(int[][] arr);
    public double averageWaitingTime(int[] wt);
    public int[] turnAroundTime(int[][] arr, int[] wt);
    public double averageTurnAroundTime(int[] tat);
    public int[] responseTime(int[][] arr, int[] wt);
    public double averageResponseTime(int[] rt);
}

package operating_system;

public class FirstComeFirstServed extends CPUSchedulingSimulator{

    public FirstComeFirstServed(int[] pid, int[] at, int[] bt) {
        super(pid, at, bt);
    }

    public int[][] readyQueue() {
        int[][] arr = new int[][]{this.getPid(), this.getAt(), this.getBt()};
        for (int i = 0; i < super.getNumProcess(); i++) {
            for (int j = 0; j < super.getNumProcess() - i - 1; j++) {
                if (arr[1][j] > arr[1][j + 1]) {
                    for (int k = 0; k < arr.length; k++) {
                        int temp = arr[k][j];
                        arr[k][j] = arr[k][j + 1];
                        arr[k][j + 1] = temp;
                    }
                }
            }
        }
        return arr;
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

    @Override
    public int getNumProcess() {
        return super.getNumProcess();
    }
}

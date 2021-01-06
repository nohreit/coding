package operating_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int[][] processes = new int[0][];
        pln("CPU Scheduling Simulator\n\nChoose one CPU Scheduling bellow :");
        boolean cont = true;
        String c;
        ArrayList<String[]> list = null;

        do {
            pln("[F]irst Come First Served\n" +
                    "[S]hortest Job First\n" +
                    "[R]ound Robin\n" +
                    "[Q]uit the simulation\n" +
                    "Input:\t");
            c = new Scanner(System.in).nextLine();
            if (c.equalsIgnoreCase("F") || c.equalsIgnoreCase("S") ||
                    c.equalsIgnoreCase("R") || c.equalsIgnoreCase("Q")) {
                list = readFile();
                processes = toIntArray(list);
                pln("Processes list");
                details(processes);
                cont = false;
            }
            else pln("Wrong input, try again");
        } while (cont);

        if (list.size() != 0) {
            assert processes != null;
            switch (c.toUpperCase()) {
                case "F" -> {
                    pln("First come first served CPU scheduling");
                    firstComeFirstServed(new FirstComeFirstServed(processes[0], processes[1], processes[2]));
                }
                case "S" -> {
                    pln("Shortest Job First CPU scheduling");
                    shortestJobFirst(new ShortestJobFirst(processes[0], processes[1], processes[2]));
                }
                case "R" -> {
                    pln("Round Robin CPU scheduling");
                    roundRobin(new RoundRobin(processes[0], processes[1], processes[2]));
                }
            }
        }else pln("The file is empty");
        pln("\nSimulation Terminated");


    }


    public static void firstComeFirstServed(FirstComeFirstServed fcfs) {
        int[][] arrFcfs = fcfs.readyQueue();

        details(arrFcfs);

        int[] wt = fcfs.waitingTime(arrFcfs);

        p("\nWaiting Times: ");
        for (int w : wt) {
            p(w + " ");
        }

        pln("\nAverage Waiting Time: " + fcfs.averageWaitingTime(wt));

        int[] tat = fcfs.turnAroundTime(arrFcfs, wt);

        p("Turn Around Times: ");
        for (int w : tat) {
            p(w + " ");
        }

        pln("\nAverage Turn Around Time: " + fcfs.averageTurnAroundTime(tat));

        int[] rt = fcfs.responseTime(arrFcfs, wt);

        p("Response Times: ");
        for (int w : rt) {
            p(w + " ");
        }

        pln("\nAverage Response Time: " + fcfs.averageResponseTime(rt));
    }

    public static void shortestJobFirst(ShortestJobFirst sjf) {
        int[][] arrSJF = sjf.readyQueue();

        details(arrSJF);

        int[] wt = sjf.waitingTime(arrSJF);

        p("\nWaiting Times: ");
        for (int w : wt) {
            p(w + " ");
        }

        pln("\nAverage Waiting Time: " + sjf.averageWaitingTime(wt));

        int[] tat = sjf.turnAroundTime(arrSJF, wt);

        p("Turn Around Times: ");
        for (int w : tat) {
            p(w + " ");
        }

        pln("\nAverage Turn Around Time: " + sjf.averageTurnAroundTime(tat));

        int[] rt = sjf.responseTime(arrSJF, wt);

        p("Response Times: ");
        for (int w : rt) {
            p(w + " ");
        }

        pln("\nAverage Response Time: " + sjf.averageResponseTime(rt));
    }

    public static void roundRobin(RoundRobin rr) {
        p("Enter the quantum time: ");
        int quantum = new Scanner(System.in).nextInt();

        int[][] arrRR = rr.readyQueue(quantum);

        details(arrRR);

        int[] wt = rr.waitingTime(arrRR);

        p("\nWaiting Times: ");
        for (int w : wt) {
            p(w + " ");
        }

        pln("\nAverage Waiting Time: " + rr.averageWaitingTime(wt));

        int[] tat = rr.turnAroundTime(arrRR, wt);

        p("Turn Around Times: ");
        for (int w : tat) {
            p(w + " ");
        }

        pln("\nAverage Turn Around Time: " + rr.averageTurnAroundTime(tat));

        int[] rt = rr.responseTime(arrRR, wt);

        p("Response Times: ");
        for (int w : rt) {
            p(w + " ");
        }

        pln("\nAverage Response Time: " + rr.averageResponseTime(rt));
    }

    public static ArrayList<String[]> readFile() {
        Scanner inStream = null;
        String fileName;
        ArrayList<String[]> processes = new ArrayList<>();
        boolean loop = false;
        pln("Enter the file name that contains the list of processes or type [Q]uit to end the simulation");
        do {
            fileName = new Scanner(System.in).nextLine().trim();
            try {
                File theFileObject = new File(fileName);
                inStream = new Scanner(theFileObject);
                while (inStream.hasNextLine()) {
                    String[] line = inStream.nextLine().trim().split(" ");
                    processes.add(line);
                }
            } catch (FileNotFoundException e) {
                pln((fileName.equalsIgnoreCase("Q") || fileName.equalsIgnoreCase("Quit")) ?
                        "" : e.getMessage() + ". Please try again!\t Type Q or Quit to end.");
                loop = true;
            } finally {
                if (inStream != null) {
                    inStream.close();
                }
            }
            if (fileName.equalsIgnoreCase("Q") ||
                    fileName.equalsIgnoreCase("Quit")) loop = false;
        } while (loop);
        return processes;
    }

    public static int[][] toIntArray(ArrayList<String[]> list) {
        if(list.size() == 0) return null;
        int[][] arr = new int[list.get(0).length][list.size()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(list.get(j)[i]);
            }
        }
        return arr;
    }

    public static void details(int[][] processes) {
        if(processes != null) {
            pln("==========================================");
            pln("PID\t\tArrival Time\t\tBurst Time");
            pln("==========================================");
            for (int i = 0; i < processes[0].length; i++) {
                pln(processes[0][i] + "\t\t\t\t" + processes[1][i] + "\t\t\t\t" + processes[2][i]);
                pln("------------------------------------------");
            }
        }
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}

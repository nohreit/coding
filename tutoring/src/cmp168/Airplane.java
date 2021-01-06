package cmp168;

public class Airplane {
    private Passenger[] passengers;
    private String airplaneName;
    private int numPassengers;

    public Airplane() {
        this.passengers = new Passenger[100];
        this.numPassengers = 0;
        this.airplaneName = "";

    }

    public Airplane(String name) {
        this.passengers = new Passenger[100];
        this.numPassengers = 0;
        this.airplaneName = name;
    }

    public Airplane(int num) {
        this.passengers = num > 0 ? new Passenger[num] : new Passenger[0];
        this.numPassengers = 0;
        this.airplaneName = "";
    }

    public Airplane(String name, int num) {
        this.passengers = num > 0 ? new Passenger[num] : new Passenger[0];
        this.numPassengers = 0;
        this.airplaneName = name;
    }

    public void addPassenger(Passenger p) {
        if (numPassengers >= passengers.length)
            resizePassengerArray();
        passengers[numPassengers] = p;
        numPassengers++;
    }

    public void resizePassengerArray() {
        if (this.passengers.length == 0)
            this.passengers = new Passenger[1];
        else {
            Passenger[] temp = this.passengers;
            this.passengers = new Passenger[this.passengers.length * 2];
            if (temp.length >= 0) System.arraycopy(temp, 0, this.passengers, 0, temp.length);
        }
    }

    public int getNumPassengers() {
        return this.numPassengers;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public Passenger getPassenger(int index) {
        if ((index >= 0 && index < passengers.length) && this.passengers[index] != null)
            return passengers[index];
        return null;
    }

    public Passenger[] getPassengers() {
        if (this.passengers.length == 0)
            return null;
        return this.passengers;
    }

    public Passenger getFirstPassenger() {
        return passengers[0];
    }

    public Passenger getLastPassenger() {
        return passengers[numPassengers - 1];
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public void printAllDetails() {
        System.out.printf("AirplaneName: %20s| Number of Passengers: %4d| Airplane Size: %4d\n ",
                this.airplaneName, this.numPassengers, this.passengers.length);
        for (int i = 0; i < this.numPassengers; i++)
            this.getPassengers()[i].printDetails(); // in that airplane get the passenger at seat x
        // and print the passenger's info
    }

    public Passenger removePassenger(int index) {
        if ((index >= 0 && index < passengers.length) && this.passengers[index] != null) {
            Passenger temp = passengers[index];
            for (int i = index; i < this.numPassengers-1 && this.passengers[i] != null; i++)
                passengers[i] = passengers[i + 1];

            passengers[passengers.length-1] = null;

            this.numPassengers--; // Decrement the number of passenger
            return temp;
        }
        return null;
    }

    public void removeAllPassengers(){
        this.passengers = new Passenger[0];
        this.numPassengers = 0;
    }

    public double getTotalWeightOfAllPassengers() {
        double total = 0.0;
        for (int i = 0; i < numPassengers; i++)
            total += this.passengers[i].getWeight();
        return total;
    }

    public double getAverageWeightOfAllPassengers() {
        return getTotalWeightOfAllPassengers() / this.numPassengers;
    }

    public void increaseWeightOfAllPassengers() {
        for (int i = 0; i < this.numPassengers; i++)
            this.passengers[i].gainWeight();
    }

    public void increaseWeightOfAllPassengers(double value) {
        for (int i = 0; i < this.numPassengers; i++)
            this.passengers[i].gainWeight(value);
    }

    public int getNumberOfPassengersAboveWeight(double weight) {
        weight = (weight < 0) ? 0 : weight;
        int count = 0;
        for (int i = 0; i < this.numPassengers && (this.passengers[i].getWeight() > weight); i++)
            count++;
        return count;
    }

    public int getNumberOfPassengersBelowWeight(double weight) {
        weight = (weight < 0) ? 0 : weight;
        int count = 0;
        for (int i = 0; i < this.numPassengers && (this.passengers[i].getWeight() < weight); i++)
            count++;
        return count;
    }
}



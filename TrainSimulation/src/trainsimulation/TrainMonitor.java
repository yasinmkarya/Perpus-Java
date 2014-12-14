/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulation;

/**
 *
 * @author hdadmin
 */
public class TrainMonitor {

    private int numOfTrain;
    private int totalTrain;

    public TrainMonitor() {
        this.numOfTrain = 0;
        this.totalTrain = 0;
    }

    public void setTotalTrain(int totalTrain) {
        this.totalTrain = totalTrain;
    }

    public void reset() {
        this.numOfTrain = 0;
    }

    public synchronized void trainDone(Train train) {
        System.out.println("Train " + train.getTrainName() + " has done");
        this.totalTrain++;
        if (this.numOfTrain == this.totalTrain) {
            this.notify();
        }
    }
}

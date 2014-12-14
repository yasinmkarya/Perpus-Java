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
public class Train extends Thread {

    private String trainName;
    private TrainMonitor trainMonitor;

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public void setTrainMonitor(TrainMonitor trainMonitor) {
        this.trainMonitor = trainMonitor;
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("Train Done");
        this.trainMonitor.trainDone(this);
    }
}

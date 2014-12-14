/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulation;

import java.util.Date;

/**
 *
 * @author hdadmin
 */
public class TrainSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean keepRunning = true;
        Train train[] = new Train[10];
        train[0] = new Train();
        train[1] = new Train();
        
        TrainMonitor trainMonitor = new TrainMonitor();

        while (keepRunning) {
            synchronized (trainMonitor) {
                System.out.println("Menunggu kereta berjalan ..");
                train[0].setTrainName("Kahuripan");
                train[1].setTrainName("Lodaya");
                train[0].setTrainMonitor(trainMonitor);
                train[1].setTrainMonitor(trainMonitor);
                
                trainMonitor.reset();
                trainMonitor.setTotalTrain(2);

                System.out.println("Jalankan kereta ..");
                train[0].start();
                train[1].start();

                try {
                    System.out.println("Menunggu semua kereta selesai..");
                    trainMonitor.wait();
                    System.out.println("I am waking up. Execute batch, commit and ready to retrieve new workers");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            System.out.println("End while " + new Date() + "\n\n");
        }
    }
}

// package tanyapetrolpump.models.Lane;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
/** 
public class Lane implements Runnable {
    private final int laneId = 1;
    private static int laneWaitQueue;

    // Varies with its pumps' usage 
    private boolean laneInUse[3];

    // Unique lane number
    private int laneNumber;

    // CONSTRUCTOR
    public Lane() {
        laneNumber = laneId++;

        // pump[0] usage, pump[1] usage, pump[2] usage is set to false respectively
        laneInUse = [false, false, false];
        laneWaitQueue = 0;

        // create 3 station pumps in each new lane
        Lane stationPumps[3] = new Pump();
    }

    // Setters
    public void setLaneUsage( ) {
        laneInUse = true;
        laneWaitQueue++;
    }

    // Getters
    public void getLaneUsage( ) {
        return laneInUse;
    }

    // METHODS
    public static void sendToLane( Vehicle vehicleArrivedOnALane, Lane temporaryLane ) {
        Pump emptyPump = new Pump;
        if lane[0].getLaneUsage() = false;
            lane[0].sendToPump( lane(0) );
        else if lane[1].getLaneUsage() = false;
            lane[1].sendToPump( lane(1) );
        else if lane[2].getLaneUsage() = false;
            lane[2].sendToPump( lane(2) );
}
**/
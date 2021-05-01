package by.courses2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class America implements Runnable {
    private static Set<BodyParts> robot = new HashSet<>();
    private static int robotCount = 0;


    @Override
    public void run() {
        while (!WarStatus.isWarOver) {
            List<BodyParts> requestParts = new ArrayList<>();
            for (BodyParts bodyPart : BodyParts.values()) {
                if (!robot.contains(bodyPart)) {
                    requestParts.add(bodyPart);
                }
            }
            BodyParts requestedDetail = Factory.getRequestedDetail(requestParts);
            if (requestedDetail != null) {
                robot.add(requestedDetail);
                System.out.println("America: " + robot);
            }
            if (robot.size() == 5) {
                robotCount++;
                System.out.println("Current America Army: " + robotCount);
                robot.clear();
            }
            if (robotCount == 20) {
                WarStatus.isWarOver = true;
                WarStatus.winner = "America";
            }
        }
    }
}
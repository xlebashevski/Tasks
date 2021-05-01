package by.courses2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Factory implements Runnable {
    private static List<BodyParts> storage = new LinkedList<>();
    private Random random = new Random();

    public static BodyParts getRequestedDetail(List<BodyParts> requestDetails) {
        synchronized (storage) {
            for (BodyParts requestDetail : requestDetails) {
                if (storage.contains(requestDetail)) {
                    storage.remove(requestDetail);
                    return requestDetail;
                }
            }
            return null;
        }
    }

    @Override
    public void run() {
        while (!WarStatus.isWarOver) {
            synchronized (storage) {
                storage.add(createRandomPart());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private BodyParts createRandomPart() {
        int randomIndex = random.nextInt(5);
        switch (randomIndex) {
            case 0:
                return BodyParts.Head;
            case 1:
                return BodyParts.LeftHand;
            case 2:
                return BodyParts.LeftLeg;
            case 3:
                return BodyParts.RightHand;
            case 4:
                return BodyParts.RightLeg;
        }
        return null;
    }
}
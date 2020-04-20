import java.util.HashSet;
import java.util.Set;

public class RobotMove {

    public static class Robot {

        public Robot() {}

        public void turnLeft() {

        }
        public boolean move() {
            return false;
        }
        public boolean isGold() {
            return false;
        }
    }

    public static class Pair<U, V> {
        public U first;
        public V second;
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public void findGold(Robot robot) {
        if (robot == null || robot.isGold()) {
            return;
        }

        Set<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();

        tryFindGold(robot, set, 0, 0);
    }

    public int[] dx = new int[] {-1, 0, 0, 1};
    public int[] dy = new int[] {0, -1, 1, 0};

    public boolean tryFindGold(Robot robot, Set<Pair<Integer, Integer>> set, int x, int y) {
        if (robot.isGold()) {
            return true;
        }

        if (set.contains(new Pair<Integer, Integer>(x, y))) {
            return false;
        } else {
            set.add(new Pair<Integer, Integer>(x, y));
            
            for (int k = 0; k < 4; k++) {
                robot.turnLeft();
                robot.move();
                if (tryFindGold(robot, set, x + dx[k], y + dy[k])) {
                    return true;
                } else {
                    robot.turnLeft();
                    robot.turnLeft();
                    robot.move();
                    robot.turnLeft();
                    robot.turnLeft();
                }
            }
        }
        return false;
    }
}
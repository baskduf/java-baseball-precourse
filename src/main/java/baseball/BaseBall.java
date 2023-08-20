package baseball;

import java.util.List;
import java.util.Objects;

public class BaseBall {

    private final List<Integer> ballNumber;
    BaseBall(List<Integer> ballNumber){
        this.ballNumber = ballNumber;
    }

    public List<Integer> getBallNumber(){
        return this.ballNumber;
    }

    public boolean getEquals(int index, BaseBall target){
        return Objects.equals(target.getBallNumber().get(index), getBallNumber().get(index));
    }

    public boolean getContains(int index, BaseBall target){
        boolean result = false;
        for(int i = 0; i < BaseBallGame.BALL_COUNT; i++){
            if (Objects.equals(target.getBallNumber().get(index), getBallNumber().get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private BaseBall baseBall;
    private BaseBall userBall;
    public static final int MATCH_BALL = 0;
    public static final int MATCH_STRIKE = 1;
    public static final int BALL_COUNT = 3;

    public void start(){

        boolean result = true;
        this.baseBall = new BaseBall(Randoms.pickUniqueNumbersInRange(1,9,3));
        while(result){
            try{
                System.out.println(this.baseBall.getBallNumber());
                inputNumbers();
                if(matchNumbers()){
                    result = clearGame();
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private boolean clearGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        Exception.getInstance().checkInteger(input);
        int numbers = Integer.parseInt(input);
        if(numbers == 1){
            this.baseBall = new BaseBall(Randoms.pickUniqueNumbersInRange(1,9,3));
            return true;
        }
        else {
            return false;
        }
    }

    private void inputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Exception.getInstance().checkInteger(input);
        int numbers = Integer.parseInt(input);
        Exception.getInstance().checkInputNumbers(numbers);
        Exception.getInstance().checkDuplicationNumbers(parseNumbers(numbers));
        this.userBall = new BaseBall(parseNumbers(numbers));
    }

    private List<Integer> parseNumbers(int numbers){
        List<Integer> list = new ArrayList<Integer>();
        list.add(numbers/100);
        numbers%=100;
        list.add(numbers/10);
        numbers%=10;
        list.add(numbers);
        return list;
    }

    private boolean matchNumbers(){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < BALL_COUNT; i++){
            if(baseBall.getEquals(i, userBall)){
                strike++;
            }else if(baseBall.getContains(i, userBall)){
                ball++;
            }
        }
        return printMatchNumbers(new int[]{ball,strike});
    }

    private boolean printMatchNumbers(int [] match){
        String result = "";
        if(match[MATCH_BALL] > 0){
            result += match[MATCH_BALL]+"볼 ";
        }
        if(match[MATCH_STRIKE] > 0){
            result += match[MATCH_STRIKE]+"스트라이크";
        }
        if(match[MATCH_BALL] == 0 && match[MATCH_STRIKE] == 0){
            result += "낫싱";
        }
        System.out.println(result);
        return match[MATCH_STRIKE] == 3;
    }

}

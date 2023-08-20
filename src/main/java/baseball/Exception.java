package baseball;

import java.util.List;

public class Exception {

    private static final Exception exception = new Exception();
    private Exception(){};

    public static Exception getInstance(){
        return exception;
    }

    public void checkInteger(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 입니다.");
        }
    }

    public void checkPlayNumber(int input){
        if(!(input == 1 || input == 2)){
            throw new IllegalArgumentException("[ERROR] 범위를 넘은 숫자입니다.");
        }
    }

    public void checkInputNumbers(int inputNumbers){
        if(inputNumbers < 100 || inputNumbers > 999){
            throw new IllegalArgumentException("[ERROR] 범위를 넘은 숫자입니다.");
        }
    }

    public void checkDuplicationNumbers(List<Integer> inputList){
        int[] arr = new int[10];
        for(int element : inputList){
            arr[element] ++;
            if(arr[element] >= 2){
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력 할 수 없습니다.");
            }
        }
    }

}

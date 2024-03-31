package engine.input;

import java.util.Map;

public class Input {

    private static Map<KeyCode, InputKeyCode> INPUTS_KEY_CODE = InputKeyCode.getInputsKeyCode();

    private static Input singleton;

    public static Input getInstance(){
        if(singleton == null) singleton = new Input();
        return singleton;
    }

    private Input() {}
    
    public static void update(){
        for(InputKeyCode input : INPUTS_KEY_CODE.values()){
            input.update();
        }
    }
    
    public static void inputPressed(int inputKey) throws KeyNotAssociatedException {
        INPUTS_KEY_CODE.get(KeyCode.valueOf(inputKey)).enter();
    }
    
    public static void inputReleased(int inputKey) throws KeyNotAssociatedException {
        INPUTS_KEY_CODE.get(KeyCode.valueOf(inputKey)).exit();
    }
    
    public static boolean getKey(KeyCode keyCode){
        return INPUTS_KEY_CODE.get(keyCode).isStay();
    }

    public static boolean getKeyDown(KeyCode keyCode){
        return INPUTS_KEY_CODE.get(keyCode).isEnter();
    }

    public static boolean getKeyUp(KeyCode keyCode){
        return INPUTS_KEY_CODE.get(keyCode).isExit();
    }

}

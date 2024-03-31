package engine.input;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_0;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_B;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_C;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_CAPS_LOCK;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F10;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F11;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F12;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_G;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_H;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_I;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_J;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_K;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_0;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_L;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_ALT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_CONTROL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SHIFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_M;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_N;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_O;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_P;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_R;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_ALT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_CONTROL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_T;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_TAB;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_U;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_V;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_WORLD_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_X;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Y;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Z;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_1;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_2;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_3;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_4;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_5;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_6;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_7;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_8;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_MIDDLE;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_RIGHT;

public enum KeyCode {
    A(GLFW_KEY_A, "A"),
    B(GLFW_KEY_B, "B"),
    C(GLFW_KEY_C, "C"),
    D(GLFW_KEY_D, "D"),
    E(GLFW_KEY_E, "E"),
    F(GLFW_KEY_F, "F"),
    G(GLFW_KEY_G, "G"),
    H(GLFW_KEY_H, "H"),
    I(GLFW_KEY_I, "I"),
    J(GLFW_KEY_J, "J"),
    K(GLFW_KEY_K, "K"),
    L(GLFW_KEY_L, "L"),
    M(GLFW_KEY_M, "M"),
    N(GLFW_KEY_N, "N"),
    O(GLFW_KEY_O, "O"),
    P(GLFW_KEY_P, "P"),
    Q(GLFW_KEY_Q, "Q"),
    R(GLFW_KEY_R, "R"),
    S(GLFW_KEY_S, "S"),
    T(GLFW_KEY_T, "T"),
    U(GLFW_KEY_U, "U"),
    V(GLFW_KEY_V, "V"),
    W(GLFW_KEY_W, "W"),
    X(GLFW_KEY_X, "X"),
    Y(GLFW_KEY_Y, "Y"),
    Z(GLFW_KEY_Z, "Z"),
    ALPHA_0(GLFW_KEY_0, "alpha-0"),
    ALPHA_1(GLFW_KEY_1, "alpha-1"),
    ALPHA_2(GLFW_KEY_2, "alpha-2"),
    ALPHA_3(GLFW_KEY_3, "alpha-3"),
    ALPHA_4(GLFW_KEY_4, "alpha-4"),
    ALPHA_5(GLFW_KEY_5, "alpha-5"),
    ALPHA_6(GLFW_KEY_6, "alpha-6"),
    ALPHA_7(GLFW_KEY_7, "alpha-7"),
    ALPHA_8(GLFW_KEY_8, "alpha-8"),
    ALPHA_9(GLFW_KEY_9, "alpha-9"),
    UP_ARROW(GLFW_KEY_UP, "up"),
    DOWN_ARROW(GLFW_KEY_DOWN, "down"),
    RIGHT_ARROW(GLFW_KEY_RIGHT, "right"),
    LEFT_ARROW(GLFW_KEY_LEFT, "left"),
    NUMPAD_0(GLFW_KEY_KP_0, "numpad-0"),
    NUMPAD_1(GLFW_KEY_KP_1, "numpad-1"),
    NUMPAD_2(GLFW_KEY_KP_2, "numpad-2"),
    NUMPAD_3(GLFW_KEY_KP_3, "numpad-3"),
    NUMPAD_4(GLFW_KEY_KP_4, "numpad-4"),
    NUMPAD_5(GLFW_KEY_KP_5, "numpad-5"),
    NUMPAD_6(GLFW_KEY_KP_6, "numpad-6"),
    NUMPAD_7(GLFW_KEY_KP_7, "numpad-7"),
    NUMPAD_8(GLFW_KEY_KP_8, "numpad-8"),
    NUMPAD_9(GLFW_KEY_KP_9, "numpad-9"),
    F1(GLFW_KEY_F1, "f1"),
    F2(GLFW_KEY_F2, "f2"),
    F3(GLFW_KEY_F3, "f3"),
    F4(GLFW_KEY_F4, "f4"),
    F5(GLFW_KEY_F5, "f5"),
    F6(GLFW_KEY_F6, "f6"),
    F7(GLFW_KEY_F7, "f7"),
    F8(GLFW_KEY_F8, "f8"),
    F9(GLFW_KEY_F9, "f9"),
    F10(GLFW_KEY_F10, "f10"),
    F11(GLFW_KEY_F11, "f11"),
    F12(GLFW_KEY_F12, "f12"),
    LESS(GLFW_KEY_WORLD_2, "less"),
    CAPS_LOCK(GLFW_KEY_CAPS_LOCK, "caps-lock"),
    CTRL_LEFT(GLFW_KEY_LEFT_CONTROL, "ctrl-left"),
    CTRL_RIGHT(GLFW_KEY_RIGHT_CONTROL, "ctrl-right"),
    ALT_LEFT(GLFW_KEY_LEFT_ALT, "alt-left"),
    ALT_RIGHT(GLFW_KEY_RIGHT_ALT, "alt-right"),
    SHIFT_LEFT(GLFW_KEY_LEFT_SHIFT, "shift-left"),
    SHIFT_RIGHT(GLFW_KEY_RIGHT_SHIFT, "shift-right"),
    SPACE(GLFW_KEY_SPACE, "space"),
    ENTER(GLFW_KEY_ENTER, "enter"),
    ESCAPE(GLFW_KEY_ESCAPE, "escape"),
    TAB(GLFW_KEY_TAB, "tabulation"),
    MOUSE_LEFT(GLFW_MOUSE_BUTTON_LEFT, "mouse-left"),
    MOUSE_MIDDLE(GLFW_MOUSE_BUTTON_MIDDLE, "mouse-middle"),
    MOUSE_RIGHT(GLFW_MOUSE_BUTTON_RIGHT, "mouse-right"),
    MOUSE_1(GLFW_MOUSE_BUTTON_1, "mouse-1"),
    MOUSE_2(GLFW_MOUSE_BUTTON_2, "mouse-2"),
    MOUSE_3(GLFW_MOUSE_BUTTON_3, "mouse-3"),
    MOUSE_4(GLFW_MOUSE_BUTTON_4, "mouse-4"),
    MOUSE_5(GLFW_MOUSE_BUTTON_5, "mouse-5"),
    MOUSE_6(GLFW_MOUSE_BUTTON_6, "mouse-6"),
    MOUSE_7(GLFW_MOUSE_BUTTON_7, "mouse-7"),
    MOUSE_8(GLFW_MOUSE_BUTTON_8, "mouse-8");

    private int code;

    private String key;
    
    private KeyCode(int code, String key){
        this.code = code;
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public String getKey(){
        return key;
    }

    public static KeyCode valueOf(int inputKey) throws KeyNotAssociatedException {
        for(KeyCode keyCode : values()){
            if(keyCode.code == inputKey){
                return keyCode;
            }
        }
        throw new KeyNotAssociatedException("This key has not been associated: [" + inputKey + "]");
    }

}

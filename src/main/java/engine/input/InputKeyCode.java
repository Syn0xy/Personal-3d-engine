package engine.input;

import java.util.HashMap;
import java.util.Map;

import engine.utils.Updatable;

public class InputKeyCode implements Updatable {

    private boolean enter;

    private boolean stay;

    private boolean exit;

    private boolean nothing;

    private InputKeyCode() {
        this.enter = false;
        this.stay = false;
        this.exit = false;
        this.nothing = false;
    }

    public boolean isEnter() {
        return enter;
    }

    public boolean isStay() {
        return stay;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isNothing() {
        return nothing;
    }

    private void reset() {
        this.enter = false;
        this.stay = false;
        this.exit = false;
        this.nothing = true;
    }

    public void enter() {
        if (this.nothing) {
            this.enter = true;
        }
        this.stay = true;
        this.exit = false;
        this.nothing = false;
    }

    public void exit() {
        this.exit = true;
    }

    @Override
    public void update() {
        if (!this.nothing) {
            if (this.enter) {
                this.enter = true;
            }
            if (this.exit) {
                this.reset();
            }
        }
    }

    protected static final Map<KeyCode, InputKeyCode> getInputsKeyCode() {
        KeyCode[] keyCodes = KeyCode.values();
        Map<KeyCode, InputKeyCode> inputsKeyCode = new HashMap<>();
        for (int i = 0; i < keyCodes.length; i++) {
            inputsKeyCode.put(keyCodes[i], new InputKeyCode());
        }
        return inputsKeyCode;
    }

}

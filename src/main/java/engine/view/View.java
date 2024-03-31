package engine.view;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Z;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetTime;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowSizeCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowTitle;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;

import engine.input.Input;
import engine.input.KeyNotAssociatedException;

public abstract class View {
    
    public static final int SCREEN_WIDTH = 1920;
    
    public static final int SCREEN_HEIGHT = 1080;

    private double framesPerSecond;
    private double milliSeconds;

    public abstract String title();
    protected abstract void draw();

    double prevTime = 0;
    double crntTime = 0;
    double timeDiff;
    int counter = 0;

    private long window;

    public View(int width, int height){
        // Initialiser GLFW
        if (!glfwInit()) {
            System.err.println("Erreur lors de l'initialisation de GLFW");
            System.exit(-1);
        }

        // Configurer GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        // Créer une fenêtre
        this.window = glfwCreateWindow(width, height, title(), 0, 0);
        if (window == 0) {
            System.err.println("Erreur lors de la création de la fenêtre GLFW");
            glfwTerminate();
            System.exit(-1);
        }

        GLFWVidMode monitor = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (monitor.width() - width) / 2, (monitor.height() - height) / 2);        
        glfwMakeContextCurrent(window); // Rendre la fenêtre le contexte OpenGL actuel
        glfwSwapInterval(1); // Activer la synchronisation verticale (VSync)
        glfwShowWindow(window); // Rendre la fenêtre visible
        GL.createCapabilities(); // Initialise OpenGL
        
        setupCallbacks(window);

        glfwSwapInterval(0);
    }
    
    public void start() {
        while (!glfwWindowShouldClose(window)) {
            update();
        }
        
        glfwTerminate(); // Libérer les ressources
    }
    
    private void update() {
        crntTime = glfwGetTime();
        timeDiff = crntTime - prevTime;
        counter++;
        if(timeDiff >= 1.0 / 30.0){
            framesPerSecond = (1.0 / timeDiff) * counter;
            milliSeconds = timeDiff / counter;
            String title = title() + " - " + String.format("%,.2f", framesPerSecond) + " fps / " + String.format("%,.3f", milliSeconds) + " ms";
            glfwSetWindowTitle(window, title);
            prevTime = crntTime;
            counter = 0;
        }
        
        glClear(GL_COLOR_BUFFER_BIT); // Effacer l'écran
        draw(); // Dessiner
        glfwSwapBuffers(window); // Échanger les tampons (double buffering)
        glfwPollEvents(); // Gérer les événements et mettre à jour le rendu
    }
    
    private static void setupCallbacks(long window) {
        
        glfwSetWindowSizeCallback(window, new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                // System.out.println("w:" + width + ", h:" + height);
                // glMatrixMode(GL_PROJECTION);
                // glLoadIdentity();
                // glOrtho(0, width, 0, height, -1, 1);
                // glMatrixMode(GL_MODELVIEW);
            }
        });
        
        // Rappel pour les touches du clavier
        glfwSetKeyCallback(window, new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                switch (key) {
                    case GLFW_KEY_Q: key = GLFW_KEY_A; break;
                    case GLFW_KEY_A: key = GLFW_KEY_Q; break;
                    case GLFW_KEY_W: key = GLFW_KEY_Z; break;
                    case GLFW_KEY_Z: key = GLFW_KEY_W; break;
                }
                inputEvent(key, action);
            }
        });

        // Rappel pour les boutons de la souris
        glfwSetMouseButtonCallback(window, new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                inputEvent(button, action);
            }
        });

        // Rappel pour la position du curseur de la souris
        // glfwSetCursorPosCallback(window, new GLFWCursorPosCallback() {
        //     @Override
        //     public void invoke(long window, double xpos, double ypos) {
        //         // Ajoutez votre gestionnaire d'événements de souris ici...
        //     }
        // });
    }

    private static void inputEvent(int key, int action){
        try {
            if(action == GLFW_PRESS)
                Input.inputPressed(key);
            else if(action == GLFW_RELEASE)
                Input.inputReleased(key);
        } catch (KeyNotAssociatedException e) {
            System.err.println(e.getMessage());
        }
    }

}

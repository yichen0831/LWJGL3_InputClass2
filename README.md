# LWJGL3_InputClass2
A input class for use in LWJGL3 which help easier handle the KeyCallback.

This input class can be checked however many times during one update loop. That is, if several objects call Input.isKeyPressed(GLFW_KEY_SPACE) for instance, every object will get true if the space is pressed.

If you would like to have the key input being checked only one time during one update loop, you can refer to [LWJGL3_InputClass](https://github.com/yichen0831/LWJGL3_InputClass).

##Usage:

1. Import the InputClass.

        import where.you.put.the.class.Input;

2. Set it to the GLFWKeyCallback

        glfwSetKeyCallback(window, keyCallback = new Input());

3. Remember to call Input.resetKeyState() before glfwPollEvents().

        Input.resetKeyState();
        glfwPollEvents();

4. Easily check anytime anywhere the input by

        // when key is down (including first pressed and repeated)
        if(Input.isKeyDown(GLFW_KEY_SPACE)) {
            System.out.println("space down");
        }
        
        // only when key is first pressed
        if(Input.isKeyPressed(GLFW_KEY_SPACE)) {
            System.out.println("space pressed");
        }
        
        // only when key is repeated
        if(Input.isKeyRepeated(GLFW_KEY_SPACE)) {
            System.out.println("space repeated");
        }
        
        // when the key is released
        if(Input.isKeyReleased(GLFW_KEY_SPACE)) {
            System.out.println("space released");
        }

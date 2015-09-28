import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;

/* [LWJGL3_InputClass2](https://github.com/yichen0831/LWJGL3_InputClass2)
 *
 * A input class for use in LWJGL3 which help easier handle the KeyCallback.
 *
 * This input class can be checked however many times during one update loop.
 * That is, if several objects call Input.isKeyPressed(GLFW_KEY_SPACE) for instance,
 * every object will get true if the space is pressed.
 *
 * If you would like to have the key input being checked only one time
 * during one update loop, you can refer to
 * [LWJGL3_InputClass](https://github.com/yichen0831/LWJGL3_InputClass).
*/

public class Input extends GLFWKeyCallback {
	public enum KeyState {
		Idle,
		Release,
		Press,
		Repeat,
	};

	public static KeyState[] keyState = new KeyState[GLFW_KEY_LAST];

	// remember to call resetKeyState() before glfwPollEvents()
	public static void resetKeyState() {
		for(int i=0; i < keyState.length; i++) {
			keyState[i] = KeyState.Idle;
		}
	}

	public static boolean isKeyDown(int key) {
		if(keyState[key] == KeyState.Press || keyState[key] == KeyState.Repeat) {
			return true;
		}
		return false;
	}

	public static boolean isKeyPressed(int key) {
		if(keyState[key] == KeyState.Press) {
			return true;
		}
		return false;
	}

	public static boolean isKeyRepeated(int key) {
		if(keyState[key] == KeyState.Repeat) {
			return true;
		}
		return false;
	}

	public static boolean isKeyReleased(int key) {
		if(keyState[key] == KeyState.Release) {
			return true;
		}
		return false;
	}

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		switch(action) {
		case GLFW_RELEASE:
			keyState[key] = KeyState.Release;
			break;
		case GLFW_PRESS:
			keyState[key] = KeyState.Press;
			break;
		case GLFW_REPEAT:
			keyState[key] = KeyState.Repeat;
		}
	}
}

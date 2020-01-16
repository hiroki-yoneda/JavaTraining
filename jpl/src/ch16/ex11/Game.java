package jpl.ch16.ex11;

import java.io.FileOutputStream;
import java.io.IOException;

public class Game {

	public static void main(String[] args) {
		String name; //クラス名
		while ((name = getNextPlayer()) != null) {
			try {
				PlayerLoader loader = new PlayerLoader();
				Class<? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				Game game = new Game();
				player.play(game);
				game.reportScore(name);
			} catch (Exception e) {
				reportException(name, e);
			}
		}
	}

	private static void reportException(String name, Exception exception) {
		try (FileOutputStream out = new FileOutputStream("src/main/resource" + name);) {
			out.write(0);
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}

	public void reportScore(String name) {
		try (FileOutputStream out = new FileOutputStream("src/main/resource" + name);) {
			out.write(0);
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}

	public static String getNextPlayer() {
		return "PlayerName";
	}

}
